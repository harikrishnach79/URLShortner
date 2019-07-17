package in.shortner.url.controller;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import in.shortner.url.entity.URLMapper;
import in.shortner.url.service.URLMapperService;

@Controller
public class URLController {

	@Value("${base.url}")
	String baseURL;
	
	private static Logger logger = LoggerFactory.getLogger(URLController.class);

	private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

	@Autowired
	private URLMapperService urlMapperService;

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView showLoginPage(ModelMap model) {
		ModelAndView mv = new ModelAndView("create");
		return mv;
	}

	@RequestMapping(value = "/r/{id}", method = RequestMethod.GET)
	public String requestMethodName(ModelMap model, @PathVariable String id) {
		String codedURL = id;
		logger.info("Short url received {}",id);
		String actualURL = urlMapperService.getActualURLByShortURL(codedURL);
		logger.info("Actual url mapped {}",actualURL);
		if (actualURL == "") {
			return "notfound";
		} else {
			return "redirect:" + actualURL;
		}
	}

	@RequestMapping(value = "/createSURL", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody String createShortURL(@RequestBody URLMapper urlMapper, HttpServletResponse response) {
		String uniqueCode = generateUniqueCode();
		urlMapper.setShortURL(uniqueCode);
		logger.info("Actual URL Received:: {},Short Code:: {}",urlMapper.getActualURL(),urlMapper.getShortURL());
		URLMapper result = urlMapperService.saveCodedURL(urlMapper);
		if(result.getShortURL()!=null && result.getShortURL()!="") {
			String url = baseURL + result.getShortURL();
			return url;
		}
		return "Please Try Again";
	}

	private String generateUniqueCode() {
		StringBuilder builder = new StringBuilder();
		int length = 5;
		while (length-- != 0) {
			int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
	}
}

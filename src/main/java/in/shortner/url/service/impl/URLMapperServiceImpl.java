package in.shortner.url.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.shortner.url.entity.URLMapper;
import in.shortner.url.repository.URLMapperRepository;
import in.shortner.url.service.URLMapperService;

@Service
public class URLMapperServiceImpl implements URLMapperService {

	private static Logger logger = LoggerFactory.getLogger(URLMapperServiceImpl.class);

	@Autowired
	private URLMapperRepository urlMapperRepository;

	@Override
	public String getActualURLByShortURL(String shortURL) {
		String actualURL = "";
		try {
			URLMapper urlMapper = urlMapperRepository.findByShortURL(shortURL);
			if (urlMapper.getActualURL() != null && urlMapper.getActualURL() != "") {
				actualURL = urlMapper.getActualURL();
				urlMapper.setClicksCount(urlMapper.getClicksCount()+1);
				urlMapper = urlMapperRepository.save(urlMapper);
				logger.info("Clicks as of now {}",urlMapper.getClicksCount());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return actualURL;
	}

	@Override
	public URLMapper saveCodedURL(URLMapper urlMapper) {
		URLMapper resURLMapper = new URLMapper();
		urlMapper.setClicksCount(0);
		try {
			resURLMapper = urlMapperRepository.save(urlMapper);
		} catch (Exception e) {
			logger.error("SQL Save Exxception messsage::: {}", e.getMessage());
		}
		return resURLMapper;
	}

}

package in.shortner.url.service;

import in.shortner.url.entity.URLMapper;

public interface URLMapperService {

	public String getActualURLByShortURL(String shortURL);
	
	public URLMapper saveCodedURL(URLMapper urlMapper);
}

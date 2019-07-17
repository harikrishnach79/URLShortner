package in.shortner.url.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "URL_MAPPER")
public class URLMapper {
	
	private String actualURL;

	@Id
	private String shortURL;

	private int clicksCount;

	public String getActualURL() {
		return actualURL;
	}

	public void setActualURL(String actualURL) {
		this.actualURL = actualURL;
	}

	public String getShortURL() {
		return shortURL;
	}

	public void setShortURL(String shortURL) {
		this.shortURL = shortURL;
	}

	public int getClicksCount() {
		return clicksCount;
	}

	public void setClicksCount(int clicksCount) {
		this.clicksCount = clicksCount;
	}

}

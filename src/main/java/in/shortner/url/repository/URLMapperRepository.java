package in.shortner.url.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.shortner.url.entity.URLMapper;

@Repository
public interface URLMapperRepository extends JpaRepository<URLMapper, String> {

	public URLMapper findByShortURL(String shortURL);
}

package com.Url.Shorten.Repository;

import com.Url.Shorten.Entity.Url;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlRepository extends JpaRepository<Url,Long> {

    public boolean existsByShortUrl(String shortUrl);

    public  Url findByShortUrl(String shortUrl);
}

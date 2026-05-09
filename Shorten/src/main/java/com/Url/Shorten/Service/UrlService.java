package com.Url.Shorten.Service;

import com.Url.Shorten.Entity.Url;
import com.Url.Shorten.Repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
public class UrlService {

    @Autowired
    private UrlRepository urlRepository;

    public String shortenUrl(String originalUrl){
        originalUrl = originalUrl.trim();
        String randomMix = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";


        Random random = new Random();
          String shortUrl;

        do {
            StringBuilder shortCode = new StringBuilder();
            while (shortCode.length() < 8) {
                int index = random.nextInt(randomMix.length());
                char ch = randomMix.charAt(index);
                shortCode.append(ch);
            }
             shortUrl = shortCode.toString();
        } while(urlRepository.existsByShortUrl(shortUrl));


       //create entity
        Url url = new Url();
        url.setOriginalUrl(originalUrl);
        url.setShortUrl(shortUrl);
        url.setClickCount(0L);
        LocalDateTime current = LocalDateTime.now();
        url.setCreatedTime(current);
        url.setExpiryTime(current.plusMinutes(5));
     urlRepository.save(url);


     return "http://localhost:8080/" + shortUrl;
    }



    public String redirectUrl(String shortUrl) {
        Url url = urlRepository.findByShortUrl(shortUrl);

        if (url == null) {
            throw new RuntimeException("Url does not exist");
        }
        LocalDateTime currentTime = LocalDateTime.now();
        LocalDateTime expiry = url.getExpiryTime();
        if (currentTime.isAfter(expiry)) {
            throw new RuntimeException("Link is expired");
        }
        Long current = url.getClickCount();
            url.setClickCount(current + 1);

//            System.out.println(shortUrl);

            urlRepository.save(url);
            return url.getOriginalUrl();

        }
    }


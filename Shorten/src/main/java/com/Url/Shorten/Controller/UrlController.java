package com.Url.Shorten.Controller;


import com.Url.Shorten.Service.UrlService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class UrlController {

    @Autowired
    private UrlService urlService;

    @PostMapping("/shorten")
    ResponseEntity<String> shortUrl(@RequestBody String  originalUrl){
        String result =   urlService.shortenUrl(originalUrl);
    return ResponseEntity.ok(result);
    }


    @GetMapping("/{shortCode}")
    public void  redirectUrl(@PathVariable String shortCode,HttpServletResponse response) throws IOException {
      String originalUrl=  urlService.redirectUrl(shortCode);
         response.sendRedirect(originalUrl);
    }
}

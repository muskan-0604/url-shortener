package com.Url.Shorten.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 2048)
    private String originalUrl;
    @Column(nullable = false, length = 10 , unique = true)
    private String shortUrl;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdTime;
    private LocalDateTime expiryTime;


    @Column(nullable = false)
    private Long clickCount = 0L;
}

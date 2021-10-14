package com.example.geeksforgeeks.urlshortener;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Component
public class UrlShortener {

        private String domain; // abc.com
        public int lengthOfShortUrl;
        private Map<String, String> shortToLongUrlMap; // short url is key,
        private Map<String, String> longToShortUrlMap; // long url to short url mapping, long url is the key
        private ArrayList<Character> allowedChars;


        // a - z, A - Z, 0 - 9,
        // https://www.flipkart.com/shopping_cart/2345/bill  --> https://abc.com/7d3i

        UrlShortener(){
            this("abc.com", 5);
        }

        UrlShortener(String domain, int length){
            this.domain = domain;
            this.lengthOfShortUrl = length;

            this.shortToLongUrlMap = new HashMap<>();
            this.longToShortUrlMap = new HashMap<>();

            this.allowedChars = new ArrayList<>();

            for(char i = 'a'; i <= 'z'; i++){
                this.allowedChars.add(i);
            }

            for(char i = 'A'; i <= 'Z'; i++){
                this.allowedChars.add(i);
            }

            for(char i = '0'; i <= '9'; i++){
                this.allowedChars.add(i);
            }
        }

        // a5f1 - flipkart.com
        // a5d5 - walmart.com
        //      - flipkart.com
        public String shortenUrl(String longUrl){ // returning short url

            if(longUrl.length() <= this.lengthOfShortUrl){
                return longUrl;
            }

            if(longToShortUrlMap.containsKey(longUrl)){
                return longToShortUrlMap.get(longUrl);
            }

            String shortUrl = this.domain + "/" ;
            while(true) {
                for (int i = 0; i < this.lengthOfShortUrl; i++) {
                    Random random = new Random();
                    int index = random.nextInt(62);  // 0 - 61
                    char ch = this.allowedChars.get(index);
                    shortUrl += ch;
                }

                if (!shortToLongUrlMap.containsKey(shortUrl)) {
                    // Here it means that we have generated a unique short url
                    break;
                }

                // It means that short url which is generated already exists, so we need to generate a newer one
            }

            // a5f1 - flipkart.com
            // 5sf2 - walmart.com
            shortToLongUrlMap.put(shortUrl, longUrl);
            longToShortUrlMap.put(longUrl, shortUrl);
            return shortUrl;
        }

        public String expandUrl(String shortUrl) throws Exception { // returning long url

            if(shortToLongUrlMap.containsKey(shortUrl)){
                return shortToLongUrlMap.get(shortUrl);
            }

            throw new Exception("No short url found");
        }

    }


















    // Java EE - Tomcat
// Embedded server -




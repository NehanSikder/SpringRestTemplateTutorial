package com.sikder;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class main {

    public static void main(String[] args) {

//        VALUES TO READ FROM CONFIGURATION
        String resourceUrl = "https://api.yelp.com/v3/businesses/search?location=\"350 5th Ave, New York, NY 10118\"";
        String restApiKey = "V9bDm7aNSzKPAXtDArUjtwiotsYdoGTlBfHL1-XlpJP2jyW8GSbqv9cYDu3vEqYegzWc7keNaaicqsaLQuYyhL2cL9uyatkcJHVKQWMv6nwtKAzxMiO-pqcD_CuiXXYx";

//      MAKE REQUEST
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + restApiKey);
//        ResponseEntity<String> responseEntity = restTemplate.getForEntity(resourceUrl, String.class);
        HttpEntity<String> requestHeader = new HttpEntity<String>(headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                resourceUrl,
                HttpMethod.GET,
                requestHeader,
                String.class
        );

//      GET VALUE FROM RESPONSE
        System.out.println(responseEntity.getStatusCode());
    }



}

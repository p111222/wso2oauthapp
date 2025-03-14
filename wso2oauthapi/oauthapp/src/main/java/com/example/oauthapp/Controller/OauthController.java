package com.example.oauthapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@RestController
public class OauthController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/token", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getToken() {
        String url = "https://api.kriate.co.in:8344/oauth2/token";

        // Set headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        headers.set("Authorization", "Basic YVFDcjR4ajhnVU9WUXBBcTFra3ozbWR5WkZvYTpmbHRZaHFrcG90NEY3R2VXZmp1QVRXU1BjY1lh");

        // Set form data using MultiValueMap
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("grant_type", "password");
        body.add("username", "admin");
        body.add("password", "admin");
        body.add("scope", "apim:api_create apim:api_manage");

        // Create entity
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(body, headers);

        // RestTemplate call
        String response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class).getBody();

        return response;
    }
}

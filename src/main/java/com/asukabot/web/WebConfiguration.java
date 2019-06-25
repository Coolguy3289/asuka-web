package com.asukabot.web;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@SpringBootApplication
public class WebConfiguration {

    @RequestMapping("/")
    public String index() {
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getClass().getCanonicalName());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        OAuth2AuthenticationToken token = (OAuth2AuthenticationToken) authentication;
        token.getPrincipal().getAttributes();
        Map<String, Object> details = token.getPrincipal().getAttributes();
        if (details != null)
            for (Object o : details.keySet()) {
                System.out.print("item:" + o + " val: ");
                System.out.println(details.get(o));
            }
        return "home";
    }
}

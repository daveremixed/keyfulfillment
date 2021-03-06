package com.gonzobeans.keyfulfillment.controller;

import com.gonzobeans.keyfulfillment.model.App;
import com.gonzobeans.keyfulfillment.service.AppService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class AppController {
    private static final Logger LOG = LoggerFactory.getLogger(AppController.class);
    private static final String COOKIE_NAME = "org.gonzobeans.keyfulfillment.token";
    private final AppService appService;

    @Autowired
    public AppController(AppService appService) {
        this.appService = appService;
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<App> getApp(@PathVariable("name") String name,
                                      @CookieValue(COOKIE_NAME) String token) {
        App app = appService.getApp(token);
        if (!app.getName().equals(name)) {
            throw new IllegalArgumentException("Application requested does not match token");
        }
        return new ResponseEntity<>(app, HttpStatus.OK);
    }

}

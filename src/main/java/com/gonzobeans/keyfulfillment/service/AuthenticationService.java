package com.gonzobeans.keyfulfillment.service;

import com.gonzobeans.keyfulfillment.dao.Persistence;
import com.gonzobeans.keyfulfillment.model.App;
import com.gonzobeans.keyfulfillment.util.CodeGenerator;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;


@Service
public class AuthenticationService {
    private static final int MAX_CACHE_SIZE = 1000;
    private static final int TIMEOUT = 15;

    private Cache<String, App> authenticationCache;
    private Persistence persistence;

    @Autowired
    public AuthenticationService(Persistence persistence) {
         authenticationCache = CacheBuilder.newBuilder()
                 .expireAfterAccess(TIMEOUT, TimeUnit.MINUTES)
                 .maximumSize(MAX_CACHE_SIZE)
                 .build();
    }

    public String getToken(String appName,  String appSecret) {
        if (appName == null || appSecret == null) {
            throw new IllegalArgumentException("appName and appSecret must not be null");
        }
        App app = persistence.getApp(appName);
        if (appSecret.equals(app.getSecret())) {
            String token = CodeGenerator.createSecret();
            app.setSecret(null);
            authenticationCache.put(token, app);
            return token;
        } else {
            throw new IllegalArgumentException("That appName & appSecret combination is not found");
        }
    }

    public App getAppFromToken(String token) {
        if (token == null) {
            throw new IllegalArgumentException("Token must not be null");
        }
        App app = authenticationCache.getIfPresent(token);
        if (app  == null)  {
            throw new IllegalArgumentException("Token does not exist or is expired. Please re-authenticate");
        }
        return new App(app);
    }


}

package com.gonzobeans.keyfulfillment.service;

import com.gonzobeans.keyfulfillment.model.App;
import org.springframework.stereotype.Service;

@Service
public class AppService {

    public App createApp(String name, String description, String codeType, int codeSize){
        App app = new App();
        return app;
    }

    public App getAppByName(String appName) {
        //Look up the app
        // remove the secret
        //return the app
        return new App();
    }

}

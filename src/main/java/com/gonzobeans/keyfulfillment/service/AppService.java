package com.gonzobeans.keyfulfillment.service;

import com.gonzobeans.keyfulfillment.dao.Persistence;
import com.gonzobeans.keyfulfillment.model.App;
import com.gonzobeans.keyfulfillment.model.CodeType;
import com.gonzobeans.keyfulfillment.util.CodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppService {

    private AuthenticationService authenticationService;
    private Persistence persistence;

    @Autowired
    public AppService(AuthenticationService authenticationService, Persistence persistence) {
        this.authenticationService = authenticationService;

    }

    public App createApp(String name, String description, String codeType, int codeSize){
        App app = new App.Builder()
                .withName(name)
                .withDescription(description)
                .withCodeType(CodeType.create(codeType))
                .withCodeSize(codeSize)
                .withSecret(CodeGenerator.createSecret())
                .build();
        persistence.createApp(app);
        return new App();
    }

    public App getApp(String token) {
        return authenticationService.getAppFromToken(token);
    }

}

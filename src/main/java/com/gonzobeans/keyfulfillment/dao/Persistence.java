package com.gonzobeans.keyfulfillment.dao;

import com.gonzobeans.keyfulfillment.exception.ItemAlreadyExistsException;
import com.gonzobeans.keyfulfillment.model.App;
import com.gonzobeans.keyfulfillment.model.dao.RdbApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

@Component
public class Persistence {
    private AppRepository appRepository;
    private ConversionService conversionService;

    @Autowired
    public Persistence (AppRepository appRepository, ConversionService conversionService) {
        this.appRepository = appRepository;
        this.conversionService = conversionService;
    }

    public void createApp(App app) {
        if (appRepository.findByName(app.getName()) != null) {
            throw new ItemAlreadyExistsException("An application with this name already exists.");
        }
        appRepository.save(new RdbApp(app));
    }

    public App getApp(String appName) {
        return appRepository.findByName(appName);
    }
}

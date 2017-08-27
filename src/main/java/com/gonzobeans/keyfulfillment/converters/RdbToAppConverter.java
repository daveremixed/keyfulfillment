package com.gonzobeans.keyfulfillment.converters;

import com.gonzobeans.keyfulfillment.model.dao.RdbApp;
import com.gonzobeans.keyfulfillment.model.App;
import org.springframework.core.convert.converter.Converter;


public class RdbToAppConverter implements Converter<RdbApp, App> {

    @Override
    public App convert(RdbApp rdbApp) {
        return new App();
    }
}

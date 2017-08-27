package com.gonzobeans.keyfulfillment.converters;

import com.gonzobeans.keyfulfillment.dao.entity.RdbApp;
import com.gonzobeans.keyfulfillment.entity.App;
import org.springframework.core.convert.converter.Converter;


public class RdbToAppConverter implements Converter<App, RdbApp> {

    @Override
    public RdbApp convert(App app) {
        return new RdbApp();
    }
}

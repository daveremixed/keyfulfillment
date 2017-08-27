package com.gonzobeans.keyfulfillment.converters;

import com.gonzobeans.keyfulfillment.model.Key;
import com.gonzobeans.keyfulfillment.model.dao.RdbKey;
import org.springframework.core.convert.converter.Converter;

public class RdbToKeyConverter implements Converter<RdbKey, Key> {

    public Key convert(RdbKey rdbKey) {
        return new Key();
    }
}

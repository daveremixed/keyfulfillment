package com.gonzobeans.keyfulfillment.converters;

import com.gonzobeans.keyfulfillment.model.KeySet;
import com.gonzobeans.keyfulfillment.model.dao.RdbKeySet;
import org.springframework.core.convert.converter.Converter;

public class RdbToKeySetConverter implements Converter<RdbKeySet, KeySet> {

    @Override
    public KeySet convert(RdbKeySet rdbKeySet) {
        return new KeySet();
    }
}

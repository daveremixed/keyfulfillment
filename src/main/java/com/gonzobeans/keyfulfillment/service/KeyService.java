package com.gonzobeans.keyfulfillment.service;

import com.gonzobeans.keyfulfillment.dao.Persistence;
import com.gonzobeans.keyfulfillment.model.App;
import com.gonzobeans.keyfulfillment.model.KeySet;
import com.gonzobeans.keyfulfillment.model.KeyStatus;
import com.gonzobeans.keyfulfillment.model.response.RedeemKeyResponse;
import com.gonzobeans.keyfulfillment.model.response.ServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KeyService {

    private AuthenticationService authSerivice;
    private Persistence persistence;

    @Autowired
    public KeyService(AuthenticationService authSerivice, Persistence persistence) {
        this.authSerivice = authSerivice;
    }

    public void createKeySet(String token) {
        App app = authSerivice.getAppFromToken(token);

    }

    public void getKeySet(String token, String keySetName) {
        App app = authSerivice.getAppFromToken(token);

    }

    public void updateKeySet(String token, KeySet keySet) {
        App app = authSerivice.getAppFromToken(token);

    }

    public List<String> createKeys(String token, String keySetName, int numKeys) {
        List<String> keyValues = new ArrayList<>();

        return keyValues;
    }

    public void setKeyStatusBatch(String token, List<String> keyValues, KeyStatus fromStatus, KeyStatus toStatus) {

    }

    public RedeemKeyResponse redeemKey(String token, String keyValue) {
        App app = authSerivice.getAppFromToken(token);

        // Get the key
        // Get the KeySet
        // Get the App

        //Validate the key

        //Return Response
        return new RedeemKeyResponse();
    }
}

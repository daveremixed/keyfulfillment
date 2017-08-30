package com.gonzobeans.keyfulfillment.dao;

import com.gonzobeans.keyfulfillment.model.App;
import com.gonzobeans.keyfulfillment.model.Key;
import com.gonzobeans.keyfulfillment.model.KeySet;

public class PostGresPersistenceImpl implements Persistence {
    @Override
    public App getApp(String appName) {
        return null;
    }

    @Override
    public void createApp(App app) {

    }

    @Override
    public void updateApp(App app) {

    }

    @Override
    public void disableApp(App app) {

    }

    @Override
    public KeySet getKeySet(String appName, String keySetName) {
        return null;
    }

    @Override
    public void updateKeySet(String appName, KeySet keyset) {

    }

    @Override
    public void disableKeySet(String appName, String keySetName) {

    }

    @Override
    public Key getKey(String appName, String keyValue) {
        return null;
    }

    @Override
    public void updateKey(String appName, Key key) {

    }
}

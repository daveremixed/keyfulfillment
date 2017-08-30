package com.gonzobeans.keyfulfillment.dao;

import com.gonzobeans.keyfulfillment.model.App;
import com.gonzobeans.keyfulfillment.model.Key;
import com.gonzobeans.keyfulfillment.model.KeySet;

public interface Persistence {

    App getApp(String appName);

    void createApp(App app);

    void updateApp(App app);

    void disableApp(App app);

    KeySet getKeySet(String appName, String keySetName);

    void updateKeySet(String appName, KeySet keyset);

    void disableKeySet(String appName, String keySetName);

    Key getKey(String appName, String keyValue);

    void updateKey(String appName, Key key);


}

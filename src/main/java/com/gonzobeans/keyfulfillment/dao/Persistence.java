package com.gonzobeans.keyfulfillment.dao;

import com.gonzobeans.keyfulfillment.entity.App;
import com.gonzobeans.keyfulfillment.entity.KeySet;

public interface Persistence {

    App getApp(String appName);

    void createApp(App app);

    void updateApp(App app);

    void disableApp(App app);

    KeySet getKeySet(String appName, String keySetName);

    void disableKeySet(String appName, String keySetName);


}

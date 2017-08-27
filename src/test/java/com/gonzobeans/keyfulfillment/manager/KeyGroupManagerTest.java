package com.gonzobeans.keyfulfillment.manager;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by Dave on 5/29/2017.
 */
public class KeyGroupManagerTest {

    private AppManager manager;

    @Before
    public void setup() {
        manager = new AppManager();
    }

    @Test
    public void createKeyGroupTest() {
        manager.createApp("testGroup", "This is a test description.");
    }


}

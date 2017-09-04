package com.gonzobeans.keyfulfillment.model.dao;
import com.gonzobeans.keyfulfillment.model.App;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RdbApp extends App {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private boolean deleted;

    public RdbApp() {
        super();
    }

    public RdbApp(App app) {
        super(app);
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }


}

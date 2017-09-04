package com.gonzobeans.keyfulfillment.dao;

import com.gonzobeans.keyfulfillment.model.dao.RdbApp;
import org.springframework.data.repository.CrudRepository;

public interface AppRepository extends CrudRepository<RdbApp, Long> {

    RdbApp findByName(String name);
}

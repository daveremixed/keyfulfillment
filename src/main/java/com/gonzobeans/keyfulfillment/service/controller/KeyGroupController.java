package com.gonzobeans.keyfulfillment.service.controller;

import com.gonzobeans.keyfulfillment.entity.KeyGroup;
import com.gonzobeans.keyfulfillment.exception.IllegalNameException;
import com.gonzobeans.keyfulfillment.exception.ItemAlreadyExistsException;
import com.gonzobeans.keyfulfillment.manager.KeyGroupManager;
import com.gonzobeans.keyfulfillment.service.response.ErrorResponse;
import com.gonzobeans.keyfulfillment.service.response.KeyGroupResponse;
import com.gonzobeans.keyfulfillment.service.response.ServiceResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/keygroup")
public class KeyGroupController {
    private static final Logger LOG = LoggerFactory.getLogger(KeyGroupController.class);
    private final KeyGroupManager manager;

    KeyGroupController() {
        this.manager = new KeyGroupManager();
    }

    @RequestMapping(method=RequestMethod.POST)
    public @ResponseBody ServiceResponse createKeyGroup(@RequestBody KeyGroup keyGroup) {

        try {
            KeyGroup kg = manager.createKeyGroup(keyGroup.getName(), keyGroup.getDescription());
            KeyGroupResponse response = new KeyGroupResponse(kg.getName(), kg.getDescription());
            response.setSecret(kg.getSecret());
            return response;
        } catch(ItemAlreadyExistsException | IllegalNameException ex) {
            return new ErrorResponse(ex.getMessage());
        }
    }

    @RequestMapping(value="/{keyGroup}",  method=RequestMethod.PUT)
    public @ResponseBody ServiceResponse updateKeyGroup(@RequestBody KeyGroup keyGroup) {
        return new ErrorResponse("Not Yet Implemented");
    }

    @RequestMapping(value="/{keyGroup}", method=RequestMethod.GET)
    public @ResponseBody ServiceResponse getKeyGroup(@PathVariable String keyGroup) {
        return new KeyGroupResponse(keyGroup, "This is a test description");
    }

    @RequestMapping(value="/{keyGroup}", method=RequestMethod.DELETE)
    public @ResponseBody ServiceResponse deleteKeyGroup(@PathVariable String keyGroup) {
        return new KeyGroupResponse(keyGroup, "This is a test description");
    }
}

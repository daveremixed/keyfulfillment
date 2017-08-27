package com.gonzobeans.keyfulfillment.service.controller;

import com.gonzobeans.keyfulfillment.entity.App;
import com.gonzobeans.keyfulfillment.exception.IllegalNameException;
import com.gonzobeans.keyfulfillment.exception.ItemAlreadyExistsException;
import com.gonzobeans.keyfulfillment.exception.ServiceException;
import com.gonzobeans.keyfulfillment.manager.AppManager;
import com.gonzobeans.keyfulfillment.service.response.ErrorResponse;
import com.gonzobeans.keyfulfillment.service.response.KeyGroupResponse;
import com.gonzobeans.keyfulfillment.service.response.ServiceResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/keygroup")
public class AppController {
    private static final Logger LOG = LoggerFactory.getLogger(AppController.class);


    /**
     * Create
     * @param keyGroup
     * @return
     */
    @RequestMapping(method=RequestMethod.POST)
    public HttpEntity<?> createKeyGroup(@RequestBody App keyGroup) {

        try {
            App kg = manager.createApp(keyGroup.getName(), keyGroup.getDescription());
            KeyGroupResponse response = new KeyGroupResponse(kg);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch(ItemAlreadyExistsException | IllegalNameException | ServiceException ex) {
            return new ResponseEntity<>(new ErrorResponse(ex), HttpStatus.CONFLICT);
        }
    }

    /**
     * Read
     * @param keyGroup
     * @return
     */
    @RequestMapping(value="/{keyGroup}", method=RequestMethod.GET)
    public @ResponseBody ServiceResponse getKeyGroup(@PathVariable String keyGroup) {
        return new KeyGroupResponse(keyGroup, "This is a test description");
    }

    /**
     * Update
     * @param keyGroup
     * @return
     */
    @RequestMapping(value="/{keyGroup}",  method=RequestMethod.PUT)
    public @ResponseBody ServiceResponse updateKeyGroup(@RequestBody App keyGroup) {
        return new ErrorResponse("Not Yet Implemented");
    }

    /**
     * Delete
     * @param keyGroup
     * @return
     */
    @RequestMapping(value="/{keyGroup}", method=RequestMethod.DELETE)
    public @ResponseBody ServiceResponse deleteKeyGroup(@PathVariable String keyGroup) {
        return new KeyGroupResponse(keyGroup, "This is a test description");
    }
}

package com.gonzobeans.keyfulfillment.service.controller;

import com.gonzobeans.keyfulfillment.entity.KeyGroup;
import com.gonzobeans.keyfulfillment.service.response.ErrorResponse;
import com.gonzobeans.keyfulfillment.service.response.KeyGroupResponse;
import com.gonzobeans.keyfulfillment.service.response.ServiceResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/keygroup")
public class KeyGroupController {
    private static final Logger LOG = LoggerFactory.getLogger(KeyGroupController.class);

    @RequestMapping(method=RequestMethod.POST)
    public @ResponseBody ServiceResponse createKeyGroup(@RequestBody KeyGroup keyGroup) {
        KeyGroupResponse response = new KeyGroupResponse(keyGroup.getName(), keyGroup.getDescription());
        response.setSecret("SECRETSECRETSHHH");
        return response;
    }

    @RequestMapping(value="/{keyGroup}",  method=RequestMethod.PUT)
    public @ResponseBody ServiceResponse updateKeyGroup(@PathVariable String keyGroup) {
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

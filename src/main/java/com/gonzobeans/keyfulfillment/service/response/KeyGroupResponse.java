package com.gonzobeans.keyfulfillment.service.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.gonzobeans.keyfulfillment.entity.App;
import org.springframework.hateoas.ResourceSupport;

/**
 * Created by Dave on 5/29/2017.
 */

public class KeyGroupResponse extends ResourceSupport {

    private App content;

    @JsonCreator
    public KeyGroupResponse(App keyGroup) {
        this.content = keyGroup;
    }

}

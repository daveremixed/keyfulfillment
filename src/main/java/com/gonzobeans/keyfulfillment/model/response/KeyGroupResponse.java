package com.gonzobeans.keyfulfillment.model.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.gonzobeans.keyfulfillment.model.App;
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

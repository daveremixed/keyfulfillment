package com.gonzobeans.keyfulfillment.controller;

import com.gonzobeans.keyfulfillment.model.response.PingResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Simple Ping Controller
 */
@RestController
public class PingController {
    private Logger LOG = LoggerFactory.getLogger(PingResponse.class);

    @RequestMapping("/ping")
    public PingResponse ping(HttpServletRequest request) {
        LOG.info("Ping request from " +  request.getRemoteAddr());
        return new PingResponse();
    }
}

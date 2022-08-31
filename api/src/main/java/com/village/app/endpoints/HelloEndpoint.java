package com.village.app.endpoints;

import com.village.app.logic.HelloLogic;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloEndpoint {
    @GetMapping(path = "/hello")
    @ResponseBody
    public String hello(@RequestParam(required = false) String what) {
        return HelloLogic.hello(what);
    }

    @GetMapping(path = "/hello2")
    @ResponseBody
    public String hello2(@RequestParam(defaultValue = "WORLD") String what) {
        return HelloLogic.hello2(what);
    }

    @GetMapping(path = "/helloJSON", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String helloJSON(@RequestParam(defaultValue = "WORLD") String what) {
        return HelloLogic.helloJSON(what);
    }
}

package com.example.welcome.hello;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

class HelloServlet {
    private static final String NAME_PARAM = "name";
    private static final String LANG_PARAM = "lang";
    private final Logger logger = LoggerFactory.getLogger(HelloServlet.class);
    private HelloService service;


    @Autowired
    HelloServlet(HelloService service){

        this.service = service;
    }
    @GetMapping("/api") // w przypadku nie podania imienia i jezyka
    String welcome() {
       return welcome (null, null);
    }
    @GetMapping(value = "/api", params ={"lang","name"})
    String welcome(@RequestParam("lang") Integer langId, @RequestParam("name") String name)  {
        logger.info("Got request ");
        return service.prepareGreeting(name,langId);

    }
}

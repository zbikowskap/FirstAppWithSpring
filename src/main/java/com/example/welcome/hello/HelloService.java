package com.example.welcome.hello;

import com.example.welcome.lang.Lang;
import com.example.welcome.lang.LangRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
class HelloService {
    static final String FALLBACK_NAME = "world";
    static final Lang FALLBACK_LANG = new Lang(1, "Hello", "EN");
    private final Logger logger = LoggerFactory.getLogger(HelloService.class);
    private LangRepository repository;

@Autowired
    HelloService(LangRepository repository) {
        this.repository = repository;
    }

    //   String prepareGreeting(String name){
//       return prepareGreeting(name,null);
//   }
    String prepareGreeting(String name, Integer langId) {
            langId = Optional.ofNullable(langId).orElse(FALLBACK_LANG.getId());
        var welcomeMsg = repository.findById(langId).orElse(FALLBACK_LANG).getWelcomeMsg();
        var nameToWelcome = Optional.ofNullable(name).orElse(FALLBACK_NAME);
        return welcomeMsg + " " + nameToWelcome + "!";
    }
}

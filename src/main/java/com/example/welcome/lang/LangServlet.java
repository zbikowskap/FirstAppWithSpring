package com.example.welcome.lang;



import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController //controller + responseBody
    @RequestMapping("/api")
class LangServlet{
    private final Logger logger = LoggerFactory.getLogger(LangServlet.class);

    private LangService service;

    LangServlet(LangService service, ObjectMapper mapper){
        this.service = service;
    }
  @GetMapping("/langs")
    ResponseEntity<List<LangDTO>> findAllLangs() {
        logger.info("Got request ");
        return ResponseEntity.ok(service.findAll());
    }
}

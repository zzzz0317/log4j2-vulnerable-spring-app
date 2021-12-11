package net.asec01.log4j2springvulnerableapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Controller
public class MainController {
    static Logger log = LogManager.getLogger(MainController.class.getName());

    @GetMapping(value = "/vulnerable_request_get", produces = "application/json; charset=utf-8")
    @ResponseBody
    public static Response requestGet(String v){
        log.info("vulnerable_request_get v={}", v);
        if (v == null){
            return new Response("vulnerable_request_get", "use get request v=payload to test this vulnerable point");
        }
        return new Response("vulnerable_request_get", v);
    }

    @PostMapping(value = "/vulnerable_request_post", produces = "application/json; charset=utf-8")
    @ResponseBody
    public static Response requestPost(String v){
        log.info("vulnerable_request_post v={}", v);
        if (v == null){
            return new Response("vulnerable_request_post", "use get request v=payload to test this vulnerable point");
        }
        return new Response("vulnerable_request_post", v);
    }

    @RequestMapping(value = "/vulnerable_request_header_ua", produces = "application/json; charset=utf-8")
    @ResponseBody
    public static Response requestHeaderUA(@RequestHeader("User-Agent") String useragent){
        log.info("vulnerable_request_header_ua User-Agent: {}", useragent);
        return new Response("vulnerable_request_header_ua", useragent);
    }
}

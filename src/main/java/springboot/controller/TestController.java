package springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springboot.service.TestService;

@RestController
@RequestMapping("/api")
public class TestController {

    @Autowired
    private TestService testService;

    public TestController() {
        System.out.println("controller constructor");
    }

    @GetMapping("/test")
    public String test(String tesr) {
        System.out.println("controller");
        return testService.test();
    }

}

package springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springboot.service.TestService;
import springboot.webAwareScopes.ApplicationScopeClass;
import springboot.webAwareScopes.RequestScopeClass;
import springboot.webAwareScopes.SessionScopeClass;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api")
public class TestController {

    @Autowired
    private TestService testService;

    @Autowired
    private RequestScopeClass requestScopeClass;

    @Autowired
    private SessionScopeClass sessionScopeClass;

    @Autowired
    private ApplicationScopeClass applicationScopeClass;

    public TestController() {
        System.out.println("controller constructor");
    }

    @GetMapping("/test")
    public String test(HttpSession httpSession) {
        httpSession.invalidate();//invalidate new session to update session bean
        System.out.println("controller");
        String reqScCl = requestScopeClass.callMethod();
        String sesScCl = sessionScopeClass.callMethod();
        String appScCl = applicationScopeClass.callMethod();
        return "requestScope controller " + reqScCl + " sessionScope controller " + sesScCl + " applicationScope controller " +
                appScCl + " testService " + testService.test();
    }

}

package springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.webAwareScopes.ApplicationScopeClass;
import springboot.webAwareScopes.RequestScopeClass;
import springboot.webAwareScopes.SessionScopeClass;

@Service
public class TestService {

    @Autowired
    private RequestScopeClass requestScopeClass;

    @Autowired
    private SessionScopeClass sessionScopeClass;

    @Autowired
    private ApplicationScopeClass applicationScopeClass;

    public TestService() {
        System.out.println("service constructor");
    }

    public String test() {
        System.out.println("service");
        return requestScopeClass.callMethod() + " " + sessionScopeClass.callMethod() +
                " " + applicationScopeClass.callMethod() + " success";
    }
}

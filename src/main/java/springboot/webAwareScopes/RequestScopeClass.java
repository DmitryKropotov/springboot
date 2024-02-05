package springboot.webAwareScopes;


import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class RequestScopeClass {

    private int called = 0;

    private static int calledPrivate = 0;

    public RequestScopeClass() {
        System.out.println("RequestScopeClass constructor");
    }

    public String callMethod() {
        System.out.println("RequestScopeClass callMethod");
        called++;
        calledPrivate++;
        return "Hello from scope request " + called + " " + calledPrivate;
    }
}

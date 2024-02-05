package springboot.webAwareScopes;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionScopeClass {

    private int called = 0;

    private static int calledPrivate = 0;

    public SessionScopeClass() {
        System.out.println("SessionScopeClass constructor");
    }

    public String callMethod() {
        System.out.println("SessionScopeClass callMethod");
        called++;
        calledPrivate++;
        return "Hello from scope session " + called + " " + calledPrivate;
    }
}

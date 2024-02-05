package springboot.webAwareScopes;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value = WebApplicationContext.SCOPE_APPLICATION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ApplicationScopeClass {

    private int called = 0;

    private static int calledPrivate = 0;

    public ApplicationScopeClass() {
        System.out.println("ApplicationScopeClass constructor");
    }

    public String callMethod() {
        System.out.println("ApplicationScopeClass callMethod");
        called++;
        calledPrivate++;
        return "Hello from scope application " + called + " " + calledPrivate;
    }
}

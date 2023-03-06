package mg.tonymushah.nanami.router;

import java.util.HashMap;
import java.util.Set;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mg.tonymushah.nanami.thymeleaf.Component;
import mg.tonymushah.nanami.thymeleaf.ComponentEngine;

public abstract class AbstractRoute<T> {
    private HashMap<String, Object> context;
    public abstract String render(ComponentEngine engine);
    public abstract Set<Class<? extends AbstractRoute<?>>> getOutletPagesClass();
    public abstract T useLoaderData();
    public abstract void loader(HttpServletRequest request, HttpServletResponse response);
    public abstract Component outlet(HashMap<String, Object> context);
    public HashMap<String, Object> getContext() {
        return context;
    }
    public void setContext(HashMap<String, Object> context) {
        this.context = context;
    }
    public Set<Class<?>> getOutletClasses() throws {}
}

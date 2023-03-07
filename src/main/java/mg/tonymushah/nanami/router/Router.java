package mg.tonymushah.nanami.router;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mg.tonymushah.nanami.router.routes.RootRoute;
import mg.tonymushah.nanami.thymeleaf.Component;
import mg.tonymushah.nanami.thymeleaf.ComponentEngine;

public abstract class Router {
    private RootRoute<?> root;
    private ComponentEngine engine;

    public Router(RootRoute<?> root, ComponentEngine engine) {
        this.setRoot(root);
        this.setEngine(engine);
    }

    public RootRoute<?> getRoot() {
        return root;
    }

    public void setRoot(RootRoute<?> root) {
        this.root = root;
    }

    public abstract Component onException(Exception exception);

    public void setEngine(ComponentEngine engine) {
        this.engine = engine;
    }

    public Component load(HttpServletRequest request, HttpServletResponse response) throws Exception{
        return root.load(request, response);
    }
    public Object loadAction(HttpServletRequest request, HttpServletResponse response) throws Exception{
        return root.loadAction(request, response);
    }
    public ComponentEngine getEngine() {
        return engine;
    }
}

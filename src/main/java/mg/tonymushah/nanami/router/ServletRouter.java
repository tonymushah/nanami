package mg.tonymushah.nanami.router;

import java.io.IOException;
import java.nio.charset.Charset;

import org.springframework.http.HttpMethod;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mg.tonymushah.nanami.router.routes.RootRoute;
import mg.tonymushah.nanami.thymeleaf.Component;
import mg.tonymushah.nanami.thymeleaf.ComponentEngine;

/*
 * 
 */
public abstract class ServletRouter extends HttpServlet {
    private RootRoute<?> root;
    private ComponentEngine engine;

    public ServletRouter(RootRoute<?> root, ComponentEngine engine) {
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

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        try {
            if (req.getMethod() == HttpMethod.GET.toString()) {
                Component getted = root.load(req, resp);
                getted.renderThrottled(engine).processAll(resp.getOutputStream(), Charset.defaultCharset());
            } else {
                root.loadAction(req, resp);
            }
        } catch (Exception e) {
            // TODO: handle exception
            this.onException(e).renderThrottled(engine).processAll(resp.getOutputStream(), Charset.defaultCharset());
        }
    }

    public ComponentEngine getEngine() {
        return engine;
    }
}

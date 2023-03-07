package pages;

import java.util.ArrayList;
import java.util.HashMap;

import org.thymeleaf.context.Context;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mg.tonymushah.nanami.router.RootRoute;
import mg.tonymushah.nanami.router.StaticRoute;
import mg.tonymushah.nanami.thymeleaf.Component;
import mg.tonymushah.nanami.thymeleaf.ComponentEngine;

public class Root extends RootRoute<String>{

    @Override
    public Component render(HashMap<String, ?> context) throws Exception {
        // TODO Auto-generated method stub
        Component root = new Component();
        root.setComponent("root");
        root.getChildren().add(this.outlet(null));
        root.getContext().setVariable("title", this.getTitle());
		return root;
    }

    @Override
    public Object action(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'action'");
    }

    @Override
    public Component handleError(Exception e) throws Exception {
        // TODO Auto-generated method stub
        Component error = new Component(new Context(), "rootErrorHandle");
        error.getContext().setVariable("message", e.getMessage());
        ArrayList<String> stackTrace = new ArrayList<String>();
        for (StackTraceElement stackTraceElement : e.getStackTrace()) {
            stackTrace.add(stackTraceElement.toString());
        }
        error.getContext().setVariable("stack", stackTrace);
        return error;
    }

    @Override
    public String loader(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'loader'");
    }
}

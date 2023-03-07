package pages;

import java.util.ArrayList;
import java.util.HashMap;

import org.thymeleaf.context.Context;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mg.tonymushah.nanami.router.routes.StaticRoute;
import mg.tonymushah.nanami.thymeleaf.Component;

public class Index extends StaticRoute<HashMap<String, Object>> {

    public Index(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
        //TODO Auto-generated constructor stub
    }

    @Override
    public HashMap<String, Object> loader(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // TODO Auto-generated method stub
        HashMap<String, Object> returns = new HashMap<String, Object>();
        String name = request.getParameter("name");
        returns.put("name", name == null ? "World" : name);
        returns.put("path", request.getServletPath());
        this.getRoot().setTitle(String.format("Hello %s", name));
        return returns;
    }

    @Override
    public Object action(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'action'");
    }

    @Override
    public Component handleError(Exception e) throws Exception {
        // TODO Auto-generated method stub
        Component error = new Component(new Context(), "error");
        error.getContext().setVariable("message", e.getMessage());
        ArrayList<String> stackTrace = new ArrayList<String>();
        for (StackTraceElement stackTraceElement : e.getStackTrace()) {
            stackTrace.add(stackTraceElement.toString());
        }
        error.getContext().setVariable("stack", stackTrace);
        return error;
    }


    @Override
    public Component render(HashMap<String, ?> context) {
        // TODO Auto-generated method stub
        Component hello_cmp = new Component(new Context(), "hello");
		hello_cmp.getContext().setVariables(this.useLoaderData());
        return hello_cmp;
    }
    
}

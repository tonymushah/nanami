package pages;

import java.util.ArrayList;
import java.util.HashMap;

import org.thymeleaf.context.Context;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mg.tonymushah.nanami.router.routes.StaticRoute;
import mg.tonymushah.nanami.thymeleaf.Component;

public class User extends StaticRoute<Object> {

    public User(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
        //TODO Auto-generated constructor stub
    }

    @Override
    public Component render(HashMap<String, ?> context) throws Exception {
        // TODO Auto-generated method stub
        Component to_returns = new Component(new Context(), "user/layout");
        to_returns.getChildren().add(this.outlet(null));
        return to_returns;
    }

    @Override
    public Object loader(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // TODO Auto-generated method stub
        
        throw new UnsupportedOperationException("Unimplemented method 'loader'");
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

}

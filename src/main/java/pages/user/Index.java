package pages.user;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

import org.thymeleaf.context.Context;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mg.tonymushah.nanami.router.routes.StaticRoute;
import mg.tonymushah.nanami.thymeleaf.Component;
import models.User;

public class Index extends StaticRoute<ArrayList<User>>{

    public Index(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
        //TODO Auto-generated constructor stub
    }

    @Override
    public ArrayList<User> loader(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // TODO Auto-generated method stub
        ArrayList<User> to_returns = new ArrayList<User>();
        to_returns.add(new User("Dirk Tony", "tonymushah"));
        return to_returns;
    }

    @Override
    public Object action(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'action'");
    }

    @Override
    public Component outlet(HashMap<String, Object> context) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'outlet'");
    }

    @Override
    public Component handleError(Exception e) throws Exception {
        // TODO Auto-generated method stub
        throw e;
    }


    @Override
    public Component render(HashMap<String, ?> context) throws Exception {
        // TODO Auto-generated method stub
        this.getRoot().setTitle("User Title");
        Component component = new Component(new Context(), "user/index");
        component.getContext().setVariable("users", useLoaderData());
        return component;
    }
    
}

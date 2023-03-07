package pages.user;

import java.util.HashMap;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mg.tonymushah.nanami.router.StaticRoute;
import mg.tonymushah.nanami.thymeleaf.Component;

public class Tony extends StaticRoute<Object> {

    public Tony(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
        //TODO Auto-generated constructor stub
    }

    @Override
    public Component render(HashMap<String, ?> context) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'render'");
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
        throw new UnsupportedOperationException("Unimplemented method 'handleError'");
    }
    
}

package mg.tonymushah.nanami.router.routes;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public abstract class DynamicRoute<T> extends AbstractRoute<T> {

    public DynamicRoute(HttpServletRequest request, HttpServletResponse response) {
        super(request, response);
        //TODO Auto-generated constructor stub
    }
    
}

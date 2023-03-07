package mg.tonymushah.nanami.router.routes;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mg.tonymushah.nanami.thymeleaf.Component;
import mg.tonymushah.utils.AccessingAllClassesInPackage;
import mg.tonymushah.utils.exceptions.PackageNotFoundException;

public abstract class RootRoute<T> extends AbstractRoute<T> {
    private String title; 

    @Override
    public AbstractRoute<?> getOutletRoute()
            throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
            NoSuchMethodException, SecurityException, ClassNotFoundException, PackageNotFoundException {
        // TODO Auto-generated method stub
        String current_path = "/";
        String servelet_path = new String(this.getRequest().getServletPath());
        String[] to_use_paths = servelet_path.split(current_path);
        String to_use_path = to_use_paths.length == 0 ? "" : to_use_paths[1];
        return this.getNestedRouteByName(to_use_path).getConstructor(HttpServletRequest.class, HttpServletResponse.class).newInstance(this.getRequest(), this.getResponse());
    }
    @Override
    public Component outlet(HashMap<String, Object> context) throws Exception {
        AbstractRoute<?> getted = this.getOutletRoute();
        getted.setRoot(this);
        return getted.load(context);
    }
    public RootRoute() {
        super(null, null);
        //TODO Auto-generated constructor stub
        this.setTitle("");
    }

    @Override
    public Set<Class<? extends AbstractRoute<?>>> getOutletPageClasses() throws PackageNotFoundException {
        // TODO Auto-generated method stub
        Set<Class<?>> classes = AccessingAllClassesInPackage.findAllClasses(this.getClass().getPackageName());
        Set<Class<? extends AbstractRoute<?>>> routes = new HashSet<Class<? extends AbstractRoute<?>>>();
        classes.forEach(new Consumer<Class<?>>() {

            @Override
            public void accept(Class<?> t) {
                // TODO Auto-generated method stub
                System.out.println();
                if(AbstractRoute.class.isAssignableFrom(t) == true && RootRoute.class.isAssignableFrom(t) == false){
                    routes.add((Class<? extends AbstractRoute<?>>) t);
                }
            }
            
        });
        return routes;
    }
    public Component load(HttpServletRequest request, HttpServletResponse response, HashMap<String, ?> context) throws Exception{
        this.setRequest(request);
        this.setResponse(response);
        return super.load(context);
    }
    public Component load(HttpServletRequest request, HttpServletResponse response) throws Exception{
        this.setRequest(request);
        this.setResponse(response);
        return super.load(null);
    }
    

    public Object loadAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // TODO Auto-generated method stub
        this.setRequest(request);
        this.setResponse(response);
        return super.loadAction();
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

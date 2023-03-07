package mg.tonymushah.nanami.router;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mg.tonymushah.nanami.thymeleaf.Component;
import mg.tonymushah.nanami.thymeleaf.ComponentEngine;
import mg.tonymushah.utils.AccessingAllClassesInPackage;
import mg.tonymushah.utils.exceptions.PackageNotFoundException;

public abstract class AbstractRoute<T> {
    private RootRoute<?> root;
    private T loader;
    private HttpServletRequest request;
    private HttpServletResponse response;
    public Object loadAction(){
        
    }
    public HttpServletRequest getRequest() {
        return request;
    }
    protected void setRequest(HttpServletRequest request) {
        this.request = request;
    }
    protected HttpServletResponse getResponse() {
        return response;
    }
    protected void setResponse(HttpServletResponse response) {
        this.response = response;
    }
    public AbstractRoute(HttpServletRequest request, HttpServletResponse response) {
        this.setRequest(request);
        this.setResponse(response);
    }
    public abstract Component render(HashMap<String, ?> context) throws Exception;
    public T useLoaderData(){
        return this.getLoader();
    }
    public abstract T loader(HttpServletRequest request, HttpServletResponse response) throws Exception;
    public abstract Object action(HttpServletRequest request, HttpServletResponse response) throws Exception;
    public Component outlet(HashMap<String, Object> context)throws Exception{
        String current_path = this.getClass().getName().replace('.', '/').replaceFirst(this.root.getClass().getPackageName(), "").toLowerCase();
        String servelet_path = new String(this.request.getServletPath());
        String[] to_use_paths = servelet_path.split(current_path);
        String to_use_path = "";
        if(to_use_paths.length != 0){
            to_use_path = to_use_paths[1].split("[/]")[1];
        }
        AbstractRoute<?> getted = this.getNestedRouteByName(to_use_path).getConstructor(HttpServletRequest.class, HttpServletResponse.class).newInstance(this.getRequest(), this.getResponse());
        getted.setRoot(this.getRoot());
        return getted.load(context);
    }
    public Set<Class<? extends AbstractRoute<?>>> getOutletPageClasses() throws PackageNotFoundException {
        Set<Class<?>> classes = AccessingAllClassesInPackage.findAllClasses(this.getClass().getName().toLowerCase());
        Set<Class<? extends AbstractRoute<?>>> routes = new HashSet<Class<? extends AbstractRoute<?>>>();
        classes.forEach(new Consumer<Class<?>>() {

            @Override
            public void accept(Class<?> t) {
                // TODO Auto-generated method stub
                if(AbstractRoute.class.isAssignableFrom(t)){
                    routes.add((Class<? extends AbstractRoute<?>>) t);
                }
            }
            
        });
        return routes;
    }
    public Class<? extends AbstractRoute<?>> getIndexNestedRoute() throws PackageNotFoundException, ClassNotFoundException{
        for (Class<? extends AbstractRoute<?>> class_ : getOutletPageClasses()) {
            if(class_.getSimpleName().toLowerCase().compareTo("index") == 0){
                return class_;
            }
        } 
        throw new ClassNotFoundException("Can't find the index route in the nested package");
    }
    public Class<? extends AbstractRoute<?>> getNestedRouteByName(String name) throws ClassNotFoundException, PackageNotFoundException{
        if(name.isBlank() == true && name.isEmpty()){
            return getIndexNestedRoute();
        }else{
            for (Class<? extends AbstractRoute<?>> class_ : getOutletPageClasses()) {
                if(class_.getSimpleName().compareToIgnoreCase(name) == 0){
                    return class_;
                }
            }
            throw new ClassNotFoundException(String.format("Can't find the %s route", name));
        }
    }
    protected T getLoader() {
        return loader;
    }
    protected void setLoader(T loader) {
        this.loader = loader;
    }
    public abstract Component handleError(Exception e) throws Exception;
    public Component load(HashMap<String, ?> context) throws Exception{
        try {
            try {
                this.setLoader(this.loader(this.getRequest(), this.getResponse()));
            } catch (UnsupportedOperationException e) {
                // TODO: handle exception
                this.setLoader(null);
            }
            return this.render(context);
        } catch (Exception e) {
            // TODO: handle exception
            return this.handleError(e);
        }
    }
    public RootRoute<?> getRoot() {
        return root;
    }
    public void setRoot(RootRoute<?> root) {
        this.root = root;
    }
    
}

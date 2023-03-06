package mg.tonymushah.nanami.thymeleaf;

import java.util.ArrayList;

import org.thymeleaf.context.AbstractContext;
import org.thymeleaf.context.Context;

public class Component {
    private AbstractContext context;
    private ArrayList<Component> children;
    private String component;
    public AbstractContext getContext() {
        return context;
    }
    public void setContext(AbstractContext context) {
        this.context = context;
    }
    public ArrayList<Component> getChildren() {
        return children;
    }
    public void setChildren(ArrayList<Component> children) {
        this.children = children;
    }
    public String getComponent() {
        return component;
    }
    public void setComponent(String component) {
        this.component = component;
    }
    public Component() {
        this.setContext(new Context());
        this.setChildren(new ArrayList<Component>());
    }
    public Component(AbstractContext context, String component) {
        this.context = context;
        this.component = component;
        this.setChildren(new ArrayList<Component>());
    }
    public String render(ComponentEngine engine){
        String children = new String();
        for (Component component : this.children) {
            children = children + component.render(engine);
            System.out.println(children);
        }
        ContextWithChildren contextWithChildren = new ContextWithChildren(children);
        for(String var_name : this.getContext().getVariableNames()){
            contextWithChildren.setVariable(var_name, this.getContext().getVariable(var_name));
        }
        return engine.process(this.getComponent(), contextWithChildren);
    }
}

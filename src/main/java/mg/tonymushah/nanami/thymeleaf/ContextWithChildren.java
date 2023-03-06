package mg.tonymushah.nanami.thymeleaf;

import java.util.Locale;
import java.util.Map;

import org.thymeleaf.context.AbstractContext;

public class ContextWithChildren extends AbstractContext{

    public ContextWithChildren() {
    }
    public ContextWithChildren(String children) {
        this.setVariable("children", children);
    }
    public ContextWithChildren(Locale locale) {
        super(locale);
        this.setVariable("children", "");
    }
    public ContextWithChildren(Locale locale, String children) {
        super(locale);
        this.setVariable("children", children);
    }
    public ContextWithChildren(Locale locale, Map<String, Object> variables) {
        super(locale, variables);
        this.setVariable("children", "");
    }
    public ContextWithChildren(Locale locale, Map<String, Object> variables, String children) {
        super(locale, variables);
        this.setVariable("children", children);
    }
    public void setChildren(String children){
        this.setVariable("children", children);
    }
}

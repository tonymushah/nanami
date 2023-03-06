package mg.tonymushah.nanami.thymeleaf;

import org.thymeleaf.spring6.SpringTemplateEngine;

/**
 * ProcessComponnent
 */
public class ComponentEngine extends SpringTemplateEngine {

    public ComponentEngine() {
        this.setTemplateResolver(Configuration.componentResolver());
    }
    
}
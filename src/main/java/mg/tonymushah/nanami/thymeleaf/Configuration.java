package mg.tonymushah.nanami.thymeleaf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Description;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

public class Configuration {
    @Description("Thymeleaf Componnent Resolver")
    public static ClassLoaderTemplateResolver componentResolver() {
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setPrefix("/components/");
        templateResolver.setSuffix(".nnm");
        templateResolver.setTemplateMode(TemplateMode.HTML);

        return templateResolver;
    }

    @Description("Thymeleaf Componnent Engine")
    public static ComponentEngine componentEngine() {
        ComponentEngine templateEngine = new ComponentEngine();
        return templateEngine;
    }
}

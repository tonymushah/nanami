package mg.tonymushah.nanami;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties.Tomcat;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.context.Context;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mg.tonymushah.nanami.router.RootRoute;
import mg.tonymushah.nanami.thymeleaf.Component;
import mg.tonymushah.nanami.thymeleaf.ComponentEngine;
import mg.tonymushah.nanami.thymeleaf.Configuration;
import pages.Root;

public class NanamiApplication  {
	RootRoute<?> root;
	Tomcat configTomcat;
	
}

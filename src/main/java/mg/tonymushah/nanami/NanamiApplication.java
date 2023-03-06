package mg.tonymushah.nanami;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.context.Context;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mg.tonymushah.nanami.thymeleaf.Component;
import mg.tonymushah.nanami.thymeleaf.ComponentEngine;
import mg.tonymushah.nanami.thymeleaf.Configuration;

@SpringBootApplication
@RestController
public class NanamiApplication {
	@RequestMapping("/**")
	public String process_request(HttpServletRequest request, HttpServletResponse response){
		String name = request.getParameter("name");
		ComponentEngine engine = Configuration.componentEngine();
		Component root = new Component();
		root.setComponent("root");
		root.getContext().setVariable("title", String.format("Hello %s!", name == null ? "World" : name));
		Component hello_cmp = new Component(new Context(), "hello");
		hello_cmp.getContext().setVariable("name", name == null ? "World" : name);
		for (int i = 0; i < 10; i++) {
			root.getChildren().add(hello_cmp);
		}
		return root.render(engine);
	}
	public static void main(String[] args) {
		SpringApplication.run(NanamiApplication.class, args);
	}

}

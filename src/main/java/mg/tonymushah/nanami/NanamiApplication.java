package mg.tonymushah.nanami;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mg.tonymushah.nanami.router.Router;

@SpringBootApplication
@RestController
public class NanamiApplication {
    private static Router router;
    @RequestMapping("/**")
    public void handleRequests(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        NanamiApplication.getRouter().service(request, response);
    }
    private static Router getRouter() {
        return router;
    }
    private static void setRouter(Router router) {
        NanamiApplication.router = router;
    }
    public NanamiApplication() {
    }
    public NanamiApplication(Router router) {
        NanamiApplication.setRouter(router);
    }
    public void run(String[] args) {
        SpringApplication app = new SpringApplication(NanamiApplication.class);
        app.run(args);
    }
}

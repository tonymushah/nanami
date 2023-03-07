package mg.tonymushah.nanami;

import java.util.ArrayList;

import org.thymeleaf.context.Context;

import mg.tonymushah.nanami.router.Router;
import mg.tonymushah.nanami.thymeleaf.Component;
import mg.tonymushah.nanami.thymeleaf.ComponentEngine;
import pages.Root;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Router router = new Router(new Root(), new ComponentEngine()) {

            @Override
            public Component onException(Exception exception) {
                // TODO Auto-generated method stub
                Component error = new Component(new Context(), "rootErrorHandle");
                error.getContext().setVariable("message", exception.getMessage());
                ArrayList<String> stackTrace = new ArrayList<String>();
                for (StackTraceElement stackTraceElement : exception.getStackTrace()) {
                    stackTrace.add(stackTraceElement.toString());
                }
                error.getContext().setVariable("stack", stackTrace);
                return error;
            }

        };
        new NanamiApplication(router).run(args);
    }
}
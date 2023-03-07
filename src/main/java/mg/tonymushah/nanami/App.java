package mg.tonymushah.nanami;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import mg.tonymushah.utils.AccessingAllClassesInPackage;
import mg.tonymushah.utils.exceptions.PackageNotFoundException;
import pages.Index;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws PackageNotFoundException {
        Set<Class<?>> pages = AccessingAllClassesInPackage.findAllClasses("pages");
        for (Class<?> page : pages) {
            System.out.println(page.getSimpleName());
            String package_ = String.format("%s", page.getName().toLowerCase());
            System.out.println(package_);
            System.out.println(page.getPackageName());
            if(AccessingAllClassesInPackage.isPackageExist(package_)){
                System.out.println(String.format("Outlet package for %s exist", page.getName()));
                Set<Class<?>> pages_ = AccessingAllClassesInPackage.findAllClasses(package_);
                for (Class<?> class1 : pages_) {
                    System.out.println(class1.getSimpleName());
                    System.out.println(class1.getPackageName());
                }
                System.out.println();
            }
        }
    }
}
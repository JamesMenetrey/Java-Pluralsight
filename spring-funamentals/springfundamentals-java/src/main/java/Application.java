import com.pluralsight.services.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);

        CustomerService service = appContext.getBean(CustomerService.class);
        System.out.println(service);

        CustomerService service2 = appContext.getBean(CustomerService.class);
        System.out.println(service2);

        System.out.println(service.findAll().get(0).getFirstname());
    }
}

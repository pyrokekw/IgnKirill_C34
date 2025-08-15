import org.example.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("test-service.xml");

        Test bean = context.getBean(Test.class);
        System.out.println(bean);
    }
}

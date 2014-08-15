package hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

@Configuration 
/* @Configuration
 * indicates that a class declares one or more @Bean methods and may be processed by the Spring container to generate
 * bean definitions and service requests for those beans at runtime
 */
@ComponentScan
/*
 * @ComponentScan
 * Configures component scanning directives for use with @Configuration classes
 * If specific packages are not defined scanning will occur from the package of the class with this annotation.
 * In this case it will scan hello package.
 */
public class Application {

    @Bean
    // instantiate, configure and return a bean
    MessageService mockMessageService() {
        return new MessageService() {
            public String getMessage() {
              return "Hello World!";
            }
        };
    }

  public static void main(String[] args) {
      ApplicationContext context = 
          new AnnotationConfigApplicationContext(Application.class);
      MessagePrinter printer = context.getBean(MessagePrinter.class);
      printer.printMessage();
  }
}

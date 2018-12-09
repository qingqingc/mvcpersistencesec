package com.mvc.testing;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

import com.mvc.service.ManService;
import com.mvc.service.ManServiceImpl;
import com.mvc.web.ManController;

@Configuration
@ComponentScan
public class Test2 {

//    @Bean
//    MessageService mockMessageService() {
//        return new MessageService() {
//            public String getMessage() {
//              return "Hello World!";
//            }
//        };
//    }
	
//	@Bean
//	public ManDao constructMan() {
//		return 
//	}
//	

  public static void main(String[] args) {
      ApplicationContext context = 
          new AnnotationConfigApplicationContext(Test2.class);
      ManController m = context.getBean(ManController.class);
//      m.kserMan();
      System.out.println("sdf");
//      MessagePrinter printer = context.getBean(MessagePrinter.class);
//      printer.printMessage();
  }
}
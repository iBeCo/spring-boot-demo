package hello.greeting;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    //private static final Logger LOG = LogManager.getLogger(GreetingController.class);
    //https://shout.setfive.com/2015/11/02/spring-boot-authentication-with-custom-http-header/
    //https://howtodoinjava.com/spring-restful/custom-token-auth-example/

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
//        LOG.debug("Debugging log in our greeting method");
//        LOG.info("Info log in our greeting method");
//        LOG.warn("Warning log in our greeting method");
//        LOG.error("Error in our greeting method");
//        LOG.fatal("Damn! Fatal error. Please fix me.");
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
}

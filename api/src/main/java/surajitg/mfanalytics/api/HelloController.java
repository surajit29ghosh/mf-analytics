<<<<<<< HEAD
package surajitg.mfanalytics.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    
    @GetMapping("/hello")
    @ResponseBody
    public String Welcome() {
        return "Welcome to Mf Analytics API";
    }
}
=======
package surajitg.mfanalytics.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    
    @GetMapping("/hello")
    @ResponseBody
    public String Welcome() {
        return "Welcome to Mf Analytics API";
    }
}
>>>>>>> e510ded059a4c161aaa032faee36c59027e6c95f

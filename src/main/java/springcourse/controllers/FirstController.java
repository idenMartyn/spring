package springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {

//    @GetMapping("/hello")
//    public String helloPage(HttpServletRequest request){
//        String name = request.getParameter("name");
//        String surname = request.getParameter("surname");
//        System.out.println(name + " " + surname);
//        return "first/hello";
//    }

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model){
        //System.out.println(name + " " + surname);
        model.addAttribute("message", "hello, " + name + " " + surname);
        return "first/hello";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam(value = "a") int a,
                             @RequestParam(value = "b") int b,
                             @RequestParam(value = "action") String action,
                             Model model) {

        double result = 0;


        if(action.equals("multiplication")){
            result = a * b;
            model.addAttribute("result", result);
        } else if (action.equals("addition")) {
            result = a + b;
            model.addAttribute("result", result);
        } else if (action.equals("subtraction")) {
            result = a - b;
            model.addAttribute("result", result);
        } else if (action.equals("division")) {
            result = a / (double)b;
            model.addAttribute("result", result);
        } else {
            model.addAttribute("result", "Введите верное название операции");
        }

        return "first/calculator";
    }

    @GetMapping("/goodbye")
    public String goodbyePage(){
        return "first/goodbye";
    }
}

package clov3r.googlecalendartask;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CalendarController {

    @GetMapping
    public String test(Model model) {
        model.addAttribute("data", "World");
        return "test";
    }
}

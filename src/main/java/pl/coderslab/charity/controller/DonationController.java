package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class DonationController {
    @RequestMapping("/donations")
    public String homeAction(Model model){
        return "formx";
    }
}

package pl.coderslab.charity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.List;


@Controller
public class HomeController {
    private final DonationRepository donationRepository;
    private final InstitutionRepository institutionRepository;

    public HomeController(DonationRepository donationRepository, InstitutionRepository institutionRepository) {
        this.donationRepository = donationRepository;
        this.institutionRepository = institutionRepository;
    }


    @RequestMapping("/")
    public String homeAction(Model model){
        model.addAttribute("donations", donationRepository.findTotalQuantity());
        model.addAttribute("gifts", donationRepository.findAll().size());
        List<Institution> institutions = institutionRepository.findAll();
        System.out.println(institutions);
        model.addAttribute("institutions", institutions);

        return "index";
    }
}

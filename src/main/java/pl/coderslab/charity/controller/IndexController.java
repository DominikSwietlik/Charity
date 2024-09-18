package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;

@Controller
@RequestMapping("")
public class IndexController {

    private final DonationRepository donationRepository;
    private final InstitutionRepository institutionRepository;

    public IndexController(DonationRepository donationRepository, InstitutionRepository institutionRepository) {
        this.donationRepository = donationRepository;
        this.institutionRepository = institutionRepository;
    }


    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("donations", donationRepository.findTotalQuantity());
        model.addAttribute("gifts", donationRepository.findAll().size());
        model.addAttribute("institutions", institutionRepository.findAll());
    return "index";
}

}

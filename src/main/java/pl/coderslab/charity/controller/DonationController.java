package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.repository.CategoryRepository;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;


@Controller
public class DonationController {

    private final CategoryRepository categoryRepository;
    private final InstitutionRepository institutionRepository;
    private final DonationRepository donationRepository;
    public DonationController(CategoryRepository categoryRepository, InstitutionRepository institutionRepository, DonationRepository donationRepository) {
        this.categoryRepository = categoryRepository;
        this.institutionRepository = institutionRepository;
        this.donationRepository = donationRepository;
    }
    @RequestMapping("/donations")
    public String homeAction(Model model){
        List<Category> categories = categoryRepository.findAll();
        List<Institution> institutions = institutionRepository.findAll();
        model.addAttribute("institutions", institutions);
        model.addAttribute("categories", categories);

        return "form";
    }

    @PostMapping("/donations/save")
    public String saveDonation(@RequestParam("categories") List<String> categories, @RequestParam("bags") Long bags, @RequestParam("address") String address, @RequestParam("city") String city,@RequestParam("postcode") String postcode,@RequestParam("phone") String phone, Model model){

        System.out.println(categories.size());
        System.out.println(bags);
        return "index";
    }
}

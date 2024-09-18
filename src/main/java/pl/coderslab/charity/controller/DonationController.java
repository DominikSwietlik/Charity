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

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


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
    public String saveDonation(@RequestParam("categories") List<Long> categories, @RequestParam("bags")Integer bags,
                               @RequestParam("organization") Long organization,
                               @RequestParam("address") String address, @RequestParam("city") String city,
                               @RequestParam("postcode") String postcode, @RequestParam("phone") String phone,
                               @RequestParam("data") String data, @RequestParam("time") String time,
                               @RequestParam("more_info") String more_info, Model model){
        Donation donation = new Donation();
        //System.out.println(categories.size());
            List<Category> categories2 = new ArrayList<>();
            List<Category> catTmp = new ArrayList<>();

            for(Long el : categories)
            {
                Optional<Category> categoryOptional = categoryRepository.findById(el);
                categories2.add(categoryOptional.get());
            }

        donation.setCategories(categories2);

        System.out.println(bags);
        donation.setQuantity(bags);

        System.out.println(organization);
        Optional<Institution> institution = institutionRepository.findById(organization);
        donation.setInstitution(institution.get());

        System.out.println(address);
        donation.setStreet(address);

        System.out.println(city);
        donation.setCity(city);

        System.out.println(postcode);
        donation.setZipCode(postcode);

        System.out.println(phone);
        donation.setPhone(phone);

        System.out.println(data);
        donation.setPickUpDate(LocalDate.parse(data));

        System.out.println(time);
        donation.setPickUpTime(LocalTime.parse(time));

        System.out.println(more_info);
        donation.setPickUpComment(more_info);

        donationRepository.save(donation);

        return "redirect:/";
    }
}

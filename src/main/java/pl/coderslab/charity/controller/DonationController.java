package pl.coderslab.charity.controller;

import lombok.NonNull;
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
    public String saveDonation(@RequestParam("categories") List<Long> categories, @RequestParam("bags") @NotNull @Min(1) Integer bags,
                               @RequestParam("organization") Long organization,
                               @RequestParam("address") String address, @RequestParam("city") String city,
                               @RequestParam("postcode") String postcode, @RequestParam("phone") String phone,
                               @RequestParam("data") String data, @RequestParam("time") String time,
                               @RequestParam("more_info") String more_info, Model model){
        Donation donation = new Donation();

            List<Category> categories2 = categoryRepository.findByIdIn(categories);


        donation.setCategories(categories2);
        donation.setQuantity(bags);
        Optional<Institution> institution = institutionRepository.findById(organization);
        donation.setInstitution(institution.get());
        donation.setStreet(address);
        donation.setCity(city);
        donation.setZipCode(postcode);
        donation.setPhone(phone);
        donation.setPickUpDate(LocalDate.parse(data));
        donation.setPickUpTime(LocalTime.parse(time));
        donation.setPickUpComment(more_info);

        donationRepository.save(donation);

        return "redirect:/";
    }
}

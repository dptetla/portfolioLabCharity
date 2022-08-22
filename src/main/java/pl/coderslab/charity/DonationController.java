package pl.coderslab.charity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class DonationController {
    private final DonationRepository donationRepository;
    private final InstitutionRepository institutionRepository;
    private final CategoryRepository categoryRepository;

    public DonationController(DonationRepository donationRepository, InstitutionRepository institutionRepository, CategoryRepository categoryRepository) {
        this.donationRepository = donationRepository;
        this.institutionRepository = institutionRepository;
        this.categoryRepository = categoryRepository;
    }

    @RequestMapping (value = "/adddonation", method = RequestMethod.GET)
    public String fillDonation(Model model){
        model.addAttribute("donation", new Donation());
        model.addAttribute("institutions", institutionRepository.findAll());
        model.addAttribute("categories", categoryRepository.findAll());
        return "/adddonation";
    }

    @RequestMapping (value = "/adddonation", method = RequestMethod.POST)
    public String saveDonation( Donation donation){
//        if (result.hasErrors()){
//            return "/adddonation";
//        }
        donationRepository.save(donation);
        return "/form-confirmation";
    }
}

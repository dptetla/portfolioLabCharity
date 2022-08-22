package pl.coderslab.charity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
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
        int donationAmount = 0;
        List<Donation> listAmount = donationRepository.findAll();
        for (Donation number : listAmount){
            donationAmount += 1;
            }
        model.addAttribute("listAmount", donationAmount);
        int quantityAmount = 0;
        List<Donation> listQuantity = donationRepository.findAll();
        for (Donation quantity : listQuantity){
            quantityAmount += quantity.getQuantity();
        }
        model.addAttribute("listQuantity", quantityAmount);

        List<Institution> list = institutionRepository.findAll();
        List<InstitutionDTO> institutionPairs = new ArrayList<>();
        InstitutionDTO dto = null;
        for (int i = 0; i < list.size(); i++){
            if (i % 2==0){
                dto = new InstitutionDTO();
                dto.setInstitutionOne(list.get(i));
            }else {
                dto.setInstitutionTwo(list.get(i));
                institutionPairs.add(dto);
                dto = null;
            }
        }
        if (dto != null){institutionPairs.add(dto);}

        model.addAttribute("allInstitutionsPairs", institutionPairs);

        return "/index";
    }
}

package TSB.DEV.spring.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import TSB.DEV.spring.repository.BeneficiaireRepository;

@Controller
public class BeneficiaresController {
		@Autowired
	    private BeneficiaireRepository beneficiareRepo;
	    
	    @GetMapping("/listBeneficiares")
	    public String viewAllBenef(Model model) {
			model.addAttribute("listBeneficiares", beneficiareRepo.findAll());
			return "gestionclients/listBeneficiares";
	    }
}

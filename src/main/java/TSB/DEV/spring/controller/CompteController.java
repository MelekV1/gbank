package TSB.DEV.spring.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import TSB.DEV.spring.dto.ProprietaireCompte;
import TSB.DEV.spring.model.Compte;
import TSB.DEV.spring.repository.ClientRepository;
import TSB.DEV.spring.repository.CompteRepository;

@Controller
public class CompteController {
	    @Autowired
	    private CompteRepository compteRepo;
	    
	    @Autowired
	    private ClientRepository clientRepo;
	    
	    @GetMapping("/listComptes")
	    public String viewAllComptes(Model model) {
			model.addAttribute("listComptes", compteRepo.findAll());
			return "gestioncomptes/listComptes";
	    }
	    

		@GetMapping("/newCompte")
		public String showNewCompteForm(Model model) {
			// create model attribute to bind form data
			ProprietaireCompte nouvCompte = new ProprietaireCompte();
			model.addAttribute("compte", nouvCompte);

			return "gestioncomptes/new_compte";
		}
		
		@PostMapping("/saveCompte")
		public String saveClient(@ModelAttribute("compte") ProprietaireCompte nouvCompte) {
			Compte compte = new Compte();
			if(clientRepo.findById(nouvCompte.getIdClient()).get() != null)
				compte.setClient(clientRepo.findById(nouvCompte.getIdClient()).get());
			compte.setRibCompte(nouvCompte.getRibCompte());
			compte.setSolde(nouvCompte.getSolde());
			compte.setOuverture(nouvCompte.getOuverture());
			compteRepo.save(compte);
			return "sucess";
		}
		
		@GetMapping("/updateCompte/{id}")
		public String updateClient(@PathVariable ( value = "id") long id, Model model) {
			Optional<Compte> compte = compteRepo.findById(id) ;
			model.addAttribute("compte", compte);
			return "gestioncomptes/updateCompte";
		}
		
		@GetMapping("/deleteCompte/{id}")
		public String deleteCompte(@PathVariable (value = "id") long id) {
			compteRepo.deleteById(id);
			return "sucess";
		}
}

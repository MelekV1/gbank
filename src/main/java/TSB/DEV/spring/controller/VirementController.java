package TSB.DEV.spring.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import TSB.DEV.spring.model.Compte;
import TSB.DEV.spring.model.Virement;
import TSB.DEV.spring.repository.BeneficiaireRepository;
import TSB.DEV.spring.repository.CompteRepository;
import TSB.DEV.spring.repository.VirementMasseRepository;
import TSB.DEV.spring.repository.VirementPermanentRepository;
import TSB.DEV.spring.repository.VirementRepository;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class VirementController {

	    @Autowired
	    private VirementRepository virementRepo;
	    @Autowired
	    private VirementPermanentRepository PermavirementRepo;
	    @Autowired
	    private VirementMasseRepository MvirementRepo;
	    
	    @Autowired
	    private BeneficiaireRepository benefRepo;
	    
	    @Autowired
	    private CompteRepository compteRepo;
	    
	    @GetMapping("/listVirements")
	    public  String viewAllVirements(Model model) {
			model.addAttribute("listVirements", virementRepo.findAll());
			return "gestionvirements/listVirements";
	    }
	    
	    @GetMapping("/listVirementsPermanents")
	    public  String viewAllPVirements(Model model) {
			model.addAttribute("listVirements", PermavirementRepo.findAll());
			return "gestionvirements/listVirementsPermanent";
	    }
	    
	    @GetMapping("/listVirementsMasse")
	    public  String viewAllMVirements(Model model) {
			model.addAttribute("listVirements", MvirementRepo.findAll());
			return "gestionvirements/listVirementsMasse";
	    }

		@GetMapping("/newVirement")
		public String showForm(Model model) {
			Virement v = new Virement();
			model.addAttribute("virement", v);
			return "gestionvirements/new_virement";
		}
		
		@GetMapping("/newVirementExterne")
		public String showFormExterne(Model model) {
			Virement v = new Virement();
			model.addAttribute("virement", v);
			return "gestionvirements/new_virement_externe";
		}
		
		@PostMapping("/saveVirement")
		public String saveVirement(@ModelAttribute("virement") Virement v) {
			//get Compte beneficiaire
			Compte cBenef = compteRepo.findByRibCompte(v.getRibBeneficiaire());
			//get Compte client
			Compte cClient = compteRepo.findByRibCompte(v.getRibDepart());
			if(cClient.getSolde()>v.getMontant()) {
				cClient.setSolde(cClient.getSolde()-v.getMontant());
				cBenef.setSolde(cBenef.getSolde()+v.getMontant());
				compteRepo.save(cClient);
				compteRepo.save(cBenef);
				virementRepo.save(v);
				return "sucess";
			}else {
				return "error";
			}
		}
		
		@PostMapping("/saveVirementExterne")
		public String saveExterne(@ModelAttribute("virement") Virement v) {
			//Verifier l'existance de beneficiaire
			if(benefRepo.findByRibBeneficiaire(v.getRibBeneficiaire()) != null) {
				Compte cClient = compteRepo.findByRibCompte(v.getRibDepart());
				//get Compte client
				if(cClient.getSolde()>v.getMontant()) {
						cClient.setSolde(cClient.getSolde()-v.getMontant());
						compteRepo.save(cClient);
						virementRepo.save(v);
						if(v.getMontant()>5000) {
							return "gestionvirements/sucessForcee";
						}
						return "sucess";
					
				}else {
					return "error";
				}
			}else {
				return "error";
			}
		}
		
		@GetMapping("/updateVirement/{id}")
		public String update(@PathVariable ( value = "id") long id, Model model) {
			Optional<Virement> v = virementRepo.findById(id) ;
			model.addAttribute("virement", v);
			return "gestionvirements/updateVirement";
		}
		
		@GetMapping("/deleteVirement/{id}")
		public String delete(@PathVariable (value = "id") long id) {
			virementRepo.deleteById(id);
			return "sucess";
		}

}

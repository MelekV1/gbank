package TSB.DEV.spring.controller;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import TSB.DEV.spring.excelExport.ClientExport;
import TSB.DEV.spring.model.Client;
import TSB.DEV.spring.repository.ClientRepository;

@Controller
public class ClientController {
		@Autowired
	    private ClientRepository clientRepo;
	    
	    @GetMapping("/listClients")
	    public String ViewAllComptes(Model model) {
			model.addAttribute("listClients", clientRepo.findAll());
			return "gestionclients/listClients";
	    }
	    

		@GetMapping("/newclient")
		public String showNewClientForm(Model model) {
			// create model attribute to bind form data
			Client client = new Client();
			model.addAttribute("client", client);
			return "gestionclients/new_client";
		}
		
		@PostMapping("/saveClient")
		public String saveClient(@ModelAttribute("client") Client client) {
			clientRepo.save(client);
			return "sucess";
		}
		
		@GetMapping("/updateClient/{id}")
		public String updateClient(@PathVariable ( value = "id") long id, Model model) {
			Optional<Client> client = clientRepo.findById(id) ;
			model.addAttribute("client", client);
			return "gestionclients/updateClient";
		}
		
		@GetMapping("/deleteClient/{id}")
		public String deleteClient(@PathVariable (value = "id") long id) {
			clientRepo.deleteById(id);
			return "sucess";
		}
		
		@GetMapping("/export")
	    public String exportToExcel(HttpServletResponse response) throws IOException {
	        response.setContentType("application/octet-stream");
	        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	        String currentDateTime = dateFormatter.format(new Date());
	         
	        String headerKey = "Content-Disposition";
	        String headerValue = "attachment; filename=users_" + currentDateTime + ".xlsx";
	        response.setHeader(headerKey, headerValue);
	         
	        List<Client> listUsers = clientRepo.findAll();
	         
	        ClientExport excelExporter = new ClientExport(listUsers);
	         
	        excelExporter.export(response);
	        return "Sucess";
	    } 
}

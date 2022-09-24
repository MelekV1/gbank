package TSB.DEV.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import TSB.DEV.spring.model.User;
import TSB.DEV.spring.repository.UserRepository;

@Controller
public class UserController {
  @Autowired
  private UserRepository userService;
	
  @GetMapping("/login")
  public String login(Model model) {
	  User user = new User();
	  model.addAttribute("user", user);
	  return "login";
  }
	@PostMapping("/checkUser")
	public String check(@ModelAttribute("user") User user, Model model) {
		User u = userService.findByUsername(user.getUsername());
		model.addAttribute("user", u);
		return "index";
	}
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private SecurityService securityService;
//
//    @Autowired
//    private UserValidator userValidator;
//
//    @GetMapping("/registration")
//    public String registration(Model model) {
//        if (securityService.isAuthenticated()) {
//            return "redirect:/";
//        }
//
//        model.addAttribute("userForm", new User());
//
//        return "registration";
//    }
//
//    @PostMapping("/registration")
//    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
//        userValidator.validate(userForm, bindingResult);
//
//        if (bindingResult.hasErrors()) {
//            return "registration";
//        }
//
//        userService.save(userForm);
//
//        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());
//
//        return "redirect:/welcome";
//    }
//
//    @GetMapping("/login")
//    public String login(Model model, String error, String logout) {
//        if (securityService.isAuthenticated()) {
//            return "redirect:/";
//        }
//
//        if (error != null)
//            model.addAttribute("error", "Your username and password is invalid.");
//
//        if (logout != null)
//            model.addAttribute("message", "You have been logged out successfully.");
//
//        return "login";
//    }
//
//    @GetMapping({"/", "/welcome"})
//    public String welcome(Model model) {
//        return "welcome";
//    }
}
package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

// as long as we define this on top of the class, we may use as many controllers as we want.
// In fact, it is good practice to use separate controllers for different things

@Controller				
public class Login_Controller {
	
	@RequestMapping("/login") // When spring gets admin url req, it will redirect it to this login page
	
	public String login(@RequestParam(value="error", required=false) String error,
											@RequestParam(value="logout", required=false) String logout, Model model){
		
		/* these 2 values above should be d same as in applicn context parameter after '?'
			@RequestParam will basically bind/assign the parameter 'error' to our String error
			
			Reg, "required" attribute- 
			Defaults to true, leading to an exception being thrown if the parameter(our case 'error') is missing in the request. 
			Switch this to false if you prefer a null value if the parameter is not present in the request. 
		*/
		
		if(error != null){
			model.addAttribute("error", "Invalid Credentials"); // this is so that we can display the error msg by calling ${error}
		}
		if(logout != null){
			model.addAttribute("logout_msg", "You have been Logged Out successfully");
		}
		
		return "login";
	}
	
}

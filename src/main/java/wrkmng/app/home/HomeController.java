package wrkmng.app.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import wrkmng.domain.model.Role;
import wrkmng.domain.service.role.RoleService;
import wrkmng.domain.service.user.WorkManagerUserDetails;
import wrkmng.domain.service.user.WorkManagerUserDetailsService;

@Controller
@RequestMapping("home")
public class HomeController {
	@Autowired
	WorkManagerUserDetailsService userDetailsService;
	@Autowired
	RoleService roleService;

	@RequestMapping(method = RequestMethod.GET)
	String home(@AuthenticationPrincipal WorkManagerUserDetails userDetails, Model model){
		Role role = roleService.findOne(userDetails.getUser().getRoleId());

		model.addAttribute("user", userDetails.getUser());
		model.addAttribute("role", role);


		return "home/home";
	}
}

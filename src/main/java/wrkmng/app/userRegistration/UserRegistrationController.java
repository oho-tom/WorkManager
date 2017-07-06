package wrkmng.app.userRegistration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import wrkmng.domain.model.Role;
import wrkmng.domain.model.User;
import wrkmng.domain.service.reservation.AlreadyReservedException;
import wrkmng.domain.service.role.RoleService;
import wrkmng.domain.service.user.WorkManagerUserDetailsService;

@Controller
@RequestMapping("userRegistration")
public class UserRegistrationController {
	@Autowired
	WorkManagerUserDetailsService userDetailsService;
	@Autowired
	RoleService roleService;

	@ModelAttribute
	UserRegistrationForm setUpForm() {
		UserRegistrationForm form = new UserRegistrationForm();
		return form;
	}

	@RequestMapping(method = RequestMethod.GET)
	String userRegistration(Model model){

		List<User> users = userDetailsService.findUser();
		List<Role> roles = roleService.findRole();

		model.addAttribute("users", users);
		model.addAttribute("roles", roles);

		return "userRegistration/userRegistrationForm";
	}

	@RequestMapping(method = RequestMethod.POST)
	String regist(@Validated UserRegistrationForm form, Model model) {

		User user = new User();
		user.setUserId(form.getUserId());
		user.setLastName(form.getLastName());
		user.setFirstName(form.getFirstName());
		user.setRoleId(form.getRoleId());
		user.setPassword(form.getPassword());

		try {
			userDetailsService.regist(user);
			model.addAttribute("success", "ユーザーを登録しました。");
		}
		catch (AlreadyReservedException e) {
			model.addAttribute("error", e.getMessage());
		}
		return userRegistration(model);
	}
}


package wrkmng.domain.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import wrkmng.domain.model.User;
import wrkmng.domain.repository.user.UserRepository;

@Service
public class WorkManagerUserDetailsService implements UserDetailsService {
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findOne(username);

		if(user == null) {
			throw new UsernameNotFoundException(username + "is not found.");
		}
		return new WorkManagerUserDetails(user);
	}
}

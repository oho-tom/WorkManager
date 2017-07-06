package wrkmng.domain.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import wrkmng.domain.model.User;
import wrkmng.domain.repository.user.UserRepository;

@Service
public class WorkManagerUserDetailsService implements UserDetailsService {
	@Autowired
	UserRepository userRepository;

	@Autowired
    private PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findOne(username);

		if(user == null) {
			throw new UsernameNotFoundException(username + "is not found.");
		}
		return new WorkManagerUserDetails(user);
	}

	public List<User> findUser(){
		return userRepository.findAll();
	}

	public User regist(User user){

		// 重複チェック

		// パスワード暗号化
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);

		userRepository.save(user);

		return user;
	}
}

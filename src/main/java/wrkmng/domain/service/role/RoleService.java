package wrkmng.domain.service.role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import wrkmng.domain.model.Role;
import wrkmng.domain.repository.role.RoleRepository;

@Service
@Transactional
public class RoleService {

	@Autowired
	RoleRepository roleRepository;

	public List<Role> findRole(){
		return roleRepository.findAll();
	}

	public Role findOne(String roleId) {
		return roleRepository.findOne(roleId);
	}
}
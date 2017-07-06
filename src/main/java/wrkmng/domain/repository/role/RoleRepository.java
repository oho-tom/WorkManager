package wrkmng.domain.repository.role;

import org.springframework.data.jpa.repository.JpaRepository;

import wrkmng.domain.model.Role;

public interface RoleRepository extends JpaRepository<Role, String> {
}

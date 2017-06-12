package wrkmng.domain.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;

import wrkmng.domain.model.User;

public interface UserRepository extends JpaRepository<User, String> {

}

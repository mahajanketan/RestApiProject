package in.sp.main.Repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import in.sp.main.entitiye.User;

public interface UserRepositry extends JpaRepository<User, Integer> {
	

}

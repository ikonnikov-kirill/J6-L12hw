package j6l12hw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import j6l12hw.model.User;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findAll();

    User findUserByLogin(String login);

    User findById(int id);

}

package j6l12hw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import j6l12hw.model.Role;

import java.util.List;


public interface RoleRepository extends JpaRepository<Role, Integer> {

    List<Role> findRoleById(int id);
}
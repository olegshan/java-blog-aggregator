package olegshan.agg.jba.repository;

import olegshan.agg.jba.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Bors on 24.04.2016.
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByName(String name);
}

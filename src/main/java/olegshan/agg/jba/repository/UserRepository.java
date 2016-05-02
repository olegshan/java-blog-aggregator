package olegshan.agg.jba.repository;

import olegshan.agg.jba.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Bors on 24.04.2016.
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByName(String name);
}

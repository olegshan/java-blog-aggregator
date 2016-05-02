package olegshan.agg.jba.repository;

import olegshan.agg.jba.entity.Blog;
import olegshan.agg.jba.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * Created by Bors on 24.04.2016.
 */
public interface BlogRepository extends JpaRepository<Blog, Integer> {

    List<Blog> findByUser(User user);
}

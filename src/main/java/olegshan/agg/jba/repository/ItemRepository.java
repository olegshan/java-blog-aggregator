package olegshan.agg.jba.repository;

import olegshan.agg.jba.entity.Blog;
import olegshan.agg.jba.entity.Item;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Bors on 24.04.2016.
 */
public interface ItemRepository extends JpaRepository<Item, Integer> {

    List<Item> findByBlog(Blog blog, Pageable pageable);

    Item findByBlogAndLink(Blog blog, String link);
}

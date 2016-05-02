package olegshan.agg.jba.service;

import olegshan.agg.jba.entity.Blog;
import olegshan.agg.jba.entity.Item;
import olegshan.agg.jba.entity.User;
import olegshan.agg.jba.exception.RssException;
import olegshan.agg.jba.repository.BlogRepository;
import olegshan.agg.jba.repository.ItemRepository;
import olegshan.agg.jba.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Bors on 27.04.2016.
 */
@Service
public class BlogService {

    @Autowired
    BlogRepository blogRepository;

    @Autowired
    ItemRepository itemReporitory;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private RssService rssService;

    public void saveItems(Blog blog) {
        try {
            List<Item> items = rssService.getItems(blog.getUrl());
            for (Item item : items) {
                Item savedItem = itemReporitory.findByBlogAndLink(blog, item.getLink());
                if (savedItem == null) {
                    item.setBlog(blog);
                    itemReporitory.save(item);
                }
            }
        } catch (RssException e) {
            e.printStackTrace();
        }
    }

    @Scheduled(fixedDelay = 3600000)
    public void reloadBlogs() {
        List<Blog> blogs = blogRepository.findAll();
        for (Blog blog : blogs) {
            saveItems(blog);
        }
    }

    public void save(Blog blog, String name) {
        User user = userRepository.findByName(name);
        blog.setUser(user);
        blogRepository.save(blog);
        saveItems(blog);
    }

    @PreAuthorize("#blog.user.name == authentication.name or hasRole('ROLE_ADMIN')")
    public void delete(@P("blog") Blog blog) {
        blogRepository.delete(blog);
    }

    public Blog findOne(int id) {
        return blogRepository.findOne(id);
    }
}

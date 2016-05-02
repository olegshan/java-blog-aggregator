package olegshan.agg.jba.service;

import olegshan.agg.jba.entity.Blog;
import olegshan.agg.jba.entity.Item;
import olegshan.agg.jba.entity.Role;
import olegshan.agg.jba.entity.User;
import olegshan.agg.jba.repository.BlogRepository;
import olegshan.agg.jba.repository.ItemRepository;
import olegshan.agg.jba.repository.RoleRepository;
import olegshan.agg.jba.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Bors on 24.04.2016.
 */
@Transactional
@Service
public class InitDbService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private ItemRepository itemRepository;

    @PostConstruct
    public void init() {
        if (roleRepository.findByName("ROLE_ADMIN") == null) {
            Role roleUser = new Role();
            roleUser.setName("ROLE_USER");
            roleRepository.save(roleUser);

            Role roleAdmin = new Role();
            roleAdmin.setName("ROLE_ADMIN");
            roleRepository.save(roleAdmin);

            User userAdmin = new User();
            userAdmin.setEnabled(true);
            userAdmin.setName("admin");
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            userAdmin.setPassword(encoder.encode("admin"));
            List<Role> roles = new ArrayList<>();
            roles.add(roleAdmin);
            roles.add(roleUser);
            userAdmin.setRoles(roles);
            userRepository.save(userAdmin);

            Blog blogJavavids = new Blog();
            blogJavavids.setName("JavaVids");
            blogJavavids.setUrl("http://feeds.feedburner.com/javavids?format=xml");
            blogJavavids.setUser(userAdmin);
            blogRepository.save(blogJavavids);

        /*Item item1 = new Item();
        item1.setBlog(blogJavavids);
        item1.setTitle("first");
        item1.setLink("http://www.javavids.com");
        item1.setPublishedDate(new Date());
        itemRepository.save(item1);

        Item item2 = new Item();
        item2.setBlog(blogJavavids);
        item2.setTitle("second");
        item2.setLink("http://www.javavids.com");
        item2.setPublishedDate(new Date());
        itemRepository.save(item2);*/
        }
    }
}

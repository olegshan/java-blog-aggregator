package olegshan.agg.jba.service;

import olegshan.agg.jba.entity.Item;
import olegshan.agg.jba.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Bors on 30.04.2016.
 */
@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getItems() {
        return itemRepository.findAll(new PageRequest(0, 20, Sort.Direction.DESC, "publishedDate")).getContent();
    }

}

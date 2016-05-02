package olegshan.agg.jba.service;

import olegshan.agg.jba.entity.Item;
import olegshan.agg.jba.exception.RssException;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Bors on 30.04.2016.
 */
public class RssServiceTest {

    private RssService rssService;

    @org.junit.Before
    public void setUp() throws Exception {
        rssService = new RssService();
    }

    @org.junit.Test
    public void getItems() throws RssException {
        List<Item> items = rssService.getItems(new File("test-rss/javavids.xml"));
        assertEquals(10, items.size());
        Item firstItem = items.get(0);
        assertEquals("How to solve Source not found error during debug in Eclipse", firstItem.getTitle());
        assertEquals("22 06 2014 23:35:49", new SimpleDateFormat("dd MM yyyy HH:mm:ss").format(firstItem.getPublishedDate()));
    }

}
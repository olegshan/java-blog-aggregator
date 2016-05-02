package olegshan.agg.jba.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Bors on 23.04.2016.
 */

@Entity
public class Item {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(length = 1000)
    private String title;

    @Lob
    @Type(type = "org.hibernate.type.MaterializedClobType")
    @Column(length = Integer.MAX_VALUE)
    private String description;

    @Column(length = 1000)
    private String link;

    @Column(name = "published_date")
    private Date publishedDate;

    @ManyToOne
    @JoinColumn(name = "blog_id")
    private Blog blog;

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }
}

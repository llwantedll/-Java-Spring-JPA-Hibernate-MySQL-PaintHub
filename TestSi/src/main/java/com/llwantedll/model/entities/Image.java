package com.llwantedll.model.entities;

import com.llwantedll.Utils.ImageUtil;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "image")
public class Image implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String name;

    private String description;

    @Column(name = "image", nullable = false)
    @Lob
    private byte[] image;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tag_image",
            joinColumns = @JoinColumn(name = "image_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tag> tags;

    @Column(name = "data_load")
    private Date dateLoad;

    @Transient private MultipartFile imageMP;
    @Transient private String tagsString;

    public Image() {
        tags = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateLoad() {
        return dateLoad;
    }

    public void setDateLoad(Date dateLoad) {
        this.dateLoad = dateLoad;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setNewTag(Tag tag){
        tags.add(tag);
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    @Transient
    public String getImg64base() {
        return ImageUtil.byteImageToBase64(image);
    }

    public String getTagsString() {
        return tagsString;
    }

    public void setTagsString(String tagsString) {
        this.tagsString = tagsString;
    }

    public MultipartFile getImageMP() {
        return imageMP;
    }

    public void setImageMP(MultipartFile imageMP) {
        this.imageMP = imageMP;
    }
}

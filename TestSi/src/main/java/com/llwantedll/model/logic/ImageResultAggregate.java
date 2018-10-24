package com.llwantedll.model.logic;

import com.llwantedll.model.entities.Image;
import java.io.Serializable;
import java.util.List;

//CLASS AGGREGATE FOR SEARCH RESULT

public class ImageResultAggregate implements Serializable{
    private long count;
    private List<Image> images;

    public ImageResultAggregate(long count, List<Image> images) {
        this.count = count;
        this.images = images;
    }

    public ImageResultAggregate() {
    }

    public void setCount(long count) {
        this.count = count;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public long getCount() {
        return count;
    }

    public List<Image> getImages() {
        return images;
    }

}

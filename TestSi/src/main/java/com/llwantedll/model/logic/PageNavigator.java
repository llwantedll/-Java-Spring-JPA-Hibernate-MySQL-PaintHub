package com.llwantedll.model.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//THIS CLASS IS CALCULATING INTERFACE FOR PAGE TRANSITION

public class PageNavigator{
    private int currentPage;
    private int pagesToShow;
    private int imagePerPage;
    private long imagesCount;

    public PageNavigator(int currentPage, int pagesToShow,
                         int imagePerPage, long imagesCount) {
        this.currentPage = currentPage;
        this.pagesToShow = pagesToShow;
        this.imagePerPage = imagePerPage;
        this.imagesCount = imagesCount;
    }

    public PageNavigator() {
    }

    public int getLastPage(){
        return (int)((imagesCount-1)/imagePerPage+1);
    }

    public List<Integer> getPages(){
        List<Integer> pages = new ArrayList<>(pagesToShow);
        int excessBegin = 0;
        int excessEnd = 0;
        for (int i = currentPage - (pagesToShow/2);
             i <= currentPage + (pagesToShow/2)+excessBegin; i++) {
            if(i>0 && i<=getLastPage()){
                pages.add(i);
            }
            else if(i<=0){
                excessBegin++;
            }
            else if(i>getLastPage()){
                excessEnd++;
            }
        }
        for (int i = currentPage - (pagesToShow/2) - excessEnd;
             i < currentPage - (pagesToShow/2); i++) {
            if(i>0 && i<=getLastPage()){
                pages.add(i);
            }
        }
        return pages.stream().sorted().collect(Collectors.toList());
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPagesToShow() {
        return pagesToShow;
    }

    public void setPagesToShow(int pagesToShow) {
        this.pagesToShow = pagesToShow;
    }

    public int getImagePerPage() {
        return imagePerPage;
    }

    public void setImagePerPage(int imagePerPage) {
        this.imagePerPage = imagePerPage;
    }

    public long getImagesCount() {
        return imagesCount;
    }

    public void setImagesCount(long imagesCount) {
        this.imagesCount = imagesCount;
    }
}

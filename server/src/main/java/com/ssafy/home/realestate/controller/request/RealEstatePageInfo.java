package com.ssafy.home.realestate.controller.request;

public class RealEstatePageInfo {
    private String pageNum;
    private String pageSize;

    public RealEstatePageInfo() {
    }

    public String getPageNum() {
        return pageNum;
    }

    public void setPageNum(String pageNum) {
        this.pageNum = pageNum;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }
}

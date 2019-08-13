package com.fruitsalesplatform.entity;

/**
 * 分页相关
 * Created by zhangshixin on 19/8/13.
 */
public class PageEntity {
    private int currentPage = 1;
    private int startPage = 0;
    private int pageSize = 10;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}

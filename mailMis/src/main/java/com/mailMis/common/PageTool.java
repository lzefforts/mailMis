package com.mailMis.common;

import java.util.List;

/**
 * Created by ArnoldLee on 17/9/28.
 */
public class PageTool<T> {

    private int total;
//    private int page;
    private List<T> rows;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

//    public int getPage() {
//        return page;
//    }
//
//    public void setPage(int page) {
//        this.page = page;
//    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}

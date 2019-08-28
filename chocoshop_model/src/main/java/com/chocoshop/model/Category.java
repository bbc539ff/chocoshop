package com.chocoshop.model;

public class Category {
    private Long cid;
    private String cname;
    private Long cparent;

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Long getCparent() {
        return cparent;
    }

    public void setCparent(Long cparent) {
        this.cparent = cparent;
    }

    @Override
    public String toString() {
        return "Category{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", cparent=" + cparent +
                '}';
    }
}

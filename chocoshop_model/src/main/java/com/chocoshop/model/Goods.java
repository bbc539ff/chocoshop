package com.chocoshop.model;

import java.util.Date;

public class Goods {
    private Long gid;
    private String gtitle;
    private Long cid;
    private Double gprice;
    private Integer gnum;
    private String imageurl;
    private Integer gstatus;
    private Date created;
    private Date updated;
    private String detail;
    private String detail_imageurl;

    public Long getGid() {
        return gid;
    }

    public void setGid(Long gid) {
        this.gid = gid;
    }

    public String getGtitle() {
        return gtitle;
    }

    public void setGtitle(String gtitle) {
        this.gtitle = gtitle;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Double getGprice() {
        return gprice;
    }

    public void setGprice(Double gprice) {
        this.gprice = gprice;
    }

    public Integer getGnum() {
        return gnum;
    }

    public void setGnum(Integer gnum) {
        this.gnum = gnum;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public Integer getGstatus() {
        return gstatus;
    }

    public void setGstatus(Integer gstatus) {
        this.gstatus = gstatus;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getDetail_imageurl() {
        return detail_imageurl;
    }

    public void setDetail_imageurl(String detail_imageurl) {
        this.detail_imageurl = detail_imageurl;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "gid=" + gid +
                ", gtitle='" + gtitle + '\'' +
                ", cid=" + cid +
                ", gprice=" + gprice +
                ", gnum=" + gnum +
                ", imageurl='" + imageurl + '\'' +
                ", gstatus=" + gstatus +
                ", created=" + created +
                ", updated=" + updated +
                ", detail='" + detail + '\'' +
                ", detail_imageurl='" + detail_imageurl + '\'' +
                '}';
    }
}

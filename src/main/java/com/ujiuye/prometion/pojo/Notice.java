package com.ujiuye.prometion.pojo;

import java.io.Serializable;
import java.util.Date;

public class Notice implements Serializable {
    private Integer id;

    private String title;

    private Date date;

    private String path;

    private Integer createby;

    private String content;

    private static final long serialVersionUID = 1L;

    public Notice(Integer id, String title, Date date, String path, Integer createby) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.path = path;
        this.createby = createby;
    }


    public Notice(Integer id, String title, Date date, String path, Integer createby, String content) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.path = path;
        this.createby = createby;
        this.content = content;
    }

    public Notice() {
        super();
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
        this.title = title == null ? null : title.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public Integer getCreateby() {
        return createby;
    }

    public void setCreateby(Integer createby) {
        this.createby = createby;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", date=").append(date);
        sb.append(", path=").append(path);
        sb.append(", createby=").append(createby);
        sb.append(", content=").append(content);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
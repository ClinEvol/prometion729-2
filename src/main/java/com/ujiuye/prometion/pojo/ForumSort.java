package com.ujiuye.prometion.pojo;

import java.io.Serializable;

public class ForumSort implements Serializable {
    private Integer id;

    private String title;

    private String description;

    private Integer click;

    private Integer count;

    private Integer rank;

    private Integer type;

    private static final long serialVersionUID = 1L;

    public ForumSort(Integer id, String title, String description, Integer click, Integer count, Integer rank, Integer type) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.click = click;
        this.count = count;
        this.rank = rank;
        this.type = type;
    }

    public ForumSort() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getClick() {
        return click;
    }

    public void setClick(Integer click) {
        this.click = click;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", description=").append(description);
        sb.append(", click=").append(click);
        sb.append(", count=").append(count);
        sb.append(", rank=").append(rank);
        sb.append(", type=").append(type);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
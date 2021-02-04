package com.ujiuye.prometion.pojo;

import java.io.Serializable;
import java.util.Date;

public class ForumPost implements Serializable {
    private Integer id;

    private String title;

    private String discript;

    private Integer employeeFk;

    private Date createtime;

    private Integer status;

    private Integer forumsortFk;

    private Integer commentCount;

    private Integer click;

    private String label;

    private String content;

    private static final long serialVersionUID = 1L;

    public ForumPost(Integer id, String title, String discript, Integer employeeFk, Date createtime, Integer status, Integer forumsortFk, Integer commentCount, Integer click, String label, String content) {
        this.id = id;
        this.title = title;
        this.discript = discript;
        this.employeeFk = employeeFk;
        this.createtime = createtime;
        this.status = status;
        this.forumsortFk = forumsortFk;
        this.commentCount = commentCount;
        this.click = click;
        this.label = label;
        this.content = content;
    }

    public ForumPost() {
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

    public String getDiscript() {
        return discript;
    }

    public void setDiscript(String discript) {
        this.discript = discript == null ? null : discript.trim();
    }

    public Integer getEmployeeFk() {
        return employeeFk;
    }

    public void setEmployeeFk(Integer employeeFk) {
        this.employeeFk = employeeFk;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getForumsortFk() {
        return forumsortFk;
    }

    public void setForumsortFk(Integer forumsortFk) {
        this.forumsortFk = forumsortFk;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Integer getClick() {
        return click;
    }

    public void setClick(Integer click) {
        this.click = click;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label == null ? null : label.trim();
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
        sb.append(", discript=").append(discript);
        sb.append(", employeeFk=").append(employeeFk);
        sb.append(", createtime=").append(createtime);
        sb.append(", status=").append(status);
        sb.append(", forumsortFk=").append(forumsortFk);
        sb.append(", commentCount=").append(commentCount);
        sb.append(", click=").append(click);
        sb.append(", label=").append(label);
        sb.append(", content=").append(content);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
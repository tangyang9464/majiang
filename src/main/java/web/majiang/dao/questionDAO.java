package web.majiang.dao;

import javax.persistence.*;

@Table(name = "question")
public class questionDAO {
    @Id
    private Long id;

    private String title;

    @Column(name = "gmt_create")
    private Long gmtCreate;

    @Column(name = "gmt_modified")
    private Long gmtModified;

    private Long creator;

    @Column(name = "comment_count")
    private Integer commentCount;

    @Column(name = "view_count")
    private Integer viewCount;

    @Column(name = "like_count")
    private Integer likeCount;

    private String tag;

    private String description;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * @return gmt_create
     */
    public Long getGmtCreate() {
        return gmtCreate;
    }

    /**
     * @param gmtCreate
     */
    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * @return gmt_modified
     */
    public Long getGmtModified() {
        return gmtModified;
    }

    /**
     * @param gmtModified
     */
    public void setGmtModified(Long gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * @return creator
     */
    public Long getCreator() {
        return creator;
    }

    /**
     * @param creator
     */
    public void setCreator(Long creator) {
        this.creator = creator;
    }

    /**
     * @return comment_count
     */
    public Integer getCommentCount() {
        return commentCount;
    }

    /**
     * @param commentCount
     */
    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    /**
     * @return view_count
     */
    public Integer getViewCount() {
        return viewCount;
    }

    /**
     * @param viewCount
     */
    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    /**
     * @return like_count
     */
    public Integer getLikeCount() {
        return likeCount;
    }

    /**
     * @param likeCount
     */
    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    /**
     * @return tag
     */
    public String getTag() {
        return tag;
    }

    /**
     * @param tag
     */
    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}
package web.majiang.mapper;

import org.apache.ibatis.jdbc.SQL;
import web.majiang.dao.questionDAO;

public class questionDAOSqlProvider {
    public String insertSelective(questionDAO record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("question");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getTitle() != null) {
            sql.VALUES("title", "#{title,jdbcType=VARCHAR}");
        }
        
        if (record.getGmtCreate() != null) {
            sql.VALUES("gmt_create", "#{gmtCreate,jdbcType=BIGINT}");
        }
        
        if (record.getGmtModified() != null) {
            sql.VALUES("gmt_modified", "#{gmtModified,jdbcType=BIGINT}");
        }
        
        if (record.getCreator() != null) {
            sql.VALUES("creator", "#{creator,jdbcType=BIGINT}");
        }
        
        if (record.getCommentCount() != null) {
            sql.VALUES("comment_count", "#{commentCount,jdbcType=INTEGER}");
        }
        
        if (record.getViewCount() != null) {
            sql.VALUES("view_count", "#{viewCount,jdbcType=INTEGER}");
        }
        
        if (record.getLikeCount() != null) {
            sql.VALUES("like_count", "#{likeCount,jdbcType=INTEGER}");
        }
        
        if (record.getTag() != null) {
            sql.VALUES("tag", "#{tag,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            sql.VALUES("description", "#{description,jdbcType=LONGVARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(questionDAO record) {
        SQL sql = new SQL();
        sql.UPDATE("question");
        
        if (record.getTitle() != null) {
            sql.SET("title = #{title,jdbcType=VARCHAR}");
        }
        
        if (record.getGmtCreate() != null) {
            sql.SET("gmt_create = #{gmtCreate,jdbcType=BIGINT}");
        }
        
        if (record.getGmtModified() != null) {
            sql.SET("gmt_modified = #{gmtModified,jdbcType=BIGINT}");
        }
        
        if (record.getCreator() != null) {
            sql.SET("creator = #{creator,jdbcType=BIGINT}");
        }
        
        if (record.getCommentCount() != null) {
            sql.SET("comment_count = #{commentCount,jdbcType=INTEGER}");
        }
        
        if (record.getViewCount() != null) {
            sql.SET("view_count = #{viewCount,jdbcType=INTEGER}");
        }
        
        if (record.getLikeCount() != null) {
            sql.SET("like_count = #{likeCount,jdbcType=INTEGER}");
        }
        
        if (record.getTag() != null) {
            sql.SET("tag = #{tag,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            sql.SET("description = #{description,jdbcType=LONGVARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }
}
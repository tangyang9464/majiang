package web.majiang.mapper;

import org.apache.ibatis.jdbc.SQL;
import web.majiang.dao.commentDAO;

public class commentDAOSqlProvider {
    public String insertSelective(commentDAO record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("comment");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getParentId() != null) {
            sql.VALUES("parent_id", "#{parentId,jdbcType=BIGINT}");
        }
        
        if (record.getType() != null) {
            sql.VALUES("type", "#{type,jdbcType=INTEGER}");
        }
        
        if (record.getCommentator() != null) {
            sql.VALUES("commentator", "#{commentator,jdbcType=BIGINT}");
        }
        
        if (record.getGmtCreate() != null) {
            sql.VALUES("gmt_create", "#{gmtCreate,jdbcType=BIGINT}");
        }
        
        if (record.getGmtModified() != null) {
            sql.VALUES("gmt_modified", "#{gmtModified,jdbcType=BIGINT}");
        }
        
        if (record.getLikeCount() != null) {
            sql.VALUES("like_count", "#{likeCount,jdbcType=BIGINT}");
        }
        
        if (record.getContent() != null) {
            sql.VALUES("content", "#{content,jdbcType=VARCHAR}");
        }
        
        if (record.getCommentCount() != null) {
            sql.VALUES("comment_count", "#{commentCount,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(commentDAO record) {
        SQL sql = new SQL();
        sql.UPDATE("comment");
        
        if (record.getParentId() != null) {
            sql.SET("parent_id = #{parentId,jdbcType=BIGINT}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{type,jdbcType=INTEGER}");
        }
        
        if (record.getCommentator() != null) {
            sql.SET("commentator = #{commentator,jdbcType=BIGINT}");
        }
        
        if (record.getGmtCreate() != null) {
            sql.SET("gmt_create = #{gmtCreate,jdbcType=BIGINT}");
        }
        
        if (record.getGmtModified() != null) {
            sql.SET("gmt_modified = #{gmtModified,jdbcType=BIGINT}");
        }
        
        if (record.getLikeCount() != null) {
            sql.SET("like_count = #{likeCount,jdbcType=BIGINT}");
        }
        
        if (record.getContent() != null) {
            sql.SET("content = #{content,jdbcType=VARCHAR}");
        }
        
        if (record.getCommentCount() != null) {
            sql.SET("comment_count = #{commentCount,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }
}
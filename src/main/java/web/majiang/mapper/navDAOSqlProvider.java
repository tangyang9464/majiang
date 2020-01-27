package web.majiang.mapper;

import org.apache.ibatis.jdbc.SQL;
import web.majiang.dao.navDAO;

public class navDAOSqlProvider {
    public String insertSelective(navDAO record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("nav");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getTitle() != null) {
            sql.VALUES("title", "#{title,jdbcType=VARCHAR}");
        }
        
        if (record.getUrl() != null) {
            sql.VALUES("url", "#{url,jdbcType=VARCHAR}");
        }
        
        if (record.getPriority() != null) {
            sql.VALUES("priority", "#{priority,jdbcType=INTEGER}");
        }
        
        if (record.getGmtCreate() != null) {
            sql.VALUES("gmt_create", "#{gmtCreate,jdbcType=BIGINT}");
        }
        
        if (record.getGmtModified() != null) {
            sql.VALUES("gmt_modified", "#{gmtModified,jdbcType=BIGINT}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(navDAO record) {
        SQL sql = new SQL();
        sql.UPDATE("nav");
        
        if (record.getTitle() != null) {
            sql.SET("title = #{title,jdbcType=VARCHAR}");
        }
        
        if (record.getUrl() != null) {
            sql.SET("url = #{url,jdbcType=VARCHAR}");
        }
        
        if (record.getPriority() != null) {
            sql.SET("priority = #{priority,jdbcType=INTEGER}");
        }
        
        if (record.getGmtCreate() != null) {
            sql.SET("gmt_create = #{gmtCreate,jdbcType=BIGINT}");
        }
        
        if (record.getGmtModified() != null) {
            sql.SET("gmt_modified = #{gmtModified,jdbcType=BIGINT}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}
package web.majiang.mapper;

import org.apache.ibatis.jdbc.SQL;
import web.majiang.dao.adDAO;

public class adDAOSqlProvider {
    public String insertSelective(adDAO record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("ad");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getTitle() != null) {
            sql.VALUES("title", "#{title,jdbcType=VARCHAR}");
        }
        
        if (record.getUrl() != null) {
            sql.VALUES("url", "#{url,jdbcType=VARCHAR}");
        }
        
        if (record.getImage() != null) {
            sql.VALUES("image", "#{image,jdbcType=VARCHAR}");
        }
        
        if (record.getGmtStart() != null) {
            sql.VALUES("gmt_start", "#{gmtStart,jdbcType=BIGINT}");
        }
        
        if (record.getGmtEnd() != null) {
            sql.VALUES("gmt_end", "#{gmtEnd,jdbcType=BIGINT}");
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
        
        if (record.getPos() != null) {
            sql.VALUES("pos", "#{pos,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(adDAO record) {
        SQL sql = new SQL();
        sql.UPDATE("ad");
        
        if (record.getTitle() != null) {
            sql.SET("title = #{title,jdbcType=VARCHAR}");
        }
        
        if (record.getUrl() != null) {
            sql.SET("url = #{url,jdbcType=VARCHAR}");
        }
        
        if (record.getImage() != null) {
            sql.SET("image = #{image,jdbcType=VARCHAR}");
        }
        
        if (record.getGmtStart() != null) {
            sql.SET("gmt_start = #{gmtStart,jdbcType=BIGINT}");
        }
        
        if (record.getGmtEnd() != null) {
            sql.SET("gmt_end = #{gmtEnd,jdbcType=BIGINT}");
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
        
        if (record.getPos() != null) {
            sql.SET("pos = #{pos,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}
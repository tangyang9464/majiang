package web.majiang.mapper;

import org.apache.ibatis.jdbc.SQL;
import web.majiang.dao.userDAO;

public class userDAOSqlProvider {
    public String insertSelective(userDAO record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("user");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getAccountId() != null) {
            sql.VALUES("account_id", "#{accountId,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getToken() != null) {
            sql.VALUES("token", "#{token,jdbcType=VARCHAR}");
        }
        
        if (record.getGmtCreate() != null) {
            sql.VALUES("gmt_create", "#{gmtCreate,jdbcType=BIGINT}");
        }
        
        if (record.getGmtModified() != null) {
            sql.VALUES("gmt_modified", "#{gmtModified,jdbcType=BIGINT}");
        }
        
        if (record.getBio() != null) {
            sql.VALUES("bio", "#{bio,jdbcType=VARCHAR}");
        }
        
        if (record.getAvatarUrl() != null) {
            sql.VALUES("avatar_url", "#{avatarUrl,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(userDAO record) {
        SQL sql = new SQL();
        sql.UPDATE("user");
        
        if (record.getAccountId() != null) {
            sql.SET("account_id = #{accountId,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getToken() != null) {
            sql.SET("token = #{token,jdbcType=VARCHAR}");
        }
        
        if (record.getGmtCreate() != null) {
            sql.SET("gmt_create = #{gmtCreate,jdbcType=BIGINT}");
        }
        
        if (record.getGmtModified() != null) {
            sql.SET("gmt_modified = #{gmtModified,jdbcType=BIGINT}");
        }
        
        if (record.getBio() != null) {
            sql.SET("bio = #{bio,jdbcType=VARCHAR}");
        }
        
        if (record.getAvatarUrl() != null) {
            sql.SET("avatar_url = #{avatarUrl,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }
}
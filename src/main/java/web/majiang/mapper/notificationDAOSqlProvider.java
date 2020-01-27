package web.majiang.mapper;

import org.apache.ibatis.jdbc.SQL;
import web.majiang.dao.notificationDAO;

public class notificationDAOSqlProvider {
    public String insertSelective(notificationDAO record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("notification");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getNotifier() != null) {
            sql.VALUES("notifier", "#{notifier,jdbcType=BIGINT}");
        }
        
        if (record.getReceiver() != null) {
            sql.VALUES("receiver", "#{receiver,jdbcType=BIGINT}");
        }
        
        if (record.getOuterid() != null) {
            sql.VALUES("outerid", "#{outerid,jdbcType=BIGINT}");
        }
        
        if (record.getType() != null) {
            sql.VALUES("type", "#{type,jdbcType=INTEGER}");
        }
        
        if (record.getGmtCreate() != null) {
            sql.VALUES("gmt_create", "#{gmtCreate,jdbcType=BIGINT}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getNotifierName() != null) {
            sql.VALUES("notifier_name", "#{notifierName,jdbcType=VARCHAR}");
        }
        
        if (record.getOuterTitle() != null) {
            sql.VALUES("outer_title", "#{outerTitle,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(notificationDAO record) {
        SQL sql = new SQL();
        sql.UPDATE("notification");
        
        if (record.getNotifier() != null) {
            sql.SET("notifier = #{notifier,jdbcType=BIGINT}");
        }
        
        if (record.getReceiver() != null) {
            sql.SET("receiver = #{receiver,jdbcType=BIGINT}");
        }
        
        if (record.getOuterid() != null) {
            sql.SET("outerid = #{outerid,jdbcType=BIGINT}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{type,jdbcType=INTEGER}");
        }
        
        if (record.getGmtCreate() != null) {
            sql.SET("gmt_create = #{gmtCreate,jdbcType=BIGINT}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getNotifierName() != null) {
            sql.SET("notifier_name = #{notifierName,jdbcType=VARCHAR}");
        }
        
        if (record.getOuterTitle() != null) {
            sql.SET("outer_title = #{outerTitle,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }
}
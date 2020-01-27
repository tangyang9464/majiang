package web.majiang.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import web.majiang.dao.notificationDAO;

public interface notificationDAOMapper {
    @Delete({
        "delete from notification",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into notification (id, notifier, ",
        "receiver, outerid, ",
        "type, gmt_create, ",
        "status, notifier_name, ",
        "outer_title)",
        "values (#{id,jdbcType=BIGINT}, #{notifier,jdbcType=BIGINT}, ",
        "#{receiver,jdbcType=BIGINT}, #{outerid,jdbcType=BIGINT}, ",
        "#{type,jdbcType=INTEGER}, #{gmtCreate,jdbcType=BIGINT}, ",
        "#{status,jdbcType=INTEGER}, #{notifierName,jdbcType=VARCHAR}, ",
        "#{outerTitle,jdbcType=VARCHAR})"
    })
    int insert(notificationDAO record);

    @InsertProvider(type=notificationDAOSqlProvider.class, method="insertSelective")
    int insertSelective(notificationDAO record);

    @Select({
        "select",
        "id, notifier, receiver, outerid, type, gmt_create, status, notifier_name, outer_title",
        "from notification",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="notifier", property="notifier", jdbcType=JdbcType.BIGINT),
        @Result(column="receiver", property="receiver", jdbcType=JdbcType.BIGINT),
        @Result(column="outerid", property="outerid", jdbcType=JdbcType.BIGINT),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.BIGINT),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="notifier_name", property="notifierName", jdbcType=JdbcType.VARCHAR),
        @Result(column="outer_title", property="outerTitle", jdbcType=JdbcType.VARCHAR)
    })
    notificationDAO selectByPrimaryKey(Long id);

    @UpdateProvider(type=notificationDAOSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(notificationDAO record);

    @Update({
        "update notification",
        "set notifier = #{notifier,jdbcType=BIGINT},",
          "receiver = #{receiver,jdbcType=BIGINT},",
          "outerid = #{outerid,jdbcType=BIGINT},",
          "type = #{type,jdbcType=INTEGER},",
          "gmt_create = #{gmtCreate,jdbcType=BIGINT},",
          "status = #{status,jdbcType=INTEGER},",
          "notifier_name = #{notifierName,jdbcType=VARCHAR},",
          "outer_title = #{outerTitle,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(notificationDAO record);
}
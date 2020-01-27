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
import web.majiang.dao.navDAO;

public interface navDAOMapper {
    @Delete({
        "delete from nav",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into nav (id, title, ",
        "url, priority, gmt_create, ",
        "gmt_modified, status)",
        "values (#{id,jdbcType=INTEGER}, #{title,jdbcType=VARCHAR}, ",
        "#{url,jdbcType=VARCHAR}, #{priority,jdbcType=INTEGER}, #{gmtCreate,jdbcType=BIGINT}, ",
        "#{gmtModified,jdbcType=BIGINT}, #{status,jdbcType=INTEGER})"
    })
    int insert(navDAO record);

    @InsertProvider(type=navDAOSqlProvider.class, method="insertSelective")
    int insertSelective(navDAO record);

    @Select({
        "select",
        "id, title, url, priority, gmt_create, gmt_modified, status",
        "from nav",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="priority", property="priority", jdbcType=JdbcType.INTEGER),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.BIGINT),
        @Result(column="gmt_modified", property="gmtModified", jdbcType=JdbcType.BIGINT),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER)
    })
    navDAO selectByPrimaryKey(Integer id);

    @UpdateProvider(type=navDAOSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(navDAO record);

    @Update({
        "update nav",
        "set title = #{title,jdbcType=VARCHAR},",
          "url = #{url,jdbcType=VARCHAR},",
          "priority = #{priority,jdbcType=INTEGER},",
          "gmt_create = #{gmtCreate,jdbcType=BIGINT},",
          "gmt_modified = #{gmtModified,jdbcType=BIGINT},",
          "status = #{status,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(navDAO record);
}
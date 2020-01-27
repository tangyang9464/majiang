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
import web.majiang.dao.adDAO;

public interface adDAOMapper {
    @Delete({
        "delete from ad",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into ad (id, title, ",
        "url, image, gmt_start, ",
        "gmt_end, gmt_create, ",
        "gmt_modified, status, ",
        "pos)",
        "values (#{id,jdbcType=INTEGER}, #{title,jdbcType=VARCHAR}, ",
        "#{url,jdbcType=VARCHAR}, #{image,jdbcType=VARCHAR}, #{gmtStart,jdbcType=BIGINT}, ",
        "#{gmtEnd,jdbcType=BIGINT}, #{gmtCreate,jdbcType=BIGINT}, ",
        "#{gmtModified,jdbcType=BIGINT}, #{status,jdbcType=INTEGER}, ",
        "#{pos,jdbcType=VARCHAR})"
    })
    int insert(adDAO record);

    @InsertProvider(type=adDAOSqlProvider.class, method="insertSelective")
    int insertSelective(adDAO record);

    @Select({
        "select",
        "id, title, url, image, gmt_start, gmt_end, gmt_create, gmt_modified, status, ",
        "pos",
        "from ad",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="image", property="image", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_start", property="gmtStart", jdbcType=JdbcType.BIGINT),
        @Result(column="gmt_end", property="gmtEnd", jdbcType=JdbcType.BIGINT),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.BIGINT),
        @Result(column="gmt_modified", property="gmtModified", jdbcType=JdbcType.BIGINT),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="pos", property="pos", jdbcType=JdbcType.VARCHAR)
    })
    adDAO selectByPrimaryKey(Integer id);

    @UpdateProvider(type=adDAOSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(adDAO record);

    @Update({
        "update ad",
        "set title = #{title,jdbcType=VARCHAR},",
          "url = #{url,jdbcType=VARCHAR},",
          "image = #{image,jdbcType=VARCHAR},",
          "gmt_start = #{gmtStart,jdbcType=BIGINT},",
          "gmt_end = #{gmtEnd,jdbcType=BIGINT},",
          "gmt_create = #{gmtCreate,jdbcType=BIGINT},",
          "gmt_modified = #{gmtModified,jdbcType=BIGINT},",
          "status = #{status,jdbcType=INTEGER},",
          "pos = #{pos,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(adDAO record);
}
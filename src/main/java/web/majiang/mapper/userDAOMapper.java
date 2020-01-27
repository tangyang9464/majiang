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
import web.majiang.dao.userDAO;

public interface userDAOMapper {
    @Delete({
        "delete from user",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into user (id, account_id, ",
        "name, token, gmt_create, ",
        "gmt_modified, bio, ",
        "avatar_url)",
        "values (#{id,jdbcType=BIGINT}, #{accountId,jdbcType=VARCHAR}, ",
        "#{name,jdbcType=VARCHAR}, #{token,jdbcType=VARCHAR}, #{gmtCreate,jdbcType=BIGINT}, ",
        "#{gmtModified,jdbcType=BIGINT}, #{bio,jdbcType=VARCHAR}, ",
        "#{avatarUrl,jdbcType=VARCHAR})"
    })
    int insert(userDAO record);

    @InsertProvider(type=userDAOSqlProvider.class, method="insertSelective")
    int insertSelective(userDAO record);

    @Select({
        "select",
        "id, account_id, name, token, gmt_create, gmt_modified, bio, avatar_url",
        "from user",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="account_id", property="accountId", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="token", property="token", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.BIGINT),
        @Result(column="gmt_modified", property="gmtModified", jdbcType=JdbcType.BIGINT),
        @Result(column="bio", property="bio", jdbcType=JdbcType.VARCHAR),
        @Result(column="avatar_url", property="avatarUrl", jdbcType=JdbcType.VARCHAR)
    })
    userDAO selectByPrimaryKey(Long id);

    @UpdateProvider(type=userDAOSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(userDAO record);

    @Update({
        "update user",
        "set account_id = #{accountId,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "token = #{token,jdbcType=VARCHAR},",
          "gmt_create = #{gmtCreate,jdbcType=BIGINT},",
          "gmt_modified = #{gmtModified,jdbcType=BIGINT},",
          "bio = #{bio,jdbcType=VARCHAR},",
          "avatar_url = #{avatarUrl,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(userDAO record);

    @Select("select * from user where token=#{token}")
    userDAO selectByToken(String token);
}
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
import web.majiang.dao.commentDAO;

public interface commentDAOMapper {
    @Delete({
        "delete from comment",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into comment (id, parent_id, ",
        "type, commentator, ",
        "gmt_create, gmt_modified, ",
        "like_count, content, ",
        "comment_count)",
        "values (#{id,jdbcType=BIGINT}, #{parentId,jdbcType=BIGINT}, ",
        "#{type,jdbcType=INTEGER}, #{commentator,jdbcType=BIGINT}, ",
        "#{gmtCreate,jdbcType=BIGINT}, #{gmtModified,jdbcType=BIGINT}, ",
        "#{likeCount,jdbcType=BIGINT}, #{content,jdbcType=VARCHAR}, ",
        "#{commentCount,jdbcType=INTEGER})"
    })
    int insert(commentDAO record);

    @InsertProvider(type=commentDAOSqlProvider.class, method="insertSelective")
    int insertSelective(commentDAO record);

    @Select({
        "select",
        "id, parent_id, type, commentator, gmt_create, gmt_modified, like_count, content, ",
        "comment_count",
        "from comment",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.BIGINT),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="commentator", property="commentator", jdbcType=JdbcType.BIGINT),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.BIGINT),
        @Result(column="gmt_modified", property="gmtModified", jdbcType=JdbcType.BIGINT),
        @Result(column="like_count", property="likeCount", jdbcType=JdbcType.BIGINT),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="comment_count", property="commentCount", jdbcType=JdbcType.INTEGER)
    })
    commentDAO selectByPrimaryKey(Long id);

    @UpdateProvider(type=commentDAOSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(commentDAO record);

    @Update({
        "update comment",
        "set parent_id = #{parentId,jdbcType=BIGINT},",
          "type = #{type,jdbcType=INTEGER},",
          "commentator = #{commentator,jdbcType=BIGINT},",
          "gmt_create = #{gmtCreate,jdbcType=BIGINT},",
          "gmt_modified = #{gmtModified,jdbcType=BIGINT},",
          "like_count = #{likeCount,jdbcType=BIGINT},",
          "content = #{content,jdbcType=VARCHAR},",
          "comment_count = #{commentCount,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(commentDAO record);
}
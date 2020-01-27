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
import web.majiang.dao.questionDAO;

import java.util.List;

public interface questionDAOMapper {
    @Delete({
        "delete from question",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into question (id, title, ",
        "gmt_create, gmt_modified, ",
        "creator, comment_count, ",
        "view_count, like_count, ",
        "tag, description)",
        "values (#{id,jdbcType=BIGINT}, #{title,jdbcType=VARCHAR}, ",
        "#{gmtCreate,jdbcType=BIGINT}, #{gmtModified,jdbcType=BIGINT}, ",
        "#{creator,jdbcType=BIGINT}, #{commentCount,jdbcType=INTEGER}, ",
        "#{viewCount,jdbcType=INTEGER}, #{likeCount,jdbcType=INTEGER}, ",
        "#{tag,jdbcType=VARCHAR}, #{description,jdbcType=LONGVARCHAR})"
    })
    int insert(questionDAO record);

    @InsertProvider(type=questionDAOSqlProvider.class, method="insertSelective")
    int insertSelective(questionDAO record);

    @Select({
        "select",
        "id, title, gmt_create, gmt_modified, creator, comment_count, view_count, like_count, ",
        "tag, description",
        "from question",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.BIGINT),
        @Result(column="gmt_modified", property="gmtModified", jdbcType=JdbcType.BIGINT),
        @Result(column="creator", property="creator", jdbcType=JdbcType.BIGINT),
        @Result(column="comment_count", property="commentCount", jdbcType=JdbcType.INTEGER),
        @Result(column="view_count", property="viewCount", jdbcType=JdbcType.INTEGER),
        @Result(column="like_count", property="likeCount", jdbcType=JdbcType.INTEGER),
        @Result(column="tag", property="tag", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.LONGVARCHAR)
    })
    questionDAO selectByPrimaryKey(Long id);

    @UpdateProvider(type=questionDAOSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(questionDAO record);

    @Update({
        "update question",
        "set title = #{title,jdbcType=VARCHAR},",
          "gmt_create = #{gmtCreate,jdbcType=BIGINT},",
          "gmt_modified = #{gmtModified,jdbcType=BIGINT},",
          "creator = #{creator,jdbcType=BIGINT},",
          "comment_count = #{commentCount,jdbcType=INTEGER},",
          "view_count = #{viewCount,jdbcType=INTEGER},",
          "like_count = #{likeCount,jdbcType=INTEGER},",
          "tag = #{tag,jdbcType=VARCHAR},",
          "description = #{description,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(questionDAO record);

    @Update({
        "update question",
        "set title = #{title,jdbcType=VARCHAR},",
          "gmt_create = #{gmtCreate,jdbcType=BIGINT},",
          "gmt_modified = #{gmtModified,jdbcType=BIGINT},",
          "creator = #{creator,jdbcType=BIGINT},",
          "comment_count = #{commentCount,jdbcType=INTEGER},",
          "view_count = #{viewCount,jdbcType=INTEGER},",
          "like_count = #{likeCount,jdbcType=INTEGER},",
          "tag = #{tag,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(questionDAO record);

    @Select("select * from question")
    List<questionDAO> selectList();
}
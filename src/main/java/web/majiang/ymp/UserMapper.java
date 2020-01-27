package web.majiang.ymp;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository//显示声明这是一个bean组件
@Mapper
public interface UserMapper {
    @Insert("insert into user (name,token) value (#{name},#{token})")
    public void insert(String name,String token);
    @Select("select name from user where token=#{token}")
    public String getUserByToken(String token);
}

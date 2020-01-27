package web.majiang.mapper;

import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;
import web.majiang.dao.userDAO;

public interface userDAOMapper extends Mapper<userDAO> {
//    @Select("select * from user where token=#{token}")
//    userDAO selectByToken(String token);
}
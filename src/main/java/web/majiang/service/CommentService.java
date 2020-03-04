package web.majiang.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import web.majiang.DTO.CommentShowDTO;
import web.majiang.dao.commentDAO;
import web.majiang.dao.userDAO;
import web.majiang.mapper.commentDAOMapper;
import web.majiang.mapper.userDAOMapper;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {
    @Autowired
    commentDAOMapper commentDAOMapper;
    @Autowired
    userDAOMapper userDAOMapper;

    public List<CommentShowDTO> selectCommentShowDTOByExample(Example example){
        List<commentDAO> commentList = commentDAOMapper.selectByExample(example);
        ArrayList<CommentShowDTO> comments = new ArrayList<>();
        for (commentDAO c:commentList) {
            CommentShowDTO commentShowDTO = new CommentShowDTO();
            BeanUtils.copyProperties(c,commentShowDTO);
            commentShowDTO.setUser(userDAOMapper.selectByPrimaryKey(c.getCommentator()));
            comments.add(commentShowDTO);
        }
        return comments;
    }
}

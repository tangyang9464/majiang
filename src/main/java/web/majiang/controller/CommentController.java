package web.majiang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;
import web.majiang.DTO.CommentDTO;
import web.majiang.DTO.CommentShowDTO;
import web.majiang.dao.commentDAO;
import web.majiang.dao.userDAO;
import web.majiang.mapper.commentDAOMapper;
import web.majiang.service.CommentService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class CommentController {
    @Autowired
    commentDAOMapper commentDAOMapper;
    @Autowired
    CommentService commentService;

    @ResponseBody
    @PostMapping("/comment")
    public String setReplels(HttpServletRequest request,
                           @RequestBody CommentDTO commentDTO,
                           HttpServletResponse response){
        userDAO user = (userDAO) request.getSession().getAttribute("user");

        if(user==null){
            return "2003";//未登录代码
        }
        else {
            commentDAO comment = new commentDAO();
            comment.setParentId(commentDTO.getParentId());
            comment.setContent(commentDTO.getContent());
            comment.setType(commentDTO.getType());
            comment.setGmtModified(System.currentTimeMillis());
            comment.setGmtCreate(System.currentTimeMillis());
            comment.setCommentator(user.getId());
            comment.setLikeCount(0L);
            commentDAOMapper.insertSelective(comment);
            return "200";//成功代码
        }
    }

    @ResponseBody
    @GetMapping("/comment/{id}")
    public List<CommentShowDTO> getComments(@PathVariable(name = "id") Long id){
        Example example = new Example(commentDAO.class);
        example.createCriteria().andEqualTo("parentId", id).andEqualTo("type",2);
        return commentService.selectCommentShowDTOByExample(example);
    }
}

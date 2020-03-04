package web.majiang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import tk.mybatis.mapper.entity.Example;
import web.majiang.DTO.CommentShowDTO;
import web.majiang.DTO.QuestionDTO;
import web.majiang.dao.commentDAO;
import web.majiang.dao.questionDAO;
import web.majiang.mapper.commentDAOMapper;
import web.majiang.mapper.questionDAOMapper;
import web.majiang.service.CommentService;
import web.majiang.service.QuestionService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class questionController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private questionDAOMapper questionDAOMapper;
    @Autowired
    commentDAOMapper commentDAOMapper;

    @RequestMapping("/question/{id}")
    public String getQuestion(@PathVariable(name = "id") Long id,
                              Model model){
        //问题主题信息
        QuestionDTO question = questionService.selectByPrimaryKey(id);
        question.setViewCount(question.getViewCount()+1);
        model.addAttribute("question", question);
        //回复信息
        Example example = new Example(commentDAO.class);
        example.createCriteria().andEqualTo("parentId", question.getId());
        List<CommentShowDTO> comments = commentService.selectCommentShowDTOByExample(example);
        model.addAttribute("comments", comments);
        //浏览数增加
        questionDAO questionDAO = new questionDAO();
        questionDAO.setViewCount(question.getViewCount());
        questionService.updateByExampleSelective("id", question.getId(),questionDAO);
        return "question";
    }
}

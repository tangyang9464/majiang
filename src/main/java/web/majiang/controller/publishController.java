package web.majiang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.majiang.dao.questionDAO;
import web.majiang.dao.userDAO;
import web.majiang.mapper.questionDAOMapper;

import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.Data;

@Controller
public class publishController {
    @Autowired
    questionDAOMapper questionDAOMapper;

    @PostMapping("/publish")
    public String publish(@RequestParam("title") String title,
                          @RequestParam("description") String description,
                          @RequestParam("tag") String tag,
                          HttpServletRequest request){
        //获取作者对象
        userDAO user = (userDAO)request.getSession().getAttribute("user");
        Long  creator = user.getId();//作者id
        //放入作者,题目,内容描述,标签creator,title,description,tag
        questionDAO question = new questionDAO();
        question.setCreator(creator);
        question.setTitle(title);
        question.setDescription(description);
        question.setTag(tag);
        question.setGmtCreate(System.currentTimeMillis());
        //插入数据库
        questionDAOMapper.insertSelective(question);
        return "redirect:/";
    }
}

package web.majiang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import tk.mybatis.mapper.entity.Example;
import web.majiang.dao.questionDAO;
import web.majiang.dao.userDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/profile")
public class MyInformationController {
    @RequestMapping("/questions")
    public void getQuestion(HttpServletRequest request,
                            HttpServletResponse response
                            ) throws ServletException, IOException {
        userDAO user = (userDAO) request.getSession().getAttribute("user");
        Example example = new Example(questionDAO.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id",user.getId());
        request.setAttribute("example", example);
        request.getRequestDispatcher("/index").forward(request, response);
    }
}

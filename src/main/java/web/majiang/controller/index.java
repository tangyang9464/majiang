package web.majiang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import web.majiang.dao.userDAO;
import web.majiang.mapper.userDAOMapper;
import web.majiang.service.QuestionService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class index {
    @Autowired
    userDAOMapper userMapper;
    @Autowired
    QuestionService QS;

    @RequestMapping({"/","/index.html"})
    public String preIndex(HttpServletRequest request,
                           HttpServletResponse response,
                           Model model){
        //用户登录检查
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie:cookies) {
            //找到token
            if(cookie.getName().equals("token")){
                userDAO user = userMapper.selectByToken(cookie.getValue());
                if(user != null){
                    //放到会话中,用于登录用户的数据输入
                    request.getSession().setAttribute("user", user);
                }
                break;
            }
        }

        //页面数据获取
        //数据放入前端页面
        model.addAttribute("question", QS.list());
        return "index";
    }
}

package web.majiang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import tk.mybatis.mapper.entity.Example;
import web.majiang.dao.userDAO;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LogOut {
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response){
        //清除cooike
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            //找到token
            if (cookie.getName().equals("token")) {
                cookie.setMaxAge(0);
                response.addCookie(cookie);
                break;
            }
        }
//       清除session对象
        request.getSession().removeAttribute("user");
        return "redirect:/";
    }
}

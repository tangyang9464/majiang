package web.majiang.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tk.mybatis.mapper.entity.Example;
import web.majiang.DTO.QuestionDTO;
import web.majiang.dao.questionDAO;
import web.majiang.dao.userDAO;
import web.majiang.mapper.questionDAOMapper;
import web.majiang.mapper.userDAOMapper;
import web.majiang.service.QuestionService;
import web.majiang.util.QuestionDTOPageInfo;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.ServerException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class index {
    @Autowired
    userDAOMapper userMapper;
    @Autowired
    QuestionService QS;
    @Value("${page.pageSize:2}")
    private Integer pageSize;

    @RequestMapping({"/","/index.html"})
    public void preIndex(HttpServletRequest request,
                           HttpServletResponse response,
                           Model model) throws Exception {
        //用户登录检查
        Cookie[] cookies = request.getCookies();
        if(cookies != null)
            for (Cookie cookie : cookies) {
                //找到token
                if (cookie.getName().equals("token")) {
                    Example example = new Example(userDAO.class);
                    example.createCriteria().andEqualTo("token", cookie.getValue());
                    userDAO user = userMapper.selectOneByExample(example);
                    if (user != null) {
                        //放到会话中,用于登录用户的数据输入
                        request.getSession().setAttribute("user", user);
                    }
                    break;
                }
            }
        request.getRequestDispatcher("/index").forward(request, response);
    }

    @RequestMapping("/index")
    public String PageDisplay(Model model,
                              @RequestParam(required = false,defaultValue="1",value="pageNum") Integer pageNum,
                              HttpServletRequest request,
                              @RequestParam(required = false) Example example
                              ){

        //为了程序的严谨性，判断非空：
        if(pageNum == null){
            pageNum = 1;   //设置默认当前页
        }
        if(pageNum <= 0){
            pageNum = 1;
        }
        if(pageSize == null){
            pageSize = 5;    //设置默认每页显示的数据数
        }
        QuestionDTOPageInfo<questionDAO> pageInfo = QS.QuestionPagingQuery(pageNum, pageSize,example);
        model.addAttribute("pageInfo",pageInfo);
        return "index";
    }
}

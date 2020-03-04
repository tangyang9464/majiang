package web.majiang.controller;

import com.alibaba.fastjson.JSON;
import me.zhyd.oauth.config.AuthConfig;
import me.zhyd.oauth.request.AuthGithubRequest;
import me.zhyd.oauth.model.AuthCallback;
import me.zhyd.oauth.request.AuthRequest;
import me.zhyd.oauth.utils.AuthStateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import web.majiang.DTO.GitHubUser;
import web.majiang.dao.userDAO;
import web.majiang.mapper.userDAOMapper;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller
@RequestMapping("/oauth")
public class RestAuthController {
    @Value("${github.clientId}")
    private String clientId;
    @Value("${github.clientSecret}")
    private String clientSecret;
    @Value("${github.redirectUri}")
    private String redirectUri;
    @Autowired
    userDAOMapper userMapper;

    @RequestMapping("/render")
    public void renderAuth(HttpServletResponse response) throws IOException {
        AuthRequest authRequest = getAuthRequest();
        response.sendRedirect(authRequest.authorize(AuthStateUtils.createState()));
    }
    //这里处理登录后的数据管理
    @RequestMapping("/callback")
    public String login(AuthCallback callback,HttpServletResponse response) {
        String token = callback.getCode();

        AuthRequest authRequest = getAuthRequest();
        Object obj = authRequest.login(callback).getData();
        //转换成JSON字符串
        String str = JSON.toJSONString(obj);
        //转换成Github对象
        GitHubUser user = JSON.parseObject(str,GitHubUser.class);
        if(user != null)
        {
            //插入数据库(放入姓名,token,头像url),DTO转换成DAO
            userDAO userDAO = new userDAO();
            userDAO.setName(user.getusername());
            userDAO.setToken(token);
            userDAO.setAvatarUrl(user.getavatar());
            userMapper.insertSelective(userDAO);
//            放入cooike
            Cookie cookie = new Cookie("token", token);
            cookie.setPath("/");
            response.addCookie(cookie);
            return "redirect:/index.html";
        }
        else{
            return "redirect:/index.html";
        }
    }

    private AuthRequest getAuthRequest() {
        return new AuthGithubRequest(AuthConfig.builder()
                .clientId(clientId)
                .clientSecret(clientSecret)
                .redirectUri(redirectUri)
                .build());
    }
}

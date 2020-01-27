package web.majiang.component;

import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.util.Locale;

public class MyLocaleResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        //默认使用系统语言代码
        Locale locale = Locale.getDefault();
        //获取语言代码参数
        String lan = httpServletRequest.getParameter("lan");
        if(!StringUtils.isEmpty(lan))
        {
            //分割成语言和国家代码
            String[] s = lan.split("_");
            locale = new Locale(s[0],s[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}

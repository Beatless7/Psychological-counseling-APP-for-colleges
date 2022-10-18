package io.renren.interceptor;

import io.renren.annotation.Login;
import io.renren.annotation.LoginStudent;
import io.renren.common.exception.ErrorCode;
import io.renren.common.exception.RenException;
import io.renren.entity.StudentTokenEntity;
import io.renren.service.StudentTokenService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 学生权限(Token)验证
 *
 * @author Tjut team
 */

@Component
public class StudentAuthorizationInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private StudentTokenService tokenService;

    public static final String STUDENT_KEY = "studentId";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Login annotation;
        if(handler instanceof HandlerMethod) {
            annotation = ((HandlerMethod) handler).getMethodAnnotation(Login.class);
        }else{
            return true;
        }

        if(annotation == null){
            return true;
        }

        //从header中获取token
        String token = request.getHeader("token");
        //如果header中不存在token，则从参数中获取token
        if(StringUtils.isBlank(token)){
            token = request.getParameter("token");
        }

        //token为空
        if(StringUtils.isBlank(token)){
            throw new RenException(ErrorCode.TOKEN_NOT_EMPTY);
        }

        //查询token信息
        StudentTokenEntity tokenEntity = tokenService.getByToken(token);
        if(tokenEntity == null || tokenEntity.getExpireDate().getTime() < System.currentTimeMillis()){
            throw new RenException(ErrorCode.TOKEN_INVALID);
        }

        //设置studentId到request里，后续根据studentId，获取学生信息
        request.setAttribute(STUDENT_KEY, tokenEntity.getStudentId());

        return true;
    }

}

package io.renren.resolver;

import io.renren.annotation.Login;
import io.renren.annotation.LoginStudent;
import io.renren.entity.StudentEntity;
import io.renren.interceptor.StudentAuthorizationInterceptor;
import io.renren.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * 有@LoginStudent注解的方法参数，注入当前登录用户
 *
 * @author Tjut team
 */

@Component
public class LoginStudentHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver{
    @Autowired
    private StudentService studentService;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().isAssignableFrom(StudentEntity.class) && parameter.hasParameterAnnotation(LoginStudent.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer container,
                                  NativeWebRequest request, WebDataBinderFactory factory) throws Exception {
        //获取用户ID
        Object object = request.getAttribute(StudentAuthorizationInterceptor.STUDENT_KEY, RequestAttributes.SCOPE_REQUEST);
        if(object == null){
            return null;
        }

        //获取用户信息
        StudentEntity student = studentService.getStudentByStudentId((Long)object);

        return student;
    }

}

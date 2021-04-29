package cn.gdpi.bookmall.aspect;

import cn.gdpi.bookmall.annotation.Intercept;
import cn.gdpi.bookmall.util.Code;
import cn.gdpi.bookmall.util.JwtTokenUtil;
import cn.gdpi.bookmall.util.Return;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @author lihaotao
 * @description 说明
 * @date 2020-12-18 16:48
 ***/
@Aspect
@Component
public class InterceptAspect {

    private final String header="Authorization";

    @Resource
    private JwtTokenUtil jwtTokenUtil;

    @Pointcut("@annotation(cn.gdpi.bookmall.annotation.Intercept)")
    public void pointcut() { }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        Object result = null;
        try {
            String token = request.getHeader(this.header);
            if (ObjectUtils.isEmpty(token)||token.length()<=0){
                 return Return.error(Code.ERROR_CODE, "请登录");
            }else {

                if(jwtTokenUtil.isTokenExpired(token)){
                    Return.error(Code.ERROR_CODE, "请登录");
                }

                MethodSignature signature = (MethodSignature) point.getSignature();
                Method method = signature.getMethod();
                Intercept intercept = method.getAnnotation(Intercept.class);

                Integer role=intercept.role();
                
                int tokenRole=jwtTokenUtil.getRoleFromToken(token);

                if(role.intValue()<=tokenRole){
                    result = point.proceed();
                    return result;
                }
                return Return.error(Code.NONE_PERMISSION_CODE,"权限不足");
            }
        } catch (Throwable e) {
            return result;
        }
    }

}

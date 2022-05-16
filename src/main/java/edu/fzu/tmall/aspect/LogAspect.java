package edu.fzu.tmall.aspect;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@Slf4j
@Component
@Aspect
public class LogAspect {

    // 切入点
    @Pointcut("execution(* edu.fzu.tmall.service.OrderServiceImpl.*(..))")
    public void logPointcut(){

    }

    // 输出日志信息
    @AfterReturning(pointcut= "logPointcut()",returning = "rvt")
    public void log(JoinPoint joinPoint,Object rvt){
        String username="## 用户";
        // 方法
        String method=joinPoint.getTarget().getClass().getName()+"."+joinPoint.getSignature().getName()+"()";
        String param=joinPoint.getArgs().toString();
        String value=rvt.toString();
        // 后置通知
        System.out.println("======后置通知开始=====");
        System.out.println("用户："+username);
        System.out.println("方法："+method);
        System.out.println("参数"+param);
        System.out.println("返回值："+value);
    }
}

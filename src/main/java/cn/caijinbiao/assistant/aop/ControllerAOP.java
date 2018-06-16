package cn.caijinbiao.assistant.aop;

import cn.caijinbiao.assistant.exception.CheckException;
import cn.caijinbiao.assistant.exception.IsNullOrEmptyException;
import cn.caijinbiao.assistant.exception.NoPermissionException;
import cn.caijinbiao.assistant.response.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

@Component
@Aspect
@Slf4j
public class ControllerAOP {
    @Around("execution(cn.caijinbiao.assistant.response.ResponseResult cn.caijinbiao.assistant.controller..*.*(..))")
    public Object handlerJSON(ProceedingJoinPoint pjp) {
        long startTime = System.currentTimeMillis();
        try {
            ResponseResult<?> respondResult = (ResponseResult<?>) pjp.proceed();
            log.info(pjp.getSignature() + " 使用耗时 : " + (System.currentTimeMillis() - startTime));
            return respondResult;
        } catch (Throwable e) {
            return handlerException(pjp, e);
        }
    }

    /**
     * 全局捕获异常
     * 根据错误类型返回对应HTTP状态码
     * 对于不是自定义的异常进行log记录
     */
    @AfterThrowing(throwing = "ex", pointcut = "execution(cn.caijinbiao.assistant.response.ResponseResult cn.caijinbiao.assistant.controller..*.*(..))")
    public ResponseResult handlerException(JoinPoint pjp, Throwable ex) {
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        ResponseResult responseResult = new ResponseResult();
        responseResult.setMessage(ex.getMessage());
        try {
            if (ex instanceof IsNullOrEmptyException) {
                response.setStatus(400);
            } else if (ex instanceof CheckException) {
                response.setStatus(422);
            } else if (ex instanceof NoPermissionException) {
                response.setStatus(403);
            } else {
                response.setStatus(500);
                log.error("【异常通知】: " + pjp.getTarget().getClass().getName() + " 类的 " + pjp.getSignature().getName() + " 方法执行参数 " + Arrays.deepToString(pjp.getArgs()) + " 时遇见异常了" + ex.getMessage(), ex);
                responseResult.setMessage("服务器异常，请重试或刷新页面重新操作");
            }
        } catch (Exception e) {
            response.setStatus(500);
            log.error("【自动处理异常错误】内部错误: " + pjp.getSignature() + " 参数 : " + Arrays.toString(pjp.getArgs()) + " 实际错误为 ", ex);
            log.error("【自动处理异常错误】自动处理错误: ",e);
            return new ResponseResult("服务器异常，请重试或刷新页面重新操作");
        }
        return responseResult;
    }
}

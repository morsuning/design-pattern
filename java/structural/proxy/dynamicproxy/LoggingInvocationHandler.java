package structural.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

// InvocationHandler: 这是动态代理的核心
public class LoggingInvocationHandler implements InvocationHandler {
    private final Object target;

    public LoggingInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("DynamicProxy: Before invoking " + method.getName());
        Object result = method.invoke(target, args);
        System.out.println("DynamicProxy: After invoking " + method.getName());
        return result;
    }
}

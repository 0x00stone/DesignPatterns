# 定义
+ 适配器模式（Adapter Pattern）
+ 将一个接口转换成另一个接口，使原本不兼容的接口能够一起工作。这种模式可以用来连接不同的系统、类或对象。

# 具体场景
+ package org.springframework.web.servlet.mvc;
+ 适配实现了Controller接口的处理器
```java
public class SimpleControllerHandlerAdapter implements HandlerAdapter {
    public SimpleControllerHandlerAdapter() {
    }

    public boolean supports(Object handler) {
        return handler instanceof Controller;
    }

    @Nullable
    public ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return ((Controller)handler).handleRequest(request, response);
    }

    public long getLastModified(HttpServletRequest request, Object handler) {
        if (handler instanceof LastModified lastModified) {
            return lastModified.getLastModified(request);
        } else {
            return -1L;
        }
    }
}
```
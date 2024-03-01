# 定义
+ 适配器模式（Adapter Pattern）
+ 将一个接口转换成另一个接口，使原本不兼容的接口能够一起工作。这种模式可以用来连接不同的系统、类或对象。

# 优点
+ 兼容性： 适配器模式可以使不兼容的接口兼容，从而使它们能够一起工作。
+ 灵活性： 适配器模式可以提高灵活性，因为你可以通过使用不同的适配器来连接不同的系统或类。
+ 可扩展性： 适配器模式可以提高可扩展性，因为你可以通过添加新的适配器来支持新的系统或类。

# 缺点
+ 复杂性： 适配器模式可能会增加代码的复杂性，尤其是当你有许多不同的适配器时。
+ 性能： 适配器模式可能会降低性能，因为你需要在每次调用适配器时都进行一次转换。

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
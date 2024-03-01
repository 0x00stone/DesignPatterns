# 定义
+ 责任链模式（Chain of Responsibility Pattern）是一种行为型设计模式，它允许你将请求沿着处理链传递，直到有一个对象能够处理该请求。责任链模式可以用来实现多种目的，例如：

# 优点
+ 灵活性： 责任链模式可以提供灵活性，因为你可以通过改变处理链的顺序来改变请求的处理方式。
+ 可扩展性： 责任链模式可以提高可扩展性，因为你可以通过添加新的处理者来扩展处理链。
+ 解耦： 责任链模式可以降低请求发送者和请求处理者之间的耦合度，使之更容易维护和扩展。

# 缺点
+ 潜在的性能损失： 责任链模式可能会导致潜在的性能损失，因为请求需要沿着处理链传递，直到找到合适的处理者。
+ 增加复杂性： 责任链模式可能会增加代码的复杂性，尤其是当处理链很复杂时。

# 使用场景
+ package org.springframework.web.servlet.config.annotation;
+ 用于注册和管理应用中的拦截器。
+ 在Spring中，拦截器可以拦截Web应用程序中的HTTP请求和响应，并在请求处理的某个阶段执行自定义逻辑，例如进行认证、授权、日志记录、事务处理等
```java
public class InterceptorRegistry {
    private final List<InterceptorRegistration> registrations = new ArrayList();
    private static final Comparator<Object> INTERCEPTOR_ORDER_COMPARATOR;

    public InterceptorRegistry() {
    }

    public InterceptorRegistration addInterceptor(HandlerInterceptor interceptor) {
        InterceptorRegistration registration = new InterceptorRegistration(interceptor);
        this.registrations.add(registration);
        return registration;
    }

    public InterceptorRegistration addWebRequestInterceptor(WebRequestInterceptor interceptor) {
        WebRequestHandlerInterceptorAdapter adapted = new WebRequestHandlerInterceptorAdapter(interceptor);
        InterceptorRegistration registration = new InterceptorRegistration(adapted);
        this.registrations.add(registration);
        return registration;
    }

    protected List<Object> getInterceptors() {
        return this.registrations.stream().sorted(INTERCEPTOR_ORDER_COMPARATOR).map(InterceptorRegistration::getInterceptor).toList();
    }

    static {
        INTERCEPTOR_ORDER_COMPARATOR = OrderComparator.INSTANCE.withSourceProvider((object) -> {
            if (object instanceof InterceptorRegistration interceptorRegistration) {
                Objects.requireNonNull(interceptorRegistration);
                return interceptorRegistration::getOrder;
            } else {
                return null;
            }
        });
    }
}

```
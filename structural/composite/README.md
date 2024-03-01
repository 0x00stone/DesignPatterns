# 定义
+ 组合模式（Composite Pattern）
+ 将对象组合成树形结构，并以一致的方式处理这些对象。这种模式可以使你的代码更易于维护和扩展。

# 优点
+ 层次结构： 组合模式可以将对象组织成层次结构，使你可以更轻松地管理和操作这些对象。
+ 灵活性： 组合模式可以提高灵活性，因为你可以通过组合不同的对象来创建新的对象。
+ 可扩展性： 组合模式可以提高可扩展性，因为你可以通过添加新的对象来扩展树形结构。

# 缺点
+ 复杂性： 组合模式可能会增加代码的复杂性，尤其是当你有许多不同的对象时。
+ 性能： 组合模式可能会降低性能，因为你需要在每次操作对象时都遍历整个树形结构。

# 使用情景
+ package org.springframework.context;
+ 上下文层级关系可以用来定义通用的配置（在父上下文中）和特定的配置（在子上下文中），可以视为一种富有层次的Composite结构
```java
public interface ApplicationContext extends EnvironmentCapable, ListableBeanFactory, HierarchicalBeanFactory, MessageSource, ApplicationEventPublisher, ResourcePatternResolver {
    @Nullable
    String getId();

    String getApplicationName();

    String getDisplayName();

    long getStartupDate();

    @Nullable
    ApplicationContext getParent();

    AutowireCapableBeanFactory getAutowireCapableBeanFactory() throws IllegalStateException;
}
```
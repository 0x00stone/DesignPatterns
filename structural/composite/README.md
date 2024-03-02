# 定义
+ 组合模式（Composite Pattern）
+ 将对象组合成树形结构，并以一致的方式处理这些对象。这种模式可以使你的代码更易于维护和扩展。

# 优点
+ 层次结构： 组合模式可以将对象组织成层次结构，使你可以更轻松地管理和操作这些对象。

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
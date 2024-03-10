# 定义
+ 单例模式（Singleton Pattern）保证一个类只有一个实例， 并提供一个访问该实例的全局节点
+ 使用场景：如数据库连接池、缓存等。

# 优点
+ 全局访问： 单例模式允许你从任何地方访问同一个实例。
+ 性能： 单例模式可以提高性能，因为你不需要在每次使用对象时都重新创建对象。
+ 内存消耗： 单例模式可以减少内存消耗，因为你只需要创建一个对象。

# 缺点
+ 灵活性： 单例模式可能会降低灵活性，因为你无法创建多个实例。
+ 可扩展性： 单例模式可能会降低可扩展性，因为你无法在不同的环境中使用不同的实例。
+ 该模式在多线程环境下需要进行特殊处理， 避免多个线程多次创建单例对象

# 举例
## 饿汉式
+ package org.springframework.session;
```java
public final class UuidSessionIdGenerator implements SessionIdGenerator {
    private static final UuidSessionIdGenerator INSTANCE = new UuidSessionIdGenerator();

    private UuidSessionIdGenerator() {
    }

    @NonNull
    public String generate() {
        return UUID.randomUUID().toString();
    }

    public static UuidSessionIdGenerator getInstance() {
        return INSTANCE;
    }
}
```
+ 典型
# 定义
+ 策略模式（Strategy Pattern）
+ 定义一系列算法，并分别将它们封装在一个个独立的类中，使之可以相互替换

# 优点
+ 封装算法： 策略模式可以将算法封装在一个个独立的类中，使之更容易维护和扩展。
+ 提高代码的可读性和可维护性： 策略模式可以提高代码的可读性和可维护性，因为你可以通过查看策略类来了解算法的实现细节。
+ 提高代码的可复用性： 策略模式可以提高代码的可复用性，因为你可以将策略类在不同的场景中重复使用。

# 缺点
+ 可扩展性： 策略模式的可扩展性可能有限，因为你可能需要为每个新的算法创建一个新的类。

# 实例
+ package org.springframework.session;
+ SessionIdGenerator sessionIdGenerator可以自定义实现sessionID

```java
public interface SessionIdGenerator {
    @NonNull
    String generate();
}
```

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
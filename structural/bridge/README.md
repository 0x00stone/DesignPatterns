# 定义
+ 桥接模式（Bridge Pattern）
+ 它将抽象部分与实现部分分离，使它们可以独立地变化。这种模式可以使你的代码更易于维护和扩展。
+ 桥接模式倾向构造而非继承。实现细节被从一个层推送到另一个对象的另一层

# 优点
+ 解耦： 桥接模式可以将抽象部分与实现部分解耦，使它们可以独立地变化。
+ 灵活性： 桥接模式可以提高灵活性，因为你可以通过使用不同的实现类来改变对象的 behavior。
+ 可扩展性： 桥接模式可以提高可扩展性，因为你可以通过添加新的实现类来支持新的功能。

# 缺点
+ 复杂性： 桥接模式可能会增加代码的复杂性，尤其是当你有许多不同的抽象类和实现类时。
+ 性能： 桥接模式可能会降低性能，因为你需要在每次调用实现类的方法时都进行一次间接调用。

# 实现情景
+ package org.springframework.transaction;
+ 适配了不同数据访问技术的事务管理（例如JDBC、Hibernate、JPA等）
```java
public interface PlatformTransactionManager extends TransactionManager {
    TransactionStatus getTransaction(@Nullable TransactionDefinition definition) throws TransactionException;

    void commit(TransactionStatus status) throws TransactionException;

    void rollback(TransactionStatus status) throws TransactionException;
}
```
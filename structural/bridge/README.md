# 定义
+ 桥接模式（Bridge Pattern）
+ 它将抽象部分与实现部分分离，使它们可以独立地变化。这种模式可以使你的代码更易于维护和扩展。
+ 桥接模式倾向构造而非继承。实现细节被从一个层推送到另一个对象的另一层

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
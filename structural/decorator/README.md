# 定义
+ 装饰器模式（Decorator Pattern）
+ 向一个现有对象添加新的功能，而无需改变其结构。这种模式可以使你的代码更易于维护和扩展。

# 使用情景
+ package org.springframework.jdbc.datasource;
+ DelegatingDataSource和它的子类TransactionAwareDataSourceProxy就被用来添加如事务感知功能而不改变现有数据源的代码。
```java
public class TransactionAwareDataSourceProxy extends DelegatingDataSource {
    private boolean reobtainTransactionalConnections = false;

    public TransactionAwareDataSourceProxy() {}

    public TransactionAwareDataSourceProxy(DataSource targetDataSource) {}

    public void setReobtainTransactionalConnections(boolean reobtainTransactionalConnections) {}

    public Connection getConnection() throws SQLException {}

    protected Connection getTransactionAwareConnectionProxy(DataSource targetDataSource) {}

    protected boolean shouldObtainFixedConnection(DataSource targetDataSource) {}

    private class TransactionAwareInvocationHandler implements InvocationHandler { }
}

```
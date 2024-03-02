# 定义
+ 命令模式（Command Pattern）
+ 将请求封装成对象，从而可以参数化其他对象、记录请求日志、撤销请求或支持可撤销的操作

# 优点
+ 可撤销性： 命令模式支持可撤销的操作，即你可以撤销之前执行过的命令。
+ 日志记录： 命令模式可以用来记录请求日志，以便你可以在以后分析请求的执行情况。

# 使用情景
+ package org.springframework.jdbc.core;
+ 每个PreparedStatementCreator封装了一个SQL语句和其参数，然后这个语句会在数据库上执行。
```java
@FunctionalInterface
public interface PreparedStatementCreator {
    PreparedStatement createPreparedStatement(Connection con) throws SQLException;
}
```
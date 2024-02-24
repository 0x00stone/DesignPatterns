# 定义
+ 外观模式（Facade Pattern）是一种结构型设计模式，它为一个复杂的子系统提供了一个统一的接口，从而使这个子系统更容易使用。外观模式可以将子系统中的一组接口组合成一个更简单、更易用的接口。

# 优点
+ 简化接口： 外观模式可以简化一个复杂子系统的接口，使之更容易使用。
+ 提高灵活性： 外观模式可以提高灵活性，因为你可以通过改变外观类来改变子系统中的行为，而无需改变客户端代码。
+ 降低耦合度： 外观模式可以降低子系统与客户端代码之间的耦合度，使之更容易维护和扩展。

# 缺点
+ 潜在的性能损失： 外观模式可能会导致潜在的性能损失，因为你需要在每次调用子系统的方法时都通过外观类进行转发。
+ 增加复杂性： 外观模式可能会增加代码的复杂性，尤其是当子系统很复杂时。
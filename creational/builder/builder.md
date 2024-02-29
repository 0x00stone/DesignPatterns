# 定义
+ 建造者模式（Builder Pattern）
+ 允许你使用相同的建造步骤创建不同的对象。这种模式允许你将对象的创建与它的表示分离，从而使你可以独立地改变对象的创建和表示。
+ 说人话：通常在构造函数参数过多时使用

# 范例
+ package org.springframework.web.reactive.function.client.WebClient;

```java
WebClient.create()
        .webClient.post()
        .uri("https://www.github.com")
        .header("Content-Type", "application/json")
        .body(BodyInserters.fromValue("hello"))
        .retrieve()
        .bodyToMono(String.class)
        .map(responseBody -> {
            return responseBody;
        });
```

  
# 优点
+ 可扩展性： 建造者模式可以很容易地扩展，以支持新的产品类型。只需创建一个新的具体建造者类，就可以创建新的产品类型。
+ 灵活性： 建造者模式允许你以不同的方式创建对象。你可以使用不同的建造者类来创建不同的对象，也可以使用同一个建造者类来创建不同的对象。
+ 可重用性： 建造者模式可以重用相同的建造步骤来创建不同的对象。这可以减少代码的重复，并使代码更易于维护。

# 缺点
+ 复杂性： 建造者模式可能会增加代码的复杂性，尤其是当你有许多不同的产品类型时。
+ 性能： 建造者模式可能会降低性能，因为你需要在每次创建对象时都调用建造者类的方法。
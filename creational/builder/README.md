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
+ 可重用性： 建造者模式可以重用相同的建造步骤来创建不同的对象。这可以减少代码的重复，并使代码更易于维护。

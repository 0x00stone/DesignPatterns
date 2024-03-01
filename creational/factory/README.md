# 工厂模式
+ 优点：
  + 抽象工厂模式可以使代码更易于维护和扩展。
  + 抽象工厂模式可以隐藏创建对象的细节，使代码更易于理解。
  + 抽象工厂模式可以使代码更易于扩展，因为每次添加一个新的产品族时，只需要修改相应的工厂类即可。
+ 缺点：
  + 抽象工厂模式可能会导致代码过于分散，难以管理。

# 区别
+ 使用场景：
  + 抽象工厂模式,当对象之间具有显著的互相依赖关系时使用;
  + 工厂方法模式,提前知道将要创建的对象的具体类型，但希望将对象的实例化推迟到子类进行时
+ 抽象工厂模式提供了一个创建一系列相关或依赖对象的接口，而工厂方法模式只提供了一个创建对象的接口。
+ 抽象工厂模式由子类来创建对象，而工厂方法模式由工厂类来创建对象。
+ 抽象工厂模式可以使代码更易于维护和扩展，而工厂方法模式可以使代码更易于理解和扩展。

# 范例
+ org.springframework.beans.factory.config.ListFactoryBean;
```java
public class ListFactoryBean extends AbstractFactoryBean<List<Object>> {

	@Nullable
	private List<?> sourceList;

	@SuppressWarnings("rawtypes")
	@Nullable
	private Class<? extends List> targetListClass;
    
	public void setSourceList(List<?> sourceList) {
		this.sourceList = sourceList;
	}

	@SuppressWarnings("rawtypes")
	public void setTargetListClass(@Nullable Class<? extends List> targetListClass) {
		if (targetListClass == null) {
			throw new IllegalArgumentException("'targetListClass' must not be null");
		}
		if (!List.class.isAssignableFrom(targetListClass)) {
			throw new IllegalArgumentException("'targetListClass' must implement [java.util.List]");
		}
		this.targetListClass = targetListClass;
	}


	@Override
	@SuppressWarnings("rawtypes")
	public Class<List> getObjectType() {
		return List.class;
	}

	@Override
	@SuppressWarnings("unchecked")
	protected List<Object> createInstance() {}

}

```
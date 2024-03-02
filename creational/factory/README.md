# 工厂模式
+ 优点：
  + 抽象工厂模式可以使代码更易于维护和扩展。
  + 抽象工厂模式可以隐藏创建对象的细节，使代码更易于理解。
+ 缺点：
  + 抽象工厂模式可能会导致代码过于分散，难以管理。

# 区别
+ 抽象工厂模式提供了一个创建一系列相关或依赖对象的接口，而工厂方法模式只提供了一个创建对象的接口。

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
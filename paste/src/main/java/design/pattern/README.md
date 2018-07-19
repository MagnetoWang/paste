## Java设计模式
- 参考链接
    - http://blog.anxpp.com/index.php/archives/489/
    - https://github.com/anxpp/JavaDesignPattern
    - https://blog.csdn.net/cselmu9/article/details/51366946
    - http://design-patterns.readthedocs.io/zh_CN/latest/creational_patterns/simple_factory.html
    - 
- 说明
    - 非常感谢上面链接的原创者的资料和代码。让我受益无穷
    - 非常感谢结城浩的《图解设计模式》


### 设计模式字典
- 模式图解：http://design-patterns.readthedocs.io/zh_CN/latest/creational_patterns/simple_factory.html
- 
### 模式分类

- 创建型
  - 创建型模式的变化虽然很多，但是本质就是抽象类和接口的灵活运用。
  - 用对场景才能发挥这些模式的力量。
  - 创建型模式涉及对象的实例化，特点是不让用户代码依赖于对象的创建或排列方式，避免用户直接使用new创建对象。 
  - **工厂方法模式** 
    - 定义一个用于创建对象的接口，让子类决定实例化哪一个类。工厂方法使一个类的实例化延迟到其子类。 
    - Define an interface for creating an object,but let subclasses decide which class to instantiate.Factory Method lets a class defer instantiation to subclassess. 
  - **抽象工厂方法模式**
    - 提供一个创建一系列或相互依赖对象的接口，而无须指定他们的具体的类。 
    -   Provide an interface for creating families of related or dependent objects without specifying their concrete classess. 
  - [**生成器模式**](https://github.com/Jia-Hong-Peng/Graphic-design-pattern/tree/master/src/Builder)
    -  将一个复杂对象的构建与它的表示分离，使同样的构建过程可以创建不同的表示 。
    -   Separate the construction of a complex object from its representation so that the same construction process can create different representations. 
  - [**原型模式**](https://quanke.gitbooks.io/design-pattern-java/%E5%8E%9F%E5%9E%8B%E6%A8%A1%E5%BC%8F-Prototype%20Pattern.html)
    -  用原型实例指定创建对象的种类，并且通过复制这些原型创建新的对象。 
    -  Specify the kinds of objects to create using a prototypical instance,and create new objects by copying this prototype. 
  - [**单例模式**](https://blog.csdn.net/cselmu9/article/details/51366946)
    -  保证一个类仅有一个实例，并提供一个访问它的全局访问点。 
    -   Ensure a class only has one instance,and provide a global point of access to it. 
- 行为型模式
  -  行为型模式涉及怎样合理的设计对象之间的交互通信，以及怎样合理为对象分配职责，让设计富有弹性，易维护，易复用。 
  -  **责任链模式**
  -  **命令模式**
  -  **解释器模式**
  -  **迭代器模式**
  -  **中介者模式**
  -  **备忘录模式**
  -  **观察者模式**
  -  **状态模式**
  -  **策略模式**
  -  **模板方法模式**
  -  **访问者模式** 
- 结构型模式
  - 结构型模式涉及如何组合类和对象以形成更大的结构，和类有关的结构型模式涉及如何合理使用继承机制；和对象有关的结构型模式涉及如何合理的使用对象组合机制。
  - **适配器模式**
  - **组合模式**
  - **代理模式**
  - **享元模式**
  - **外观模式**
  - **桥接模式**
  - **装饰模式**

### 模式说明

- **工厂方法模式** 和 **抽象工厂方法模式** 的关系。抽象工厂方法模式 **包含** 工厂模式
  - ​    简单工厂模式是由一个具体的类去创建其他类的实例，父类是相同的，父类是具体的。
  - ​    工厂方法模式是有一个抽象的父类定义公共接口，子类负责生成具体的对象，这样做的目的是将类的实例化操作延迟到子类中完成。
  - ​    抽象工厂模式提供一个创建一系列相关或相互依赖对象的接口，而无须指定他们具体的类。它针对的是有多个产品的等级结构。而工厂方法模式针对的是一个产品的等级结构。
- 单例模式 的 多线程解决方案 是  双重检查
- 生成器模式：builder接口或者抽象类,具体类（想要的格式）和一个中间负责人的类（提供内容并指定对应的类）
- 


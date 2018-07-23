## Java设计模式
- 参考链接
    - http://blog.anxpp.com/index.php/archives/489/
    - https://github.com/anxpp/JavaDesignPattern
    - https://blog.csdn.net/cselmu9/article/details/51366946
    - http://design-patterns.readthedocs.io/zh_CN/latest/creational_patterns/simple_factory.html
    - https://github.com/Jia-Hong-Peng/Graphic-design-pattern
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
  -  [**责任链模式**](https://github.com/Jia-Hong-Peng/Graphic-design-pattern/blob/master/src/ChainOfResponsibility)
     -   使很多个对象都有机会处理请求，从而避免请求的发送者和接收者之间的耦合关系。将这些对象连成一条链，并沿着这条链传递该请求，直到有一个对象处理它为止。 
  -  [**命令模式**](http://blog.anxpp.com/index.php/archives/489/)
     -  将一个请求封装为一个对象，从而使用户可用不同的请求对客户进行参数化；对请求排队或记录请求日志，以及支持可撤销的操作。 
     -  Encapsulate a request as an object,thereby letting you parameterize clients with different reauests,queue or log requests,and support undoable operations. 
  -  **解释器模式**
     -   给定一个语言，定义它的文法的一种表示，并定义一个解释器，这个解释器使用该表示来解释语言中的句子。 
     -  Given a language,define a representation for its grammar along with an interpreter that uses the representation to interpret sentences in the language. 
  -  **迭代器模式**
     -  提供一种方法顺序访问一个聚合对象中的各个元素，而由不需要暴露该对象的内部细节。 
  -  **中介者模式**
     -  用一个中介对象来封装一系列的对象交互。中介者使各对象不需要显示的相互引用，从而使其耦合松散，而且可以独立的改变他们之前的交互。 
  -  **备忘录模式**
     -  在不破坏封装性的前提下，捕获一个对象的内部状态，并在该对象之外保存该状态，这样就可以将该对象恢复到之前保存的状态。 
     -   Without violating encapsulation,captrue and externalize an object' orifianl state so that the object can be restored to this state later. 
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
- 责任链模式：好的责任链模式的具体处理者应该是不受顺序的影响。也就是低耦合，高度独立！
- 命令模式：定义一个接口，具体类分别实现里面的方法。同样需要一个管理者，来统筹这些命令
- 中介者模式：先定义一个中介者接口，然后用具体类实现里面的方法。大部分工作是在中介者一个类里面操作


## Java设计模式
- 参考链接
    - http://blog.anxpp.com/index.php/archives/489/
    - https://github.com/anxpp/JavaDesignPattern
    - https://blog.csdn.net/cselmu9/article/details/51366946
    - http://design-patterns.readthedocs.io/zh_CN/latest/creational_patterns/simple_factory.html
    - https://github.com/Jia-Hong-Peng/Graphic-design-pattern
- 说明
    - 非常感谢上面链接的原创者的资料和代码。让我受益无穷
    - 非常感谢结城浩的《图解设计模式》一书


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
     -  定义对象间的一种一对多的依赖关系，当一个对象状态发生改变时，所有依赖它的对象都得到通知并被自动更新。 
  -  **状态模式**
     -   允许一个对象在其内部状态改变时改变它的行为，对象看起来似乎修改了它的类。 
     -  Allow an object to alter its behavior when its internal state changes.The object will appear to change its class. 
  -  **策略模式**
     -   定义一系列算法，把他们一个个封装起来，并且使他们可相互替换。本模式使得算法可独立于其他客户端而变化。 
  -  **模板方法模式**
     -  定义一个操作中算法的骨架，而将一些步骤延迟到子类中。模板方法使子类可以不改变一个算法的结构即可重定义该算法的某些特定步骤。 
     -  Define the skeleton of an algorithm in an operation,deferring some steps to subclasses.Template Method lets subclasses redefine certain steps of an algorithm without changing the algorithm's structure. 
  -  **访问者模式** 
     -   表示一个作用于某对象结构中的各个元素的操作。它可以在不改变各个元素的类的前提下定义作用于这些元素的新操作。 
     -    Represent an opration to be performed on the elements of an object structure.Visitor lets you define a new operation without changing the classes of the elements on which it oprates. 
- 结构型模式
  - 结构型模式涉及如何组合类和对象以形成更大的结构，和类有关的结构型模式涉及如何合理使用继承机制；和对象有关的结构型模式涉及如何合理的使用对象组合机制。
  - **适配器模式**
    - 将一个类的接口转换成客户希望的另外一个接口。该模式使得原本由于接口不兼容而不能一起工作的那些类可以一起工作。 
  - **组合模式**
    -  将对象组合成树形结构以表示“部分-整体”的层次结构。Composite使用户对单个对象和组合对象的使用具有一致性。 
    -   Compose objects into tree structures to represent part-whole hierarchies.Composite lets clients treat individual objects and compositions of objects uniformly. 
  - **代理模式**
    - 为其它对象提供一种代理以控制对这个对象的访问。 
    - Provide a surrogate or placeholder for another object to control access to it. 
  - **享元模式**
    -  运用共享技术有效地支持大量细粒度的对象。 
    -   Use sharing to support large numbers of fine-grained objects efficiently. 
  - **外观模式**
    - 为系统中的一组接口提供一个一致的界面，Facade模式定义了一个高层接口，这个接口使得这一子系统更加容易使用。
  - **桥接模式**
    - 将抽象部分与它的实现部分分离，使它们都可以独立的变化。 
    - Decouple an abstraction from its implementation so that the two can vary independently. 
  - **装饰模式**
    - 动态的给对象添加额外的职责。就功能来说，装饰模式比生产子类更为灵活。 

### 模式说明

- **工厂方法模式** 和 **抽象工厂方法模式** 的关系。抽象工厂方法模式 **包含** 工厂模式
  - ​    简单工厂模式是由一个具体的类去创建其他类的实例，父类是相同的，父类是具体的。
  - ​    工厂方法模式是有一个抽象的父类定义公共接口，子类负责生成具体的对象，这样做的目的是将类的实例化操作延迟到子类中完成。
  - ​    抽象工厂模式提供一个创建一系列相关或相互依赖对象的接口，而无须指定他们具体的类。它针对的是有多个产品的等级结构。而工厂方法模式针对的是一个产品的等级结构。
- 生成器模式
  - 定义一个抽象类，后面要实现里面的方法
  - 定义一个指挥的类，用来操作继承了抽象类的子类
- 原型模式
  - 定义一个接口，和一个管理的类
  - 接口是后面要实现的具体内容
  - 管理的类，用来操作这些内容
  - 相当于把生成实例和管理两个操作分割开
  - **和生成器模式很类似，区别在于一个是接口，一个是抽象类**
- 单例模式 的 多线程解决方案 是  双重检查
- 生成器模式：builder接口或者抽象类,具体类（想要的格式）和一个中间负责人的类（提供内容并指定对应的类）
- 责任链模式：好的责任链模式的具体处理者应该是不受顺序的影响。也就是低耦合，高度独立！
- 命令模式：定义一个接口，具体类分别实现里面的方法。同样需要一个管理者，来统筹这些命令
- 中介者模式：先定义一个中介者接口，然后用具体类实现里面的方法。大部分工作是在中介者一个类里面操作
- 备忘录模式：没有抽象和接口类。只是把对象和状态分离开。用一个状态类专门记录对象的部分需要的数据。
- 观察者模式：定义一个接口负责观察，一个抽象类负责统筹具体类的操作。核心是通过不同的类实例，因为都有操作对象的引用。因此才能达到通知的效果。只是传递引用，然后修改里面的内容就行了。
- 状态模式
  - 两个接口，一个负责处理如何操作内容，一个负责状态的改变
  - 状态的接口可以被许多不同状态实现具体方法
  - 内容由对应处理的类具体实现
- 策略模式
  - 定义接口就行了。然后具体类实现里面的方法。需要哪个策略用哪个类
- 模板模式
  - 定义一个抽象类，然后再具体实现里面的方法。和策略模式特别像，不过一个是接口，一个是抽象类
- 访问者模式
  - 一个接口，可以包括访问内容的实体
  - 一个抽象类，作为访问者。后面需要具体实现
  - 还要一个抽象类需要再封装接口。最后再用具体的类实现对应方法
- 适配器模式
  - 在已经非常稳定的类基础上再次封装
- 组合模式
  - 与访问模式基本一样。
  - 但是没有访问类。而是纯粹的类与类之间组合
- 代理模式
  - 定义一个接口
  - 用两个类实现接口里面的方法。其中一个类总是调用另一类。相当于代理这个真正实现的类 
- 享元模式
  - 三个类
  - 一个是最小元素的实体类
  - 一个是生成这个实体类的工厂类。最好是单例模式
  - 最后一个是管理上面两个类，并和外面使用这类资源进行调度。达到资源利用率最大化
- 外观模式
  - 就是封装接口的意思。让接口变得更加好用
- 桥接模式
  - 定义一个抽象类，负责统筹后面需要分别具体实现的类
  - 在定义一个类，负责调用上面具体类实现的方法。这个类以后就是对外接触的类。相当于封闭具体实现的类
  - 这样的结构模式，显然，我们在扩展抽象类的时候，不会影响到调用具体实现类的类
  - 当然，具体实现的类仍然会被影响。但是，之前的代码不会受影响
- 装饰模式
  - 定义一个抽象类，作为基础类
  - 再定义一个抽象类继承上面的类，同时扩展部分功能
  - 实现第一个抽象类的具体类，负责管理数据
  - 实现第二个抽象类的具体类，负责装饰数据，不能修改数据！


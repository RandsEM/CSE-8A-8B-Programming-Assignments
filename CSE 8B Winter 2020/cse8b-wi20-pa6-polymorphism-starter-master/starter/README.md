1. Polymorphism is the concept where a class can take on many forms when its subclass "inherits" from it. What this means
is that if I had a parent class Person, a class called GradStudent and a class called HighSchool Student can inherit all the 
functionalities including field variables and methods from the class Person. So if the class person had the method "eat", this means
that an object created from the GradStudent and HighSchoolStudent class can use that method as well if it inherits from the Person class. 
This concept allows us to not have to write out every single method again if multiple classes share the same functionality. However, 
inheriting is a one way street. A parent class does not have access to the functionalities of its subclasses. To use an analogy, this is 
because all bicycles are vehicles but not all vehicles are bicycles. 

2. We can do this because the IntegerValue and BooleanValue class inherits from the class Value. This means that they can take on the type of the
Value class. 

3. Because BooleanExpression and ArithmeticExpression is an abstract class. It is up to the classes that are concrete that inherits these two classes 
to implement them.

4. The difference is that a class can implement multiple interfaces but cannot extend multiple classes. When implementing an interface, the class is just 
going to implement the methods in the interface for it. So if the interface shape has the method area(), the classes that implmeent this interface must implement 
the method area() according to it's own definition of what the area is. However, when extending classes, the method that is written in the parent class is automatically
given to the class that extends it. We should be using extend when the conrete class is in the same tree as the parent or else we should use implements.

5. The reason java supports multiple inheritance of interfaces but not multiple inheritance of implementation is because there could be name conflicts. When suppoer classes
contain methods with the same name, they cannot determine which member or method to access. If java supported multiple extendings, then ambiuity can arise. 
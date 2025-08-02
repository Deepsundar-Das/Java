class A {

    void showMessage() {
        System.out.println("Hello we are class A");
    }
}

abstract class B {

    abstract void sayHello();

    void greet() {
        System.out.println("hello, namaskar");
    }
}

class Anonymous {

    public static void main(String[] arr) {
        // we want to create another behaviour of class A without overriding(without extending to other class)
        // we know it will not be used on other classes frequently, it will be used only on this class
        // that is why we have anonymous class

        A obj = new A() {
            void showMessage() {
                System.out.println("we are in anonymous class");
            }
        };

        obj.showMessage();

        // For class B

        // here we are creating a object of anonymous class not of class B
        // we are just overriding the methods
        // and also getting a reference variable of B
        // it works because we have provided the implementation of abstract method and this anonymous class extends the class B
        B obj1 = new B() {
            void sayHello() {
                System.out.println(
                    "Hello I am in class B, but I am abstract, it works because I am in anonymous class"
                );
            }
        };

        obj1.sayHello();
        obj1.greet();
    }
}

// to reduce the headache of writting anonymous class which have only one abstract method which is
// functional interface(SAM) java has given us lambda

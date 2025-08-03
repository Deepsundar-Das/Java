// there are a multiple way to make threads
// method 1:
// to make a thread we can extend the thread class,
// but also we have to implement the run method of runnable method to run the
// thread otherwise the thread will not run because thread implements the Runnable interface

class A extends Thread{
    public void run(){
        for(int i = 0;  i < 100; i++){
            System.out.println("bud");
        }
    }
}

class B extends Thread{
    public void run(){
        for(int i = 0; i < 100; i++){
            System.out.println("Dipan");
        }
    }
}

// method : 2
//

//class C implements Runnable{
//    public void run(){
//        for(int i = 0;  i < 100; i++){
//            System.out.println("bud");
//        }
//    }
//}
//
//class D implements Runnable{
//    public void run(){
//        for(int i = 0; i < 100; i++){
//            System.out.println("Dipan");
//        }
//    }
//}


class Counter{
    int count = 0;
    public synchronized void increase(){
        count++;
    }
}

public class ThreadTest {
    public static void main(String[] args) throws Exception {
//        A a = new A();
//        B b = new B();
        // this start method indirectly calls the run method of the runnable class
        // which is implemented in the class which have extends the Thread or Runnable class
//        a.start();
//        b.start();

//        Runnable c = new C();
//        Runnable d = new D();
        // we can create a runnable object using lambda expression as runnable is a functional interface

        Counter count = new Counter();

        Runnable c = () -> {
            for (int i = 0; i < 1000; i++) {
                count.increase();
            }
        };

        Runnable d = () -> {
            for (int i = 0; i < 1000; i++) {
                count.increase();
            }
        };

        Thread t1 = new Thread(c);
        Thread t2 = new Thread(d);


//        System.out.println("priority of the t1 is : "+t1.getPriority());
//
//        System.out.println("priority of the t2 is : "+t2.getPriority());

        t1.start();
        t2.start();

        // join is very important because it says the main method to wait until t1 and t2 finishes its execution
        t1.join();
        t2.join();

        // if we do not synchronize the count it will give any type of value chances are more
        // that we will not get the expected value
        System.out.println(count.count);
    }

}

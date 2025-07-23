import java.util.*;
// in java lambda can be used only for a functional interface(which has only one abstract method)
class Lambda {
    public static void main(String[] ar) {

      ArrayList<Integer> arr = new ArrayList<>();
      for(int i = 0; i < 10; i++){
        arr.add(i + 1);
      }
       //forEach takes an lambda function and executes it
      //forEach method is not a functioal interface but the parameter it takes is the functioal interface
      arr.forEach(item -> System.out.println(item*2));   

      // Create the lambda expression for the Operation Interface
      Operation add = (a, b) -> a+b;
      
      // I think add is like a anonymous class
      // implemantaion is provided by variable 

      Lambda calculator = new Lambda();

      System.out.println(calculator.calculate(10, 20, add));
    }


    private int calculate(int a, int b, Operation op){
        return op.operation(a, b);
      }
}
   
    // this is a functional interface or SAM(single abstract method) Interface
    interface Operation{
      public abstract int operation(int a, int b);
    }

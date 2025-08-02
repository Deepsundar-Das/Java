/*
    types of errors -> 
    1. compile time error (eg : syntax error)
    2. runtime error --> this is called Exceptions
    3. logical error
*/

/*
 * there is a small difference between error and Exception we can handle exceptions but cannot handle errors.
 * like any logical error, runtime errors these can be handled by us these are called exceptions but machine failure or memory full these cannot be handled by us these are errors
 */

class Exception {
  public static void main(String[] ar) {
     int i = 4;
     int j = 0;
     int k = 20;
  
    try{
      // if jvm see an exception it will come out of try block
      // i /= j;

      // but for some reason we want to throw some exceptions based on condition 
      // that time we can use throw

      k %= i;
      if(k == 0){
        throw new ArithmeticException("result cannot be zero");
      }
    }catch(ArithmeticException e){
      // System.out.println("it is impossible " + e);
      
      // it will only show the message 
      System.out.println("it is impossible " + e.getMessage());
    }
  }
 }


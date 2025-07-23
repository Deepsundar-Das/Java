class FunWithPredicate{
  public static void main(String[] args){
    // Let say I want to check a phone number in for some reason
    // so I need to check if the phone number is not null and it is 10 digit
    // long (assume that only 10 digits are the input as a string)

    MyPredicate<String> notNull = s -> (s != null);
    MyPredicate<String> lessThan10 = s -> (s.length() == 10);

    // check if both are true 
     // MyPredicate<String> phNo = notNull.and(lessThan10);
    // above line will work without problem
    MyPredicate<String> phNo = notNull.and(null);
    // above line will give nullPointerException only when we will try to take some operation
    // based on the MyPredicate<String> variable like if we try to print the result it will give error otherwise not

   // System.out.println("test with null => " + phNo.test("1234567890"));



  }
}

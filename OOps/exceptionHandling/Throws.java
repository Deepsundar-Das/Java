// throws is if like deligetor it deligates responsibilities to that class who call it 
// it is generally good if a class has many methods which throw same exception(though try catch block is required/ otherwise jvm will handle it, which at the end print the stacktrace and stop the program)

class A{
  public void loadClass() throws ClassNotFoundException{
    Class.forName("java.util.Arraylist");
  }
}



class Throws {
  public static void main(String[] args) throws ClassNotFoundException {
    A a = new A();
    try{
      a.loadClass();
      System.out.println("class is loaded successfuly");
    }catch(ClassNotFoundException exception){
      System.out.println("class not found");
      exception.printStackTrace();
    }
    System.out.println("I am outside of the try-catch block");
  }
}


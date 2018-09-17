package demo;

public class ExceptionHandlingDemo {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    try {
      demo();
    } catch (Exception e) { // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public static void demo() throws Exception {
	  throw new ArithmeticException("not valid operation");
   // int i = 1 / 0;

    //	  try {
    //		  System.out.println("Hello world!");
    //
    //		  int i = 1/0;
    //		  System.out.println("Completed");
    //	  }catch(Exception e) {
    //		  System.out.println("I am inside catch block" );
    //		  System.out.println("Message i : "+e.getMessage() );
    //		  System.out.println( "Cause is: "+e.getCause());
    //		  e.printStackTrace();
    //	  }
    //	  finally {
    //		  System.out.println("I am inside finally block." );
    //	  }

  }
}

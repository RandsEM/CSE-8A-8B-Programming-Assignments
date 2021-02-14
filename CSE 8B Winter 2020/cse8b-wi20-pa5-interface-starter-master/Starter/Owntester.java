public class Owntester{

  private static void testList (FifoList ownList){
    ownList.peek();
    
  }

  public static void main(String[] args){
    FifoList tester = new FifoList(1);
    tester.add(1);
    testList(tester);
    
  }
}
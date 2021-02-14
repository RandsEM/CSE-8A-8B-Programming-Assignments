import java.util.*;

public class Main{


  public static void main(String[] args) {
    
    double sum =0; 
    double abs = 0;
    System.out.println(Math.sin(Math.PI/3));
    Scanner scan = new Scanner(System.in);
    System.out.println("input number");
    int j = scan.nextInt();

    for(int i = 1; i <= j; i++){
      sum += (Math.cos(i))/(Math.pow(3,i));
      abs +=  absolute((Math.cos(i))/(Math.pow(3,i)));
    }

    System.out.println(sum);
    System.out.println(abs);

  }

  public static double absolute(double dub){
    return Math.abs(dub);
  }
}
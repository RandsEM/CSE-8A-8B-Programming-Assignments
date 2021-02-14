
import java.util.Scanner;

public class Slideshow{

  public Sound[] sounds;
  public Image[] pictures;


  public Slideshow(){

    this.sounds = new Sound[0];
    this.pictures = new Image[0];

  }

  public void addSlide(Image newImg, Sound newSound){
    int currentsoundsize = (this.sounds).length;
    int currentimagesize = (this.pictures).length;

    Sound[] previousSound = this.sounds;
    Image[] previousImage = this.pictures;

    this.sounds = new Sound[currentsoundsize + 1];
    this.pictures = new Image[currentimagesize + 1];
    for(int i = 0; i < previousSound.length; i++){
      this.sounds[i] = previousSound[i];
    }
    for(int j = 0; j < previousSound.length; j++){
      this.pictures[j] = previousImage[j];
    }
    this.sounds[currentsoundsize] = newSound;
    this.pictures[currentimagesize] = newImg;
  }

  /* public void play(){

    for(int i = 0; i < (this.sounds).length; i++){
      (this.pictures[i]).show();
      (this.sounds[i]).blockingPlay();
    }
  }



  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);

    Slideshow slideshow = new Slideshow();
    //first slide
    Image cat = new Image("res/cat.jpg");
    Sound broom = new Sound("res/broomsweep.wav");

    slideshow.addSlide(cat, broom);

    Image dog = new Image("res/dog.jpg");
    Sound funk = new Sound("res/UpbeatFunk.wav");

    slideshow.addSlide(dog, funk);

    Image crane = new Image("res/crane.jpg");
    Sound owl = new Sound("res/owl.wav");

    slideshow.addSlide(crane, owl);

    slideshow.play();


    System.out.println("Would you like to play the slide show again?");
    String answer = scan.nextLine();

    if(answer.equals("yes")){
      slideshow.play();
    }else{
      System.exit(0);

    }



  }

  */



}

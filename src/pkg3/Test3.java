package pkg3;
import pkg1.Fish;
import static pkg1.Fish.*;
public class Test3 {
    public static void main(String args[]){
        Fish f = Fish.STAR;
        System.out.println(f);
        System.out.println(GOLD);
    }
}
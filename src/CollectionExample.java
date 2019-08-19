import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionExample{
    public static void main(String args[]){
        List<Integer> all = new ArrayList<Integer>();
        all.add(1);
        all.add(2);
        all.add(3);
        all.add(4);
        all.add(5);
        all.add(6);
        all.add(7);
        all.add(8);
        all.add(9);
        all.add(10);


        List<Integer> sub = new ArrayList<Integer>();

        sub.add(1);
        sub.add(2);
        all.retainAll(sub);

        System.out.println(all);
        System.out.println(sub);


    }
}

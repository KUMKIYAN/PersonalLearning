import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SecondHighest {

    public static void main(String[] args){
        Integer[] arr = {10,50,20,30,40};
        System.out.println(Stream.of(arr).sorted().limit(arr.length - 1).max(Integer::compareTo).get());
    }
}

import org.openqa.selenium.json.JsonOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

class K{
    public static void main(String[] args) {
        Predicate<Integer> f = K::isEven;
        BiFunction<Integer,Integer, Integer> ff = K::sum;
        System.out.println(hello(f,ff));
    }

    private static boolean hello(Predicate<Integer> f, BiFunction<Integer,Integer,Integer> biFunction) {
        return false;
    }


    public static boolean isEven(Integer i){
        if(i%2 == 0)
            return true;
        else
            return false;
    }

    public static Integer sum(Integer i, int k){
       return i+k;
    }
}

class checkReturn{
    public static void main(String args[]){
        System.out.println( new checkReturn().check());
    }
    public boolean check(){
        try {
            System.out.println("hi");
            return true;
        }finally {
            System.out.println("Hi I am done");
        }
    }
}
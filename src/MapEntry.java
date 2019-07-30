import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapEntry {
    public static void main(String args[]){
        HashMap<Integer,String> user = new HashMap<Integer, String>();
        user.put(101,"kiyandoor");
        user.put(102,"kumar");
        user.put(103,"Rajesh");

        //Java 8
        Set<Map.Entry<Integer,String>> users = user.entrySet();
        users.stream().forEach( e -> System.out.println(e.getKey() + "---->" + e.getValue()));

        //previous to Java8
        Iterator itr = users.iterator();
        while (itr.hasNext()) {
            Map.Entry m = (Map.Entry) itr.next();
            System.out.println(m.getKey() +"-"+ m.getValue());
        }
    }
}

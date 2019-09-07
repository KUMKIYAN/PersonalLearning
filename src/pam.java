import org.openqa.selenium.Proxy;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class pam {

    public static void main(String args[]) {

        try {
            FileInputStream fis = new FileInputStream("/sample.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}


class pam2{
    public static void main(String args[]){


        try{
          //  System.out.println("A");
            throw new RuntimeException();
           // System.out.println("AA");
        }catch (RuntimeException ex){
            System.out.println("B");
            throw ex;
        } catch (Exception e){
            System.out.println("C");
        } finally {
            System.out.println("D");
        }
    }
}


class Student1{

    String firstName;
    String lastName;
    Integer rollNumber;

    public Student1() {
    }

    public Student1(Integer rollNumber, String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.rollNumber = rollNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(Integer rollNumber) {
        this.rollNumber = rollNumber;
    }

    @Override
    public String toString() {
        return "Student1{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", rollNumber=" + rollNumber +
                '}';
    }

    public static void main(String args[]){
        Student1 m1 = new Student1(1,"kiyan","kumar");
        Student1 m2 = new Student1(2,"Akhil","lumar");
        Set<Student1> s1  = new HashSet<Student1>();
        s1.add(m1);
        s1.add(m2);

        Comparator<Student1> comparator = Comparator.comparing(Student1::getRollNumber);
        System.out.println(s1.stream().sorted(comparator.reversed()).collect(Collectors.toList()));


        Comparator<Student1> compartor1 = Comparator.comparing(Student1::getLastName);
        System.out.println(s1.stream().sorted(compartor1).collect(Collectors.toList()));

        try (Stream<String> stream = Files.lines(Paths.get("src/sample.txt")))
        {
            System.out.println(
                    stream .filter(line -> line.startsWith("india"))
                            .map(a -> a.replaceAll("\\D",""))
                            .mapToInt(Integer::parseInt).average());
                    }
        catch (IOException e)
        { e.printStackTrace() ; }




    }
}


class MapExample{

    public static void main(String args[]){
    Map<Integer, String> myMap = new HashMap<Integer, String>();

    myMap.put(1,"Kumar");
    myMap.put(5,"Sasi");
    myMap.put(6,"Arjun");
    myMap.put(7,"Lakshmi");
    myMap.put(8,"Lakshmi");
    myMap.put(13,"Manoj");
    myMap.put(9,"Chaithu");
    myMap.put(10,"Vanaja");
    myMap.put(11,"Arjun");
    myMap.put(12,"Rushi");
    myMap.put(2,"Sudha");
    myMap.put(3,"Ravi");
    myMap.put(4,"Rajesh");
    myMap.put(14,"Kumar");
    myMap.put(15,"Sasi");
    myMap.put(16,"Arjun");
    myMap.put(17,"Lakshmi");
    myMap.put(18,"Lakshmi");
    myMap.put(139,"Manoj");
    myMap.put(9,"Chaithu");
    myMap.put(10,"Vanaja");
    myMap.put(11,"Arjun");
    myMap.put(12,"Rushi");
    myMap.put(2,"Sudha");
    myMap.put(3,"Ravi");
    myMap.put(4,"Rajesh");

        System.out.println(myMap);

        Comparator<String> comp1 = String::compareTo;

        System.out.println(myMap.values().stream().sorted(comp1).collect(Collectors.toList()));
        System.out.println(myMap.values().stream().sorted(comp1.reversed()).collect(Collectors.toList()));


        Map<Integer,String> descendingOrderMap = new LinkedHashMap<Integer, String>();

        myMap.entrySet().stream()
                .sorted((k1, k2) -> -k1.getValue().compareTo(k2.getValue()))
                .forEach(k -> descendingOrderMap.put(k.getKey(),k.getValue()));

        myMap.entrySet().stream().sorted((k1,k2) -> -k1.getValue().compareTo(k2.getValue()))
                .forEach(s -> System.out.println(s.getKey() + ":" + s.getValue()));

        System.out.println(descendingOrderMap);


        String myProxy = "localhost:7777";  //example: proxy host=localhost port=7777
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PROXY, new Proxy().setHttpProxy(myProxy));
      //  WebDriver webDriver = new FirefoxDriver(capabilities);
    }

        }







//how will you initiate in @smoke test cases

//invisibility of test case

//15 combinations

//based on first name - done

//avg indian city temparature - done

//what is the advantage of BDD

// When you will not go for BDD

// maven should be learnt completely

// jenkins


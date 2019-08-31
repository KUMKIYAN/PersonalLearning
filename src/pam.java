import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static net.sourceforge.htmlunit.corejs.javascript.TopLevel.Builtins.Function;

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





//how will you initiate in @smoke test cases

//invisibility of test case

//15 combinations

//based on first name - done

//avg indian city temparature

//what is the advantage of BDD

// When you will not go for BDD

// maven should be learnt completely


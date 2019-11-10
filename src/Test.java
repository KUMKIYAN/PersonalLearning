import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;
import java.util.SortedSet;
import java.util.HashMap;
import java.util.Set;
import java.util.Collection;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.SortedMap;
import java.util.Properties;
import java.io.FileInputStream;

class  Test
{
    //instance variables
    int a = 10;
    int b = 20;
    //static method
    public static void main(String[] args)
    {//static area
        Test t = new Test();
        // we can call instance variable in the static area only with the help of object. this applicable for all the below three lines
        System.out.println(t.a);
        System.out.println(t.b);
        t.m1();
    }
    //instance method
    public void m1(){
        //instance area
        System.out.println(a);
        System.out.println(b);
    }
}



//3 ways to access static variables

class AssignmentOne
{
    static int a =100;
    static int b = 200;
    public static void main(String[] args)
    {

        //ways to access static varibales
        System.out.println(AssignmentOne.a); // one way
        System.out.println(a); // 2nd way
        AssignmentOne o = new AssignmentOne();
        System.out.println(a); // 3rd way
    }

}



//Variables vs Default value

class DefaultValuesDemo
{
    // JVM assing default values to instance variables
    int a;
    double b;
    public static void main(String[] args)
    {
        DefaultValuesDemo d= new DefaultValuesDemo();
        System.out.println(d.a);
        System.out.println(d.b);
    }
}

/*D:\CoreJava\Programs>javac Test.java

D:\CoreJava\Programs>java DefaultValuesDemo
0
0
*/

class DefaultValuesDemoTwo
{
    // JVM assing default values to static variables
    static double a;
    static boolean b;
    public static void main(String[] args)
    {
        System.out.println(DefaultValuesDemoTwo.a);
        System.out.println(DefaultValuesDemoTwo.b);
    }

}

/*
D:\CoreJava\Programs>javac Test.java

D:\CoreJava\Programs>java DefaultValuesDemoTwo
0.0
false*/


class DefaultValuesDemoThree
{
    //JVM will not assign default values to local varibles
    public static void main(String[] args)
    {
        int a;
        float b;
        //System.out.println(a); // before using local variables we must initialize them. otherwise we get following error
        //System.out.println(b); // uncomment the sout lines to see below compiler errors
    }
}


/*D:\CoreJava\Programs>javac Test.java
Test.java:94: error: variable a might not have been initialized
                System.out.println(a);
                                   ^
Test.java:95: error: variable b might not have been initialized
                System.out.println(b);
                                   ^
2 errors*/

class AssignmentTwo
{
    int a = 10;
    double b= 10.5;
    static short c = 25;
    static boolean d = true;
    void m1()
    {
        System.out.println(a);
        System.out.println(b);
        System.out.println(AssignmentTwo.c);
        System.out.println(AssignmentTwo.d);
    }

    static void m2()
    {
        AssignmentTwo a1 = new AssignmentTwo();  // object destyoy when m2 ends.
        System.out.println(a1.a); // non staic varibales can n't be used in static methods directly. create objec and use them
        System.out.println(a1.b);
        System.out.println(AssignmentTwo.c);
        System.out.println(AssignmentTwo.d);
    }

    public static void main(String args[])
    {
        AssignmentTwo a = new AssignmentTwo();
        a.m1();
        AssignmentTwo.m2();
    }

}


class StaticInstanceVariableDemo
{
    int i = 50;
    static int b = 100;
    public static void main(String[] args)
    {
        StaticInstanceVariableDemo s = new StaticInstanceVariableDemo();
        System.out.println(s.i);
        System.out.println(s.b);

        s.i = 51;
        s.b = 101;

        StaticInstanceVariableDemo s1 = new StaticInstanceVariableDemo();
        System.out.println(s1.i);
        System.out.println(s1.b);

        s1.i = 61;
        s1.b = 121;


        StaticInstanceVariableDemo s2 = new StaticInstanceVariableDemo();
        System.out.println(s2.i);
        System.out.println(s2.b);
    }
}


class MethodExampleOne
{
    void m1(){   // instance method
        System.out.println("m1 method");
    }

    static void m2(){ //static method
        System.out.println("m2 method");
    }

    public static void main (String[] args){
        MethodExampleOne e = new MethodExampleOne();
        e.m1();  // instance method called using object
        MethodExampleOne.m2(); // static method called using Class

    }
}

class MethodExampleTwo // methods expecting parameters
{
    void m1(int a, char ch)
    {
        System.out.println("m1 method");
        System.out.println(a);
        System.out.println(ch);
    }

    static void m2(String s, double d)
    {
        System.out.println("m2 method");
        System.out.println(s);
        System.out.println(d);
    }

    public static void main (String[] args){
        MethodExampleTwo e = new MethodExampleTwo();
        e.m1(5, 'K');  // instance method called using object
        MethodExampleTwo.m2("KCK", 10.5); // static method called using Class

    }

}


class X{}
class Y{}
class Student{}
class Employee{}
class MethodExampleThree
{
    void m1(X x, Student s){
        System.out.println("m1 method");
    }

    static void m2(Y y, Employee e){
        System.out.println("m2 method");
    }

    public static void main(String[] args){
        MethodExampleThree t = new MethodExampleThree();
        X x = new X();
        Student s = new Student();
        t.m1(x, s);

        Y y1 = new Y();  // object names are not important only object type are important
        Employee e1 = new Employee();
        MethodExampleThree.m2(y1, e1);
        //The above three lines can be replaced with
        //MethodExampleThree.m2(new Y(), new Student());
    }
}


class MethodExampleFour
{
    void m1()
    {
        System.out.println("m1 method");
    }

    //void m1()
    void mOne()
    {
        System.out.println("m1 method");
    }

		/*D:\CoreJava\Programs>javac Test.java
Test.java:251: error: method m1() is already defined in class MethodExampleFour
        void m1()
             ^*/

    public static void main(String[] args)
    {
        MethodExampleFour f = new MethodExampleFour();
        f.m1();

    }
}

class MethodExampleFive
{
	/*
	D:\CoreJava\Programs>javac Test.java
	Test.java:272: error: invalid method declaration; return type required
	m1()
	^ */

    void m1() // remove void here to see the above error, return type is mandatory.
    {
        System.out.println("m1 method");

    }

    public static void main(String[] args)
    {
        MethodExampleFive f = new MethodExampleFive();
        f.m1();
    }
}

class MethodExampleSix
{
    void m1()
    {
        System.out.println("m1 method");

	/*	void m2()
		{
			System.out.println("m2 method");
		}*/
    }

// uncomment the above inner method to see the below error. Java does not suport the innerMethod concept.

/*		D:\CoreJava\Programs>javac Test.java
		Test.java:296: error: illegal start of expression
						void m2()
						^
		Test.java:296: error: ';' expected
						void m2()
							   ^
		2 errors */

    public static void main(String args[])
    {
        MethodExampleSix s = new MethodExampleSix();
        s.m1();
    }
}


class MethodExampleSeven
{
    void m1()
    {
        m2();
        System.out.println("m1 method");
        m2();
    }

    void m2()
    {
        m3();
        System.out.println("m2 method");
    }

    void m3()
    {
        System.out.println("m3 method");
    }


    public static void main(String[] args)
    {

        MethodExampleSeven s = new MethodExampleSeven();
        s.m1();
    }

}


class MethodExampleEight
{
    int a = 100;
    int b = 200;
    void add(int a , int b)
    {
        System.out.println(a+b);
        System.out.println(this.a+this.b); // try this without this keyword. it will be represented as local variables
    }
    public static void main(String[] args)
    {
        MethodExampleEight e = new MethodExampleEight();
        e.add(1000,2000);
    }
}

class MethodExampleNine
{
    int a = 100;
    int b = 200;
    //static void add(int a , int b)
    void add(int a , int b)  // add static and try to see the below error.
    {
        System.out.println(this.a+this.b); // inside static area this keyword not allowed

		/*	D:\CoreJava\Programs>javac Test.java
			Test.java:375: error: non-static variable this cannot be referenced from a stati
			c context
							System.out.println(this.a+this.b); // inside static area this ke
			yword not allowed */
    }
    public static void main(String[] args)
    {
        MethodExampleNine e = new MethodExampleNine();
        e.add(1000,2000);
    }
}


class MethodExampleTen
{
    public static void main(String[] args)
    {
        System.out.println("A" + 'B');
        System.out.println(10 + 20);
        System.out.println(10 + 20 + "Durga" + "kck" + 30);
        int a = 10;
        int b = 20;
        int c = 30;
        // do not print Sout for each variable as student level.
        // try to print all in the single line as shown below.
        System.out.println(a+"-----"+ b + "------" + c);

    }
}


class MethodReturnTypeExampleOne
{
    int m1()
    {
        System.out.println("m1 method");
        return 10;
    }

    float m2()
    {
        System.out.println("m2 method");
        return 10.5f;
    }

    static char m3()
    {
        System.out.println("m3 method");
        return 'K';
    }



    public static void main(String[] args)
    {
        MethodReturnTypeExampleOne a = new MethodReturnTypeExampleOne();
        int k = a.m1();
        System.out.println("return value of m1() :" + k);
        float f = a.m2();
        System.out.println("return value of m2() :" + f);
        char c = MethodReturnTypeExampleOne.m3();
        System.out.println("return value of m3() " + c);


    }
}


class XYZ{}
class Stud{}
class Empoyee{}
class MethodReturnTypeExampleTwo
{
    XYZ m1()
    {
        System.out.println("m1 method");
        XYZ x = new XYZ();
        return x;
        //return new X();

    }

    Stud m2()
    {
        System.out.println("m2 method");
        Stud s = new Stud();
        return s;
        //return new Student();
    }

    Employee m3()
    {
        System.out.println("m3 method");
        Employee e = new Employee();
        return e;
        //return new Exployee();
    }

    static XYZ m4()
    {
        System.out.println("m4 method");
        XYZ xe = new XYZ();
        return xe;
        //return new Xe();

    }

    public static void main(String[] args)
    {
        MethodReturnTypeExampleTwo a = new MethodReturnTypeExampleTwo();
        XYZ x1 = a.m1();
        System.out.println("class XYZ Object:" +x1);
        Stud s1 = a.m2();
        System.out.println("class Stud Object:" +s1);
        Employee k = a.m3();
        System.out.println("class Employee Object:" +k);
        x1 = MethodReturnTypeExampleTwo.m4();
        System.out.println("class XYZ static Object:" +x1);
    }
}

class MethodReturnTypeExampleThree
{
    MethodReturnTypeExampleThree m1()
    {
        System.out.println("m1 method");
        MethodReturnTypeExampleThree m1 = new MethodReturnTypeExampleThree();
        return m1;
    }

    MethodReturnTypeExampleThree m2()
    {
        System.out.println("m2 method");
        return this;
    }

    public static void main(String[] args)
    {
        MethodReturnTypeExampleThree t = new MethodReturnTypeExampleThree();
        MethodReturnTypeExampleThree t1 = t.m1(); // returning same class object
        MethodReturnTypeExampleThree t2 = t.m2(); // returning same class object
    }

}

class MethodReturnTypeExampleFour
{
    int a = 100; // instance
    int m1(int a) // local
    {
        System.out.println("M1 method");
        return a;   // priority for local variable
    }

    public static void main(String args[])
    {
        MethodReturnTypeExampleFour k = new MethodReturnTypeExampleFour();
        int p = k.m1(200);
        System.out.println("method returning:" +p);

    }
}

class MethodReturnTypeExampleFive
{
    int a = 100;
    int m1()
    {
        System.out.println("M1 method");
        return a; // no local priority goes to instance variable
    }

    public static void main(String args[])
    {
        MethodReturnTypeExampleFive k = new MethodReturnTypeExampleFive();
        int p = k.m1();
        System.out.println("method returning:" +p);

    }
}

class MethodReturnTypeExampleSix
{
    int a = 100; // instance
    int m1(int a) // local
    {
        System.out.println("M1 method");
        return this.a; // priroty goes to instance due to this keyword
    }

    public static void main(String args[])
    {
        MethodReturnTypeExampleSix k = new MethodReturnTypeExampleSix();
        int p = k.m1(200);
        System.out.println("method returning:" +p);

    }
}

class DefaultDataTypeValues
{
    public static void main(String args[])
    {
        float a = 10.5f;  // use either f or F. by default decimal values are treadted as double.
        float b = (float)15.5; // typecasting approach
        double d = 20.5;
        System.out.println(a);

/*
D:\CoreJava\Programs>javac Test.java
Test.java:582: error: incompatible types: possible lossy conversion from double
to float
                float a = 10.5;
                          ^

remove f and try to see this error
*/
        System.out.println(b);

        System.out.println(d);
    }

}

class ConstructorExampleOne
{
    void m1()
    {
        System.out.println("m1 method");
    }

/*	ConstructorExampleOne() /* default constructor
	{
		//empty implementatio // compiler calls this zero argument constructor during object creation if no constructor defined here

	} */

    public static void main(String[] args)
    {
        ConstructorExampleOne c = new ConstructorExampleOne(); //this statement will be call zero argument constructor by compiler if no constructor specfied by developer
        c.m1();
    }
}


class ConstructorExampleTwo
{
    void m1()
    {
        System.out.println("m1 method");
    }

    // user defined constructor
    ConstructorExampleTwo()
    {
        System.out.println("0-arg Constructor");
    }

    ConstructorExampleTwo(int a)
    {
        System.out.println("1-arg Constructor")	;
    }
    public static void main(String[] args)
    {
        ConstructorExampleTwo c = new ConstructorExampleTwo();
        ConstructorExampleTwo c1 = new ConstructorExampleTwo(10);
    }
}


class ConstructorExampleThree
{
    ConstructorExampleThree(int a)
    {
        System.out.println("1-arg Constructor");
    }

    public static void main(String[] args)
    {
        // ConstructorExampleThree c = new ConstructorExampleThree();  uncomment to see below error
        // zero argument/default constructor is not there it will give compiler error as given below.
        //when no constructors are defined, then only zero argument/default constructors will be generated by compiler.

			/*  required: int
			  found: no arguments
			  reason: actual and formal argument lists differ in length
			1 error */
    }
}

class ConstructorExampleFour
{
    ConstructorExampleFour()
    {
        System.out.println("Business logic during object createion");
    }

    public static void main(String[] args)
    {
        ConstructorExampleFour f = new ConstructorExampleFour();
    }
}


class ConstructorEmployee
{

    int eid;
    String ename;
    float esal;

    void display()
    {
        System.out.println("employee id is " + eid);
        System.out.println("employee name is " + ename);
        System.out.println("employee sal is " + esal);
    }

    public static void main(String args[])
    {
        ConstructorEmployee e = new ConstructorEmployee();
        e.display();
    }
}

class ConstructorEmployeeOne
{

    int eid;
    String ename;
    float esal;

    ConstructorEmployeeOne() // the problem here is that it will assign same values for all the objects. // to-over come use param constructors eg : - ConstructorEmployeeTwo
    {
        eid = 100;
        ename = "kck";
        esal = 1501.50f;
    }
    void display()
    {
        System.out.println("employee id is " + eid);
        System.out.println("employee name is " + ename);
        System.out.println("employee sal is " + esal);
    }

    public static void main(String[] args)
    {
        ConstructorEmployeeOne e = new ConstructorEmployeeOne();
        e.display();
    }

}

class ConstructorEmployeeTwo
{

    int eid;
    String ename;
    float esal;

    ConstructorEmployeeTwo(int eid, String ename, float esal)
    {
        this.eid = eid;
        this.ename = ename;		// this keyword is very important to convert local variable to instance variable when local and instance variable have same name;
        this.esal = esal;
    }
    void display()
    {
        System.out.println("employee id is " + eid);
        System.out.println("employee name is " + ename);
        System.out.println("employee sal is " + esal);
    }

    public static void main(String[] args)
    {
        ConstructorEmployeeTwo e1 = new ConstructorEmployeeTwo(1001,"kck",100.75f);
        ConstructorEmployeeTwo e2 = new ConstructorEmployeeTwo(1002,"aka",191.75f);
        e1.display();
        e2.display();
    }

}

class ConstructorExampleFive
{
    ConstructorExampleFive()
    {
        System.out.println("0-org cons");
    }


    ConstructorExampleFive(int a)
    {
        System.out.println("1-org cons");
    }

    ConstructorExampleFive(int a, int b)
    {
        System.out.println("2-org cons");
    }

    public static void main(String[] args)
    {
        ConstructorExampleFive f1 = new ConstructorExampleFive();
        ConstructorExampleFive f2 = new ConstructorExampleFive(5);
        ConstructorExampleFive f3 = new ConstructorExampleFive(5,10);
    }
}


class ConstructorExampleSix
{
    ConstructorExampleSix()
    {
        this(6);
        System.out.println("0-org cons");
    }


    ConstructorExampleSix(int a)
    {
        this(6,12);
        System.out.println("1-org cons");
    }

    ConstructorExampleSix(int a, int b)
    {
        System.out.println("2-org cons");
    }

    public static void main(String[] args)
    {
        ConstructorExampleSix f1 = new ConstructorExampleSix();
        ConstructorExampleSix f2 = new ConstructorExampleSix(5);
        ConstructorExampleSix f3 = new ConstructorExampleSix(5,10);
    }
}


class ConstructorExampleSeven
{
    ConstructorExampleSeven()
    {
        System.out.println("0-org cons");
		/*this(6);


		D:\CoreJava\Programs>javac Test.java
		Test.java:823: error: call to this must be first statement in constructor
                this(6);
                    ^
		1 error
		*/
    }


    ConstructorExampleSeven(int a)
    {
        this(6,12);
		/*this();

			D:\CoreJava\Programs>javac Test.java
			Test.java:838: error: call to this must be first statement in constructor
							this();
								^
			1 error

		*/
        System.out.println("1-org cons");


    }

    ConstructorExampleSeven(int a, int b)
    {
        System.out.println("2-org cons");
    }

    public static void main(String[] args)
    {
        ConstructorExampleSeven f1 = new ConstructorExampleSeven();
        ConstructorExampleSeven f2 = new ConstructorExampleSeven(5);
        ConstructorExampleSeven f3 = new ConstructorExampleSeven(5,10);
    }
}


class ConstructorExampleEight
{
    ConstructorExampleEight()
    {
        System.out.println("0-arg con");
    }

    ConstructorExampleEight(int a)
    {
        System.out.println("1-arg con");
    }

    ConstructorExampleEight(int a, int b)
    {
        System.out.println("2-arg con");
    }


    public static void main(String[] args)
    {

        // named approach level object creation
        ConstructorExampleEight e = new ConstructorExampleEight();
        ConstructorExampleEight e1 = new ConstructorExampleEight(5);
        ConstructorExampleEight e2 = new ConstructorExampleEight(7,15);


        // name less approach level object creation

        new ConstructorExampleEight();
        new ConstructorExampleEight(20);
        new ConstructorExampleEight(25,27);
    }

}

class InstanceBlockOne
{
    InstanceBlockOne()
    {
        System.out.println("0-arg cons");
    }
    InstanceBlockOne(int a, int b)
    {
        System.out.println("2-arg cons");
    }
    InstanceBlockOne(int a)
    {
        System.out.println("1-arg cons");
    }

    {//instance block
        System.out.println("instance block");
    }

    public static void main(String[] args)
    {
        new InstanceBlockOne();
        new InstanceBlockOne(4);
        new InstanceBlockOne(5,10);
    }

}

/*

D:\CoreJava\Programs>java InstanceBlockOne
instance block
0-arg cons
instance block
1-arg cons
instance block
2-arg cons

*/

class InstanceBlockTwo
{
    InstanceBlockTwo()
    {
        System.out.println("0-arg cons");
    }
    InstanceBlockTwo(int a, int b)
    {
        System.out.println("2-arg cons");
    }
    InstanceBlockTwo(int a)
    {
        System.out.println("1-arg cons");
    }

// Instance blocks execute from top to bottom

    {//instance block
        System.out.println("instance block -1");
    }

    {//instance block
        System.out.println("instance block -2");
    }


    public static void main(String[] args)
    {
        new InstanceBlockTwo();
        new InstanceBlockTwo(4);
        new InstanceBlockTwo(5,10);
    }

}

/*

D:\CoreJava\Programs>java InstanceBlockTwo
instance block -1
instance block -2
0-arg cons
instance block -1
instance block -2
1-arg cons
instance block -1
instance block -2
2-arg cons

*/
class InstanceBlockThree
{
    InstanceBlockThree()
    {
        this(12);
        System.out.println("0-arg cons");
    }
    InstanceBlockThree(int a)
    {
        System.out.println("1-arg cons");
    }

    {//instance block
        System.out.println("instance block -1");
    }

    public static void main(String[] args)
    {
        new InstanceBlockThree(); // even though this constructor call another one, instance block happens only once.
    }

}

/*
D:\CoreJava\Programs>java InstanceBlockThree
instance block -1
1-arg cons
0-arg cons
*/


class StaticBlockExample
{
    static
    {
        System.out.println("Static block - 1");
    }
    static
    {
        System.out.println("static block -2");
    }
    {
        System.out.println("Instance Block -1");
    }
    {
        System.out.println("Instance Block -2");
    }

    public static void main(String[] args)
    {
        new StaticBlockExample();
        new StaticBlockExample();

    }


}

class StaticBlockTwo
{
    static
    {
        System.out.println("Static block Two - 1");
    }
    static
    {
        System.out.println("static block Two -2");
    }
}

class StaticBlockThree
{
    static
    {
        System.out.println("Static block Three - 1");
    }
    static
    {
        System.out.println("static block Three -2");
    }
}

class StaticBlockFour
{
    static
    {
        System.out.println("Static block Four - 1");
    }
    static
    {
        System.out.println("static block Four -2");
    }

    public static void main(String[] args) throws ClassNotFoundException
    {
        Class.forName("StaticBlockTwo");
        Class.forName("StaticBlockThree");
    }
}


class StaticBlockFive
{
    static int empid;
    static // comment this blcok and execute. static blocks are used to initialize static variables.
    {
        StaticBlockFive.empid = 100;
    }
    static void display()
    {
        System.out.println(StaticBlockFive.empid);
    }

    public static void main(String[] args) throws ClassNotFoundException
    {
        StaticBlockFive.display();
    }
}

class ClassExample
{
    int a;
    int b;
    void display()
    {
        System.out.println("instance method");
    }
    static void m2(String str)
    {
        System.out.println("static method");
    }
    {System.out.println("instance block");}
    static	{System.out.println("static block");}

    ClassExample()
    {
        System.out.println("0-arg Cons");
    }

    ClassExample(int a, int b)
    {
        this.a = a;
        this.b = b;
        System.out.println("2-arg Cons");
    }

    public static void main(String[] args)
    {

        ClassExample c = new ClassExample();
        c.display();
        new ClassExample(10,20);
        ClassExample.m2("kck");

    }
}

/*

D:\CoreJava\Programs>java ClassExample
static block
instance block
0-arg Cons
instance method
instance block
2-arg Cons
static method

*/

//Completed class defeintion (till here 19)


//parent class elements
//{
// parent variables
// parent methods
// parent constructors
// parent instance blocks
// parent static blocks
//}

class ParentOne
{
    int a =100,b=200;
}

class ChildOne extends ParentOne
{
    int a=1000,b=2000;
    void sum(int a, int b)
    {
        System.out.println(a+b);
        System.out.println(this.a+this.b);
        System.out.println(super.a+super.b);
    }

    public static void main(String[] args)
    {
        new ChildOne().sum(10,20);
    }
}

class ParentTwo
{
    void m1(){System.out.println("Parent m1 method");}
}

class ChildTwo extends ParentTwo
{
    void m1(){System.out.println("child m1 method");}
    void m2(){super.m1(); m1(); this.m1();}   // remove super and this to see the output

    public static void main(String[] args)
    {
        new ChildTwo().m2();
    }

}

/*
D:\CoreJava\Programs>java ChildTwo
Parent m1 method
child m1 method
child m1 method
*/


class ParentThree
{
    ParentThree(int k){System.out.println("parent 1-arg constructor");}
}

class ChildThree extends ParentThree
{
    ChildThree()
    {
        this(10);
        System.out.println("Child 0-arg constructor");
    }
    ChildThree(int a)
    {
        super(25);  // we use this keyword to call super class constructor
        System.out.println("Child 1-arg constructor");
    }
    public static void main(String[] args)
    {
        new ChildThree();
    }
}

/*
D:\CoreJava\Programs>java ChildThree
parent 1-arg constructor
Child 1-arg constructor
Child 0-arg constructor
*/


class ParentFour
{
    ParentFour()
    {
        System.out.println("parent 0-arg constructor");
    }
}

class ChildFour extends ParentFour
{
    ChildFour()
    {
        this(10);
        //super(); super can't be used along with this keyword
        System.out.println("Child 0-arg constructor");
    }
    ChildFour(int a)
    {
        System.out.println("Child 1-arg constructor");
        // super();  // Super must be the first statement in the constructor
    }
    public static void main(String[] args)
    {
        new ChildFour();
    }
}

/*
D:\CoreJava\Programs>javac Test.java
Test.java:1269: error: call to super must be first statement in constructor
                        super();  // Super must be the first statement in the co
nstructor
                             ^
1 error

*/


class ParentFive
{
}

class ChildFive extends ParentFive
{
    ChildFive()
    {
        super();  // parent class default constructor will be executed  default consturctor is always zero argument constructor
        System.out.println("Child 0-arg constructor");
    }

    public static void main(String[] args)
    {
        new ChildFive();
    }
}

/*
D:\CoreJava\Programs>java ChildFive
Child 0-arg constructor
*/


class ParentSix
{
/*	ParentSix(int k)
		{
			System.out.println("parent 0-arg constructor");
		}  */ //uncomment this to see below error message
}

class ChildSix extends ParentSix
{
    ChildSix()
    {
        // super(); //compiler will not call default zero argument constructot if parent has once constructor
        // Even after comment also it will not work becuase, by default super will execute as default in the child class constructor
        // Since no zero argument constructor exist it thorugh error message
        // compiler will call default zero argument construcor only when no constructor is there
        System.out.println("Child 0-arg constructor");
    }
    public static void main(String[] args)
    {
        new ChildSix();
    }
}

/*

D:\CoreJava\Programs>javac Test.java
Test.java:1324: error: constructor ParentSix in class ParentSix cannot be applie
d to given types;
                        super(); //super can't be used along with this keyword
                        ^
  required: int
  found: no arguments
  reason: actual and formal argument lists differ in length
1 error

*/


class ParentSeven
{
    ParentSeven(){
        System.out.println("Parent 0-argument constructor");
    }
}

class ChildSeven extends ParentSeven
{
    ChildSeven()
    {
        // super will execute as default in the child class constructors (both zero argument and parameterized argument) even this keyword does not exist
        System.out.println("Child 0-arg constructor");
    }

    ChildSeven(int a)
    {
        // super will execute as default in the child class constructors (both zero argument and parameterized argument) even this keyword does not exist
        System.out.println("Child 1-arg constructor");
    }

    public static void main(String[] args)
    {
        new ChildSeven();
        new ChildSeven(10);

    }
}

/*
D:\CoreJava\Programs>java ChildSeven
Parent 0-argument constructor
Child 0-arg constructor
Parent 0-argument constructor
Child 1-arg constructor
*/


class ParentEight
{
    ParentEight(){
        System.out.println("Parent 0-argument constructor");
    }
}

class ChildEight extends ParentEight
{
    // compiler generates default zero argument constructor whih in turn call super as the first statement. notice output
    public static void main(String[] args)
    {
        new ChildEight();
    }
}
/*
D:\CoreJava\Programs>java ChildEight
Parent 0-argument constructor
*/

class ParentNine
{
    {System.out.println("Parent Instance Block");}
}

class ChildNine extends ParentNine
{
    {System.out.println("Child Instance Block");}
    public static void main(String[] args)
    {
        new ChildNine();
    }
}

/*
D:\CoreJava\Programs>java ChildNine
Parent Instance Block
Child Instance Block
*/


class ParentTen
{
    ParentTen()
    {
        System.out.println("Parent 0-Arg Constructor");
    }
    {System.out.println("Parent Instance Block");}

}

class ChildTen extends ParentTen
{
    ChildTen()
    {
        System.out.println("child 0-Arg Constructor");
    }
    {System.out.println("Child Instance Block");}
    public static void main(String[] args)
    {
        new ChildTen();
    }
}

/*
D:\CoreJava\Programs>java ChildTen
Parent Instance Block
Parent 0-Arg Constructor
Child Instance Block
child 0-Arg Constructor
*/

class ParentEleven
{
    ParentEleven()
    {
        System.out.println("Parent 0-Arg Constructor");
    }
    {System.out.println("Parent Instance Block");}
    static{System.out.println("Parent static Block");}
}

class ChildEleven extends ParentEleven
{
    ChildEleven()
    {
        System.out.println("child 0-Arg Constructor");
    }
    {System.out.println("Child Instance Block");}
    static{System.out.println("child static Block");}
    public static void main(String[] args)
    {
        new ChildEleven();
        new ChildEleven();
    }
}

/*  for single object
D:\CoreJava\Programs>java ChildEleven
Parent static Block
child static Block
Parent Instance Block
Parent 0-Arg Constructor
Child Instance Block
child 0-Arg Constructor

*/

/* when more than single object
D:\CoreJava\Programs>java ChildEleven
Parent static Block
child static Block
Parent Instance Block
Parent 0-Arg Constructor
Child Instance Block
child 0-Arg Constructor
Parent Instance Block
Parent 0-Arg Constructor
Child Instance Block
child 0-Arg Constructor
*/


class OverloadingOne
{
    void m1(int a)
    {
        System.out.println("int m1 method");
    }
    void m1(int a, int b)
    {
        System.out.println("int int m1 method");
    }
    void m1(char c)
    {
        System.out.println("Char m1 method");
    }

    public static void main(String[] args)
    {
        OverloadingOne o = new OverloadingOne();
        o.m1(10);
        o.m1(10,20);
        o.m1('k');
    }
}

class ConstructorOverloading
{
    ConstructorOverloading(int a)
    {
        System.out.println("int arg constructor");
    }
    ConstructorOverloading(int a, int b)
    {
        System.out.println("int int arg constructor");
    }
    ConstructorOverloading(char c)
    {
        System.out.println("Char arg constructor");
    }

    public static void main(String[] args)
    {
        //	new ConstructorOverloading(); -> will give error message as no constructor matching.
        new ConstructorOverloading(10);
        new ConstructorOverloading(10,5);
        new ConstructorOverloading('K');
    }
}

class OperatorOverloading
{
    public static void main(String[] args)
    {
        System.out.println("kiyandoor" + "Sasi");
        System.out.println(23 + 10);
    }
}

// 1) polymorphisam : in order to overridding we must ensure method signature in both parent and child
// other wise based on singnatre child object will behave

class ParentRiddingOne
{
    void marry(int k)
    {
        System.out.println("Marry Black Girl");
    }

}

class ChildRiddingOne extends ParentRiddingOne
{
    //void marry()  // uncomment this to see which one execute when method signature is not same
    void marry(int j)
    {
        System.out.println("Marry Red Girl");
    }
    public static void main(String[] args)
    {
        new ChildRiddingOne().marry(25);

    }
}

/*
D:\CoreJava\Programs>javac Test.java
Test.java:1585: error: method marry in class ChildRiddingOne cannot be applied t
o given types;
                new ChildRiddingOne().marry(10);
                                     ^
  required: no arguments
  found: int
  reason: actual and formal argument lists differ in length
1 error
*/




//2) polymorphisam : in order to overridding we must ensure overridden method and overridding method return type same
// otherwise we see the following error message

class ParentRiddingTwo
{
    int marry(int k)
    {
        System.out.println("Marry Black Girl");
        return 20;
    }

}

class ChildRiddingTwo extends ParentRiddingTwo
{
    int marry(int j)
    //float marry(int j)
    {
        System.out.println("Marry Red Girl");
        return 25;
    }
    public static void main(String[] args)
    {

        new ChildRiddingTwo().marry(10);

    }
}



/*

D:\CoreJava\Programs>javac Test.java
Test.java:1620: error: marry(int) in ChildRiddingTwo cannot override marry(int)
in ParentRiddingTwo
        float marry(int j)
              ^
  return type float is not compatible with int
1 error

*/



//3) polymorphisam : Possible to change return type using co-varient return type concept(retrun child object for child class &
// return parent object for parent class)

/*
class ParentRiddingThree
{
	int marry(int k)
	{
		System.out.println("Marry Black Girl");
		return 20;
	}

}

class ChildRiddingThree extends ParentRiddingThree
{
	int marry(int j)
	//float marry(int j)
	{
		System.out.println("Marry Red Girl");
		return 25;
	}
	public static void main(String[] args)
	{

		new ChildRiddingTwo().marry(10);

	}
}

*/







//4) polymorphisam -> final methods can be overridden



class ParentRiddingFour
{
    void marry()
    //final void marry()
    {
        System.out.println("Marry Black Girl");
    }

}

class ChildRiddingFour extends ParentRiddingFour
{
    void marry()
    {
        System.out.println("Marry Red Girl");
    }
    public static void main(String[] args)
    {
        new ChildRiddingFour().marry();

    }
}

/* uncomment above final method in parent to see the below error message

D:\CoreJava\Programs>javac Test.java
Test.java:1707: error: marry() in ChildRiddingFour cannot override marry() in Pa
rentRiddingFour
        void marry()
             ^
  overridden method is final
1 error

*/


// 4. 1 -> final varibles can't be modified
// 4. 2 -> local variables can have one access modifer -> final.

class FinalVariableOne
{
    public static void main(String[] args)
    {
        //final int k = 25;  // local variables only can have final modifier.
        int k = 25;
        k += 5;
        System.out.println(k);

    }
}

/* uncomment aove final variable declaration to see the below error message

D:\CoreJava\Programs>javac Test.java
Test.java:1739: error: cannot assign a value to final variable k
                k += 5;
                ^
1 error
*/

// 4. 3 -> final class variable are by defalt not final
// 4. 4 -> final class methods are by default final

final class FinalClassVariables
{
    public static void main(String[] args)
    {
        int k = 25;  // final class variable are by defalt not final
        k += 5;
        System.out.println(k);

    }
}



class ParentOveridingFive
{
    void m1()
    {
        System.out.println("Parent m1 method");
    }
}

class ChildOveridingFive extends ParentOveridingFive
{
    void m1()
    {
        System.out.println("Child m1 method");
    }

    void m2()
    {
        System.out.println("Child m2 method");
    }

    public static void main(String[] args)
    {
        ParentOveridingFive p = new ChildOveridingFive();
        p.m1();
        //p.m2();
				/*
				D:\CoreJava\Programs>javac Test.java
				Test.java:1796: error: cannot find symbol
								p.m2();
								 ^
				  symbol:   method m2()
				  location: variable p of type ParentOveridingFive
				1 error
				*/

        ChildOveridingFive k =(ChildOveridingFive) p; // class casting applied to parent object reference variable to access child class methods.
        k.m2();

    }

}



interface WebDriver
{
    public void get();
    public void maximize();

}

class FirefoxDriver implements WebDriver
{
    void x()
    {
        System.out.println("FF x method");
    }

    void y()
    {
        System.out.println("FF y method");
    }

    public void get()
    {
        System.out.println("FF get method");
    }

    public void maximize()
    {
        System.out.println("FF maximize method");
    }


    public static void main(String[] args)
    {
        WebDriver f = new FirefoxDriver();
        f.get();
        f.maximize();


        //ff.x(); we can't access child class methods using parent class object reference
        //ff.y(); // we have to class caste parent object reference to child class reference as shown below

        FirefoxDriver ff =  (FirefoxDriver)f;

        ff.x();
        ff.y();


    }

}

//5-  It is Not possible to override static methods in java.  static methods are specific to class not to object.
// this concept is called method hiding concept.


class ParentOveridingSix
{
    static void m1()
    {
        System.out.println("parent m1 method");
    }

}

class ChildOveridingSix extends ParentOveridingSix
{
    static void m1()
    {
        System.out.println("Child m1 method");
    }

    void m2()
    {
        System.out.println("Child m2 method");
    }

    public static void main(String[] args)
    {
        ParentOveridingSix p = new ChildOveridingSix();
        p.m1();
    }

}


/* the error message we get when child m1 is not static and parent m1 is staic

	With both static, here output is parent m1. this is called method hiding

D:\CoreJava\Programs>javac Test.java
Test.java:1882: error: m1() in ChildOveridingSix cannot override m1() in ParentO
veridingSix
        void m1()
             ^
  overridden method is static
1 error

*/

// 6 -> private method can't be overide.

class ParentOveridingSeven
{
    //private void m1() //uncomment this to see the below error message
    void m1()
    {
        System.out.println("parent m1 method");
    }

}

class ChildOveridingSeven extends ParentOveridingSeven
{
    public static void main(String[] args)
    {
        ParentOveridingSeven p = new ChildOveridingSeven();
        p.m1();
    }

}

/*

D:\CoreJava\Programs>javac Test.java
Test.java:1935: error: m1() has private access in ParentOveridingSeven
                p.m1();
                 ^
1 error
*/

class ParentOveridingEight
{
    // private void m1() // uncomment/delete to see the below error
    void m1()
    {
        System.out.println("parent m1 method");
    }
}

class ChildOveridingEight extends ParentOveridingEight
{
    /*private void m1()
	{
		System.out.println("child m1 method");
	}*/
    public static void main(String[] args)
    {
        ParentOveridingEight p = new ChildOveridingEight();
        p.m1(); // here parent m1 method will be called if we do not have any override method in child class
        // if we have override m1 method in child class child class m1 method will be called.
    }
}

/*two same private methods in parent and child -> still we can access parenet method to see the below error message.

D:\CoreJava\Programs>javac Test.java
Test.java:1964: error: m1() has private access in ParentOveridingEight
                p.m1();
                 ^
1 error

*/


// 7. While overideing it is possible to maintain same lever / increasing order permission but not Reduction of permissions not possible

//during over ridding pls check modifers.

/* pre requisites
access modifiers			->	permission
public var, methods and class -> any package can access
protected var, methods		-> same package and outside package child classess
private var, methods		-> within the class
default var, methods and class -> within the package

same level

1)defual vs default


increasing level

2)protected vs public



decresing level

3) public vs default // weaker access compiler error

*/



// Abstract



abstract class AbstractOne // remove abstract to see the below first comment
{
    abstract void m1();
    abstract void m2();
    abstract void m3();
    void m4() {System.out.println("m4 method");}
}

class ChildAbstractOne extends AbstractOne
{
    void m1() {System.out.println("m1 method");}  // overriding parent class method
    void m2() {System.out.println("m2 method");}
    void m3() {System.out.println("m3 method");}

    public static void main(String[] args){
//	AbstractOne a1= new AbstractOne(); // uncomment this to see the second error message.
        ChildAbstractOne c1 = new ChildAbstractOne();
        c1.m1();
        c1.m2();
        c1.m3();
        c1.m4();


        AbstractOne c2 = new ChildAbstractOne(); // abstract class object reference can hold its child classes.

        c2.m1();	// compile -> AbstractOne  runtime : ChildAbstractOne
        c2.m2();	// compile -> AbstractOne  runtime : ChildAbstractOne
        c2.m3();	// compile -> AbstractOne  runtime : ChildAbstractOne
        c2.m4();	// compile -> AbstractOne  runtime : ChildAbstractOne
    }

}

/* (1)

				D:\CoreJava\Programs>javac test.java
				test.java:2010: error: AbstractOne is not abstract and does not override abstrac
				t method m3() in AbstractOne
				class AbstractOne
				^
				1 error


	(2)

					D:\CoreJava\Programs>javac test.java
				test.java:2027: error: AbstractOne is abstract; cannot be instantiated
						AbstractOne a1= new AbstractOne(); // we will get following error when w
				e try to create object for abstract method
										^
				1 error



	(3)


					D:\CoreJava\Programs>java ChildAbstractOne
				m1 method
				m2 method
				m3 method
				m4 method


	(4)

					D:\CoreJava\Programs>java ChildAbstractOne
				m1 method
				m2 method
				m3 method
				m4 method
				m1 method
				m2 method
				m3 method
				m4 method

	*/


abstract class AbstractTwo
{
    abstract void m1();
    abstract void m2();
    abstract void m3();

}

abstract class ChildAbstractTwo extends AbstractTwo
{
    void m1() {System.out.println("m1 method");}
    // overriding one parent class method alone. since this class is not override all the methods we have to declare it as abstract class

}

abstract class ChildAbstractThree extends ChildAbstractTwo
{
    void m2() {System.out.println("m2 method");}
    // even though overriding parent class method m2 alone. its parent has m1 implementaion
    // this class does not have m3 implemenation. we have to declare this class as abstract class

}

class ChildAbstractFour extends ChildAbstractThree
{
    void m3() {System.out.println("m3 method");}
    // even though overriding parent class method m3 alone. its parent has m1, m2 implementaion
    // this class has complete implementation. no need for abstract and access all the root parent class methods uisng this child class objects

    public static void main(String[] args){
        ChildAbstractFour c1 = new ChildAbstractFour();
        c1.m1();
        c1.m2();
        c1.m3();
    }
}

/*

		D:\CoreJava\Programs>java ChildAbstractFour
		m1 method
		m2 method
		m3 method
*/


abstract class ChildAbstractFive extends ChildAbstractFour
{
    void m3() {System.out.println("m3 method");}
    public static void main(String[] args){
        System.out.println("hello world");
        ChildAbstractFour c1 = new ChildAbstractFour();
        c1.m1();
    }
}


abstract class AbstractThree
{
    AbstractThree()
    {
        System.out.println("Abstract class Cons");
    }

    abstract void m1();
}

class ChildAbstractSix extends AbstractThree
{
    ChildAbstractSix()
    {
        System.out.println("normal class Cons");
    }

    void m1()
    {
        System.out.println("m1 method implimentation");
    }

    public static void main(String[] args)
    {
        ChildAbstractSix c1 = new ChildAbstractSix();
        c1.m1();
    }

}

/*
		D:\CoreJava\Programs>java ChildAbstractSix
		Abstract class Cons
		normal class Cons
		m1 method implimentation
*/


abstract class Test5
{
    Test5() {System.out.println("Abstract class Cons");}
    {System.out.println("abstract class instance block");}
    static {System.out.println("abstract class static block");}
}

class Test6 extends Test5
{
    Test6()
    {
        //super(); // by default super keyword is called by compiler in the child class constructor
        System.out.println("normal class Cons");
    }

    //{System.out.println("child class instance block");}
    //static {System.out.println("child class static block");}
    // uncomment to see the second example

    public static void main(String[] args)
    {
        new Test6();
        new Test6();
    }

}
/*
	(1)D:\CoreJava\Programs>java Test6
	abstract class static block
	abstract class instance block
	Abstract class Cons
	normal class Cons
	abstract class instance block
	Abstract class Cons
	normal class Cons

	(2)D:\CoreJava\Programs>java Test6
	abstract class static block
	child class static block
	abstract class instance block
	Abstract class Cons
	child class instance block
	normal class Cons
	abstract class instance block
	Abstract class Cons
	child class instance block
	normal class Cons
*/


class ExceptionOne // this program contains some unchecked exception
{
    //compiler unchecks and compiles fine. Runtime jvm terminates the program
    //uncomment the unchecked exception and compile. compiler will not give any error message.
    // run time jvm gives error message and stop execution.
    public static void main(String[] arg)
    {
        System.out.println("KCK World");
        System.out.println("KCK World");
        System.out.println("KCK World");
//		System.out.println(10/0);

		/*
			Exception in thread "main" java.lang.ArithmeticException: / by zero
			at ExceptionOne.main(Test.java:2244)
		*/
        System.out.println("kck".charAt(2));
//		System.out.println("kck".charAt(5));
		/*
					Exception in thread "main" java.lang.StringIndexOutOfBoundsException: String ind
			ex out of range: 5
					at java.lang.String.charAt(Unknown Source)
					at ExceptionOne.main(Test.java:2253)
		*/

        int a[] = {0,1,2,3,4,5};
        System.out.println(a[5]);
        //System.out.println(a[7]);

/*		Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 7
        at ExceptionOne.main(Test.java:2263)*/



        System.out.println("KCK World");
    }
}


interface Test7
{
    void m1();
    void m2();
    void m3();
}

class Test8 implements Test7
{
    public void m1() // during override we should not decrase permission level. by default interface methods are public.
    {
        System.out.println("m1 method");
    }

    public void m2()
    {
        System.out.println("m2 method");
    }

    public void m3()
    {
        System.out.println("m3 method");
    }

	/*
			if we don't give permission as public, we get below error
			Test.java:2295: error: m3() in Test8 cannot implement m3() in Test7
							void m3()
	*/

    public static void main(String[] args)
    {
        Test8 t = new Test8();
        t.m1();
        t.m2();
        t.m3();

        Test7 t1 = new Test8(); // interface object reference can hold its child class object
        t.m1();
        t.m2();
        t.m3();
    }
}



abstract class Test9 implements Test7
{
    public void m1()
    {
        System.out.println("m1 method");
    }

}

abstract class Test10 extends Test9
{
    public void m2()
    {
        System.out.println("m2 method");
    }
}

class Test11 extends Test10
{
    public void m3()
    {
        System.out.println("m3 method");
    }
    public static void main(String[] args)
    {
        Test11 t = new Test11();
        t.m1();
        t.m2();
        t.m3();

        Test7 t1 = new Test11(); // interface object reference can hold its child class object
        t.m1();
        t.m2();
        t.m3();
    }
}


interface Itr1
{
    interface Itr2
    {
        void m1();
    }
}

class Test12 implements Itr1.Itr2
{
    public void m1()
    {
        System.out.println("m1 method implementaion");
    }
    public static void main(String[] args)
    {
        Test12 t = new Test12();
        t.m1();
    }
}

interface Itr3	//by default abstract class
{
    int a = 10; // public static final
    void m1();	//	public abstract

}

interface Itr4
{
    int a = 20;
}


class Test13 implements Itr3
{
    public void m1()
    {
        System.out.println("m1 method implementation");
    }
    public static void main()
    {
        // a = a + 5; //uncomment to see the below error
        Test12 t = new Test12();
        t.m1();
        System.out.println(a);
    }
}

/*
	D:\CoreJava\Programs>javac Test.java
	Test.java:2402: error: cannot assign a value to final variable a
					 a = a + 5; //uncomment to see the below error
					 ^
	1 error

	*/

class Test14 implements Itr3, Itr4
{
    public void m1()
    {
        System.out.println("m1 method implementation");
    }
    public static void main(String[] args)
    {
        //System.out.println(a);
        // Whenever we have two same variables in two different names trying to change in the implemetation class. we get abiguity error
        // toover comed this follow below appraoch
        System.out.println(Itr3.a);
        System.out.println(Itr4.a);
    }
}

/*
				D:\CoreJava\Programs>javac Test.java
			Test.java:2427: error: reference to a is ambiguous
							System.out.println(a);
											   ^
			  both variable a in Itr3 and variable a in Itr4 match
			1 error


		*/


interface Itr5
{
    void m1();
    void m2();
    void m3();
    void m4();
    void m5();
    void m6();
    void m7();
}

class Test15 implements Itr5  // this is adoptor class which has empty implementation of interface methods
{
    public void m1(){}
    public void m2(){}
    public void m3(){}
    public void m4(){}
    public void m5(){}
    public void m6(){}
    public void m7(){}
}

class Test16 extends Test15
{
    public void m1(){System.out.println("m1 method implementation using adptor class Test15");}
    public void m5(){System.out.println("m5 method implementation using adptor class Test15");}

    public static void main (String[] args)
    {
        new Test16().m1();
        new Test16().m5();
    }
}

/*
		D:\CoreJava\Programs>java Test16
	m1 method implementation using adptor class Test15
	m5 method implementation using adptor class Test15
	*/

class Test17 implements Cloneable
{
    int a = 100;
    int b = 200;

    public static void main(String[] args) throws Exception
    {
        Test17 t = new Test17();
        System.out.println(t.a);
        System.out.println(t.b);
        t.a = 1000;
        t.b = 2000;
        System.out.println(t.a);
        System.out.println(t.b);
        Test17 t1 = (Test17)t.clone();  // creating duplicate object for t at this point.
        t.a = 10000;
        t.b = 20000;
        System.out.println(t.a);
        System.out.println(t.b);
        System.out.println(t1.a);
        System.out.println(t1.b);
    }
}
/*

		during run time we see the below excepiton to overcome this problem we need implement marker interface Cloneable. JVM hanles this exception

		D:\CoreJava\Programs>java Test17
		100
		200
		1000
		2000
		Exception in thread "main" java.lang.CloneNotSupportedException: Test17
				at java.lang.Object.clone(Native Method)
				at Test17.main(Test.java:2500)

		after implementation of Cloneable interface

					D:\CoreJava\Programs>java Test17
			100
			200
			1000
			2000
			10000
			20000
			1000
			2000

		*/


class Test18
{
    public static void main(String[] args)
    {
        System.out.println("hi kck");
        try
        {
            System.out.println(10/0);
        }
        catch (ArithmeticException e)		// program terminates normally
        {
            System.out.println(10/2);
        }
        System.out.println("Rest of App Code");
    }
}

/*
				D:\CoreJava\Programs>java Test18
		hi kck
		5
		Rest of App Code

		*/


class Test19
{
    public static void main(String[] args)
    {
        try
        {
            System.out.println("hi kck");
            System.out.println(10/0);
        }
        catch (NullPointerException e)		// program terminates abnormally
        {
            System.out.println(10/2);
        }
        System.out.println("Rest of App Code");
    }
}

/*

				D:\CoreJava\Programs>java Test19
		hi kck
		Exception in thread "main" java.lang.ArithmeticException: / by zero
				at Test19.main(Test.java:2563)

		*/


class Test20
{
    public static void main(String[] args)
    {
        try
        {
            System.out.println("hi kck");
            System.out.println(10/2);
        }
        catch (ArithmeticException e)		// catch block will not execute if there is no exception in the try block
        {
            System.out.println("catch block");
            System.out.println(10/5);
        }
        System.out.println("Rest of App Code");
    }
}



class Test21
{
    public static void main(String[] args)
    {
        // uncomment the blow try block to see error messge. try with catch or try with finally should exist
        // independent try blocks are not allowed
		/*try
		{
			System.out.println("hi kck");
			System.out.println(10/2);
		}*/
        System.out.println("Rest of App Code");
    }
}

/*

		D:\CoreJava\Programs>javac Test.java
		Test.java:2614: error: 'try' without 'catch', 'finally' or resource declarations

						try
						^
		1 error

		*/


class Test22
{
    public static void main(String[] args)
    {
        try
        {
            System.out.println("hi kck");
            System.out.println(10/2);
        }
        //int a = 5;
        //System.out.println("After try block before catch Block");
        catch (ArithmeticException e)		// no statements should exist between try and catch blocks
        {
            System.out.println("catch block");
            System.out.println(10/5);
        }
        System.out.println("Rest of App Code");
    }
}


class Test23
{
    public static void main(String[] args)
    {
        int a = 0;
        try
        {
            System.out.println("hi kck");
            System.out.println(10/a);
        }
        catch (ArithmeticException e)		// when try and catch blocks have exception its always abnormal termination
        {
            System.out.println("catch block");
            System.out.println(20/a);
        }
        System.out.println("Rest of App Code");
    }
}

/*

		D:\CoreJava\Programs>java Test23
		hi kck
		catch block
		Exception in thread "main" java.lang.ArithmeticException: / by zero
				at Test23.main(Test.java:2671)

		*/


class Test24
{
    public static void main(String[] args)
    {
        int a = 0;
        try
        {
            System.out.println(10/a);
            System.out.println("hi try block");

        }
        catch (ArithmeticException e)		// code after exception code will not execute in the try block.
        // its always recommended to have only excetion code inside the try block. rest before try block
        {
            System.out.println("catch block");
            System.out.println(20/10);
        }
        System.out.println("Rest of App Code");
    }
}

/*

			D:\CoreJava\Programs>java Test24
		catch block
		2
		Rest of App Code

	*/


class Test25
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter Integer Value:");
        int a = s.nextInt();
        try		// mulitple catch block allowed
        {
            System.out.println(10/a);
            System.out.println("kck".charAt(20));

        }
        catch (ArithmeticException e)
        {
            System.out.println("**In ArthimeticException catch block**");

        }
        catch (StringIndexOutOfBoundsException e)
        {
            System.out.println("**In string catch blcok**");

        }

        System.out.println("Rest of App Code");
    }
}


class Test26
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter Integer Value:");
        int a = s.nextInt();
        try		// mulitple catch block allowed
        {
            System.out.println(10/a);
            System.out.println("kck".charAt(20));

        }
        catch (Throwable t)		//Root class can hold all of its child class objects
        // In Test25 we had two catch blocks now we have one catch blcok to handle both catch blocks
        {
            System.out.println(t.toString());

        }

        System.out.println("Rest of App Code");
    }
}

/*

	D:\CoreJava\Programs>java Test26
	Enter Integer Value:2
	5
	java.lang.StringIndexOutOfBoundsException: String index out of range: 20
	Rest of App Code

	D:\CoreJava\Programs>java Test26
	Enter Integer Value:0
	java.lang.ArithmeticException: / by zero
	Rest of App Code
	*/

class Test27
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter Integer Value:");
        int a = s.nextInt();
        try		// mulitple catch block allowed
        {
            System.out.println(10/a);
            System.out.println("kck".charAt(20));

        }
        catch (ArithmeticException e)
        {
            System.out.println("**In ArthimeticException catch block**");

        }
        catch (StringIndexOutOfBoundsException e)
        {
            System.out.println("**In string catch blcok**");

        }
        catch (Throwable t)		//order to catch blocks are from child to parent
        {
            System.out.println(t.toString());

        }

        System.out.println("Rest of App Code");
    }
}



class Test28
{
    public static void main(String[] args)
    {
        try
        {
            System.out.println("try");
        }
        catch (Throwable e)		// this catch block will not execute since no exception in try block
        {
            System.out.println("catch");
        }
        finally  // this finally block executes even catch block or try block not executed becuase of exceptions
        {
            System.out.println("finally");
        }
        System.out.println("Rest of App Code");
    }
}

class Test29
{
    public static void main(String[] args)
    {
        try
        {
            System.out.println(10/0);
        }
        catch (Throwable e)
        {
            System.out.println("catch");
        }
        finally
        {
            System.out.println("finally");
        }
        System.out.println("Rest of App Code");
    }
}

class Test30
{
    public static void main(String[] args)
    {
        try
        {
            System.out.println(10/0);
        }
        catch (NullPointerException e)
        {
            System.out.println("catch");
        }
        finally
        {
            System.out.println("finally");
        }
        System.out.println("Rest of App Code");
    }
}

class Test31
{
    public static void main(String[] args)
    {
        try
        {
            System.out.println(10/0);
        }
        catch (ArithmeticException e)
        {
            System.out.println(1/0);
        }
        finally
        {
            System.out.println("finally");
        }
        System.out.println("Rest of App Code");
    }
}


class Test32
{
    public static void main(String[] args)
    {
        try
        {
            System.out.println(10/0);
        }
        catch (ArithmeticException e)
        {
            System.out.println("catch");
        }
        finally
        {
            System.out.println(10/0);
        }
        System.out.println("Rest of App Code");
    }
}


class Test33
{
    public static void main(String[] args)
    {
        try
        {
            System.out.println("try");
            System.exit(0);
        }
        catch (ArithmeticException e)
        {
            System.out.println("catch");
        }
        finally
        {
            System.out.println("finally");
        }
        System.out.println("Rest of App Code");
    }
}

class Test34
{
    public static void main(String[] args)
    {
        System.out.println(10/0);
        try
        {
            System.out.println("try");
        }
        catch (ArithmeticException e)
        {
            System.out.println("catch");
        }
        finally
        {
            System.out.println("finally");
        }
        System.out.println("Rest of App Code");
    }
}

/*
		D:\CoreJava\Programs>java Test34
		Exception in thread "main" java.lang.ArithmeticException: / by zero
					at Test34.main(Test.java:2949)

					Finally block does not execute in the above two cases.

					*/

class Test35
{
    public static void main(String[] args)
    {
        try
        {
            System.out.println(10/0);
        }
        catch (ArithmeticException e)
        {
            System.out.println(e.toString());
            System.out.println(e.getMessage());
            //System.out.println(e.printStackTrace);  -------------> not working need to look into this.

        }
        finally
        {
            System.out.println("finally");
        }
        System.out.println("Rest of App Code");
    }
}

/*



 */

class Test36
{
    void mro() throws InterruptedException
    {
        System.out.println("Sleeping");
        Thread.sleep(3000);
        System.out.println("Sleeping");
    }
    void mandalOfficer() throws InterruptedException
    {
        mro();
    }
    void eseva() throws InterruptedException
    {
        mandalOfficer();
    }

    public static void main (String[] args) throws InterruptedException
    {
        Test36 t = new Test36();
        t.eseva();
    }

    //every method is trying to delecgate resonsibiltiy of handling exception to caller method. in stack the last calling method is main
    //	and main method delegate responsibility to JVM.
}


class Test37
{
    void mro() throws InterruptedException
    {
        System.out.println("Sleeping");
        Thread.sleep(3000);
        System.out.println("Sleeping");
    }
    void mandalOfficer() throws InterruptedException
    {
        mro();

    }
    void eseva()
    {
        try{mandalOfficer();}
        catch(InterruptedException ie){System.out.println(ie.getMessage());}
    }

    public static void main (String[] args)
    {
        Test37 i = new Test37();
        i.eseva();
    }

    //here eseva handled exception code so no need to delegate exceptions to main method.

}



class Test38
{
    Test38(int k)
    {
        if (k > 0)
            System.out.println("there will not be any exception");
        else
            throw new ArithmeticException("you are dividing by zero provided by kiyan"); // OVERRIDING PRE-DEFINED EXCEPTION -> NOT RECOMMENDED
    }

    public static void main(String[] args)
    {
        new Test38(10);
        new Test38(0);
    }

/*
				D:\CoreJava\Programs>java Test38
				there will not be any exception
				Exception in thread "main" java.lang.ArithmeticException: you are dividing by ze
				ro provided by kiyan
				at Test38.<init>(Test.java:3073)
				at Test38.main(Test.java:3079)*/
}

class InvalidAgeException extends Exception // user defined checked exception with zero constructor
{
    // default constructor approach
}



class Test39
{
    static void status(int age) throws InvalidAgeException // mandatory to have throws or try catch block due to these are checked exception
    {
        if (age > 20)
            System.out.println("you are eligible for marriage");
        else
            throw new InvalidAgeException();
    }
    public static void main(String[] args) throws InvalidAgeException // mandatory to have throws or try catch block due to these are checked exception
    {
        System.out.println("Enter your age :");
        Scanner s = new Scanner(System.in);
        int x = s.nextInt();
        Test39.status(x);
    }

	/*

					D:\CoreJava\Programs>java Test39
				Enter your age :
				6
				Exception in thread "main" InvalidAgeException
						at Test39.status(Test.java:3102)
						at Test39.main(Test.java:3109)

						*/
}


class InvalidAgeException1 extends Exception // user defined checked exception with parameterize constructor
{
    InvalidAgeException1(String str)
    {
        super(str);
    }
}


class Test40
{
    static void status(int age) throws InvalidAgeException1  // mandatory to have throws or try catch block due to these are checked exception
    {
        if (age > 20)
            System.out.println("you are eligible for marriage");
        else
            throw new InvalidAgeException1("you are not eligible for marrage InvalidAgeException1");
    }
    public static void main(String[] args) throws InvalidAgeException1 // mandatory to have throws or try catch block due to these are checked exception
    {
        System.out.print("Enter your age :");
        int x = new Scanner(System.in).nextInt();
        Test40.status(x);
    }

	/*

							D:\CoreJava\Programs>java Test40
				Enter your age :6
				Exception in thread "main" InvalidAgeException1: you are not eligible for marrag
				e InvalidAgeException1
						at Test40.status(Test.java:3141)
						at Test40.main(Test.java:3147)

						*/
}

class InvalidAgeException2 extends RuntimeException // user defined un-checked exception with default constructor
{

}


class Test41
{
    static void status(int age)  // no need to have throws or try catch block due to these are un-checked exception
    {
        if (age > 20)
            System.out.println("you are eligible for marriage");
        else
            throw new InvalidAgeException2();
    }
    public static void main(String[] args)  // no need to have throws or try catch block due to these are un-checked exception
    {
        System.out.print("Enter your age :");
        int x = new Scanner(System.in).nextInt();
        Test41.status(x);
    }

	/*

										D:\CoreJava\Programs>java Test41
			Enter your age :5
			Exception in thread "main" InvalidAgeException2
					at Test41.status(Test.java:3175)
					at Test41.main(Test.java:3181)

						*/
}


class InvalidAgeException3 extends RuntimeException // user defined un-checked exception with parameterize constructor
{
    InvalidAgeException3(String str)
    {
        super(str);
    }
}


class Test42
{
    static void status(int age) // no need to have throws or try catch block due to these are un-checked exception
    {
        if (age > 20)
            System.out.println("you are eligible for marriage");
        else
            throw new InvalidAgeException3("you are not eligible for marrage InvalidAgeException3");
    }
    public static void main(String[] args) throws InvalidAgeException3
    {
        System.out.print("Enter your age :");
        int x = new Scanner(System.in).nextInt();
        Test42.status(x);
    }

	/*

						D:\CoreJava\Programs>java Test42
			Enter your age :3
			Exception in thread "main" InvalidAgeException3: you are not eligible for marrag
			e InvalidAgeException3
					at Test42.status(Test.java:3212)
					at Test42.main(Test.java:3218)

						*/
}

//Wrapper
class Wrapper1
{
    public static void main(String[] args)
    {
        Integer i = new Integer(10);
        Integer k = new Integer("10");
        System.out.println(i);
        System.out.println(k);
        Integer j = new Integer("one");  // this will throw number format exception - > java.lang.NumberFormatException
        System.out.println(j);
    }
}

/*
	D:\CoreJava\Programs>java Wrapper1
			10
			10
			Exception in thread "main" java.lang.NumberFormatException: For input string: "o
			ne"
					at java.lang.NumberFormatException.forInputString(Unknown Source)
					at java.lang.Integer.parseInt(Unknown Source)
					at java.lang.Integer.<init>(Unknown Source)
					at Wrapper1.main(Test.java:3475)
	*/


class Wrapper2
{
    public static void main(String[] args)
    {
        Wrapper2 i = new Wrapper2();
        System.out.println(i);
        System.out.println(i.toString());	// this class does not have toString method it will call Object class toString method
        // which returns class-name@hashcode

        Integer k = new Integer(100);		// In all wrapper classes to string is overriding the object class to string method
        System.out.println(k);
        System.out.println(k.toString());
    }
/*	D:\CoreJava\Programs>java Wrapper2
	Wrapper2@15db9742
	Wrapper2@15db9742
	100
	100
	*/
}



class Wrapper3
{

    public static void main(String[] args)
    {
        // valueOf method return Wrapper Object. It is static method

        //	Byte k1 = Byte.valueOf(7); this is not possible
        Byte k2 = Byte.valueOf("100");

        //	Short k3 = Short.valueOf(14); this is not possible
        Short k4 = Short.valueOf("1000");

        Integer k5 = Integer.valueOf(10000);
        Integer k6 = Integer.valueOf("100000");

        Long k7 = Long.valueOf(1000000);
        Long k8 = Long.valueOf("10000000");

        //	Float k9 = Float.valueOf(100.0); this is not possible
        Float k10 = Float.valueOf("1000.1");
        Float k11 = Float.valueOf(100.0f);
        Float k12 = Float.valueOf("1000.2f");

        Double k13 = Double.valueOf(200.0);
        Double k14 = Double.valueOf("2000.1");

        //	Character k15 = Character.valueOf(c); this is not possible
        Character k16 = Character.valueOf('c');

        Boolean k17 = Boolean.valueOf(true);
        Boolean k18 = Boolean.valueOf("false");


        //sout alway internally call toString method of reference variable
        //wrapper object has toString method overide the Object class toString method.

        //System.out.println(k1);
        System.out.println(k2);
        //System.out.println(k3);
        System.out.println(k4);
        System.out.println(k5);
        System.out.println(k6);
        System.out.println(k7);
        System.out.println(k8);
        //	System.out.println(k9);
        System.out.println(k10);
        System.out.println(k11);
        System.out.println(k12);
        System.out.println(k13);
        System.out.println(k14);
        //	System.out.println(k15);
        System.out.println(k16);
        System.out.println(k17);
        System.out.println(k18);


        // valauOf method can be applied to String class as well apart from Wrapper Classes. return String Object
        String k = String.valueOf(5);
        System.out.println(k);

        // XxxValue(); return primitive datatype from wrapper Object

        System.out.println(k2.byteValue());
        System.out.println(k4.shortValue());
        System.out.println(k5.intValue());
        System.out.println(k6.intValue());
        System.out.println(k7.longValue());
        System.out.println(k8.longValue());
        //	System.out.println(k9);
        System.out.println(k10.floatValue());
        System.out.println(k11.floatValue());
        System.out.println(k12.floatValue());
        System.out.println(k13.doubleValue());
        System.out.println(k14.doubleValue());
        //	System.out.println(k15);
        System.out.println(k16.charValue());
        System.out.println(k17.booleanValue());
        System.out.println(k18.booleanValue());

        // parseXxx() covert String object to premitive datatype

        System.out.println(Integer.parseInt("5"));
        System.out.println(Long.parseLong("1000"));
        System.out.println(Float.parseFloat("10.0f"));
        System.out.println(Float.parseFloat("10.1"));
        System.out.println(Double.parseDouble("20.6"));
        //System.out.println(Character.parseChar('c')); no such method exist in Character Wrapper class
        // System.out.println(Character.parseChar("ca"));
        System.out.println(Boolean.parseBoolean("true"));


    }
}


class Wrapper4
{
    public static void main(String[] args)
    {
        //auto-boxing // no need of constructor and valueOf
        Integer i = 100;
        System.out.println(i);  // wrapper object to string method will be called
        System.out.println(i.toString());

        //auto-unboxing // no need of xxxValue method to convert wrapper object to primitive.
        int x = new Integer(105);
        System.out.println(x);
        //System.out.println(x.toString()); // it is not possible to have to string method for primitive data types
    }

}

// String Manupulation *************************************************************** Very very important


class String1
{
    public static void main(String[] args)
    {
        String a = "anu";

        String c = new String("kiyan");

        StringBuffer e = new StringBuffer("sasi");

        System.out.println(a);
        System.out.println(c);
        System.out.println(e);

    }
}

class String2
{
    public static void main(String[] args)
    {
        String a = "anu";
        String b = "anu";

        String c = new String("kiyan");
        String d = new String("kiyan");

        StringBuffer e = new StringBuffer("sasi");
        StringBuffer f = new StringBuffer("sasi");

        System.out.println(a == b);
        System.out.println(c == d);
        System.out.println(e == f);
    }
}

/*
		D:\CoreJava\Programs>java String2
		true
		false
		false
		*/


class String3

{
    public static void main(String[] args)
    {
        String d = new String("kiyan"); // immutable -> not changeable
        d.concat(" Java");
        StringBuffer e = new StringBuffer("sasi"); // mutable -> changeable
        e.append(" java");

        System.out.println(d);
        System.out.println(e);
    }
}
/*
		D:\CoreJava\Programs>java String3
		kiyan
		sasi java
		*/


class String4
{
    public static void main(String[] args)
    {
        String4 f = new String4();
        System.out.println(f); // Sout always call to string method by default
        System.out.println(f.toString());
    }
	/*
	D:\CoreJava\Programs>java String4
			String4@15db9742
			String4@15db9742
			*/
}


class StringEmp
{
    Integer id;
    String name;
    StringEmp(Integer id, String name)
    {
        this.id = id;
        this.name = name;
    }
    public String toString()
    {
        return this.id + "----->" + this.name;
    }

    public static void main(String[] args)
    {
        StringEmp e = new StringEmp(1,"Kiyan");
        System.out.println(e);
    }

	/*
		before string method override the output
			D:\CoreJava\Programs>java StringEmp
				StringEmp@15db9742

			afteroverride the output is */


}

class String5
{
    public static void main(String[] args)
    {
        String a = "anu";
        String b = "anu";

        String c = new String("kiyan");
        String d = new String("kiyan");

        StringBuffer e = new StringBuffer("sasi");
        StringBuffer f = new StringBuffer("sasi");

        System.out.println(a.equals(b));
        System.out.println(c.equals(d));
        System.out.println(e.equals(f));

	/*	D:\CoreJava\Programs>java String5
		true
		true
		false*/
    }
}


class String6
{
    public static void main(String[] args)
    {
        //String to StringBuffer
        String k = "kiyan";
        StringBuffer sb = new StringBuffer(k);
        System.out.println(sb.reverse()); //StringBuffer class toString method prints content of StringBuffer Object
        // the reverse method not available in String class

        // StringBuffer to String
        StringBuffer sb1 = new StringBuffer("sasi");
        String s = sb1.toString();
        System.out.println(s); //String class toString method prints content of String Object

        String6 s6 = new String6();
        System.out.println(s6); //Object class toString method prints class-name@hashcode
        //System.out.println(s6.hashcode());

		/*
				D:\CoreJava\Programs>java String6
				kiyan
				sasi
				String6@15db9742*/

    }
}

class String7
{
    public static void main(String args[])
    {
        String a = "anu";
        String b = "Sasi";
        String c = "kiyand";

        System.out.println(a.equals(b));
        System.out.println(b.equals(c));
        System.out.println(c.equals(a));

        System.out.println(a.compareTo(b));
        System.out.println(b.compareTo(c));
        System.out.println(c.compareTo(a));

        System.out.println("KIYAN".equalsIgnoreCase(c));
        System.out.println("SASI".compareToIgnoreCase(b));

		/*
		D:\CoreJava\Programs>java String7
			false
			false
			false
			14
			-24
			10
			false
			0*/

    }
}

class String8
{
    public static void main(String args[])
    {
        int[] a = new int[100];
        System.out.println(a.length); // lenght is a variable to find lengh of size of array
        System.out.println("kck".length()); // lenght() is a method to find length of String

    }
}


class String9
{
    public static void main(String args[])
    {
        String str = "ratana";
        System.out.println(str.charAt(2));
        // System.out.println(str.charAt(20)); //SIOBE
        System.out.println(str.indexOf('a'));
        System.out.println(str.lastIndexOf('a'));

        String str1 = "00R101C55";
        System.out.println(str1.contains("101"));
        System.out.println(str1.startsWith("OOR"));
        System.out.println(str1.startsWith("00R"));
        System.out.println(str1.endsWith("C55"));

        System.out.println("kiyandoor kumar".toUpperCase());
        System.out.println("KIYANDOOR KUMAR".toLowerCase());


        String str2 = "              kck           ";
        System.out.println(str2.length());
        System.out.println(str2.trim().length());


        String str3 = "Java Kiyan";
        System.out.println(str3.substring(5));
        System.out.println(str3.substring(2,6));
        System.out.println(str3.substring(2,6).length());

        String str4 = "hi kiyan how are you";
        String[] ss = str4.split(" ");
        for(String s :ss)
        {
            System.out.println(s);
        }


    }
}


class StringTokenizer1
{
    public static void main(String[] args)
    {
        StringTokenizer str = new StringTokenizer("how are you man?"); // by default sace is separator
        while (str.hasMoreElements())
        {
            System.out.println(str.nextElement());
        }

        StringTokenizer str1 = new StringTokenizer("how are? you man?","? "); // we can specigfy our own separator
        while (str1.hasMoreElements())
        {
            System.out.println(str1.nextElement());
        }
    }
}



class Collection1
{
	public static void main(String[] args)
	{
		ArrayList al = new ArrayList();
		al.add(10);
		al.add(10.5);
		al.add("kck");
		al.add('c');
		al.add(10);
		al.add(null);
		System.out.println(al);
	}

	// for primitive data types tostring method return content
	//D:\CoreJava\Programs>java Collection1
	//[10, 10.5, kck, c, 10, null]
}

//compiler will throw below warning message due to storing different objects in the array list

//D:\CoreJava\Programs>javac Test.java
//Note: Test.java uses unchecked or unsafe operations.
//Note: Recompile with -Xlint:unchecked for details.

class CollectionEmp{
    int eid;
    String ename;

    public CollectionEmp(int id, String name) {
        this.eid = id;
        this.ename = name;
    }
}

class CollectionStud{
    int sid;
    String sname;

    public CollectionStud(int id, String name) {
        this.sid = sid;
        this.sname = sname;
    }
}



class Collection2
{
	public static void main(String[] args)
	{
		CollectionEmp e = new CollectionEmp(1,"kck");
		CollectionStud s = new CollectionStud(1001,"Ravi");
		ArrayList al = new ArrayList();
		al.add(e);
		al.add(s);
		al.add("Arjun");
		al.add(10);
		System.out.println(al);

		for (Object o: al)
		{
			if (o instanceof CollectionEmp)
			{
				CollectionEmp e1 = (CollectionEmp) o;
				System.out.println(e1.eid + "......" + e1.ename);
			}
			if (o instanceof CollectionStud)
			{
				CollectionStud s1 = (CollectionStud) o;
				System.out.println(s1.sid + "......" + s1.sname);
			}
			if (o instanceof String)
			{
				System.out.println(o);
			}
			if (o instanceof Integer)
			{
				System.out.println(o);
			}
		}
	}
}

/*   for non-premitive datatypes toString method return hashcode of object

				1/ D:\CoreJava\Programs>java Collection2
				[CollectionEmp@15db9742, CollectionStud@6d06d69c, Arjun, 10]

				2/ D:\CoreJava\Programs>java Collection2
				[CollectionEmp@15db9742, CollectionStud@6d06d69c, Arjun, 10]
				1......kck
				1001......Ravi
				Arjun
				10

*/

class Collection3
{
    public static void main(String[] args)
    {
        CollectionEmp e2 = new CollectionEmp(1,"kck1");
        CollectionEmp e3 = new CollectionEmp(2,"kck2");
        CollectionEmp e4 = new CollectionEmp(3,"kck3");
        ArrayList<CollectionEmp> al = new ArrayList<CollectionEmp>();
        al.add(e2);
        al.add(e3);
        al.add(e4);
        //al.add("Arjun"); // uncomment to see the below error message due to we applied generics to store only employee data

			/*

			D:\CoreJava\Programs>javac Test.java
					Test.java:3316: error: no suitable method found for add(String)
									al.add("Arjun");
									  ^
						method Collection.add(CollectionEmp) is not applicable
						  (argument mismatch; String cannot be converted to CollectionEmp)
						method List.add(CollectionEmp) is not applicable
						  (argument mismatch; String cannot be converted to CollectionEmp)
						method AbstractCollection.add(CollectionEmp) is not applicable
						  (argument mismatch; String cannot be converted to CollectionEmp)
						method AbstractList.add(CollectionEmp) is not applicable
						  (argument mismatch; String cannot be converted to CollectionEmp)
						method ArrayList.add(CollectionEmp) is not applicable
						  (argument mismatch; String cannot be converted to CollectionEmp)
					Note: Test.java uses unchecked or unsafe operations.
					Note: Recompile with -Xlint:unchecked for details.
					Note: Some messages have been simplified; recompile with -Xdiags:verbose to get
					full output
					1 error*/



        System.out.println(al);

        for (CollectionEmp a :al)
        {
            System.out.println(a.eid + "...." + a.ename);
        }
    }
}



class Collection4
{
    public static void main(String[] args)
    {
        CollectionEmp e1 = new CollectionEmp(1,"kck1");
        CollectionEmp e2 = new CollectionEmp(2,"kck2");
        CollectionEmp e3 = new CollectionEmp(3,"kck3");
        CollectionEmp e4 = new CollectionEmp(4,"kck4");
        CollectionEmp e5 = new CollectionEmp(5,"kck5");
        CollectionEmp e6 = new CollectionEmp(6,"kck6");
        ArrayList<CollectionEmp> al = new ArrayList<CollectionEmp>();
        ArrayList<CollectionEmp> a2 = new ArrayList<CollectionEmp>();
        al.add(e1);
        al.add(e2);
        al.add(e3);
        al.add(e4);
        System.out.println("size is:" + al.size());
        al.add(2,e5); // internally shift method will take place
        a2.addAll(al); // adding one collection data to another collection object
        System.out.println(a2.containsAll(al)); // check contains all the object of al in a2
        a2.remove(e1);
        System.out.println(a2.containsAll(al));
        System.out.println("size is:" + al.size());
        al.remove(0); // remove based on index // internally shift method will take place
        al.remove(e4);

        for (CollectionEmp a :al)
        {
            System.out.println(a.eid + "...." + a.ename);
        }

    }
}


class Collection5
{
    public static void main(String[] args)
    {
        //normal version
        ArrayList a1 = new ArrayList();
        a1.add(new CollectionEmp(1,"kck1"));
        a1.add(new CollectionEmp(2,"kck2"));
        a1.add(new CollectionEmp(3,"kck3"));

        //1st approach to retrieve data

        for (Object o :a1 )
        {
            CollectionEmp e =	(CollectionEmp) o;
            System.out.println(e.eid + "->" + e.ename);
        }

        //2nd approach
        CollectionEmp e = (CollectionEmp) a1.get(2);
        System.out.println(e.eid + "->" + e.ename);


        //1st approach to retrieve data
        ArrayList<CollectionEmp> a2 = new ArrayList<CollectionEmp>();
        a2.add(new CollectionEmp(4,"kck4"));
        a2.add(new CollectionEmp(5,"kck5"));
        a2.add(new CollectionEmp(6,"kck6"));

        for (CollectionEmp e1 :a2)
        {
            System.out.println(e1.eid + "...." + e1.ename);
        }

        //2st approach to retrieve data

        CollectionEmp e2 = a2.get(2);  // without casting we we were able to get unless in first approach
        System.out.println(e2.eid + "->" + e2.ename);

        a2.addAll(a1); // a1 will add to a2

        System.out.println("................");
        for (CollectionEmp e3 :a2)
        {
            System.out.println(e3.eid + "...." + e3.ename);
        }

        //a2.removeAll(a1); // a1 removed from a2
        System.out.println("................");
        for (CollectionEmp e3 :a2)
        {
            System.out.println(e3.eid + "...." + e3.ename);
        }

        a2.retainAll(a1); // a2 objects reomved from a1 objects
        System.out.println("................>");
        for (CollectionEmp e3 :a2)
        {
            System.out.println(e3.eid + "...." + e3.ename);
        }

    }
}

class CollectionEmpe
{
    Integer id;
    String name;

    CollectionEmpe(Integer id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public String toString()
    {
        return this.id + "<->" + this.name;
    }

}

class Collection6 // very important example
{
    public static void main(String[] args)
    {
        ArrayList<CollectionEmpe> a = new ArrayList<CollectionEmpe>();
        CollectionEmpe e1 = new CollectionEmpe(100,"kck");
        System.out.println(e1);
    }

	/*	Before overriding to string method.
		D:\CoreJava\Programs>java Collection6
		CollectionEmpe@15db9742*/

	/*	After overriding to string method // toString method exists in Object class
	    D:\CoreJava\Programs>java Collection6
		100<->kck*/

}

class Collection7
{
    public static void main(String[] args)
    {
        ArrayList<CollectionEmp> a = new ArrayList<CollectionEmp>();
        a.add(new CollectionEmp(101,"kck1"));
        a.add(new CollectionEmp(102,"kck2"));
        a.add(new CollectionEmp(103,"kck3"));
        a.add(new CollectionEmp(104,"kck4"));

        System.out.println("***Using Iterator Interface -> only forward direction*****");

        //normal version
        Iterator itr = a.iterator();
        while (itr.hasNext())
        {
            CollectionEmp k = (CollectionEmp) itr.next(); // here type casting is require even though we had used generics for ArrayList
            // this is because the method iterator() returns Iterator objects
            System.out.println(k.eid + " " + k.ename);
        }

        //generic version
        Iterator<CollectionEmp> itr1 = a.iterator();
        while (itr1.hasNext())
        {
            CollectionEmp k = itr1.next(); // here type casting is not require becuase we used generics at the Iterator level
            System.out.println(k.eid + " " + k.ename);
        }

        System.out.println("***end of Iterator Interface*****");

        System.out.println("***Using ListIterator Interface -> By-directional *****");

        ListIterator<CollectionEmp> lstr = a.listIterator();
        while (lstr.hasNext())
        {
            CollectionEmp k = lstr.next();
            System.out.println(k.eid + " " + k.ename);
        }

        while (lstr.hasPrevious())
        {
            CollectionEmp k = lstr.previous();
            System.out.println(k.eid + " " + k.ename);
        }

        System.out.println("***add data at the first and last places/reomove and update the arraylist*****");

        lstr.add(new CollectionEmp(000,"kck0")); // add data at first place and go to next cursor


        while (lstr.hasNext())
            lstr.next();
        lstr.add(new CollectionEmp(106,"kck6")); // add data at last position
        while (lstr.hasPrevious())
            lstr.previous();

        while (lstr.hasNext())
        {
            CollectionEmp k = lstr.next();
            if (k.ename.equals("kck3"))
            {
                lstr.remove();
            }
            if (k.ename.equals("kck4"))
            {
                lstr.set(new CollectionEmp(99, "kck99"));
            }
        }

        while (lstr.hasPrevious())
            lstr.previous();

        while (lstr.hasNext())
        {
            CollectionEmp k = lstr.next();
            System.out.println(k.eid + " " + k.ename);
        }


    }

//	void moveFirst(Iterator mf){while(mf.hasPrevious)mf.previous();}
//	void moveLast(Iterator mf){while(mf.hasNext)mf.Next();}
}


class ArrayToCollection
{
    public static void main(String[] args)
    {
        CollectionEmp[] k = {new CollectionEmp(10,"kck10"),new CollectionEmp(11,"kck11")};
        ArrayList<CollectionEmp> al = new ArrayList<CollectionEmp>(Arrays.asList(k));
        al.add(new CollectionEmp(12,"kck12"));
        for (CollectionEmp f : al)
        {
            System.out.println(f.eid + "<->" + f.ename);
        }
    }
}

class CollectionToArray
{
    public static void main(String[] args)
    {
        //generic version
        ArrayList<CollectionEmp> al = new ArrayList<CollectionEmp>();
        al.add(new CollectionEmp(100,"kck100"));
        al.add(new CollectionEmp(101,"kck101"));
        al.add(new CollectionEmp(102,"kck102"));
        CollectionEmp[] a1 = new CollectionEmp[al.size()];
        al.toArray(a1);
        for (CollectionEmp f :a1)
        {
            System.out.println(f.eid + "<->>" + f.ename);
        }

        //normal version
        ArrayList all = new ArrayList();
        all.add(new CollectionEmp(100,"kck100"));
        all.add(new CollectionStud(1,"k1"));
        all.add(new CollectionEmp(102,"kck102"));
        all.add("kck");
        all.add(null);
        Object[] oo = all.toArray();
        for (Object f :oo)
        {
            System.out.println(f);
        }

    }
}

class ArrayListSort
{
    public static void main(String[] args)
    {
        //generic version
        ArrayList<CollectionEmp> al = new ArrayList<CollectionEmp>();
        al.add(new CollectionEmp(105,"kck105"));
        al.add(new CollectionEmp(101,"lck101"));
        al.add(new CollectionEmp(102,"kck102"));
        //Collections.sort(al); uncomment after uncomment -> class CollectionEmp implements Comparable
        for (CollectionEmp e: al)
        {
            System.out.println(e.eid + "->" + e.ename );

        }
    }
}


class eidComparatorWoG implements Comparator
{
    public int compare(Object o1, Object o2)
    {
        CollectionEmp e1 = (CollectionEmp) o1;
        CollectionEmp e2 = (CollectionEmp) o2;
        if (e1.eid == e2.eid)
            return 0;
        else if (e1.eid > e2.eid)
            return 1;
        else
            return -1;
    }
}

class eidComparatorWG implements Comparator<CollectionEmp>
{
    public int compare(CollectionEmp e1, CollectionEmp e2)
    {
        if (e1.eid == e2.eid)
            return 0;
        else if (e1.eid > e2.eid)
            return 1;
        else
            return -1;
    }
}

class enameComparatorWoG implements Comparator
{
    public int compare(Object o1, Object o2)
    {
        CollectionEmp e1 = (CollectionEmp) o1;
        CollectionEmp e2 = (CollectionEmp) o2;
        return e1.ename.compareTo(e2.ename);
    }
}

class enameComparatorWG implements Comparator<CollectionEmp>
{
    public int compare(CollectionEmp e1, CollectionEmp e2)
    {
        return e1.ename.compareTo(e2.ename);  // use - infront for reverse order
    }
}



class ArrayListSortTwo
{
    public static void main(String[] args)
    {
        //generic version
        ArrayList<CollectionEmp> al = new ArrayList<CollectionEmp>();
        al.add(new CollectionEmp(105,"kck105"));
        al.add(new CollectionEmp(101,"lck101"));
        al.add(new CollectionEmp(102,"kck102"));
        al.add(new CollectionEmp(109,"ick109"));
        al.add(new CollectionEmp(107,"kck107"));
        //Collections.sort(al, new eidComparatorWoG());
        //Collections.sort(al, new eidComparatorWG());
        //Collections.sort(al, new enameComparatorWG());
        Collections.sort(al, new enameComparatorWG());

        for (CollectionEmp e: al)
        {
            System.out.println(e.eid + "->" + e.ename );

        }
    }
}

class HashSetOne
{
    public static void main(String[] args)
    {
        CollectionEmp e1 = new CollectionEmp(1,"k1");
        CollectionEmp e2 = new CollectionEmp(2,"k2");
        CollectionEmp e3 = new CollectionEmp(3,"k3");
        CollectionEmp e4 = new CollectionEmp(4,"k4");
        CollectionEmp e5 = new CollectionEmp(2,"k2"); // this is not same object as e2. this is new object so it is not duplicate
        CollectionEmp e6 = new CollectionEmp(2,"k6"); // this is also not duplicate

        HashSet<CollectionEmp> h = new HashSet<CollectionEmp>(); // this does not perserve insertion order and does not allow duplciates
        h.add(e1);
        h.add(e2);
        h.add(e3);
        h.add(e4);
        h.add(e5);
        h.add(e6);
        h.add(e2); // this is inserting duplicate object

        Iterator<CollectionEmp> itr = h.iterator();
        while (itr.hasNext())
        {
            CollectionEmp e = (CollectionEmp) itr.next();
            System.out.println(e.eid + "-->" + e.ename);
        }

    }
}

class LinkedHashSetOne
{
    public static void main(String[] args)
    {
        CollectionEmp e1 = new CollectionEmp(1,"k1");
        CollectionEmp e2 = new CollectionEmp(2,"k2");
        CollectionEmp e3 = new CollectionEmp(3,"k3");
        CollectionEmp e4 = new CollectionEmp(4,"k4");
        CollectionEmp e5 = new CollectionEmp(2,"k2"); // this is not same object as e2. this is new object so it is not duplicate
        CollectionEmp e6 = new CollectionEmp(2,"k6"); // this is also not duplicate

        LinkedHashSet<CollectionEmp> h = new LinkedHashSet<CollectionEmp>(); // this perserve insertion order and does not allow duplciates
        h.add(e1);
        h.add(e2);
        h.add(e3);
        h.add(e4);
        h.add(e5);
        h.add(e6);
        h.add(e2); // this is inserting duplicate object

        Iterator<CollectionEmp> itr = h.iterator();
        while (itr.hasNext())
        {
            CollectionEmp e = (CollectionEmp) itr.next();
            System.out.println(e.eid + "-->" + e.ename);
        }

    }
}

class HashSetTwo
{
    public static void main(String[] args)
    {
        CollectionEmp e1 = new CollectionEmp(1,"k1");
        CollectionEmp e2 = new CollectionEmp(2,"k2");
        CollectionEmp e3 = new CollectionEmp(3,"k3");
        CollectionEmp e4 = new CollectionEmp(4,"k4");
        CollectionEmp e5 = new CollectionEmp(2,"k2"); // this is not same object as e2. this is new object so it is not duplicate
        CollectionEmp e6 = new CollectionEmp(2,"k6"); // this is also not duplicate

        HashSet h = new HashSet(); // this does not perserve insertion order and does not allow duplciates
        h.add(e1);
        h.add(e2);
        h.add(e3);
        h.add(e4);
        h.add(e5);
        h.add(e6);
        h.add(e2); // this is inserting duplicate object
        h.add(null); // NULL is allowed inside hashmap but only once (hash set wont allow duplicate objects)
        h.add(null);

        Iterator itr = h.iterator();
        while (itr.hasNext())
        {
            Object e = (Object) itr.next();
            if (e instanceof CollectionEmp)
            {
                CollectionEmp f = (CollectionEmp) e;
                System.out.println(f.eid + "-->" + f.ename);
            }
            else
                System.out.println(e);
        }

    }
}

/*
			D:\CoreJava\Programs>java HashSetTwo
			3-->k3
			null
			2-->k6
			2-->k2
			1-->k1
			2-->k2
			4-->k4 */


class LinkedHashSetTwo
{
    public static void main(String[] args)
    {
        CollectionEmp e1 = new CollectionEmp(1,"k1");
        CollectionEmp e2 = new CollectionEmp(2,"k2");
        CollectionEmp e3 = new CollectionEmp(3,"k3");
        CollectionEmp e4 = new CollectionEmp(4,"k4");
        CollectionEmp e5 = new CollectionEmp(2,"k2"); // this is not same object as e2. this is new object so it is not duplicate
        CollectionEmp e6 = new CollectionEmp(2,"k6"); // this is also not duplicate

        LinkedHashSet h = new LinkedHashSet(); // this perserve insertion order and does not allow duplciates
        h.add(e1);
        h.add(e2);
        h.add(e3);
        h.add(e4);
        h.add(e5);
        h.add(e6);
        h.add(e2); // this is inserting duplicate object
        h.add(null); // NULL is allowed inside Linkedhashmap but only once (hash set wont allow duplicate objects)
        h.add(null);

        Iterator itr = h.iterator();
        while (itr.hasNext())
        {
            Object e = (Object) itr.next();
            if (e instanceof CollectionEmp)
            {
                CollectionEmp f = (CollectionEmp) e;
                System.out.println(f.eid + "-->" + f.ename);
            }
            else
                System.out.println(e);
        }

    }
}

class HashSetThree
{
    public static void main(String[] args)
    {
        CollectionEmp e1 = new CollectionEmp(1,"k1");
        CollectionEmp e2 = new CollectionEmp(2,"k2");
        CollectionEmp e3 = new CollectionEmp(3,"k3");

        CollectionEmp e4 = new CollectionEmp(4,"k4");
        CollectionEmp e5 = new CollectionEmp(2,"k2"); // this is not same object as e2. this is new object so it is not duplicate
        CollectionEmp e6 = new CollectionEmp(2,"k6"); // this is also not duplicate

        HashSet h = new HashSet(); // this does not perserve insertion order and does not allow duplciates
        h.add(e1);
        h.add(e2);
        h.add(e3);
        //HashSet hh = new HashSet(h); // one way to add a hash set into another hashSet. h one HashSet adds to hh Hash Set
        HashSet hh = new HashSet();
        hh.addAll(h); // another way to add a hash set into another hashSet. h one HashSet adds to hh Hash Set
        hh.add(e4);
        hh.add(e5);
        hh.add(e6);
        hh.add(e2); // this is inserting duplicate object
        hh.add(null); // NULL is allowed inside hashmap but only once (hash set wont allow duplicate objects)
        hh.add(null);

        Iterator itr = hh.iterator();
        while (itr.hasNext())
        {
            Object e = (Object) itr.next();
            if (e instanceof CollectionEmp)
            {
                CollectionEmp f = (CollectionEmp) e;
                System.out.println(f.eid + "-->" + f.ename);
            }
            else
                System.out.println(e);
        }

    }
}


class LinkedHashSetThree
{
    public static void main(String[] args)
    {
        CollectionEmp e1 = new CollectionEmp(1,"k1");
        CollectionEmp e2 = new CollectionEmp(2,"k2");
        CollectionEmp e3 = new CollectionEmp(3,"k3");

        CollectionEmp e4 = new CollectionEmp(4,"k4");
        CollectionEmp e5 = new CollectionEmp(2,"k2"); // this is not same object as e2. this is new object so it is not duplicate
        CollectionEmp e6 = new CollectionEmp(2,"k6"); // this is also not duplicate

        LinkedHashSet h = new LinkedHashSet(); // this perserve insertion order and does not allow duplciates
        h.add(e1);
        h.add(e2);
        h.add(e3);
        LinkedHashSet hh = new LinkedHashSet(h); // one way to add a hash set into another LinkedhashSet. h one HashSet adds to hh Linked Hash Set
        //LinkedHashSet hh = new LinkedHashSet();
        //hh.addAll(h); // another way to add a hash set into another hashSet. h one Linked HashSet adds to hh another Linked Hash Set
        hh.add(e4);
        hh.add(e5);
        hh.add(e6);
        hh.add(e2); // this is inserting duplicate object
        hh.add(null); // NULL is allowed inside hashmap but only once (hash set wont allow duplicate objects)
        hh.add(null);

        Iterator itr = hh.iterator();
        while (itr.hasNext())
        {
            Object e = (Object) itr.next();
            if (e instanceof CollectionEmp)
            {
                CollectionEmp f = (CollectionEmp) e;
                System.out.println(f.eid + "-->" + f.ename);
            }
            else
                System.out.println(e);
        }

    }
}

class CollectionEmp1 implements Comparable
{
    int eid;
    String ename;

    CollectionEmp1(int eid, String ename)
    {
        this.eid = eid;
        this.ename=ename;
    }

    public int compareTo(Object o)
    {
        CollectionEmp1 e = (CollectionEmp1) o;
        if (eid == e.eid)
        {
            return 0;
        }
        else if (eid > e.eid)
        {
            return 1;
        }
        else
        {
            return -1;
        }
        //return 1; // -1 will work as stack , +1 will work as arraylist and 0 will allow only first one value.

    }
}


/*class CollectionStud1 implements Comparable
{
	int sid;
	String sname;

	CollectionStud1(int sid, String sname)
	{
		this.sid = sid;
		this.sname=sname;
	}

	public int compareTo(Object o)
	{
		/*CollectionStud1 s = (CollectionStud1) o;
			if (sid == s.sid)
			{
				return 0;
			}
			else if (sid > s.sid)
			{
				return 1;
			}
			else
			{
				return -1;
			}

		return +1; // -1 will work as stack , +1 will work as arraylist and 0 will allow only first one value.

	}

	public String toString()
	{
		return this.sid + " -> " + this.sname;
	}
}*/

class TreeSetOne
{
    public static void main(String[] args)
    {
        CollectionEmp1 e1 = new CollectionEmp1(1,"k1");
        CollectionEmp1 e2 = new CollectionEmp1(2,"k2");
        CollectionEmp1 e3 = new CollectionEmp1(3,"k3");
        CollectionEmp1 e4 = new CollectionEmp1(4,"k4");
        CollectionEmp1 e5 = new CollectionEmp1(2,"k2");
        CollectionEmp1 e6 = new CollectionEmp1(2,"k6");

        TreeSet h = new TreeSet(); // first constructor
        h.add(e1);
        h.add(e2);
        h.add(e3);
        h.add(e4);
        h.add(e5);
        h.add(e6);
        h.add(e2);
        //h.add(new CollectionStud1(11,"r1")); //java.lang.ClassCastException: -> beaccuse we are inserting student object in the emp object
        // this can be doen with implementing Comparable interface in CollectionStud1 with direct return type 1,-1 or 0;
        //h.add(null); // any object comparasion with null gives null pointer exception

        Iterator itr = h.iterator();
        while (itr.hasNext())
        {
            Object e = (Object) itr.next();
            if (e instanceof CollectionEmp1)
            {
                CollectionEmp1 f = (CollectionEmp1) e;
                System.out.println(f.eid + "-->" + f.ename);
            }
            else
                System.out.println(e);
        }

    }
}




//class MyComparator implements Comparator<CollectionEmp1>
class MyComparator implements Comparator
{
    public int compare(Object e1, Object e2){
        //return e1.ename.compareTo(e2.ename);
        // return e1.eid == e2.eid > < //using elseif
        return 1;
    }
}

class TreeSetTwo
{
    public static void main(String[] args)
    {
        CollectionEmp1 e1 = new CollectionEmp1(1,"k1");
        CollectionEmp1 e2 = new CollectionEmp1(2,"k2");
        CollectionEmp1 e3 = new CollectionEmp1(3,"k3");
        CollectionEmp1 e4 = new CollectionEmp1(4,"k4");
        CollectionEmp1 e5 = new CollectionEmp1(2,"k2");
        CollectionEmp1 e6 = new CollectionEmp1(2,"k6");

        TreeSet h = new TreeSet(new MyComparator()); // second constructor
        h.add(e1);
        h.add(e2);
        h.add(e3);
        h.add(e4);
        h.add(e5);
        h.add(e6);
        h.add(e2);
        h.add(new CollectionStud(10,"r1")); //java.lang.ClassCastException: -> beaccuse we are inserting student object in the emp object
        h.add(null); // any object comparasion with null gives null pointer exception

        Iterator itr = h.iterator();
        while (itr.hasNext())
        {
            Object e = (Object) itr.next();
            if (e instanceof CollectionEmp1)
            {
                CollectionEmp1 f = (CollectionEmp1) e;
                System.out.println(f.eid + "-->" + f.ename);
            }
            else
                System.out.println(e);
        }

    }
}


class TreeSetThree
{
    public static void main(String[] args)
    {
        CollectionEmp1 e1 = new CollectionEmp1(1,"k1");
        CollectionEmp1 e2 = new CollectionEmp1(2,"k2");
        CollectionEmp1 e3 = new CollectionEmp1(3,"k3");
        CollectionEmp1 e4 = new CollectionEmp1(4,"k4");
        CollectionEmp1 e5 = new CollectionEmp1(2,"k2");
        CollectionEmp1 e6 = new CollectionEmp1(2,"k6");

        TreeSet hh = new TreeSet();
        hh.add(e3);
        hh.add(e5);
        hh.add(e2);


        //TreeSet h = new TreeSet(hh); // third constructor
        TreeSet h = new TreeSet();
        h.addAll(hh); // either one is good
        h.add(e1);
        h.add(e4);
        h.add(e6);
        h.add(e2);


        Iterator itr = h.iterator();
        while (itr.hasNext())
        {
            Object e = (Object) itr.next();
            if (e instanceof CollectionEmp1)
            {
                CollectionEmp1 f = (CollectionEmp1) e;
                System.out.println(f.eid + "-->" + f.ename);
            }
            else
                System.out.println(e);
        }

    }
}


class TreeSetFour
{
    public static void main(String[] args)
    {
        CollectionEmp1 e1 = new CollectionEmp1(1,"k1");
        CollectionEmp1 e2 = new CollectionEmp1(2,"k2");
        CollectionEmp1 e3 = new CollectionEmp1(3,"k3");
        CollectionEmp1 e4 = new CollectionEmp1(4,"k4");
        CollectionEmp1 e5 = new CollectionEmp1(2,"k2");
        CollectionEmp1 e6 = new CollectionEmp1(2,"k6");

        TreeSet h = new TreeSet();
        h.add(e1);
        h.add(e2);
        h.add(e5);
        h.add(e3);
        h.add(e4);
        h.add(e6);
        h.add(e2);

        SortedSet s = h.tailSet(e3);
        TreeSet hh = new TreeSet(s); // fourth constructor

        Iterator itr1 = hh.iterator();
        while (itr1.hasNext())
        {
            Object e = (Object) itr1.next();
            if (e instanceof CollectionEmp1)
            {
                CollectionEmp1 f = (CollectionEmp1) e;
                System.out.println(f.eid + "-->" + f.ename);
            }
            else
                System.out.println(e);
        }



        Iterator itr2 = h.headSet(e4).iterator(); // use of SortedSet in the iterator
        while (itr2.hasNext())
        {
            Object e = (Object) itr2.next();
            if (e instanceof CollectionEmp1)
            {
                CollectionEmp1 f = (CollectionEmp1) e;
                System.out.println(f.eid + "-->" + f.ename);
            }
            else
                System.out.println(e);
        }
    }
}




class TreeSetFive
{
    public static void main(String[] args)
    {
        StringBuffer e1 = new StringBuffer("Ravi");
        StringBuffer e2 = new StringBuffer("SriVijay");
        StringBuffer e3 = new StringBuffer("Arjun");
        StringBuffer e4 = new StringBuffer("Sasi");
        StringBuffer e5 = new StringBuffer("Prakash");
        StringBuffer e6 = new StringBuffer("Venky");

        TreeSet<StringBuffer> h = new TreeSet<StringBuffer>(new SBComparator());
        h.add(e1);
        h.add(e2);
        h.add(e3);
        h.add(e4);
        h.add(e5);
        h.add(e6);
        h.add(e2);

        Iterator itr = h.iterator();
        while (itr.hasNext())
        {
            StringBuffer  k = (StringBuffer) itr.next();
            System.out.println(k.toString());
        }
    }
}


class SBComparator implements Comparator<StringBuffer>
{
    public int compare(StringBuffer sb1, StringBuffer sb2)
    {
        String s1 = sb1.toString();
        String s2 = sb2.toString();
        return s1.compareTo(s2);
    }
}

class EmpId implements Comparable
{
    Integer id;
    public EmpId(Integer id)
    {
        this.id = id;
    }
    public String toString()
    {
        return this.id.toString();
    }

    public int compareTo(Object i)
    {
        EmpId id = (EmpId) i;
        if (this.id == id.id)
        {
            return 0;
        }
        else if (this.id > id.id)
        {
            return 1;
        }
        else
            return -1;
    }

}

class EmpName
{
    String name;
    public EmpName(String name)
    {
        this.name = name;
    }
    public String toString()
    {
        return this.name;
    }

}

class HashMapOne
{
    public static void main(String[] args)
    {
        HashMap h = new HashMap(); // insertion order will not preserve
        h.put(new EmpId(10), new EmpName("Ravi"));
        h.put(new EmpId(11), new EmpName("Rajesh"));
        h.put(new EmpId(12), new EmpName("Venkat"));
        h.put(new EmpId(15), new EmpName("Venky"));
        h.put(new EmpId(17), new EmpName("Sasi Kumar"));
        Set s = h.keySet(); // Gives all the key of map object and sotre in Set
        System.out.println(s);
        Collection<ArrayList> c = h.values(); // Gives all the values of map object and store in Collecction
        System.out.println(c);
        Set ss = h.entrySet(); //gives all entry of map object in the form of Set. On set we can apply iterator. there is no separate cursors for any Map Object
        System.out.println(ss);

        Iterator itr = ss.iterator();
        while (itr.hasNext())
        {
            Map.Entry m = (Map.Entry) itr.next();
            System.out.println(m.getKey() +"-"+ m.getValue());
        }

    }
}

class LinkedHashMapOne
{
    public static void main(String[] args)
    {
        LinkedHashMap h = new LinkedHashMap(); // insertion order will not preserve
        h.put(new EmpId(10), new EmpName("Ravi"));
        h.put(new EmpId(11), new EmpName("Rajesh"));
        h.put(new EmpId(12), new EmpName("Venkat"));
        h.put(new EmpId(15), new EmpName("Venky"));
        h.put(new EmpId(17), new EmpName("Sasi Kumar"));
        Set s = h.keySet(); // Gives all the key of map object and sotre in Set
        System.out.println(s);
        Collection<ArrayList> c = h.values(); // Gives all the values of map object and store in Collecction
        System.out.println(c);
        Set ss = h.entrySet(); //gives all entry of map object in the form of Set. On set we can apply iterator. there is no separate cursors for any Map Object
        System.out.println(ss);

        Iterator itr = ss.iterator();
        while (itr.hasNext())
        {
            Map.Entry m = (Map.Entry) itr.next();
            System.out.println(m.getKey() +"-"+ m.getValue());
        }

    }
}


class MapTwo // use student object employee objects very important how to get them separately
{
    public static void main(String[] args)
    {
        LinkedHashMap h = new LinkedHashMap(); // insertion order will be preserve
        h.put(new CollectionEmp(10,"KCK10"), new CollectionStud(100,"Ravi"));
        h.put(new CollectionEmp(11,"KCK11"), new CollectionStud(104,"Rajesh"));
        h.put(new CollectionEmp(12,"KCK12"), new CollectionStud(110,"Venkat"));
        h.put(new CollectionEmp(15,"KCK15"), new CollectionStud(108,"Venky"));
        h.put(new CollectionEmp(17,"KCK17"), new CollectionStud(103,"Sasi Kumar"));
        Set s = h.keySet(); // Gives all the key of map object and sotre in Set
        System.out.println(s);
        Collection<ArrayList> c = h.values(); // Gives all the values of map object and store in Collecction
        System.out.println(c);
        Set ss = h.entrySet(); //gives all entry of map object in the form of Set. On set we can apply iterator. there is no separate cursors for any Map Object
        System.out.println(ss);

        Iterator itr = ss.iterator();
        while (itr.hasNext())
        {
            Map.Entry m = (Map.Entry) itr.next();
            CollectionEmp e = (CollectionEmp) m.getKey();
            System.out.println(e.eid +"-"+ e.ename);
            CollectionStud st = (CollectionStud) m.getValue();
            System.out.println(st.sid +"-"+ st.sname);
        }

        HashMap employee = new HashMap();
        HashMap student = new HashMap();
        Iterator itr2 = ss.iterator();
        while (itr2.hasNext())
        {
            Map.Entry m = (Map.Entry) itr2.next();
            CollectionEmp e = (CollectionEmp) m.getKey();
            employee.put(e.eid,e.ename);

            CollectionStud st = (CollectionStud) m.getValue();
            student.put(st.sid,st.sname);

        }

        System.out.println(employee);
        System.out.println(student);
        employee.putAll(student);
        System.out.println(employee);

        HashMap student1 = new HashMap(student);
        student1.put("123","kck123");
        System.out.println(student1);

    }
}

class TreeMapOne
{
    public static void main(String[] args)
    {
        TreeMap h = new TreeMap();  // 1st constructor
        h.put(new EmpId(10), new EmpName("Ravi")); // Since TreeMap sorting is based on keys, Here class EmpId should implement ComparableInterface
        h.put(new EmpId(12), new EmpName("Venkat"));
        h.put(new EmpId(15), new EmpName("Venky"));
        h.put(new EmpId(11), new EmpName("Rajesh"));
        System.out.println(h);
    }
}


class TreeMapTwo
{
    public static void main(String[] args)
    {
        TreeMap h = new TreeMap();
        h.put(new EmpId(10), new EmpName("Ravi"));
        h.put(new EmpId(12), new EmpName("Venkat"));
        //TreeMap hh = new TreeMap(h);  // 3rd constructor
        TreeMap hh = new TreeMap();
        hh.put(new EmpId(15), new EmpName("Venky"));
        hh.put(new EmpId(11), new EmpName("Rajesh"));
        hh.putAll(h);
        System.out.println(h);
        System.out.println(hh);
    }
}

class myComEmp implements Comparator<EmpName>
{
    public int compare(EmpName e1, EmpName e2)
    {
        return -e1.name.compareTo(e2.name);
    }
}

class TreeMapThree
{
    public static void main(String[] args)
    {
        TreeMap hh = new TreeMap(new myComEmp());  // 2nd constructor
        hh.put(new EmpName("Venky"),new EmpId(15));
        hh.put(new EmpName("Rajesh"),new EmpId(11));
        System.out.println(hh);
    }
}

class TreeMapFour
{
    public static void main(String[] args)
    {
        TreeMap h = new TreeMap();
        h.put(new EmpId(10), new EmpName("Ravi"));
        h.put(new EmpId(12), new EmpName("Venkat"));
        EmpId k = new EmpId(15);
        h.put(k, new EmpName("Venky"));
        h.put(new EmpId(11), new EmpName("Rajesh"));
        h.put(new EmpId(19), new EmpName("Tenky"));
        System.out.println(h);
        SortedMap s = h.tailMap(k);
        System.out.println(s);
        SortedMap ss = h.headMap(k);
        System.out.println(ss);
        TreeMap hh = new TreeMap(ss); // 4th constructor
        System.out.println(hh);

    }
}

class PropertiesOne
{
    public static void main(String[] args) throws IOException
    {
        FileInputStream fis = new FileInputStream("abc.properties");

        Properties p = new Properties();
        p.load(fis);

        String k = p.getProperty("username");

        System.out.println(k);

    }
}

class EmpBean
{
    // instance variables
    private int eid;
    private String ename;


    //Setter methods. return type always void
    public void setEid(int eid)
    {
        this.eid = eid;
    }

    public void setEname(String ename)
    {
        this.ename = ename;
    }

    //getter methods. return type is based on property type. Alway zero-Argument

    public int getEid()
    {
        return eid; // alway return instance variable
    }

    public String getEname()
    {
        return ename;
    }


}

class ClientEmp
{
    public static void main(String[] args)
    {
        EmpBean eb1 = new EmpBean();
        eb1.setEid(10);
        eb1.setEname("KcK");
        int eid = eb1.getEid();
        String ename = eb1.getEname();
        System.out.println(eid);
        System.out.println(ename);


        EmpBean eb2 = new EmpBean();
        eb2.setEid(30);
        eb2.setEname("KcKcK");
        System.out.println(eb2.getEid());
        System.out.println(eb2.getEname());

    }
}

class MainOne
{
    public static strictfp final synchronized void main(String[] args)
    {
        System.out.println("Main method with all modifiers");
        float a = 10/6f;
        System.out.println(a);
    }
}


class ParentOne1
{
    public static void main(String args[])
    {
        System.out.println("Parent one Main method");
    }
}

class ChildOne1 extends ParentOne1
{

}

/*  heritance is possible for main method

		D:\CoreJava\Programs>java ParentOne1
		Parent one Main method

		D:\CoreJava\Programs>java ChildOne1
		Parent one Main method
		*/


class ChildOne2 extends ParentOne1
{
    public static void main(String args[])
    {
        System.out.println("Child one Main method");
    }
}

/*
	D:\CoreJava\Programs>java ParentOne1
	Parent one Main method

	D:\CoreJava\Programs>java ChildOne2
	Child one Main method

	*/
// we are not able to override the main method. becuase it is static method -> method hiding

class ParentOne2
{
    public static void main(String args[])
    {
        System.out.println("String Main method");
    }

    public static void main(int args[])
    {
        System.out.println("integer Main method");
    }

    public static void main(char args[])
    {
        System.out.println("char Main method");
    }
}

class ParentOne3
{
    public static void main(String args[])
    {
        main(10);
        System.out.println("String Main method");
    }

    public static void main(int a)
    {
        main('c');
        System.out.println("integer Main method");
    }

    public static void main(char c)
    {
        System.out.println("char Main method");
    }
}

class CommandLine
{
    public static void main(String... args)
    {
        System.out.println(args.length);
        for (String a :args )
        {
            System.out.println(a);
        }
    }
}

/*
		D:\CoreJava\Programs>java CommandLine 12 kiyandoor kumar bala Sasi
		5
		12
		kiyandoor
		kumar
		bala
		Sasi */


class CommandLine1
{
    public static void main(String... args)
    {
        System.out.println(args.length);
        int sum = 0;
        for (String a :args )
        {
            int k = Integer.parseInt(a);
            sum =sum + k;
        }
        System.out.println(sum);
    }
}


class SameMethod
{
    void m1(int...a) // this method accept any number of arguments and execute
    {
        for (int aa :a )
        {
            System.out.print(aa + " ");
        }
        System.out.println("kck");
    }
    public static void main(String... args)
    {
        SameMethod s = new SameMethod();
        s.m1();
        s.m1(10);
        s.m1(10,20);
        s.m1(10,20,30,20,40);
    }
}

class SameMethod1
{
    void m1(char c, int...a) // this method accept any number of arguments and execute
    {
        System.out.print(c + " ");
        for (int aa :a )
        {
            System.out.print(aa + " ");
        }
        System.out.println();
    }
    public static void main(String... args)
    {
        SameMethod1 s = new SameMethod1();
        s.m1('k');
        s.m1('a',10);
        s.m1('b',10,20);
        s.m1('c',10,20,30,20,40);
    }
}


class SameMethod2
{
    void m1(int...a)
    {
        System.out.println("Variable Argument" + a);
    }

    void m1(int a)
    {
        System.out.println("Normal Argument" + a);
    }

    public static void main(String... args)
    {
        SameMethod2 s = new SameMethod2();

        s.m1(10); // normal arugument will be executed
        s.m1(10,20); // variable argument will be executed
        s.m1(10,20,30,20,40); // variable argument will be executed
    }
}

/*
	D:\CoreJava\Programs>java SameMethod2
	Normal Argument10
	Variable Argument[I@15db9742
	Variable Argument[I@6d06d69c
	*/

class SameMethod3
{
    void m1(int...a)
    {
        for (int aa : a )
        {
            System.out.println(aa);
        }

    }

    void m1(boolean...a)
    {
        for (boolean aa : a )
        {
            System.out.println(aa);
        }

    }

    public static void main(String... args)
    {
        SameMethod3 s = new SameMethod3();
        s.m1(10,20,30,20,40);
        s.m1(true,false,true, true);
        //s.m1(); -> this creates ambiguity problem
    }
}

/*

		D:\CoreJava\Programs>javac Test.java
		Test.java:5225: error: reference to m1 is ambiguous
						s.m1();
						 ^
		  both method m1(int...) in SameMethod3 and method m1(boolean...) in SameMethod3
		 match
		Note: Test.java uses unchecked or unsafe operations.
		Note: Recompile with -Xlint:unchecked for details.
		1 error
		*/


class IOExample1
{
    public static void main(String[] args) throws IOException
    {
        FileInputStream fis = new FileInputStream("abcd.txt");
        FileOutputStream fos = new FileOutputStream("xyza.txt");

        int c;

        while ((c=fis.read())!=-1) // read method return ascii calue of each char
        {

            //System.out.print((char) 97);
            //System.out.print((char) c);
            fos.write(c);   // write method takes ascii value and return corresponding char

        }

        fis.close();
        fos.close();
    }
}

class IOExample2
{
    public static void main(String[] args) throws IOException
    {
        FileReader fis = new FileReader("xyza.txt");
        FileWriter fos = new FileWriter("kcfck.txt");

        int c;

        while ((c=fis.read())!=-1) // read method return ascii calue of each char
        {

            //System.out.print((char) 97);
            //System.out.print((char) c);
            fos.write(c);   // write method takes ascii value and return corresponding char

        }

        fis.close();
        fos.close();
    }
}

class IOExample3
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader("kcfck.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("xyzab.txt"));

        String line;

        while ((line=br.readLine())!=null) // readLine method return String of each char
        {

            System.out.println(line);
            bw.write(line);   // write method takes string value to write
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}


class IOExample4
{
    public static void main(String[] args) throws IOException
    {
        BufferedInputStream br = new BufferedInputStream(new FileInputStream("xyzab.txt"));
        BufferedOutputStream bw = new BufferedOutputStream(new FileOutputStream("1234.txt"));

        int c;

        while ((c=br.read())!=-1)  // read method return ascii calue of each char
        {
            System.out.print((char) c);
            bw.write(c);   // write method takes ascii value and return corresponding char
        }

        br.close();
        bw.close();
    }
}

class User implements Serializable
{
    int userId;
    String userName;
    transient String password;
    User(int userId, String userName, String password)
    {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
    }
}

class SerilizationProcess
{
    public static void main(String[] args) throws IOException
    {
        User u = new User(10,"Sasi", "kumar");
        new ObjectOutputStream(new FileOutputStream("sasi.txt")).writeObject(u);
        System.out.println("Serilization process completed");
    }
}


class DeSerilizationProcess
{
    public static void main(String[] args) throws Exception
    {
		/*FileInputStream fis = new FileInputStream("sasi.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);*/

        //project level usage

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("sasi.txt"));

        User i = (User) ois.readObject();
        System.out.println(i.userId);
        System.out.println(i.userName);
        System.out.println(i.password);
        System.out.println("De-Serilization process completed");

    }
}

class Outer1
{
    int a = 10;
    int b = 20;
    private int c = 11;
    private int d = 22;
    void m1()
    {
        System.out.println("outer class m1 method");
    }
    class Inner1
    {
        int x = 100;
        int y = 200;
        void m2()
        {
            System.out.println(c+d); // private variables can be accessed in inner class
            System.out.println(a+b);
            System.out.println(x+y);
            m1(); // outer class methods can be called
            System.out.println("Inner class m2 method");
        }
    }

    public static void main(String[] args)
    {
        Outer1 o = new Outer1();
        Outer1.Inner1 i = o.new Inner1();
        o.m1();
        //o.m2();   // outer class object can't access inner properties
        //i.m1();   // inner class object can't access outer properties
        i.m2();
    }
}

class Outer2
{
    int x = 10;
    int y = 20;
    void m1()
    {
        System.out.println("outer class m1 method");
    }
    class Inner2
    {
        int x = 100;
        int y = 200;
        void m2(int x, int y)
        {
            System.out.println(x+y); // local variable
            System.out.println(this.x+this.y); // inner class variables
            System.out.println(Outer2.this.x+Outer2.this.y); // outer class variables
        }
    }

    public static void main(String[] args)
    {
        Outer2 o = new Outer2();
        Outer2.Inner2 i = o.new Inner2();
        i.m2(1000, 2000);
    }
}


class Outer3
{
    void m1()
    {
        class Inner3
        {
            void m2()
            {
                System.out.println("Method local inner class");
            }
        }

        Inner3 i = new Inner3();
        i.m2();
    }

    public static void main(String[] args)
    {
        Outer3 o = new Outer3();
        o.m1();
    }
}


class Outer4
{
    void m1()
    {
        class Inner3
        {
            void m2()
            {
                System.out.println("Method local inner class class -1");
            }
        }

        Inner3 i = new Inner3();
        i.m2();
    }

    void m2()
    {
        class Inner3
        {
            void m2()
            {
                System.out.println("Method local inner class class -2");
            }
        }

        Inner3 i = new Inner3();
        i.m2();
    }

    public static void main(String[] args)
    {
        Outer4 o = new Outer4();
        o.m1();
        o.m2();
    }
}

class Outer5
{
    int a = 10;
    static int b = 200;
    static class Inner5
    {
        static void m1()
        {
            //System.out.println(a); // in-valid
            System.out.println(b); // valid
        }

        void m2()
        {
            //System.out.println(a); // in-valid static class can access only static properties
            System.out.println(b); // valid
        }
    }
    class Inner6
    {
        void m1()
        {
            System.out.println(a); // valid
            System.out.println(b); // valid
        }
    }
    public static void main(String[] args)
    {
        Outer5.Inner5 i = new Outer5.Inner5();
        i.m1();
        i.m2();

        Outer5 o = new Outer5();
        Outer5.Inner6 i1 = o.new Inner6();
        i1.m1();

    }
}

/*
		D:\CoreJava\Programs>java Outer5
		200
		200
		10
		200
		*/


// Anonymous inner classes
// example 1:
//(i) regular Way
class TestNC // pkg - 1 -> Assume this is pre-defined class
{
    void m1(){}
    void m2(){}
}

class TestNC1 extends TestNC // pkg-2 user defined logic
{
    void m1(){System.out.println("m1 method");}
    void m2(){System.out.println("m2 method");}
}

class TestClientNC1 // pkg-3 client app
{

    public static void main(String[] args)
    {
        TestNC1 t = new TestNC1();
        t.m1();
        t.m2();
    }
}

//(ii) Ananimous Way

class TestClientNC2 // pkg-3 client app
{
    TestNC t = new TestNC()
    {
        void m1()
        {
            System.out.println("m1 method");
            System.out.println(t.getClass().getName());
        }
        void m2(){System.out.println("m2 method");}
    };

    public static void main(String[] args)
    {
        TestClientNC2 tt = new TestClientNC2();
        tt.t.m1();
        tt.t.m2();

    }
}

/*
		D:\CoreJava\Programs>java TestClientNC2
		m1 method
		TestClientNC2$1
		m2 method */

// example 2:
//(i) regular way
class Thread1 // pre-defined class
{
    void run(){}
}

class Thread2 extends Thread1 // user denfined class
{
    void run(){System.out.println("run method implementation");}
}

class TestClient22  // client app
{
    public static void main(String[] args)
    {
        Thread2 t = new Thread2();
        t.run();
    }
}

//(ii)annonymous class

class TestClient33  // client app
{
    Thread1 t1 = new Thread1()
    {
        void run()
        {
            System.out.println("run method implementation");
        }
    };
    public static void main(String[] args)
    {
        TestClient33 tt = new TestClient33();
        tt.t1.run();

    }
}

//example 3: // decompile the below class .class file  to see the annonymous class implementation
interface Intf
{
    void m1();
}

class TestClient44
{
    Intf f = new Intf()
    {
        public void m1()
        {
            System.out.println("m1 method implementation");
        }
    };

    public static void main(String[] args)
    {
        TestClient44 tt = new TestClient44();
        tt.f.m1();

    }


}



// example 4 with abstract class yet to to practice


abstract class AnnonymousNestClassLast // pre defined class
{
    abstract void kck();
}

class TestClientLast
{
    // Normally we can n't create object for abstract class.
    // But here we declare object for abstract class with internal abstract method implementation
    AnnonymousNestClassLast a = new AnnonymousNestClassLast()
    {
        void kck()
        {
            System.out.println("Abstract kck method declaration");
        }
    };

    public static void main(String[] args)
    {
        TestClientLast k = new TestClientLast();
        k.a.kck();
    }

}



class Array1
{
    public static void main(String[] args)
    {
        int[] a = {1,2,3,40,500};
        //1st approach to print data
        System.out.println(a[0]);
        System.out.println(a[1]);
        System.out.println(a[2]);
        System.out.println(a[3]);
        System.out.println(a[4]);

        //2nd approach

        for (int i = 0; i< a.length; i++ )
        {
            System.out.println(a[i]);
        }

        //3rd approach
        for (int aa :a)
        {
            System.out.println(aa);
        }
    }
}

class Array2
{
    public static void main(String[] args)
    {
        // for non assingn values default values will be storied
        // for user defined class default value is null
        int[] a = new int[5];
        a[0] = 100;
        a[1] = 200;
        a[2] = 300;

        for (int aa :a)
        {
            System.out.println(aa);
        }

        boolean[] b = new boolean[3];
        b[0] = true;
        b[2] = true;
        for (boolean bb:b)
        {
            System.out.println(bb);
        }

        Array2[] a1 = new Array2[4];
        for (Array2 bb: a1)
        {
            System.out.println(bb);
        }
    }
}


class Array3
{
    public static void main(String[] args)
    {

        CollectionEmp k1 = new CollectionEmp(111, "kck1");
        CollectionEmp k2 = new CollectionEmp(222, "kck2");
        CollectionEmp k3 = new CollectionEmp(333, "kck3");

        CollectionEmp[] ce = new CollectionEmp[4];
        ce[0] = k1;
        ce[2] = k2;
        ce[3] = k3;

        for (CollectionEmp ce1 :ce)
        {
            System.out.println(ce1.eid + "->" + ce1.ename);
        }

		/*		WE GET NULL POINTER EXCEPTION WHEN WE PERFORMANY OPERTAION ON NULL OBJECT THERE ce[1] is null.
				ce[1].eid gives this error
				D:\CoreJava\Programs>java Array3
				Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 4
				at Array3.main(Test.java:5768)*/


        // to over come this user instance of variable as shown below.

        for (Object ce1 :ce)
        {
            if (ce1 instanceof CollectionEmp)
            {
                CollectionEmp cc = (CollectionEmp) ce1;
                System.out.println(cc.eid + "->" + cc.ename);
            }
            else
                System.out.println(ce1);

        }
    }
}


class Array4
{
    public static void main(String[] args)
    {

        CollectionEmp k1 = new CollectionEmp(111, "kck1");
        CollectionEmp k2 = new CollectionEmp(222, "kck2");
        CollectionEmp k3 = new CollectionEmp(333, "kck3");

        CollectionEmp[] ce = new CollectionEmp[4];
        ce[0] = k1;
        ce[2] = k2;
        ce[3] = k3;

        for (int i =0; i < ce.length; i ++)
        {
            if (ce[i] == null)
            {
                System.out.println(i);
            }
        }
    }
}


class Array5
{
    public static void main(String[] args)
    {

        CollectionEmp[] ce = new CollectionEmp[4];
        System.out.println(ce.length); // length variable on the array will return size of array
        System.out.println("kckckckckckckckkckkckckkckckcccccccccccccccc".length()); //length() method return lenth of string

    }
}

class Array6
{
    public static void main(String[] args)
    {
        CollectionEmp[] ce = {new CollectionEmp(10, "k10"),new CollectionEmp(20, "k20"),new CollectionEmp(30, "k30"),new CollectionEmp(40, "k40"),new CollectionEmp(50, "k50")};
        int sum = 0;
        for (CollectionEmp e :ce )
        {
            sum += e.eid;
        }
        System.out.println("sum value is :" + sum);
        int greater = 0;
        for (CollectionEmp e :ce)
        {
            if (greater < e.eid)
            {
                greater = e.eid;
            }
        }
        System.out.println("Greater value is :" + greater);

        int smaller = ce[0].eid;
        for (CollectionEmp e :ce)
        {
            if (smaller > e.eid)
            {
                smaller = e.eid;
            }

        }
        System.out.println("Smaller value is :" + smaller);
    }
}

class Array7
{
    public static void main(String[] args)
    {
        CollectionEmp[] ce = {new CollectionEmp(10, "k10"),new CollectionEmp(20, "k20"),new CollectionEmp(30, "k30"),new CollectionEmp(40, "k40"),new CollectionEmp(50, "k50")};
        int mainArrayLength = ce.length;
        int subArrayLength = (mainArrayLength/2)+1;
        System.out.println("main Array Length : " + mainArrayLength);
        System.out.println("sub Array Length : " + subArrayLength);
        String[] s1 = new String[subArrayLength];
        String[] s2 = new String[subArrayLength];
        int k = 0;
        int j = 0;
        for (int i=0; i<mainArrayLength; i++)
        {
            if(i%2!=0)
            {
                s1[k] = ce[i].ename;
                k++;
            }
            else
            {
                s2[j] = ce[i].ename;
                j++;
            }
        }
        for (String s :s1)
        {
            System.out.println(s);
        }
        System.out.println("***********");
        for (String s :s2)
        {
            System.out.println(s);
        }
    }
}


class Array8
{
    int[] m1()
    {
        System.out.println("m1 method");
        int[] a = {500, 200, 300, 100, 400};
        return a;
    }
    void m2(double[] k)
    {
        System.out.println("m2 method");
        for (double kk : k)
        {
            System.out.print(kk + " ,");
        }
    }
    public static void main(String[] args)
    {
        Array8 a = new Array8();
        int k[] = a.m1();
        for (int f :k)
        {
            System.out.println(f);
        }

        double[] g = {10.1, 20.2, 30.3, 40.4};
        a.m2(g);
    }
}


class Array9
{
    public static void main(String[] args)
    {			//		 0			1
        int[][] a = {{10,20,30},{40,50,60}};
        //    0  1   2   0  1  2

        System.out.println(a[1][2]); // to print 60

    }
}


class Array10
{
    public static void main(String[] args)
    {
        Object[] a = new Object[3]; // Object array can hold hetro genious data
        a[0] = new CollectionEmp(10, "kck10");
        a[1] = new CollectionStud(100, "kck100");
        a[2] = 1000;
        System.out.println(a.length);
        for (Object o : a)
        {
            if (o instanceof CollectionEmp)
            {
                CollectionEmp e = (CollectionEmp) o;
                System.out.println(e.eid + "<->" + e.ename);
            }
            if (o instanceof CollectionStud)
            {
                CollectionStud e = (CollectionStud) o;
                System.out.println(e.sid + "<->" + e.sname);
            }
            if (o instanceof Integer)
            {
                Integer e = (Integer) o;
                System.out.println(e);
            }
        }

    }
}

class GrandFather{}
class Father extends GrandFather{}
class Son extends Father{}
class Array11
{
    public static void main(String[] args)
    {
        GrandFather[] a = new GrandFather[3]; // GrandFather array can hold its child classes
        a[0] = new GrandFather();
        a[1] = new Father();
        a[2] = new Son();
        System.out.println(a[0]);
        System.out.println(a[1]);
        System.out.println(a[2]);
    }

	/*
		D:\CoreJava\Programs>java Array11
		GrandFather@15db9742
		Father@6d06d69c
		Son@7852e922*/
}


class ThreadOne
{
    public static void main(String[] args) // main Thread
    {
        System.out.println("Hello World");
        System.out.println("Hello World");
        System.out.println("Hello World");
        System.out.println("Hello World"); // main Thread Executing
        System.out.println("Hello World");
        System.out.println("Hello World");
    }									   // main Thread Ending

}



class UserDefinedThread extends Thread
{
    public void run()
    {
        for (int i = 0; i<=10 ; i++ )
        {
            System.out.println("User Defined Thread");
        }

    }
}

class ThreadTwo
{
    public static void main(String[] args)  // main thread -> one there here at this point of time
    {
        UserDefinedThread t = new UserDefinedThread();
        t.start();							// user defined thread started -> at this point we have two threads
        for (int i = 0; i<15 ; i++ )
        {
            System.out.println("Hello World");
        }
    }

}


class ThreadThree
{
    public static void main(String[] args)
    {
        UserDefinedThread t = new UserDefinedThread();
        t.run();
        for (int i = 0; i<15 ; i++ )
        {
            System.out.println("Hello World");
        }
    }

}

class UserDefinedThread1 extends Thread
{
}

class ThreadFour
{
    public static void main(String[] args)
    {
        UserDefinedThread1 t = new UserDefinedThread1();
        t.start();
        for (int i = 0; i<15 ; i++ )
        {
            System.out.println("Hello World");
        }
    }

}

class UserDefinedThread2 extends Thread
{
    public void start()			// not recommended to override the thread class strart method in userdefined thread class
    {
        for (int i = 0; i<=10 ; i++ )
        {
            System.out.println("User Defined Thread");
        }

    }
}

class ThreadFive
{
    public static void main(String[] args)
    {
        UserDefinedThread2 t = new UserDefinedThread2();
        t.start();
        for (int i = 0; i<15 ; i++ )
        {
            System.out.println("Hello World");
        }
    }

}


class UserDefinedThread3 extends Thread
{
    public void run()			// when ever overload run method it always execute zero arg run method
    {
        for (int i = 0; i<=15 ; i++ )
        {
            System.out.println("0-arg User Defined Thread");
        }

        //run(10); //include other methods here explicitly
    }

    public void run(int k)			// when ever overload run method it always execute zero arg run method
    {
        for (int i = 0; i<=k ; i++ )
        {
            System.out.println("1-arg User Defined Thread");
        }

    }
}

class ThreadSix
{
    public static void main(String[] args)
    {
        UserDefinedThread3 t = new UserDefinedThread3();
        t.start();
        for (int i = 0; i<15 ; i++ )
        {
            System.out.println("Hello World");
        }
    }

}

class UserDefinedThread4 extends Thread
{
    public void run()
    {
        m1();
        m2();
        m3();
    }

    void m1(){System.out.println("m1 method");}
    void m2(){System.out.println("m2 method");}
    void m3(){System.out.println("m3 method");}

}

class ThreadSeven
{
    public static void main(String[] args)
    {
        UserDefinedThread4 t = new UserDefinedThread4();
        t.start();
    }
}


class UserDefinedThread5 extends Thread
{
    public void run()
    {
        System.out.println("Hello Kiyan");
    }
}

class ThreadEight
{
    public static void main(String[] args)
    {
        UserDefinedThread5 t1 = new UserDefinedThread5();
        t1.start();
        UserDefinedThread5 t2 = new UserDefinedThread5();
        t2.start();
        UserDefinedThread5 t3 = new UserDefinedThread5();
        t3.start();
        UserDefinedThread5 t4 = new UserDefinedThread5();
        t4.start();
    }
}

class Thread11 extends Thread
{
    public void run()
    {
        System.out.println("Kiyan");
    }
}

class Thread22 extends Thread
{
    public void run()
    {
        System.out.println("Kiyan Kiyan");
    }
}

class Thread33 extends Thread
{
    public void run()
    {
        System.out.println("Kiyan Kiyan Kiyan");
    }
}

class Thread44 extends Thread
{
    public void run()
    {
        System.out.println("Kiyan Kiyan Kiyan Kiyan");
    }
}


class ThreadNine
{
    public static void main(String[] args)
    {
        new Thread11().start();
        new Thread22().start();
        new Thread33().start();
        new Thread44().start();

    }
}

/*
	D:\CoreJava\Programs>java ThreadNine
	Kiyan
	Kiyan Kiyan
	Kiyan Kiyan Kiyan Kiyan
	Kiyan Kiyan Kiyan*/


class Thread55 extends Thread
{
    public void run()
    {
    }
}

class ThreadTen
{
    public static void main(String[] args)
    {
        Thread55 t1 = new Thread55();
        t1.start();
        Thread55 t2 = new Thread55();
        t2.start();
        System.out.println(Thread.activeCount());
        System.out.println(t1.getName());
        System.out.println(t2.getName());
        t1.setName("Kiyan");
        System.out.println(t1.getName());
        System.out.println(Thread.currentThread().getName());
        Thread.currentThread().setName("KIAYANDOOR");
        System.out.println(Thread.currentThread().getName());
        System.out.println(t1.getId());
        System.out.println(t2.getId());
        System.out.println(t1.isAlive());

    }
}

class Thread66 extends Thread
{
    public void run()
    {
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getPriority());
    }
}

class ThreadEle
{
    public static void main(String[] args)
    {
        Thread66 t1 = new Thread66();
        Thread66 t2 = new Thread66();
        t1.setPriority(Thread.MIN_PRIORITY);  // t1.setPriority(1)
        t2.setPriority(Thread.MAX_PRIORITY);  // t1.setPriority(10)
        t1.start();
        t2.start();

		/*
				D:\CoreJava\Programs>java ThreadEle
				Thread-0
				Thread-1
				10
				1 */

        Thread66 t3 = new Thread66();
        t3.setPriority(4);
        t3.start();


    }
}

class Thread77 extends Thread
{
    public void run()
    {
        System.out.println("Hook Thread");
    }
}

class ThreadTwe
{
    public static void main(String[] args)
    {
        Thread77 t = new Thread77();
        Runtime r = Runtime.getRuntime();
        r.addShutdownHook(t);
        for (int i=0; i< 1000 ; i++ )
        {
            System.out.println("Main Thread");
            if (i==1000)
            {
                System.exit(0); // abnormal termination of JVM or user ctrl x to stop the thread
            }
        }
    }
}

class Thread88 extends Thread
{
    public void run()
    {
        for (int i = 0; i < 10 ; i++ )
        {
            System.out.println("Demon Thread");
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException ie)
            {
                ie.printStackTrace();
            }
        }
    }
}

class ThreadThirteen
{
    public static void main(String[] args)
    {
        Thread88 t = new Thread88();
        t.setDaemon(true);
        t.start();
        for (int i=0; i< 2 ; i++ )
        {
            System.out.println("Main Thread");
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException ie)
            {
                ie.printStackTrace();
            }
        }
    }
}

/*
	D:\CoreJava\Programs>java ThreadThirteen
	Main Thread
	Demon Thread
	Demon Thread
	Main Thread
	Demon Thread

	D:\CoreJava\Programs>

	Deamon thread automatically closed even it is not completely executed if main/fore groud thread closed. */


class Thread99 extends Thread
{
    public void run()
    {
        for (int i = 0; i < 5 ; i++ )
        {
            System.out.println(Thread.currentThread().getName() +"->" +i);
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException ie)
            {
                ie.printStackTrace();
            }
        }
    }
}

class ThreadFourteen
{
    public static void main(String[] args) throws InterruptedException
    {
        Thread99 t1 = new Thread99();
        Thread99 t2 = new Thread99();
        t1.start();
        t1.join(); // this statement will make to execute t1 thread first and remain lines below next. see output below
        t2.start();

        for (int i=0; i< 5 ; i++ )
        {
            System.out.println("Main Thread" + i);
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException ie)
            {
                ie.printStackTrace();
            }
        }
    }
}

/*
 		D:\CoreJava\Programs>java ThreadFourteen
		Thread-0->0
		Thread-0->1
		Thread-0->2
		Thread-0->3
		Thread-0->4
		Main Thread0
		Thread-1->0
		Main Thread1
		Thread-1->1
		Thread-1->2
		Main Thread2
		Main Thread3
		Thread-1->3
		Main Thread4
		Thread-1->4
		*/

class ThreadFiveteen
{
    public static void main(String[] args) throws InterruptedException
    {
        Thread99 t1 = new Thread99();
        Thread99 t2 = new Thread99();
        t1.start();
        t1.join(2000); // this statement will make to execute t1 thread first for 2 second after that it will complete or not remain lines below next. see output below
        t2.start();

        for (int i=0; i< 5 ; i++ )
        {
            System.out.println("Main Thread" + i);
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException ie)
            {
                ie.printStackTrace();
            }
        }
    }
}


class Thread100 extends Thread
{
    public void run()
    {
        for (int i = 0; i < 5 ; i++ )
        {   System.out.println("Thread is going to Sleeping");
            try {Thread.sleep(1000); System.out.println("Thread Sleeping");	}
            catch (InterruptedException ie)	{System.out.println("Sleeping Thread Interrupted");}
        }
    }
}


class ThreadSixteen
{
    public static void main(String[] args)
    {
        Thread100 t1 = new Thread100();
        t1.start();
        t1.interrupt(); // this statement is worth only when t1 thread went to sleep and we will interrupt and make it work
    }
}

/*

	D:\CoreJava\Programs>java ThreadSixteen
	Thread is going to Sleeping
	Sleeping Thread Interrupted  // once catch block is executed, remaining code will executed normally
	Thread is going to Sleeping
	Thread Sleeping
	Thread is going to Sleeping
	Thread Sleeping
	Thread is going to Sleeping
	Thread Sleeping
	Thread is going to Sleeping
	Thread Sleeping*/

// 2nd approach to create thread


class MyRunnable implements Runnable
{
    public void run()
    {
        for (int i = 0; i < 15 ; i ++ )
        {
            System.out.println("User Thread-1");
        }
    }
}

class ThreadSeventeen
{
    public static void main(String[] args)
    {
        MyRunnable r = new MyRunnable();
        Thread t = new Thread(r);
        t.start();

        //or

        new Thread(new MyRunnable()).start();
        for (int i = 0; i < 15 ; i ++ )
        {
            System.out.println("Main Thread");
        }

    }
}

class Eighteen // see the annonymous inner class to understand if you are not cleaar
{
    public static void main(String[] args)
    {
        Thread t1 = new Thread(){
            public void run(){
                for(int i = 0; i < 5; i++){
                    System.out.println("first thread");
                }
            }
        };

        Thread t2 = new Thread(){
            public void run(){
                for(int i = 0; i < 5; i++){
                    System.out.println("second thread");
                }
            }
        };

        t1.start();
        t2.start();

        new Thread(){
            public void run(){
                for(int i = 0; i < 5; i++){
                    System.out.println("third thread");
                }
            }
        }.start();
        // t1.start(); //java.lang.IllegalThreadStateException // if t1 is already running we get this error
    }
}

/*
	D:\CoreJava\Programs>java Eighteen
	second thread
	second thread
	second thread
	first thread
	third thread
	third thread
	second thread
	second thread
	third thread
	third thread
	third thread
	first thread
	first thread
	first thread
	first thread

	*/

class Nineteen
{
    public static void main(String[] args)
    {
        Runnable r1 = new Runnable() // using runnable interfacet annonymous class
        {
            public void run()
            {
                for(int i = 0; i < 5; i++){System.out.println("R1 Thread is running");}
            }
        };

        Runnable r2 = new Runnable()
        {
            public void run()
            {
                for(int i = 0; i < 5; i++){System.out.println("R2 Thread is running");}
            }
        };

        Thread t1 = new Thread(r1);
        t1.start();
        Thread t2 = new Thread(r2);
        t2.start();

    }

}

class TwentyA
{
    synchronized static void msg(String name) // remove synchronized keyword and the output is like counter without Q
    {
        for(int i=0; i< 10; i++)
            System.out.println("hi " + name);

    }

}

class ThreadA extends Thread
{
    public void run()
    {
        TwentyA.msg("KCK");
    }
}

class ThreadB extends Thread
{
    public void run()
    {
        TwentyA.msg("Kiyandoor");
    }
}

class ThreadC extends Thread
{
    public void run()
    {
        TwentyA.msg("kiyan");
    }
}

class ThreadD
{
    public static void main(String[] args)
    {
        new ThreadA().start();
        new ThreadB().start();
        new ThreadC().start();
    }
}


class ClassConstants
{
    public static final int COMPOSE = 1;
    public static final int INBOX = 2;
    public static final int SENT = 3;
}

enum EnumConstants
{
    COMPOSE,INBOX,SENT; //by default public static final
}

class Project
{
    static void cc(int i)
    {
        if (i == ClassConstants.COMPOSE)
        {
            System.out.println("COMPOSE operation");
        }
        else if (i == ClassConstants.INBOX)
        {
            System.out.println("INBOX operation");
        }
        else
        {
            System.out.println("SENT operation");
        }
    }

    static void ec(EnumConstants e)
    {
        if (e == EnumConstants.COMPOSE)
        {
            System.out.println("COMPOSE operation");
        }
        else if (e == EnumConstants.INBOX)
        {
            System.out.println("INBOX operation");
        }
        else
        {
            System.out.println("SENT operation");
        }
    }
}

class Enum1
{
    public static void main(String[] args)
    {
        System.out.println("=> Before 1.5 versoin");
        Project.cc(1);
        Project.cc(2);
        Project.cc(3);
        Project.cc(4); // no type safety
        System.out.println("=> From 1.5 versoin");
        Project.ec(EnumConstants.COMPOSE);
        Project.ec(EnumConstants.INBOX);
        Project.ec(EnumConstants.SENT);
        //Project.ec(EnumConstants.SENT1); //Type safety

        EnumConstants[] e = EnumConstants.values();
        for (EnumConstants ee : e )
        {
            System.out.println ( "the constant is " + ee + " => its ordinal value is " + ee.ordinal());
        }

    }
}

enum Gender
{
    MALE, FEMALE; // Semi-colon is mandatory
    Gender() // the constructor executes Constant number of times. see the output
    {System.out.println("Gender Constructor");
    }
}

class Enum2
{
    public static void main(String[] args)
    {
        System.out.println(Gender.MALE);
        System.out.println(Gender.MALE);
    }
}

/*
	D:\CoreJava\Programs>java Enum2
	Gender Constructor
	Gender Constructor
	MALE
	MALE
	*/
enum Hero
{
    BALA(1),CHIRU(2),NAG(4),VENKY(3);
    int rating;
    Hero(int rating) // one arg constructor
    {
        this.rating = rating;
        System.out.println(this + " Hero Cons => "+ this.rating);
    }
}

enum Heroin
{
    Sasi(1 , "kiyandoor", "Arjun"),Lakshmi(2, "Sudha"),Vanaja(4, "Rajesh"),Chaithu(3, "RAVI");
    int position;
    String husband;
    String son;
    Heroin(int position, String husband) // one arg constructor
    {
        this.husband = husband;
        this.position = position;
        System.out.println(this + " Heroin Cons => "+ this.husband + " Position " + this.position);
    }

    Heroin(int position, String husband, String son) // two arg constructor
    {
        this.husband = husband;
        this.position = position;
        this.son = son;
        System.out.println(this + " Heroin Cons => "+ this.husband + " Position " + this.position + " And Their Son is " + this.son);
    }
}

class Enum10
{
    public static void main(String[] args)
    {
        System.out.println(Hero.NAG);
        Hero[] h = Hero.values();
        for (Hero hh : h)
        {
            System.out.println(hh + " Rating ->" + hh.rating);
        }

        System.out.println(Heroin.Sasi);
    }
}

enum Enum4
{
    KCK;
    public static void main(String[] args)
    {
        System.out.println("ENUM Main method");
    }
}

class EnumTest
{
    enum Hero{KCK,KCR}
    public static void main(String[] args)
    {
        System.out.println(Hero.KCK);
        System.out.println(Hero.KCR);
    }
}

/*
		D:\CoreJava\Programs>java EnumTest
		KCK
		KCR
		*/

class PrivateOne
{
    private int a = 100;
    int b = 200;
}

class TestRanPrivate extends PrivateOne
{
    public static void main(String args[])
    {
        PrivateOne p = new PrivateOne();
        //System.out.println(p.a);

		/*
			D:\CoreJava\Programs>javac Test.java
				Test.java:6891: error: a has private access in PrivateOne
								System.out.println(p.a);
													^
				Note: Test.java uses unchecked or unsafe operations.
				Note: Recompile with -Xlint:unchecked for details.
				1 error
		*/
        System.out.println(p.b);
    }
}

class IdentifyIP {

    public static void main(String args[]) throws Exception {
        String myUrl = "www.gmail.com";
        InetAddress in = InetAddress.getByName(myUrl);
        System.out.println("ip address :" + in);

        URL url = new URL("http://www.gmail.com:1010/index.html");
        System.out.println(url.getProtocol());
        System.out.println(url.getPort());
        System.out.println(url.getPath());
    }
}

class client{
    public static void main(String args[]) throws IOException {
        //to write data to server
        Socket s = new Socket("localhost" , 5555);
        String myString = "Hi Kiyan";
        OutputStream os = s.getOutputStream();
        PrintStream ps = new PrintStream(os);
        ps.println(myString);

        //to read data from server
        InputStream is = s.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String str = br.readLine();
        System.out.println(str);
    }
}

class Server {
    public static void main(String args[]) throws IOException, InterruptedException {
        // to read the data from client
        ServerSocket ss = new ServerSocket(5555);
        Socket s = ss.accept();
        System.out.println("connection is created ");
        Thread.sleep(2000l);

        // read the data from client
        InputStream is = s.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String data = br.readLine();
        System.out.println(data + " from client");
        Thread.sleep(2000l);

        //write the data to the client
        data = data + " this is from server";
        OutputStream os = s.getOutputStream();
        PrintStream ps = new PrintStream(os);
        ps.println(data + " hi");
    }
}
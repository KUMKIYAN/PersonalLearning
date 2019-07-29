interface Intref{
    void m1(int a);
}

//Static method reference

public class Main {

    public static void m2(int a){
        if (a%2 == 0)
            System.out.println("true");
        else
            System.out.println("false");
    }
    public static void main(String[] args) {
        Intref m = Main::m2;
        m.m1(10);
    }
}

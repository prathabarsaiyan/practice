package main.pratha;

public class Test {

    public static void main(String[] args) {
        System.out.println("hello world");

        try {
            Float f1 = new Float("3.0");

            int a = f1.intValue();
            byte b = f1.byteValue();
            double c = f1.doubleValue();

            System.out.println(a+b+c);


            System.out.println(Double.parseDouble("7.5h"));
        }catch (NumberFormatException e){
            System.out.println("bad number");
        }
    }
}

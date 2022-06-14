package WeekOneExercisee;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello I am Huyen");
        String name = "Huyen";
        String name1 = "Huyen";
        String name2 = new String("Huyen");
        String name3 = new String("Huyen");
        System.out.println(name + " " + name1);
        System.out.println(name == name1);
        System.out.println(name == name2);
        System.out.println(name2 == name3);
        System.out.println(name.equals(name1));
        System.out.println(name.equals(name2));
        System.out.println(name2.equals(name3));
        int a = 1;
        int b = 1;
        System.out.println(a == b);
    }
}

public class Swapper<T> {
    public static <T> void doSwap(T a, T b) {
        System.out.println("Before swapping:");
        System.out.println("a: " + a);
        System.out.println("b: " + b);

        T temp = a;
        a = b;
        b = temp;

        System.out.println("After swapping:");
        System.out.println("a: " + a);
        System.out.println("b: " + b);
    }

    public static void main(String[] args) {
        Integer x = 5;
        Integer y = 10;
        System.out.println("FOR INTEGER");
        doSwap(x, y);

        String str1 = "Hello";
        String str2 = "World";
        System.out.println("\nFOR STRING");
        doSwap(str1, str2);
    }
}

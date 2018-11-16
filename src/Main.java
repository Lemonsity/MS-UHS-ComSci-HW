public class Main {

    public static void main(String[] args) {
        System.out.println(r(10));
    }
    public static int r(int n){
        if (n == 1){
            return n;
        }
        return 10 * r(n/2) + (n % 2);
    }
}

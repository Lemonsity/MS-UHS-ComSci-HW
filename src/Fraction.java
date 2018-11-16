import java.io.*;

public class Fraction {
    public static void main(String[] args) throws IOException {
        int n = inputStringToInt();
        int d = inputStringToInt();
        int greatestCommon = greatestCommon(n, d);
        n /= greatestCommon;
        d /= greatestCommon;
        if (n % d == 0) {
            if (n < 0 && d < 0)
                System.out.print(Math.abs(n) / Math.abs(d));
            else
                System.out.print(n / d);
        } else if (Math.abs(n) > Math.abs(d)) {
            if (n >= 0 && d >= 0)
                System.out.print(n / d + " " + n % d + "/" + d);
            else if ((n > 0 && d < 0) || (n < 0 && d > 0))
                System.out.print("-" + Math.abs(n / d) + " " + Math.abs(n % d) + "/" + Math.abs(d));
            else
                System.out.print(Math.abs(n / d) + " " + Math.abs(n % d) + "/" + Math.abs(d));
        } else {
            if (n < 0 && d < 0)
                System.out.print(Math.abs(n % d) + "/" + Math.abs(d));
            else
                System.out.print(n + "/" + d);
        }
    }

    public static int greatestCommon(int n, int d) {
        int smaller = Math.min(n, d);
        int larger = Math.max(n, d);
        int greatestCommon = 1;
        for (int i = 1; i <= smaller; i++) {
            if (smaller % i == 0 && larger % i == 0) {
                if (i > greatestCommon)
                    greatestCommon = i;
            }
        }
        return greatestCommon;
    }

    public static String input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }

    public static int inputStringToInt() throws IOException {
        return Integer.parseInt(input());
    }
}

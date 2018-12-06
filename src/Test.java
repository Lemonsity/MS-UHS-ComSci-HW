import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//This is a class that help me test feature of the Java language and other class specific functions
public class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        int num1 = Integer.parseInt(br.readLine());
        System.out.print(num1);
    }
}
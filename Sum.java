import java.util.ArrayList;
import java.util.Scanner;

public class raj13 {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
ArrayList<Integer> numbers = new ArrayList<>();

System.out.print("Enter the number of elements: ");
int n = scanner.nextInt();

System.out.println("Enter " + n + " integers:");
for (int i = 0; i < n; i++) {
numbers.add(scanner.nextInt()); 
}

int sum = 0;
for (Integer num : numbers) {
sum += num; 
}

System.out.println("Sum of the integers: " + sum);
scanner.close();
}
}

import java.io.*;
import java.util.Scanner;

class Person implements Serializable {
private static final long serialVersionUID = 1L; 
private String name;
private int age;

public Person(String name, int age) {
this.name = name;
this.age = age;
}
public void display() {
System.out.println("Name: " + name + ", Age: " + age);
}
}

public class raj13 {
private static final String FILE_NAME = "person_data.ser";

public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);

System.out.print("Enter name: ");
String name = scanner.nextLine();

System.out.print("Enter age: ");
int age = scanner.nextInt();

Person person = new Person(name, age);
serializeObject(person);
Person deserializedPerson = deserializeObject();
if (deserializedPerson != null) {
System.out.println("Deserialized Object Data:");
deserializedPerson.display();
}
scanner.close();
}
private static void serializeObject(Person person) {
try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
oos.writeObject(person);
System.out.println("Object serialized successfully!");
} catch (IOException e) {
e.printStackTrace();
}
}
private static Person deserializeObject() {
try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
return (Person) ois.readObject();
} catch (IOException | ClassNotFoundException e) {
e.printStackTrace();
}
return null;
}
}

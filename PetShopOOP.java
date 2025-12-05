import java.util.ArrayList;
import java.util.Scanner;


abstract class Pet {
    private String name;
    private int age;

    public Pet(String name, int age) {
        this.name = name;
        this.age = age;
    }

    
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

   
    public abstract String makeSound(); 
}


class Dog extends Pet {
    public Dog(String name, int age) {
        super(name, age);
    }
    @Override
    public String makeSound() {
        return "Bark";
    }
}


class Cat extends Pet {
    public Cat(String name, int age) {
        super(name, age);
    }
    @Override
    public String makeSound() {
        return "Meow";
    }
}

class Bird extends Pet {
    public Bird(String name, int age) {
        super(name, age);
    }
    @Override
    public String makeSound() {
        return "Chirp";
    }
}


public class PetShopOOP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Pet> pets = new ArrayList<>();

        while (true) {
            System.out.println("\n--- Pet Shop Menu ---");
            System.out.println("1. Add Dog🐶");
            System.out.println("2. Add Cat🐈");
            System.out.println("3. Add Bird🕊️");
            System.out.println("4. Show Pets");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Dog name🐶: ");
                    String dName = sc.nextLine();
                    System.out.print("Enter Dog age: ");
                    int dAge = sc.nextInt();
                    pets.add(new Dog(dName, dAge));
                    System.out.println("Dog added successfully!");
                    break;

                case 2:
                    System.out.print("Enter Cat name🐈: ");
                    String cName = sc.nextLine();
                    System.out.print("Enter Cat age: ");
                    int cAge = sc.nextInt();
                    pets.add(new Cat(cName, cAge));
                    System.out.println("Cat added successfully!");
                    break;

                case 3:
                    System.out.print("Enter Bird name🕊️: ");
                    String bName = sc.nextLine();
                    System.out.print("Enter Bird age: ");
                    int bAge = sc.nextInt();
                    pets.add(new Bird(bName, bAge));
                    System.out.println("Bird added successfully!");
                    break;

                case 4:
                    if (pets.isEmpty()) {
                        System.out.println("No pets added yet.");
                    } else {
                        System.out.println("\n--- Pet List ---");
                        for (int i = 0; i < pets.size(); i++) {
                            Pet p = pets.get(i); // Polymorphism
                            System.out.println((i + 1) + ". Name: " + p.getName() +
                                    ", Age: " + p.getAge() +
                                    ", Sound: " + p.makeSound());
                        }
                    }
                    break;

                case 5:
                    System.out.println("Exiting Pet Shop. Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
import java.util.Scanner;

class WrongAgeException extends Exception {
    public WrongAgeException(String message) {
        super(message);
    }
}

class Father {
    private int fatherAge;

    public Father(int age) throws WrongAgeException {
        if (age < 0) {
            throw new WrongAgeException("Age cannot be negative");
        }
        this.fatherAge = age;
    }

    public int getFatherAge() {
        return fatherAge;
    }
}

class Son extends Father {
    private int sonAge;

    public Son(int fatherAge, int sonAge) throws WrongAgeException {
        super(fatherAge);
        if (sonAge >= fatherAge) {
            throw new WrongAgeException("Son's age should be less than Father's age");
        }
        if (sonAge < 0) {
            throw new WrongAgeException("Age cannot be negative");
        }
        this.sonAge = sonAge;

        System.out.println("Father's Age: " + fatherAge);
        System.out.println("Son's Age: " + sonAge);
    }
}

public class Exception_Inheritance_Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter Father's Age: ");
            int fatherAge = scanner.nextInt();
            // create father (validation occurs in constructor)
            Father father = new Father(fatherAge);

            System.out.print("Enter Son's Age: ");
            int sonAge = scanner.nextInt();
            // create son (will print ages if valid)
            Son son = new Son(fatherAge, sonAge);

        } catch (WrongAgeException e) {
            System.out.println("Exception: " + e.getMessage());
        } catch (Exception e) {
            // covers non-integer input etc.
            System.out.println("Invalid input. Please enter integers.");
        } finally {
            scanner.close();
        }
    }
}

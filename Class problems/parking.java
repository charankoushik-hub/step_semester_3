import java.util.Scanner;

abstract class Vehicle {
    abstract double calculateCharge(int hours);
}

class Bike extends Vehicle {
    double calculateCharge(int hours) {
        return hours * 10;
    }
}

class Car extends Vehicle {
    double calculateCharge(int hours) {
        return 30 + (hours - 1) * 20;
    }
}

class Truck extends Vehicle {
    double calculateCharge(int hours) {
        return Math.max(100, hours * 50);
    }
}

public class Parking {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            int hours = sc.nextInt();

            Vehicle vehicle;

            if (type.equals("BIKE")) {
                vehicle = new Bike();
            } else if (type.equals("CAR")) {
                vehicle = new Car();
            } else {
                vehicle = new Truck();
            }

            double charge = vehicle.calculateCharge(hours);

            System.out.printf("%s: %.2f%n", type, charge);

            total += charge;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}

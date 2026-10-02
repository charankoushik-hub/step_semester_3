import java.util.Scanner;

abstract class Delivery {
    abstract double calculateFee(double weight, double distance, double customsFee);
}

class StandardDelivery extends Delivery {
    double calculateFee(double weight, double distance, double customsFee) {
        return 5 + (0.50 * weight) + (0.10 * distance);
    }
}

class ExpressDelivery extends Delivery {
    double calculateFee(double weight, double distance, double customsFee) {
        return 15 + (1.00 * weight) + (0.20 * distance);
    }
}

class InternationalDelivery extends Delivery {
    double calculateFee(double weight, double distance, double customsFee) {
        return 25 + (2.00 * weight) + (0.50 * distance) + customsFee;
    }
}

public class Calculator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double weight = sc.nextDouble();
            double distance = sc.nextDouble();

            double customsFee = 0;

            if (type.equals("INTERNATIONAL")) {
                customsFee = sc.nextDouble();
            }

            Delivery delivery;

            if (type.equals("STANDARD")) {
                delivery = new StandardDelivery();
            } else if (type.equals("EXPRESS")) {
                delivery = new ExpressDelivery();
            } else {
                delivery = new InternationalDelivery();
            }

            double fee = delivery.calculateFee(weight, distance, customsFee);

            System.out.printf("%s: %.2f%n", type, fee);

            total += fee;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}

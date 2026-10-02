import java.util.*;

interface PaymentMethod {
    double calculateFinalAmount(double amount);
}

class Card implements PaymentMethod {
    public double calculateFinalAmount(double amount) {
        return amount + (amount * 0.02);
    }
}

class Wallet implements PaymentMethod {
    public double calculateFinalAmount(double amount) {
        return amount + (amount * 0.01);
    }
}

class BankTransfer implements PaymentMethod {
    public double calculateFinalAmount(double amount) {
        return amount;
    }
}

class PaymentFactory {
    public static PaymentMethod getPaymentMethod(String type) {
        switch (type) {
            case "CARD":
                return new Card();
            case "WALLET":
                return new Wallet();
            case "BANKTRANSFER":
                return new BankTransfer();
            default:
                throw new IllegalArgumentException("Invalid payment type");
        }
    }
}

public class Payment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            PaymentMethod payment = PaymentFactory.getPaymentMethod(type);

            double finalAmount = payment.calculateFinalAmount(amount);

            System.out.printf("%s: %.2f%n", type, finalAmount);

            total += finalAmount;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}

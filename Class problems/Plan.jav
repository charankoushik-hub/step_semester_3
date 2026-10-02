import java.time.LocalDate;
import java.util.Scanner;

abstract class SubscriptionPlan {
    abstract int getValidityDays();

    public LocalDate getRenewalDate(LocalDate startDate) {
        return startDate.plusDays(getValidityDays());
    }
}

class BasicPlan extends SubscriptionPlan {

    int getValidityDays() {
        return 30;
    }
}

class StandardPlan extends SubscriptionPlan {

    int getValidityDays() {
        return 90;
    }
}

class PremiumPlan extends SubscriptionPlan {

    int getValidityDays() {
        return 365;
    }
}

public class Plan {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String name = sc.next();
            String date = sc.next();

            LocalDate startDate = LocalDate.parse(date);

            SubscriptionPlan plan;

            if (type.equals("BASIC")) {
                plan = new BasicPlan();
            } else if (type.equals("STANDARD")) {
                plan = new StandardPlan();
            } else {
                plan = new PremiumPlan();
            }

            LocalDate renewalDate = plan.getRenewalDate(startDate);

            System.out.println(name + ": " + renewalDate);
        }

        sc.close();
    }
}

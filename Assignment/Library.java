import java.time.LocalDate;
import java.util.*;
import java.util.function.Supplier;

abstract class LibraryItem {
    protected String title;

    LibraryItem(String title) {
        this.title = title;
    }

    abstract int getLoanPeriod();

    public LocalDate getDueDate(LocalDate currentDate) {
        return currentDate.plusDays(getLoanPeriod());
    }
}

class Book extends LibraryItem {
    Book(String title) {
        super(title);
    }

    int getLoanPeriod() {
        return 14;
    }
}

class DVD extends LibraryItem {
    DVD(String title) {
        super(title);
    }

    int getLoanPeriod() {
        return 7;
    }
}

class Magazine extends LibraryItem {
    Magazine(String title) {
        super(title);
    }

    int getLoanPeriod() {
        return 3;
    }
}

public class Library {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        LocalDate currentDate = LocalDate.of(2023, 10, 26);

        Map<String, Supplier<LibraryItem>> itemTypes = new HashMap<>();

        itemTypes.put("BOOK", () -> new Book(""));
        itemTypes.put("DVD", () -> new DVD(""));
        itemTypes.put("MAGAZINE", () -> new Magazine(""));

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();

            String[] parts = line.split(" ", 2);

            String type = parts[0];
            String title = parts[1];

            // Remove quotes
            title = title.replace("\"", "");

            LibraryItem item;

            if (type.equals("BOOK")) {
                item = new Book(title);
            } else if (type.equals("DVD")) {
                item = new DVD(title);
            } else {
                item = new Magazine(title);
            }

            LocalDate dueDate = item.getDueDate(currentDate);

            System.out.println(title + ": " + dueDate);
        }

        sc.close();
    }
}

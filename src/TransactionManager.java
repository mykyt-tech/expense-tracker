import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class TransactionManager {
    private static ArrayList<Transaction> transactions = new ArrayList<>();

    public static void addNewTransaction(String description, double amount, TransactionType type) {
        LocalDate date = LocalDate.now();
        transactions.add(new Transaction(date, description, amount, type));
    }
}

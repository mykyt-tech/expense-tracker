import java.time.LocalDate;
import java.util.ArrayList;

public class TransactionManager {
    private static ArrayList<Transaction> transactions = new ArrayList<>();

    public static void addNewTransaction(String description, double amount, TransactionType type) {
        LocalDate date = LocalDate.now();
        transactions.add(new Transaction(date, description, amount, type));
    }

    public static void addNewTransaction(LocalDate date, String description, double amount, TransactionType type) {
        transactions.add(new Transaction(date, description, amount, type));
    }

    public static ArrayList<Transaction> getTransactionHistory() {
        return new ArrayList<>(transactions);
    }

    public static Summary calculateSummary() {
        double totalIncome = 0;
        double totalExpenses = 0;
        double netBalance;

        for (Transaction t : transactions) {
            TransactionType type = t.getType();

            if (type == TransactionType.INCOME) {
                totalIncome += t.getAmount();
            } else if (type == TransactionType.EXPENSE) {
                totalExpenses += t.getAmount();
            }
        }

        netBalance = totalIncome - totalExpenses;
        return new Summary(totalIncome, totalExpenses, netBalance);
    }
}

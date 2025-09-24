import java.time.LocalDate;
import java.util.ArrayList;

public class TransactionManager {
    private static ArrayList<Transaction> transactions = new ArrayList<>();

    public static void addNewTransaction(String description, double amount, TransactionType type) {
        LocalDate date = LocalDate.now();
        transactions.add(new Transaction(date, description, amount, type));
    }

    public static ArrayList<Transaction> getTransactionHistory() {
        return new ArrayList<>(transactions);
    }

    public static Summary calculateSummary() {
        double totalIncome = 0;
        double totalExpenses = 0;
        double netBalance = 0;

        for (Transaction t : transactions) {
            TransactionType type = t.getType();
            switch (type) {
                case INCOME:
                    totalIncome += t.getAmount();
                    break;
                case EXPENSE:
                    totalExpenses += t.getAmount();
                    break;
                default:
                    System.out.println("-----------------------------");
                    System.out.println("Something went wrong");
                    System.out.println("Summary cannot be calculated");
                    return null;
            }
        }

        netBalance = totalIncome - totalExpenses;
        return new Summary(totalIncome, totalExpenses, netBalance);
    }
}

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class TrackerApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fileName = "transactions.csv";
        boolean running = true;

        readTransactionsFromFile(fileName);

        System.out.println("-----------------------------");
        System.out.println("Please choose an option:");
        System.out.println("1. Add new transaction");
        System.out.println("2. View transaction history");
        System.out.println("3. Show summary");
        System.out.println("4. Exit");
        System.out.println("-----------------------------");
        System.out.print("Enter your choice: ");

        while (running) {
            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    System.out.println("-----------------------------");
                    System.out.print("Enter a description: ");
                    String description = sc.nextLine();

                    System.out.print("Enter the amount (must be positive): ");
                    double amount = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter the type (income or expense): ");
                    String typeStr = sc.nextLine();
                    TransactionType type;

                    if (typeStr.equals("income")) {
                        type = TransactionType.INCOME;
                    } else if (typeStr.equals("expense")) {
                        type = TransactionType.EXPENSE;
                    } else {
                        System.out.println("-----------------------------");
                        System.out.println("Incorrect type!");
                        break;
                    }

                    TransactionManager.addNewTransaction(description, amount, type);
                    break;
                case 2:
                    ArrayList<Transaction> transactions = TransactionManager.getTransactionHistory();
                    System.out.println("-----------------------------");

                    for (Transaction t : transactions) {
                        System.out.println("Date: " + t.getDate() + ", description: " + t.getDescription()
                                            + ", amount: " + t.getAmount() + ", type: " + t.getType());
                    }
                    break;
                case 3:
                    Summary s = TransactionManager.calculateSummary();

                    System.out.println("-----------------------------");
                    System.out.println("Summary: ");
                    System.out.println(" - Total income: " + s.getTotalIncome());
                    System.out.println(" - Total expenses: " + s.getTotalExpenses());
                    System.out.println(" - Net balance: " + s.getNetBalance());

                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("-----------------------------");
                    System.out.println("Incorrect option!");
            }
        }

        writeTransactionsToFile(fileName);
    }

    private static void writeTransactionsToFile(String fileName) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (Transaction t : TransactionManager.getTransactionHistory()) {
                bw.write(t.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("-----------------------------");
            System.out.println("Something went wrong");
            System.out.println("Transactions cannot be saved to file");
        }
    }

    private static void readTransactionsFromFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                LocalDate date = LocalDate.parse(fields[0]);
                String description = fields[1];
                double amount = Double.parseDouble(fields[2]);
                TransactionType type = TransactionType.valueOf(fields[3]);
                TransactionManager.addNewTransaction(date, description, amount, type);
            }
        } catch (FileNotFoundException e) {
            // Do nothing
        } catch (IOException e) {
            System.out.println("-----------------------------");
            System.out.println("Something went wrong");
            System.out.println("Transactions cannot be loaded from file");
        }
    }
}
import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;

public class TrackerApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

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
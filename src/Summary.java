public class Summary {
    private final double totalIncome;
    private final double totalExpenses;
    private final double netBalance;

    public Summary(double totalIncome, double totalExpenses, double netBalance) {
        this.totalIncome = totalIncome;
        this.totalExpenses = totalExpenses;
        this.netBalance = netBalance;
    }

    public double getTotalIncome() {
        return totalIncome;
    }

    public double getTotalExpenses() {
        return totalExpenses;
    }

    public double getNetBalance() {
        return netBalance;
    }
}

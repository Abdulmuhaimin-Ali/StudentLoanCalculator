public interface A_A_LoanPayable {
    double ANNUAL_RATE_TO_MONTHLY_RATE = 1.0 / 1200.0;

    public double calculateLoanPayment(double loanAmount, double annualInterestRate, int amortizationPeriod) throws A_A_NegativeValueException;
}

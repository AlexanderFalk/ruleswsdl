package wsdl.Banks;

import wsdl.Rules.Rules;

public class Group14BankJson implements Rules {

    private static final int MIN_CREDIT_SCORE   = 275;
    private static final double MIN_LOAN_YEARS  = 2.0;
    private static final double MAX_LOAN_YEARS  = 12.0;
    private static final double MIN_LOAN_AMOUNT = 5000.0;
    private static final double MAX_LOAN_AMOUNT = 75000.0;

    @Override
    public boolean minimumCreditScore(int minCreditScore) {
        if(minCreditScore >= MIN_CREDIT_SCORE) return true;
        return false;
    }

    @Override
    public boolean loanAmount(double customerLoanAmount) {
        if(customerLoanAmount > MIN_LOAN_AMOUNT && customerLoanAmount < MAX_LOAN_AMOUNT) return true;
        return false;
    }

    @Override
    public boolean loanDuration(String customerLoanDuration) {
        if(Rules.calculateYears(customerLoanDuration, MIN_LOAN_YEARS, MAX_LOAN_YEARS)) return true;
        return false;
    }

    @Override
    public String bankName() {
        return "BankJSON";
    }
}

package wsdl.Banks;

import wsdl.Rules.Rules;

import javax.jws.WebService;

public class CPHBusinessBankJson implements Rules {

    private static final int MIN_CREDIT_SCORE   = 400;
    private static final double MIN_LOAN_YEARS  = 5.0;
    private static final double MAX_LOAN_YEARS  = 25.0;
    private static final double MIN_LOAN_AMOUNT = 50000.0;
    private static final double MAX_LOAN_AMOUNT = 1000000.0;

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
        return "CPHBusinessBankJson";
    }
}

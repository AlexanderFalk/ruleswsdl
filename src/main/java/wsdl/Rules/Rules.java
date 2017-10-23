package wsdl.Rules;


import javax.jws.WebService;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public interface Rules {
    boolean     minimumCreditScore(int minCreditScore);
    boolean     loanAmount(double customerLoanAmount);
    boolean     loanDuration(String customerLoanDuration);
    String      bankName();

    static boolean calculateYears(String customerLoanDuration, double MIN_LOAN_YEARS, double MAX_LOAN_YEARS) {
        String appliedDate = customerLoanDuration;
        double inYears;
        try {
            Date stringToDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS zzz").parse(appliedDate);

            // Converted to milliseconds
            inYears = stringToDate.getTime() / 1000 / 60 / 60 / 24 / 364.24;
            //                                  ms   sec   min  hour   days
            if(inYears < MAX_LOAN_YEARS && inYears > MIN_LOAN_YEARS) return true;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }
}

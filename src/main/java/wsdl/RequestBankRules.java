package wsdl;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@WebService
public class RequestBankRules {

    private static AssignRulesToBanks banks = new AssignRulesToBanks();

    @WebMethod
    public List<String> getBanks(int minCreditScore, double loanAmount, String customerLoanDuration) {
        return banks.bankNames(minCreditScore, loanAmount, customerLoanDuration);
    }

}

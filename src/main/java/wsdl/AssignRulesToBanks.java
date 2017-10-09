package wsdl;

import com.sun.javaws.jnl.XMLFormat;
import wsdl.Banks.CPHBusinessBankJson;
import wsdl.Banks.CPHBusinessBankXML;
import wsdl.Rules.Rules;
import java.util.ArrayList;
import java.util.List;

public class AssignRulesToBanks {

    private CPHBusinessBankXML cphBusinessBankXML = new CPHBusinessBankXML();
    private CPHBusinessBankJson cphBusinessBankJson = new CPHBusinessBankJson();

    private List<Rules> getBankRules() {
        List<Rules> banks = new ArrayList<>();
        banks.add(cphBusinessBankXML);
        banks.add(cphBusinessBankJson);
        return banks;
    }


    public List<String> bankNames(int minCreditScore, double loanAmount, String customerLoanDuration) {
        List<String> banks = new ArrayList<>();
        for(int i = 0; i < getBankRules().size(); i++) {
            if(getBankRules().get(i).minimumCreditScore(minCreditScore)
                    && getBankRules().get(i).loanAmount(loanAmount)
                    && getBankRules().get(i).loanDuration(customerLoanDuration)) {

                banks.add(getBankRules().get(i).bankName());
            }
        }

        return banks;
    }
}

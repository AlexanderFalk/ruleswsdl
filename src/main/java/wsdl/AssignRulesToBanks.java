package wsdl;

import wsdl.Banks.CPHBusinessBankJson;
import wsdl.Banks.CPHBusinessBankXML;
import wsdl.Banks.Group14BankJson;
import wsdl.Banks.Group14BankXML;
import wsdl.Rules.Rules;
import java.util.ArrayList;
import java.util.List;

public class AssignRulesToBanks {

    private CPHBusinessBankXML cphBusinessBankXML = new CPHBusinessBankXML();
    private CPHBusinessBankJson cphBusinessBankJson = new CPHBusinessBankJson();
    private Group14BankXML bankXML = new Group14BankXML();
    private Group14BankJson bankJson = new Group14BankJson();

    private List<Rules> getBankRules() {
        List<Rules> banks = new ArrayList<>();
        banks.add(cphBusinessBankXML);
        banks.add(cphBusinessBankJson);
        banks.add(bankXML);
        banks.add(bankJson);
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

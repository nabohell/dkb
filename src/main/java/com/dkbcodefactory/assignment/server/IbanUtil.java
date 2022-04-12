package com.dkbcodefactory.assignment.server;

import com.dkbcodefactory.assignment.errors.ServerException;
import org.iban4j.CountryCode;
import org.iban4j.Iban;
import java.util.Arrays;

public class IbanUtil {

   public static String generateIbanNumber(String accountNumber, String bankCode, String branch) {
        Iban iban = new Iban.Builder()
                .countryCode(CountryCode.DE)
                .bankCode(bankCode)
                .branchCode(branch)
                .accountNumber(accountNumber).build();

        return iban.toString();
    }

    public static void verifyIban(String iban) {
       org.iban4j.IbanUtil.validate(iban);
    }

    public static String generate10DigitAccountNumber(Long customerId, Integer count) {
        char[] c = new char[10];
        Arrays.fill(c, '0');

        char[] customerIdASting = (customerId.toString() + count.toString()).toCharArray();
        if(customerIdASting.length > c.length){
            throw new ServerException("Can't generate account number [" + customerId+", "+ count+ "]");
        }

        int fillIndex = c.length - customerIdASting.length;
        for(int i = 0; i < customerIdASting.length; i++)  {
            c[i + fillIndex] = customerIdASting[i];
        }
        return  new String(c);
    }
}

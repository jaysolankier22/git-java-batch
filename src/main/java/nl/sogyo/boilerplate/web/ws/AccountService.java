package nl.sogyo.boilerplate.web.ws;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import nl.sogyo.boilerplate.domain.SavingsAccount;

@WebService
public class AccountService {

	/**
	 * @param args
	 */
	@WebMethod
	public List<SavingsAccount> getAccounts() {
		List<SavingsAccount> savingsAccounts = new ArrayList<SavingsAccount>();
		SavingsAccount account1 = new SavingsAccount();
		SavingsAccount account2 = new SavingsAccount();
		SavingsAccount account3 = new SavingsAccount();
		
		savingsAccounts.add(account1);
		savingsAccounts.add(account2);
		savingsAccounts.add(account3);
		
		return savingsAccounts;
	}
}
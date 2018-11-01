package nl.sogyo.boilerplate.service;

import java.util.List;

import nl.sogyo.boilerplate.domain.SavingsAccount;

public interface AccountService {

	public List<SavingsAccount> getSavingsAccounts();
	public SavingsAccount getSavingsAccount(int accountId);
	public void createSavingsAccount(SavingsAccount savingsAccount);
	public void updateSavingsAccount(int accountId, SavingsAccount savingsAccount);
}

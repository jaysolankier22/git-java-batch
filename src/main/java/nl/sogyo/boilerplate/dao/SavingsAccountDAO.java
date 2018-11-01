package nl.sogyo.boilerplate.dao;

import java.util.List;

import nl.sogyo.boilerplate.domain.SavingsAccount;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface SavingsAccountDAO {

	public void saveSavingsAccount(SavingsAccount savingsAccount);
	public List<SavingsAccount> loadSavingsAccounts();
	public SavingsAccount getSavingsAccount(int accountId);
}

package nl.sogyo.boilerplate.service;

import java.util.List;

import nl.sogyo.boilerplate.dao.SavingsAccountDAO;
import nl.sogyo.boilerplate.domain.SavingsAccount;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

	private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);
	
	private final SavingsAccountDAO savingsAccountDAO;
	
    @Autowired
    public AccountServiceImpl(SavingsAccountDAO savingsAccountDAO) {
        this.savingsAccountDAO = savingsAccountDAO;
    }
	
	@Override
	public List<SavingsAccount> getSavingsAccounts() {
		logger.debug("getSavingsAccounts()");
		return savingsAccountDAO.loadSavingsAccounts();
	}

	@Override
	public SavingsAccount getSavingsAccount(int accountId) {
		logger.debug("getSavingsAccount()");
		SavingsAccount savingsAccount = savingsAccountDAO.getSavingsAccount(accountId);
		return savingsAccount;
	}

	@Override
	public void createSavingsAccount(SavingsAccount savingsAccount) {
		logger.debug("createSavingsAccount()");
		savingsAccountDAO.saveSavingsAccount(savingsAccount);
	}

	@Override
	public void updateSavingsAccount(int accountId, SavingsAccount savingsAccount) {
		logger.debug("createSavingsAccount()");
		savingsAccount.setAccountId(accountId);
		savingsAccountDAO.saveSavingsAccount(savingsAccount);
	}
	
}

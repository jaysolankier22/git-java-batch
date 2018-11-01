package nl.sogyo.boilerplate.dao;

import java.util.List;

import nl.sogyo.boilerplate.domain.SavingsAccount;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SavingsAccountDAOImpl implements SavingsAccountDAO {

	private static final Logger logger = LoggerFactory.getLogger(SavingsAccountDAOImpl.class);
	
	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void saveSavingsAccount(SavingsAccount savingsAccount) {
		logger.debug("saveSavingsAccount()");
		this.sessionFactory.getCurrentSession().saveOrUpdate(savingsAccount);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<SavingsAccount> loadSavingsAccounts() {
		logger.debug("loadSavingsAccounts()");
		// The type is determined by the HQL query but the interface returns an untyped list
		return this.sessionFactory.getCurrentSession().createQuery("from SavingsAccount").list();
	}

	@Override
	public SavingsAccount getSavingsAccount(int accountId) {
		logger.debug("getSavingsAccount()");
		return (SavingsAccount) this.sessionFactory.getCurrentSession().get(SavingsAccount.class, accountId);
	}
}
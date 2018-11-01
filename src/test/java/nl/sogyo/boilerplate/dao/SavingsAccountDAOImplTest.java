package nl.sogyo.boilerplate.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import nl.sogyo.boilerplate.domain.SavingsAccount;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( { "classpath:/app-config.xml" })
@Transactional
public class SavingsAccountDAOImplTest {

	private static final Logger logger = LoggerFactory.getLogger(SavingsAccountDAOImplTest.class);
	
	@Autowired
	private SessionFactory mySessionFactory;
	private Session session;
	@Autowired
    private SavingsAccountDAO dao;
		
	@Before
	public void setSession() {
		session = this.mySessionFactory.openSession();
		session.beginTransaction();
	}
	
	@After
	public void closeSession() {
		session.close();
	}
	
	@Test
	@Transactional(readOnly=false)
	public void testSaveSavingsAccount() {
		logger.trace("testSaveSavingsAccount");
		/** Setup */
		SavingsAccount savingsAccount = new SavingsAccount();
		savingsAccount.setAccountNumber("1");
		savingsAccount.setBalance(100.00);
		savingsAccount.setInterestRate(5.0);

		/** Test */
		assertEquals(0, dao.loadSavingsAccounts().size());
		//assertEquals(null, session.get(SavingsAccount.class, savingsAccount.getAccountId()));
		dao.saveSavingsAccount(savingsAccount);
		//SavingsAccount storedAccount = (SavingsAccount) session.get(SavingsAccount.class, savingsAccount.getAccountId());
		SavingsAccount storedAccount = dao.getSavingsAccount(savingsAccount.getAccountId());
		assertEquals(savingsAccount.getAccountId(), storedAccount.getAccountId());
	}

	@Test
	@Transactional(readOnly=false)
	public void testListSavingsAccountsWhenFilled() {
		logger.trace("testListSavingsAccountsWhenFilled");
		/** Test */
		SavingsAccount savingsAccount1 = new SavingsAccount();
		savingsAccount1.setAccountNumber("1");
		savingsAccount1.setBalance(100.00);
		savingsAccount1.setInterestRate(5.0);
		
		SavingsAccount savingsAccount2 = new SavingsAccount();
		savingsAccount2.setAccountNumber("2");
		savingsAccount2.setBalance(100.00);
		savingsAccount2.setInterestRate(5.0);
		
		dao.saveSavingsAccount(savingsAccount1);
		dao.saveSavingsAccount(savingsAccount2);
		//session.save(savingsAccount1);
		//session.save(savingsAccount2);
		//session.getTransaction().commit();
		
		/** Test */
		List<SavingsAccount> savingsAccounts = dao.loadSavingsAccounts();
		assertNotNull(savingsAccounts);
		assertEquals(2, savingsAccounts.size());
	}
	
	@Test
	public void testListSavingsAccountsWhenEmpty() {
		logger.trace("testListSavingsAccountsWhenEmpty");
		/** Test */
		List<SavingsAccount> savingsAccounts = dao.loadSavingsAccounts();
		assertNotNull(savingsAccounts);
		assertEquals(0, savingsAccounts.size());
	}
}

package nl.sogyo.boilerplate.domain;

import static org.junit.Assert.*;

import nl.sogyo.boilerplate.domain.SavingsAccount;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SavingsAccountTest {

	private static final Logger logger = LoggerFactory.getLogger(SavingsAccountTest.class);
	
	@Test
	public void testGetBalance() {
		logger.trace("testGetBalance");
		SavingsAccount savingsAccount = new SavingsAccount();
		savingsAccount.setAccountNumber("1234567890");
		savingsAccount.setBalance(100.00);
		
		/** Test */
		assertEquals(new Double(100.00), savingsAccount.getBalance());
	}
	
	@Test
	public void testCalculateInterest() {
		logger.trace("testCalculateInterest");
		SavingsAccount savingsAccount = new SavingsAccount();
		savingsAccount.setAccountNumber("1234567890");
		savingsAccount.setBalance(100.00);
		savingsAccount.setInterestRate(5.00);
		
		/** Test */
		assertEquals(new Double(100.00), savingsAccount.getBalance());
		savingsAccount.calculateInterest();
		assertEquals(new Double(105.00), savingsAccount.getBalance());
	}
}

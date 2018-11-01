package nl.sogyo.boilerplate;
//package nl.sogyo.example;
//
//import java.util.List;
//
//import nl.sogyo.example.dao.SavingsAccountDAO;
//import nl.sogyo.example.dao.SavingsAccountDAOImpl;
//import nl.sogyo.example.domain.SavingsAccount;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//public class MyApplication {
//
//	private static final Logger logger = LoggerFactory.getLogger(MyApplication.class);
//	
//	/**
//	 * @param args
//	 */
//	public static void main(String[] args) {
//		ApplicationContext context = new ClassPathXmlApplicationContext("app-config.xml");
//		SavingsAccountDAO dao = context.getBean("savingsAccountDAOImpl", SavingsAccountDAOImpl.class);
//		
//		SavingsAccount savingsAccount = new SavingsAccount();
//		savingsAccount.setAccountNumber("1234567890");
//		savingsAccount.setInterestRate(5.00);
//		
//		dao.saveSavingsAccount(savingsAccount);
//		
//		List<SavingsAccount> savingsAccounts = dao.listSavingsAccounts();
//		
//		logger.debug("Number of savingsAccounts found: " + savingsAccounts.size());
//	}
//
//}

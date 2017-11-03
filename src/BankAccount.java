/**
 * A bank account has a balance that can be changed by
 * deposits and withdrawals.
 * @author Julian
 */
public class BankAccount implements Measurable<BankAccount>
{
	private int accountNumber;
	private double balance;
	
	public BankAccount(double initialBalance)
	{
		balance = initialBalance;
	}
	
	/**
	 * Constructs a bank account with a given balance.
	 * @param anAccountNumber the account number for this account
	 * @param initialBalance the initial balance
	 */
	public BankAccount(int anAccountNumber, double initialBalance)
	{
		accountNumber = anAccountNumber;
		balance = initialBalance;
	}
	
	/**
	 * Gets the account number of this bank account.
	 * @return the account number
	 */
	public int getAccountNumber()
	{
		return accountNumber;
	}
	
	/**
	 * Deposits money into the bank account.
	 * @param amount the amount to deposit
	 */
	public void deposit(double amount)
	{
		double newBalance = balance + amount;
		balance = newBalance;
	}
	
	/**
	 * Withdraws money from the bank account.
	 * @param amount the amount to withdraw
	 */
	public void withdraw(double amount)
	{
		double newBalance = balance - amount;
		balance = newBalance;
	}
	
	/**
	 * Gets the current balance of the bank account.
	 * @return the current balance
	 */
	public double getBalance()
	{
		return balance;
	}
	
	/**
	 * Gets the balance of the current bank account for use with a measurable
	 * object.
	 * @return the current balance
	 */
	public double getMeasure()
	{
		return balance;
	}
}

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.awt.Rectangle;

class DataSetTest
{
	@Test
	void test00DataSetAverage()
	{
		DataSet<BankAccount> bankData = new DataSet<>();
		
		bankData.add(new BankAccount(0));
		bankData.add(new BankAccount(10000));
		bankData.add(new BankAccount(2000));
		
		double expectedAverage = 4000;
		assertEquals(expectedAverage, bankData.getAverage());
	}

	@Test
	void test01DataSetGetMaximum()
	{
		DataSet<BankAccount> bankData = new DataSet<>();
		
		BankAccount ba = new BankAccount(10000);
		
		bankData.add(new BankAccount(0));
		bankData.add(ba);
		bankData.add(new BankAccount(2000));
		
		assertEquals(ba, bankData.getMaximum());
	}

	@Test
	void test02DataSetGetMinimum()
	{
		DataSet<BankAccount> bankData = new DataSet<>();
		
		BankAccount ba = new BankAccount(0);
		
		bankData.add(ba);
		bankData.add(new BankAccount(10000));
		bankData.add(new BankAccount(2000));
		
		Measurable<BankAccount> m = ba;
		
		assertEquals(m, bankData.getMinimum());
	}

	@Test
	void test03DataSetAddAll()
	{		
		DataSet<BankAccount> bankData1 = new DataSet<>();
		
		bankData1.add(new BankAccount(0));
		bankData1.add(new BankAccount(10000));
		bankData1.add(new BankAccount(2000));
		
		DataSet<BankAccount> bankData2 = new DataSet<>();
		bankData2.addAll(bankData1);
		
		double expected = 4000;
		assertEquals(expected, bankData2.getAverage());
	}

	@Test
	void test04DataSetMeasurer()
	{
		Measurer<Rectangle> m = new RectangleMeasurer();
		DataSet<Rectangle> data = new DataSet<>(m);
		
		data.add(new Rectangle(5, 10, 20, 30));
		data.add(new Rectangle(10, 20, 30, 40));
		data.add(new Rectangle(20, 30, 5, 15));
		
		double expected = 625;
		assertEquals(expected, data.getAverage());
	}
}

package Basic;

import org.testng.Assert;
import org.testng.annotations.Test;

public class NewTest {

		@Test
		public void Sum()	
		{
			
			int a=10;
			int b=20;
			int c=a+b;
			Assert.assertEquals(30, c);
			System.out.println("SUM:"+c);
		}
		@Test
		public void div()	
		{
			
			int a=10;
			int b=20;
			int c=b-a;
			Assert.assertEquals(10, c);
			System.out.println("DIV:"+c);
		}
	}



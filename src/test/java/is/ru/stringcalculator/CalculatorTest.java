package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}	

	@Test
    public void testMultipleNumbers(){
    	assertEquals(6, Calculator.add("1,2,3"));
    }

    @Test
    public void testUnknownNumbers(){
    	assertEquals(28, Calculator.add("1,2,3,4,5,6,7"));
    }

    @Test
    public void testNewLine(){
    	assertEquals(6, Calculator.add("1\n2,3"));
    }

    @Test
    public void testDifferentDelimiter(){
    	assertEquals(3, Calculator.add("//;\n1;2"));
    }
    
    @Test
    public void testDifferentDelimiter2(){
        assertEquals(3, Calculator.add("//a\n1a2"));
    }

    @Test
    public void negativeNumberThrowsAnException(){
        try{
            Calculator.add("-3,1,4,-2");
        } catch(RuntimeException ex) {
            assertEquals("Negatives not allowed: -3,-2,", ex.getMessage());
        }
    }

    @Test
    public void testNumbersBiggerThan1000(){
        assertEquals(2, Calculator.add("1001,2"));
    }

    @Test
    public void testDelimiterOfAnyLength(){
        assertEquals(6, Calculator.add("//;;;\n1;;;2;;;3"));
    }


    //@Test
    public void testMultipleDelimiters(){
        assertEquals(6, Calculator.add("//[*][%]\n1*2%3"));
    }
}
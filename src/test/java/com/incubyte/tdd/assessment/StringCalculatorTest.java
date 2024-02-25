package com.incubyte.tdd.assessment;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class StringCalculatorTest {

	@Test
    public void testEmptyString() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(0, calculator.add(""));
    }
	
	@Test
	public void testOneNumber() {
	    StringCalculator calculator = new StringCalculator();
	    assertEquals(1, calculator.add("1"));
	}
	
	@Test
    public void testAddTwoNumbers() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(3, calculator.add("1,2"));
    }
	
	@Test
    public void testAddMultipleNumbers() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(6, calculator.add("1,2,3"));
    }
	
	@Test
    public void testAddNewLinesBetweenNumbers() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(6, calculator.add("1\n2,3"));
    }
	
	@Test
    public void testAddCustomDelimiter() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(3, calculator.add("//;\n1;2"));
    }
	
	@Test(expected = IllegalArgumentException.class)
    public void testAddNegativeNumbers() {
        StringCalculator calculator = new StringCalculator();
        calculator.add("-1,2,-3");
    }
	
}

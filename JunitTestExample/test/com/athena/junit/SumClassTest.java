package com.athena.junit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SumClassTest {
	SumClass testClass=new SumClass();

	@Test
	public void test() {
		int sum = testClass.sum(new int[]{1,2,3});
		assertEquals(6, sum);
	}

}

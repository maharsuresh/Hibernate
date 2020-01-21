package com.athena.junit;

public class SumClass {

	public int sum(int[] s) {
		int sum=0;
		for (int i : s) {
			sum+=i;
		}
		return sum;
	}
}

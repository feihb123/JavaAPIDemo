package com.datacharm.test;


import com.datacharm.util.AB;
import org.junit.Test;

import junit.framework.TestCase;

public class ABTest {

	@Test
	public void testAdd() {
		TestCase.assertEquals(AB.add(10, 10), 20);
		TestCase.assertEquals(AB.add(20, 10), 30);
		TestCase.assertEquals(AB.add(30, 10), 40);
	}

}

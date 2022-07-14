package com.lti.demo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.lti.entity.Calculator;

public class BeforeAfterTests {
	int sum;
	Calculator c = new Calculator();
	
	@BeforeAll
	public static void testDbConn() {
		System.out.println("DB is active!");
	}
	@BeforeEach
	public void testStartUp() {
		sum = 0;
		System.out.println("Sum = 0");
	}

	@Test
	public void testAdd() {
		int r = c.add(100, 200);
		Assertions.assertEquals(300, r, "Checked Add Method");
	}
	@Test
	public void testAdd2() {
		int r = c.add(100, 200);
		Assertions.assertEquals(300, r, "Checked Add Method");
	}
	@AfterEach
	public void testShutDown(){
		System.out.println("Shutdown");
	}
	
	@AfterAll
	public static void testDbNull() {
		System.out.println("DB con is Null!");
	}
}

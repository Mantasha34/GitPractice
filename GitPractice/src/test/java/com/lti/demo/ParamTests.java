package com.lti.demo;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ParamTests {

	@Disabled
	@ParameterizedTest(name="#{index}= {0}")
	@ValueSource(ints = { 8,10,12,14,16})
	public void testArrays(int arg) {
		System.out.println("arg: "+arg);
		Assertions.assertTrue(arg%2==0);
	}
	@ParameterizedTest
	@DisplayName("should pass all non-null arguments to the method")
	@ValueSource(strings = { "Hello","World"})
	public void testParam(String msg)
	{
		String searchKey = "Hello";
		Assertions.assertNotNull(msg.contains(searchKey));
	}
	
	@RepeatedTest(3)
	public void shouldRepeat() {
		int x = 10,y =20;
		Assertions.assertEquals(200,x*y);
	}

	@Test
	public void testLambda()
	{
		Integer[] intArray = {2,3,7,5,10};
		List<Integer> numbers = Arrays.asList(intArray);
		Assertions.assertAll(
				() -> assertEquals(2,numbers.get(0)),
				() -> assertEquals(3,numbers.get(1)),
				() -> assertEquals(7,numbers.get(2)),
				() -> assertEquals(5,numbers.get(3)),
				() -> assertEquals(10,numbers.get(4))
				);
	}
	@Test
	public void testExceptions() {
		Assertions.assertThrows(NumberFormatException.class,()->{Integer.parseInt("One");});
	}
}

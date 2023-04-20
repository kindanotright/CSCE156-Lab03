package unl.soc;

import org.junit.jupiter.api.Assertions;
import org.junit.rules.Timeout;

import org.junit.Rule;
import org.junit.Test;

public class DnaAnalysisTests {

	/**
	 * A 5 second global timeout rule to protect against infinite loops
	 */
	@Rule
    public Timeout globalTimeout = Timeout.seconds(5);

	/**
	 * Tests that the {@link DnaAnalysis#countSubsequences(String)} method correctly
	 * counts the number of instances of the given subsequence.
	 * 
	 */
	@Test
	public void dnaFixedTest01() {
		String sub = "gattaca";
		int expected = 0;
		int result = DnaAnalysis.countSubsequences(sub);
		Assertions.assertEquals(expected, result);
	}
	
	/**
	 * Tests that the {@link DnaAnalysis#countSubsequences(String)} method correctly
	 * counts the number of instances of the given subsequence.
	 * 
	 */
	@Test
	public void dnaFixedTest02() {
		String sub = "g";
		int expected = 305;
		int result = DnaAnalysis.countSubsequences(sub);
		Assertions.assertEquals(expected, result);
	}
	
	/**
	 * Tests that the {@link DnaAnalysis#countSubsequences(String)} method correctly
	 * counts the number of instances of the given subsequence.
	 * 
	 */
	@Test
	public void dnaixedTest03() {
		String sub = "act";
		int expected = 16;
		int result = DnaAnalysis.countSubsequences(sub);
		Assertions.assertEquals(expected, result);
	}
	
	/**
	 * Tests that the {@link DnaAnalysis#countSubsequences(String)} method correctly
	 * counts the number of instances of the given subsequence.
	 * 
	 */
	@Test
	public void dnaFixedTest04() {
		String sub = "gcg";
		int expected = 5;
		int result = DnaAnalysis.countSubsequences(sub);
		Assertions.assertEquals(expected, result);
	}
	
	/**
	 * Tests that the {@link DnaAnalysis#countSubsequences(String)} method correctly
	 * counts the number of instances of the given subsequence.
	 * 
	 */
	@Test
	public void dnaFixedTest05() {
		String sub = "agt";
		int expected = 25;
		int result = DnaAnalysis.countSubsequences(sub);
		Assertions.assertEquals(expected, result);
	}

}

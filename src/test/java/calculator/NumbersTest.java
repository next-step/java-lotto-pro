package calculator;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class NumbersTest {

	@Test
	public void sum() {
		Numbers numbers = new Numbers(new String[] {"1", "2", "3"});

		int result = numbers.sum();

		assertThat(result).isEqualTo(6);
	}
}

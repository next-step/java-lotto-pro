package calculator;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class SeparatorTest {
	@Test
	public void split_쉼표_구분자() {
		String text = "1,2";

		String[] result = Separator.split(text);

		assertThat(result).containsExactly("1", "2");
	}

	@Test
	public void split_쉼표_또는_콜론_구분자() {
		String text = "1,2:3";

		String[] result = Separator.split(text);

		assertThat(result).containsExactly("1", "2", "3");
	}

	@Test
	public void split_custom_구분자() {
		String text = "//;\n1;2;3";

		String[] result = Separator.split(text);

		assertThat(result).containsExactly("1", "2", "3");
	}
}

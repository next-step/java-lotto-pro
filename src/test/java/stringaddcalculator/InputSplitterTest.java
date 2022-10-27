package stringaddcalculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputSplitterTest {
	@DisplayName("기본 구분자 분할")
	@Test
	void splitText_defaultRegex() {
		assertThat(InputSplitter.splitText("1,2,3")).containsExactly("1", "2", "3");
		assertThat(InputSplitter.splitText("4:5:6")).containsExactly("4", "5", "6");
	}

	@DisplayName("커스텀 구분자 분할")
	@Test
	void splitText_customRegex() {
		assertThat(InputSplitter.splitText("//#\n1#2#3")).containsExactly("1", "2", "3");
		assertThat(InputSplitter.splitText("//~\n4~5~6")).containsExactly("4", "5", "6");
	}
}

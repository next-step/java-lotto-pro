package lotto.util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InputSplitterTest {
	@Test
	void splitText_쉼표_분할() {
		assertThat(InputSplitter.splitText("1, 2, 3, 4")).containsExactly("1", "2", "3", "4");
	}

	@Test
	void splitTxt_공백_무시_쉼표_분할() {
		assertThat(InputSplitter.splitText("1,2,3,4")).containsExactly("1", "2", "3", "4");
	}
}

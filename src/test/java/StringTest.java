import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StringTest {
	@Test
	void splitTest(){
		String[] stringArray = "1,2".split(",");
		String[] stringOtherArray = "1".split(",");

		assertThat(stringArray).contains("1","2");
		assertThat(stringArray).containsExactly("1","2");
		assertThat(stringArray).containsOnly("2", "1");

		assertThat(stringOtherArray).contains("1");
		assertThat(stringOtherArray).containsExactly("1");
		assertThat(stringOtherArray).containsOnly("1");
	}

	@Test
	void removeBracketTest(){
		String string = "(1,2)".substring(1,4);
		assertThat(string).isEqualTo("1,2");
	}
}

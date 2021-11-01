package study;

import static org.assertj.core.api.Assertions.*;

import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

public class OtherTest {


	@Test
	public void class_assertion_test() throws Exception {
		assertThat(Runnable.class).isInterface();
	}

	@Test
	public void character_test() throws Exception {
		assertThat('c')
			.isNotEqualTo('a')
			.inUnicode()
			.isGreaterThanOrEqualTo('b')
			.isLowerCase();
	}

	@Test
	public void file_test() throws Exception {
	    assertThat(Paths.get("src/test/java/empty.txt").toFile())
			.exists()
			.isFile()
			.canRead().canWrite();
	}
}

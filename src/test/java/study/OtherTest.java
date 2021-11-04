package study;

import static org.assertj.core.api.Assertions.*;

import java.nio.file.Paths;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OtherTest {

	@Test
	@DisplayName("클래스 판별 테스트")
	public void classAssertion() {
		assertThat(Runnable.class).isInterface();
	}

	@Test
	@DisplayName("'c'가 유니코드이고 'a'가 아니며 'b' 보다 같거나 큰지 확인 성공")
	public void characterAssertion() {
		assertThat('c')
			.isNotEqualTo('a')
			.inUnicode()
			.isGreaterThanOrEqualTo('b')
			.isLowerCase();
	}

	@Test
	@DisplayName("empty.txt 파일이 있고 읽기,쓰기가 가능한자 확인 성공")
	public void fileAssertion() {
		assertThat(Paths.get("src/test/java/empty.txt").toFile())
			.exists()
			.isFile()
			.canRead().canWrite();
	}
}

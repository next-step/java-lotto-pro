import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
	@Test
	@DisplayName("1,2을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인")
	public void test() {
		String[] underTest = "1,2".split(",");

		assertThat(underTest).contains("1", "2");
	}


}

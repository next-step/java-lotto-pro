package step2.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberListTest {
	@Test
	@DisplayName("합계 구하기")
	void getSumOfNumberList() {
		List<NumberElement> numberElementList = new ArrayList<>(Arrays.asList(
			new NumberElement(1),
			new NumberElement(2),
			new NumberElement(3)
			));
		NumberList numberList = new NumberList(numberElementList);
		assertThat(numberList.getSum()).isEqualTo(6);
	}
}

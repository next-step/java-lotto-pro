package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumbersTest {
	private List<LottoNumber> lottoNumbers;

	@BeforeEach
	void setUp() {
		lottoNumbers = new ArrayList<>();
		lottoNumbers.add(new LottoNumber(43));
		lottoNumbers.add(new LottoNumber(31));
		lottoNumbers.add(new LottoNumber(1));
		lottoNumbers.add(new LottoNumber(16));
		lottoNumbers.add(new LottoNumber(10));
		lottoNumbers.add(new LottoNumber(22));
	}

	@Test
	@DisplayName("List의 크기가 6보다 작은 경우 예외 테스트")
	void create_lottoNumbers_size_down_예외() {
		lottoNumbers.remove(0);
		assertThrows(IllegalArgumentException.class, () -> new LottoNumbers(lottoNumbers));
	}

	@Test
	@DisplayName("List의 크기가 6보다 큰 경우 예외 테스트")
	void create_lottoNumbers_size_over_예외() {
		lottoNumbers.add(new LottoNumber(17));
		assertThrows(IllegalArgumentException.class, () -> new LottoNumbers(lottoNumbers));
	}

	@Test
	@DisplayName("중복된 값이 제거되었을 때 사이즈가 6이 아닌경우 예외 테스트")
	void create_lottoNumbers_distinct_예외() {
		lottoNumbers.remove(0);
		lottoNumbers.add(new LottoNumber(22));
		assertThrows(IllegalArgumentException.class, () -> new LottoNumbers(lottoNumbers));
	}

	@Test
	@DisplayName("List의 크기가 6인 lotto생성")
	void create_lottoNumbers() {
		lottoNumbers.remove(0);
		lottoNumbers.add(new LottoNumber(17));
		assertThat(new LottoNumbers(lottoNumbers).getLottoNumbers()).hasSize(6);
	}

	@Test
	@DisplayName("lottonumber 배열로 List의 크기가 6인 lotto생성")
	void create_lottonumbers_lottoNumbers() {
		LottoNumber[] LottoNumbers2 = { new LottoNumber(43), new LottoNumber(31), new LottoNumber(1),
				new LottoNumber(16), new LottoNumber(10), new LottoNumber(22) };
		assertThat(new LottoNumbers(LottoNumbers2).getLottoNumbers()).hasSize(6);
	}

	@Test
	@DisplayName("string으로 List의 크기가 6인 lotto생성")
	void create_string_lottoNumbers() {
		assertThat(new LottoNumbers("43, 31, 1, 16, 10, 22").getLottoNumbers()).hasSize(6);
	}

	@Test
	@DisplayName("당첨여부를 확인하는 테스트")
	void test() {
		List<LottoNumber> LottoNumbers2 = new ArrayList<>();
		LottoNumbers2.add(new LottoNumber(43));
		LottoNumbers2.add(new LottoNumber(31));
		LottoNumbers2.add(new LottoNumber(1));
		LottoNumbers2.add(new LottoNumber(16));
		LottoNumbers2.add(new LottoNumber(10));
		LottoNumbers2.add(new LottoNumber(21));
		assertEquals(new LottoNumbers(lottoNumbers).countEqualsLottoNumber(new LottoNumbers(LottoNumbers2)), 5);
	}
}

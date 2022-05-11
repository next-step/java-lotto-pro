package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumbersTest {
	private List<LottoNumber> LottoNumbers;

	@BeforeEach
	void setUp() {
		LottoNumbers = new ArrayList<>();
		LottoNumbers.add(new LottoNumber(43));
		LottoNumbers.add(new LottoNumber(31));
		LottoNumbers.add(new LottoNumber(1));
		LottoNumbers.add(new LottoNumber(16));
		LottoNumbers.add(new LottoNumber(10));
		LottoNumbers.add(new LottoNumber(22));
	}

	@Test
	@DisplayName("List의 크기가 6보다 작은 경우 예외 테스트")
	void create_lottoNumbers_size_down_예외(){
		LottoNumbers.remove(0);
        assertThrows(IllegalArgumentException.class, () -> new LottoNumbers(LottoNumbers));
	}
	
	@Test
	@DisplayName("List의 크기가 6보다 큰 경우 예외 테스트")
	void create_lottoNumbers_size_over_예외(){
		LottoNumbers.add(new LottoNumber(17));
        assertThrows(IllegalArgumentException.class, () -> new LottoNumbers(LottoNumbers));
	}
	
	@Test
	@DisplayName("중복된 값이 제거되었을 때 사이즈가 6이 아닌경우 예외 테스트")
	void create_lottoNumbers_distinct_예외(){
		LottoNumbers.remove(0);
		LottoNumbers.add(new LottoNumber(22));
        assertThrows(IllegalArgumentException.class, () -> new LottoNumbers(LottoNumbers));
	}
	
	@Test
	@DisplayName("List의 크기가 6인 lotto생성")
	void create_lottoNumbers(){
		LottoNumbers.remove(0);
		LottoNumbers.add(new LottoNumber(17));
		assertThat(new LottoNumbers(LottoNumbers).getLottoNumbers()).hasSize(6);
	}
}

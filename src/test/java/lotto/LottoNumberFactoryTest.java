package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.LottoNumberFactory;

class LottoNumberFactoryTest {

	@Test
	@DisplayName("로또번호 6개 생성 확인 테스트")
	public void createLottoNumberTest() {
		//given
		//when
		List<Integer> numbers = LottoNumberFactory.create();
		//then
		assertThat(numbers).hasSize(6);
	}
	
	@Test
	@DisplayName("로또번호 중복 여부 확인 테스트")
	public void validateDuplicateLottoNumberTest() {
		//given
		List<Integer> numbers = LottoNumberFactory.create();
		//when
		List<Integer> distinctNumbers = numbers.stream().distinct().collect(Collectors.toList());
		//then
		assertThat(distinctNumbers).hasSize(6);
	}
}
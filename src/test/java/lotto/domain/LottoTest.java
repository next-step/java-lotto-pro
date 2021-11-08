package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class LottoTest {

	@DisplayName("번호가 6개인 로또 생성")
	@Test
	void validLotto() {
		Set<LottoNumber> lottoNumbers = IntStream.range(1, 7)
			.mapToObj(LottoNumber::new)
			.collect(Collectors.toSet());
		Lotto lotto = new Lotto(lottoNumbers);

		assertThat(lotto).isEqualTo(new Lotto(lottoNumbers));
	}

	@DisplayName("중복된 로또 번호 확인")
	@Test
	void invalidLotto() {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> {
				Set<LottoNumber> lottoNumbers = Arrays.asList(1, 1, 3, 4, 5, 6).stream()
					.map(LottoNumber::new)
					.collect(Collectors.toSet());

				Lotto lotto = new Lotto(lottoNumbers);
			}).withMessageMatching("중복되지 않은 6개의 숫자를 입력해주세요.");
	}

	@DisplayName("두개의 로또 번호 비교를 통한 순위 반환")
	@ParameterizedTest
	@EnumSource(names = {"FIRST_PLACE"})
	void lottoMatch(Rank rank) {
		Set<LottoNumber> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6).stream()
			.map(LottoNumber::new)
			.collect(Collectors.toSet());
		Lotto stamdardLotto = new Lotto(lottoNumbers);
		Lotto lotto = new Lotto(lottoNumbers);

		Rank returnRank = stamdardLotto.match(lotto);

		assertThat(returnRank).isEqualTo(rank);
	}

}

package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class LottoTest {

	@DisplayName("번호가 6개인 로또 생성")
	@Test
	void validLotto() {
		Set<LottoNumber> lottoNumbers = IntStream.range(1, 7)
			.mapToObj(LottoNumber::of)
			.collect(Collectors.toSet());
		Lotto lotto = new Lotto(lottoNumbers);

		assertThat(lotto).isEqualTo(new Lotto(lottoNumbers));
	}

	@DisplayName("중복된 로또 번호 확인")
	@Test
	void invalidLotto() {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> {
				Set<LottoNumber> lottoNumbers = Stream.of(1, 1, 3, 4, 5, 6)
					.map(LottoNumber::of)
					.collect(Collectors.toSet());

				new Lotto(lottoNumbers);
			}).withMessageMatching("중복되지 않은 6개의 숫자를 입력해 주세요.");
	}

	@DisplayName("두개의 로또 번호 비교를 통한 순위 반환")
	@ParameterizedTest
	@EnumSource(names = {"FIRST"})
	void lottoMatch(Rank rank) {
		Set<LottoNumber> lottoNumbers = Stream.of(1, 2, 3, 4, 5, 6)
			.map(LottoNumber::of)
			.collect(Collectors.toSet());
		Lotto stamdardLotto = new Lotto(lottoNumbers);
		Lotto lotto = new Lotto(lottoNumbers);

		Rank returnRank = stamdardLotto.match(lotto, LottoNumber.of(10));

		assertThat(returnRank).isEqualTo(rank);
	}

}

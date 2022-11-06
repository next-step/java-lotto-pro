package lotto.reader;

import static org.assertj.core.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.LottoNumbers;

@DisplayName("번호 reader 테스트")
class NumberReaderTest {

	@Test
	@DisplayName("번호 반환")
	void read() {
		LottoNumbers lottoNumbers = LottoNumbers.from(Set.of(1, 2, 3, 4, 5, 6));
		NumberReader<LottoNumbers> lottoNumbersNumberReader = () -> lottoNumbers;
		LottoNumbers actualLottoNumbers = lottoNumbersNumberReader.read();
		assertThat(actualLottoNumbers).isEqualTo(lottoNumbers);
	}
}
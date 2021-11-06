package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

	private ArrayList<LottoNumber> winningNumbers;
	private WinningLotto winningLotto;


	@BeforeEach
	void setUp() {
		winningNumbers = new ArrayList<>(
			Arrays.asList(10, 11, 12, 13, 14, 15)
				.stream()
				.map(LottoNumber::new)
				.collect(Collectors.toList())
		);
		winningLotto = new WinningLotto(winningNumbers);
	}

	@Test
	public void 로또_당첨_번호_생성() {
		assertThat(winningLotto).isEqualTo(new WinningLotto(winningNumbers));
	}

	@Test
	public void 로또_순위_반환() {
		List<LottoNumber> lottoNumber = new ArrayList<>(
			Arrays.asList(1, 2, 13, 14, 15, 45)
				.stream()
				.map(LottoNumber::new)
				.collect(Collectors.toList())
		);
		Lotto lotto = new Lotto(lottoNumber);

		Rank rank = winningLotto.match(lotto);

		assertThat(rank).isEqualTo(Rank.FOURTH_PLACE);
	}
}

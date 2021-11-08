package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

public class WinningRecordTest {
	private List<Rank> ranks;
	private WinningRecord lottoRecord;

	@BeforeEach
	void setUp() {
		ranks = new ArrayList<>();
		ranks.add(Rank.FOURTH_PLACE);
		ranks.add(Rank.FOURTH_PLACE);
		ranks.add(Rank.THIRD_PLACE);
		lottoRecord = new WinningRecord(ranks);
	}

	@DisplayName("로또 당첨 개수 반환")
	@Test
	public void getPlaceCount() {
		int secondPlaceCount = lottoRecord.getPlaceCount(Rank.FOURTH_PLACE);
		assertThat(secondPlaceCount).isEqualTo(2);

		secondPlaceCount = lottoRecord.getPlaceCount(Rank.THIRD_PLACE);
		assertThat(secondPlaceCount).isEqualTo(1);
	}

	@DisplayName("수익률 계산")
	@ParameterizedTest
	@CsvSource(value = {"10000:6.00", "2000000:0.02"}, delimiter = ':')
	public void profitRate(double standard, double revenue) {
		double profitRate = lottoRecord.profitRate(standard);

		assertThat(profitRate).isEqualTo(revenue);
	}
}

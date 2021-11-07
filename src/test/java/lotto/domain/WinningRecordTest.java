package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class WinningRecordTest {
	@Test
	public void 로또_당첨_개수_반환() {
		List<Rank> ranks = new ArrayList<>();
		ranks.add(Rank.FIRST_PLACE);
		ranks.add(Rank.SECOND_PLACE);
		ranks.add(Rank.SECOND_PLACE);
		WinningRecord lottoRecord = new WinningRecord(ranks);

		int secondPlaceCount = lottoRecord.getPlaceCount(Rank.SECOND_PLACE);
		assertThat(secondPlaceCount).isEqualTo(2);

		secondPlaceCount = lottoRecord.getPlaceCount(Rank.FIRST_PLACE);
		assertThat(secondPlaceCount).isEqualTo(1);
	}
}

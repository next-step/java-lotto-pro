package lotto;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LottoListTest {

	@Test
	public void 구입수량_5만큼_로또_생성() {
		LottoList lottoList = new LottoList(5);
		assertThat(lottoList.size()).isEqualTo(5);
		System.out.println(lottoList);
	}

	@Test
	public void 수동로또_리스트_생성() {
		LottoList lottoList = new LottoList(3, new String[] {"1,2,3,4,5,6", "1,2,3,4,5,6", "1,2,3,4,5,6"});
		assertThat(lottoList.size()).isEqualTo(3);
		System.out.println(lottoList);
	}

}
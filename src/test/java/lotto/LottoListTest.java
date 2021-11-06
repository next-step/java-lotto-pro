package lotto;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoListTest {

	@Test
	@DisplayName("5입력하여 로또 5개 생성한 로또 리스트 생성")
	public void lottoList구입수량5만큼로또생성() {
		LottoList lottoList = new LottoList(5);
		assertThat(lottoList.size()).isEqualTo(5);
	}

	@Test
	@DisplayName("수동입력 로또 생성한 로또 리스트 생성")
	public void LottoList수동로또리스트생성() {
		LottoList lottoList = new LottoList();
		lottoList.addLottoList(new Lotto("1,2,3,34,5,6"));
		assertThat(lottoList.size()).isEqualTo(1);
	}

}
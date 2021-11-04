package lottogame;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LotteryNumberMakerTest {

	private static final int START_INCLUSIVE_NUMBER=1;	/* 로또 번호 최소값 */
	private static final int END_EXCLUSIVE_NUMBER=45;	/* 로또 번호 최대값 */
	private static final int SIZE_OF_LOTTERY_NUMBERS=6;

	@Test
	public void makeLotteryNumbers_1에서45사이_6개의_숫자생성(){
		List<Integer> lotteryNumbers=LotteryNumberMaker.makeLotteryTicket();

		assertThat(lotteryNumbers.size()).isEqualTo(SIZE_OF_LOTTERY_NUMBERS);
		lotteryNumbers.forEach(lotteryNumber-> assertThat(lotteryNumber).isBetween(START_INCLUSIVE_NUMBER,END_EXCLUSIVE_NUMBER));
	}
}

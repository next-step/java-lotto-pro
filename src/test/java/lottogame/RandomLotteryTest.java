package lottogame;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class RandomLotteryTest {

	@RepeatedTest(100)
	public void getRandomLottery_임의의_랜덤번호_생성(){
		int randomLotteryNumber = RandomLottery.makeRandomLotteryNumber();
		Assertions.assertThat(randomLotteryNumber).isBetween(1,45);
	}

}
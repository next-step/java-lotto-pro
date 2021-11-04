package lottogame;

import java.util.Random;

/**
 * 로또 번호 생성 전용 랜덤 클래스
 */
public class RandomLottery {

	//Random 인스턴스를 한번만 생성하고 캐싱하여 사용
	private static final Random RANDOM = new Random();
	private static final int START_INCLUSIVE_NUMBER=1;	/* 로또 번호 최소값 */
	private static final int END_INCLUSIVE_NUMBER=45;	/* 로또 번호 최대값 */


	public static int makeRandomLotteryNumber() {
		return START_INCLUSIVE_NUMBER + RANDOM.nextInt(END_INCLUSIVE_NUMBER - START_INCLUSIVE_NUMBER+1);
	}
}

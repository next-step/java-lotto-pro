package lotto.domain;

import lotto.exception.CreateLottoBallFactoryException;
import lotto.exception.DuplicateNumberException;

import java.util.*;

public class LottoBallFactory {
    private static final List<LottoBall> CACHE_BALL = new ArrayList<>();

    static {
        for (int i = LottoBallRule.MIN_LOTTO_NUMBER.getNumber(); i <= LottoBallRule.MAX_LOTTO_NUMBER.getNumber(); i++) {
            CACHE_BALL.add(new LottoBall(i));
        }
    }

    private LottoBallFactory() {
        throw new CreateLottoBallFactoryException("LottoBallFactory 생성자는 호출되면 안됩니다.");
    }

    public static List<LottoBall> draw() {
        Collections.shuffle(CACHE_BALL);
        List<LottoBall> ballsDraw = new ArrayList<>(CACHE_BALL.subList(0, LottoBallRule.LOTTO_BALLS_SIZE.getNumber()));
        Collections.sort(ballsDraw);
        return Collections.unmodifiableList(ballsDraw);
    }

    public static List<LottoBall> createLottoBallByStringNumber(String stringNumber) {
        String[] numbersSplitted = splitNumberString(stringNumber);
        return Collections.unmodifiableList(createLottoBallList(numbersSplitted));
    }

    private static String[] splitNumberString(String numbersString) {
        String[] numbersSplitted = numbersString.split(",");
        if (hasDuplicatedNumber(numbersSplitted)) {
            throw new DuplicateNumberException("중복된 숫자가 존재합니다.");
        }
        return numbersSplitted;
    }

    private static boolean hasDuplicatedNumber(String[] numbersSplitted) {
        Set<String> numberSet = new HashSet<String>(Arrays.asList(numbersSplitted));
        return numberSet.size() != LottoBallRule.LOTTO_BALLS_SIZE.getNumber();
    }

    private static List<LottoBall> createLottoBallList(String[] numbersSplitted) {
        List<LottoBall> lottoBallList = new ArrayList<>();
        for (String numberString : numbersSplitted) {
            lottoBallList.add(new LottoBall(Integer.parseInt(numberString)));
        }
        return lottoBallList;
    }

}

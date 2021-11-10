package edu.lotto.controller;

import static org.assertj.core.api.Assertions.assertThat;

import edu.lotto.constants.PatternConstants;
import edu.lotto.utils.NumberUtil;
import org.junit.jupiter.api.Test;

/**
 * 로또(자동) Test Code
 * @since 2021.11.03
 * @author Inmook,Jeong
 */
public class AutomaticLottoTest {

	@Test
	void test() {
		String s = "1, 2, 3, 4, 5, 6".replaceAll(" ", "");
		String[] winningNumberArray = s.split(PatternConstants.DEFAULT_SEPARATOR_PATTERN);
		assertThat(winningNumberArray.length == 6).isTrue();
		for(String n : winningNumberArray) {
			assertThat(NumberUtil.isNumber(n)).isTrue();
			assertThat(NumberUtil.isNumberBetweenOneAndFortyFive(Integer.parseInt(n)));
		}
	}
}

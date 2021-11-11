package edu.lotto.controller;

import static org.assertj.core.api.Assertions.assertThat;

import edu.lotto.constants.PatternConstants;
import edu.lotto.utils.NumberUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * 로또(자동) Test Code
 * @since 2021.11.03
 * @author Inmook,Jeong
 */
public class AutomaticLottoTest {

	@Test
	@DisplayName("사용자가 입력한 로또 번호에 중복값이 없는지 확인")
	void hasNotDuplicateNumber() {
		String[] numbers1 = "1,2,3,4,5,6".split(PatternConstants.DEFAULT_SEPARATOR_PATTERN);
		String[] numbers2 = "1,1,2,3,4,5".split(PatternConstants.DEFAULT_SEPARATOR_PATTERN);

		List<String> numbersList1 = Arrays.asList(numbers1);
		List<String> numbersList2 = Arrays.asList(numbers2);
		assertThat(numbersList1.stream().distinct().count()).isEqualTo(numbersList1.size());
		assertThat(numbersList2.stream().distinct().count()).isNotEqualTo(numbersList2.size());
	}
}

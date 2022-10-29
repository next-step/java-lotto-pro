package utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

class CollectionUtilsTest {

	@Test
	void testIsEqualInAnyOrder() {
		boolean isEqualInAnyOrder = CollectionUtils.isEqualInAnyOrder(
			Lists.newArrayList(1, 2, 3, 4, 5),
			Lists.newArrayList(5, 4, 3, 2, 1)
		);
		assertThat(isEqualInAnyOrder).isTrue();
	}
}

package utils;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionUtils {

	private CollectionUtils() {
	}

	public static <T> boolean isEqualInAnyOrder(Collection<T> col1, Collection<T> col2) {
		if (isNotEqualSize(col1, col2)) {
			return false;
		}
		List<T> sortedCol1 = col1.stream().sorted().collect(Collectors.toList());
		List<T> sortedCol2 = col2.stream().sorted().collect(Collectors.toList());

		return sortedCol1.equals(sortedCol2);
	}

	private static <T> boolean isNotEqualSize(Collection<T> col1, Collection<T> col2) {
		return col1.size() != col2.size();
	}
}

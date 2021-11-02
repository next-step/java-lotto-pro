package stringcalcurator;

import java.util.ArrayList;
import java.util.List;

/** 
 * public class Separators {
.
 */
public class Separators {
  private final List<Separator> items;

  public Separators(List<Separator> items) {
    this.items = new ArrayList<>(items);
  }

  /**
   * getSeparators. 
   *
   * @return  allSeparators
   */
  public String getSeparators() {
    return this.items.stream()
                      .map(Separator::value)
                      .reduce((result, seed) -> result += seed)
                      .orElse("");
  }

  public Boolean add(Separator separator) {
    return this.items.add(separator);
  }

}

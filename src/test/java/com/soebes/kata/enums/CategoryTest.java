package com.soebes.kata.enums;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CategoryTest {

  @Test
  void unknownPlainNameGiven() {
    assertThatIllegalArgumentException()
        .isThrownBy(() -> Category.fromPlainName("Unknown"))
        .withMessage("Unknown does not exist");
  }

  @Test
  void fromPlainName() {
    assertThat(Category.fromPlainName("commercial tone / promoted")).isEqualTo(Category._61);
  }

  @Test
  void fromName() {
    var actual = Category.valueOf("_92");
    assertThat(actual).hasToString("text too short or garbled").isEqualTo(Category._92);;
  }


  @Test
  void valueOf() {
    assertThatIllegalArgumentException()
        .isThrownBy(() -> Category.valueOf("XXXX"))
        .withMessage("No enum constant com.soebes.kata.enums.Category.XXXX");
  }
}
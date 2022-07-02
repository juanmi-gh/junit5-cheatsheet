package es.jm.model;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class ClosedIntervalTest {

  private static final String PROVIDER = "es.jm.model.ClosedIntervalTestProvider#";

  @Nested
  class BuildIntervalIs {

    @ParameterizedTest(name = "if built as {0}.")
    @MethodSource(PROVIDER + "validIntervalValues")
    void valid(ClosedInterval interval) {

      assertThat(interval).isInstanceOf(ClosedInterval.class);
    }

    @ParameterizedTest(name = "if built as [{0}, {1}].")
    @CsvSource({"1, 0"})
    void notValid(int min, int max) {

      assertThrows(AssertionError.class, () -> new ClosedIntervalTestProvider().min(min).max(max).build());
    }
  }

  @Nested
  class Interval {

    @ParameterizedTest(name = "if value={1} and interval={0}")
    @MethodSource(PROVIDER + "valuesIncludedInIntervals")
    void containsValue(ClosedInterval interval, int value) {

      assertThat(interval.includes(value)).isTrue();
    }

    @ParameterizedTest(name = "if value={1} and interval={0}")
    @MethodSource(PROVIDER + "valuesNotIncludedInIntervals")
    void notContainsValue(ClosedInterval interval, int value) {

      assertThat(interval.includes(value)).isFalse();
    }
  }

}

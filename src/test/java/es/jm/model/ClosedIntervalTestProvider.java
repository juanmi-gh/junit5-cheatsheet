package es.jm.model;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

class ClosedIntervalTestProvider {

  int min;
  int max;

  ClosedIntervalTestProvider min(int min) {
    this.min = min;
    return this;
  }

  ClosedIntervalTestProvider max(int max) {
    this.max = max;
    return this;
  }

  ClosedInterval build() {
    return new ClosedInterval(min, max);
  }

  static ClosedInterval shortestInterval() {
    return new ClosedIntervalTestProvider()
        .min(0)
        .max(0)
        .build();
  }

  static ClosedInterval longestInterval() {
    return new ClosedIntervalTestProvider()
        .min(Integer.MIN_VALUE)
        .max(Integer.MAX_VALUE)
        .build();
  }

  // Collection<Object[]>
  static Stream<Arguments> validIntervalValues() {

    return Stream.of(
        Arguments.of(shortestInterval()),
        Arguments.of(longestInterval()));
  }

  static Stream<Arguments> valuesIncludedInIntervals() {

    return Stream.of(
        Arguments.of(shortestInterval(), 0),
        Arguments.of(longestInterval(), 0),
        Arguments.of(longestInterval(), Integer.MIN_VALUE),
        Arguments.of(longestInterval(), Integer.MAX_VALUE)
    );
  }

  static Stream<Arguments> valuesNotIncludedInIntervals() {

    return Stream.of(
        Arguments.of(shortestInterval(), 1),
        Arguments.of(shortestInterval(), -1)
    );
  }

}

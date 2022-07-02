package es.jm;

import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;

import java.lang.reflect.Method;
import org.junit.jupiter.api.DisplayNameGenerator;

public class ReplaceCamelCase extends DisplayNameGenerator.Standard {

  @Override
  public String generateDisplayNameForClass(Class<?> testClass) {
    return replaceCamelCase(super.generateDisplayNameForClass(testClass));
  }

  @Override
  public String generateDisplayNameForNestedClass(Class<?> nestedClass) {
    return replaceCamelCase(super.generateDisplayNameForNestedClass(nestedClass));
  }

  @Override
  public String generateDisplayNameForMethod(Class<?> testClass, Method testMethod) {
    return replaceCamelCase(testMethod.getName()) + DisplayNameGenerator.parameterTypesAsString(testMethod);
  }

  String replaceCamelCase(String camelCase) {

    var result = new StringBuilder(camelCase.charAt(0));

    for (char character : camelCase.toCharArray()) {
      if (isUpperCase(character)) {
        result.append(' ');
      }
      result.append(toLowerCase(character));
    }

    return result.toString();
  }
}

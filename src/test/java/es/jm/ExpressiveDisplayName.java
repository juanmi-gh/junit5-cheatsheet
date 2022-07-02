package es.jm;

import java.lang.reflect.Method;

public class ExpressiveDisplayName extends ReplaceCamelCase {

  @Override
  public String generateDisplayNameForClass(Class<?> testClass) {
    return super.generateDisplayNameForClass(testClass);
  }

  @Override
  public String generateDisplayNameForNestedClass(Class<?> nestedClass) {
    return super.generateDisplayNameForNestedClass(nestedClass) + "...";
  }

  @Override
  public String generateDisplayNameForMethod(Class<?> testClass, Method testMethod) {
    return replaceCamelCase(testMethod.getName()) + ":";
  }
}

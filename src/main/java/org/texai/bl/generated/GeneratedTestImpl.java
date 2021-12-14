/*
 * GeneratedTestImpl.java
 *
 * Created on Dec 13, 2021, 05:54:48 PM, composed by generated from requirements from reed.
 *
 * Description: Provides an expected class to be generated using Texai Behavior Language.
 *
 * Copyright (C) Dec 13, 2021 Stephen L. Reed.
 */
package org.texai.bl.generated;


/**
 * Provides an expected class to be generated using Texai Behavior Language.
 *
 * @author Expert System
 */
public class GeneratedTestImpl extends java.lang.Object {
  // a variables section comment
  // a test static string
  private static final String TEST_STATIC_STRING = "xyz";

  // a test string
  private final String testString;

  // a test int
  private int testInt;

  // a test long
  protected long testLong;

  // a test float
  public float testFloat;

  // a test double
  double testDouble;

  // a test boolean
  boolean testBoolean;

  /**
   * Constructs a new GeneratedTestImpl instance.
   *
   * @param testString a test string
   */
  public GeneratedTestImpl(final String testString) {
    this.testString = testString;
  }

  /**
   * Performs some test operations.
   *
   * @param parameterString the given string value
   * @param parameterInt the given int value
   * @return the result of the test string operation
   */
  public String testMethod(
          final String parameterString,
          final int parameterInt) {
    //Preconditions
    assert parameterString != null : "parameterString must not be null";

    testLong = -1 + parameterInt;
    testInt = (int) testLong;

    if (testLong == 0) {
      System.out.println("testLong is zero");
    }
    else {
      System.out.println("testLong is non-zero");
    }

    return "the result";
  }
}

package org.elio.utils;

import java.util.List;
import java.util.StringJoiner;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import junit.framework.Assert;

class TextUtilsTest {

  @BeforeAll
  static void setUpBeforeClass() throws Exception {}

  @BeforeEach
  void setUp() throws Exception {}

  @Test
  void testFullJustifyString() {
    Assert.assertEquals("This    is    an, example  of text, justification.  ",
        convertToOneLine(TextUtils.fullJustify(
            new String[] {"This", "is", "an", "example", "of", "text", "justification."}, 16)));
  }

  private String convertToOneLine(List<String> text) {
    StringJoiner sj = new StringJoiner(", ");
    text.forEach(l -> sj.add(l));
    return sj.toString();
  }
}

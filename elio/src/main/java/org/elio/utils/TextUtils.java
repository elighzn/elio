package org.elio.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zli Utility functions concerning text manipulations.
 */
public final class TextUtils {

  /**
   * Given a text and a width maxWidth, format the text such that each line has exactly maxWidth
   * characters and is fully (left and right) justified.
   * 
   * @param text A String
   * @param maxWidth
   * @return
   */
  public final static List<String> fullJustify(String text, int maxWidth) {
    return fullJustify(text.split(" "), maxWidth);
  }

  /**
   * Given an array of words and a width maxWidth, format the text such that each line has exactly
   * maxWidth characters and is fully (left and right) justified.
   * 
   * @param words An array of words
   * @param maxWidth A width such that each line has exactly maxWidth characters
   * @return Output that contains lines of justified texts.
   */
  public final static List<String> fullJustify(String[] words, int maxWidth) {

    List<String> output = new ArrayList<>();
    List<Integer> indices = new ArrayList<>();
    int lens = 0;
    for (int i = 0; i < words.length; i++) {
      String word = words[i];
      if (lens + indices.size() + word.length() > maxWidth) {
        output.add(buildLine(words, maxWidth, indices, lens));
        lens = word.length();
        indices.clear();
        indices.add(i);
      } else {
        lens += word.length();
        indices.add(i);
      }
    }
    output.add(buildLastLine(words, maxWidth, indices));
    return output;
  }

  final static String buildLine(String[] words, int maxWidth, List<Integer> indices, int lens) {
    StringBuilder sb = new StringBuilder();

    int totalSpaces = maxWidth - lens;
    sb.append(words[indices.get(0)]);
    switch (indices.size()) {
      case 1:
        for (int i = 0; i < totalSpaces; i++)
          sb.append(' ');
        break;
      case 2:
        for (int i = 0; i < totalSpaces; i++)
          sb.append(' ');
        sb.append(words[indices.get(1)]);
        break;
      default:
        int d = indices.size() - 1;
        int space = totalSpaces / d;
        int additionalSpace = totalSpaces % d;
        for (int j = 1; j < indices.size(); j++) {
          for (int i = 0; i < space; i++)
            sb.append(' ');
          if (additionalSpace-- > 0)
            sb.append(' ');
          sb.append(words[indices.get(j)]);
        }
        break;
    }
    return sb.toString();
  }

  final static String buildLastLine(String[] words, int maxWidth, List<Integer> indices) {
    StringBuilder sb = new StringBuilder();
    int i = 0;
    for (; i < indices.size() - 1; i++)
      sb.append(words[indices.get(i)] + ' ');
    sb.append(words[indices.get(i)]);
    int s = maxWidth - sb.length();
    for (i = 0; i < s; i++)
      sb.append(' ');
    return sb.toString();
  }

}

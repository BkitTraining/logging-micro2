package com.example.demo.logging.logging;

import com.fasterxml.jackson.core.JsonStreamContext;
import net.logstash.logback.mask.ValueMasker;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SensitiveValueMasker implements ValueMasker {

  private String messageField = "message";
  private String mask = "*****";
  private Pattern pattern;

  private List<String> maskPatterns = new ArrayList<>();

  public void addMaskPattern(String maskPattern) {
    maskPatterns.add(maskPattern);
    pattern = Pattern
        .compile(String.join("|", maskPatterns), Pattern.MULTILINE);
  }

  public void addMask(String mask) {
    this.mask = mask;
  }

  public void addMessageField(String messageField) {
    this.messageField = messageField;
  }

  @Override
  public Object mask(JsonStreamContext context, Object o) {
    if (context.getCurrentName() != null && context.getCurrentName().equals(messageField)
        && o instanceof CharSequence) {
      CharSequence value = (CharSequence) o;
      Matcher matcher = this.pattern.matcher(value);

      StringBuilder sb = new StringBuilder(value);

      while (matcher.find()) {
        for (int i = 1; i <= matcher.groupCount(); i++) {
          if (matcher.group(i) != null) {
            int start = sb.length() - value.length() + matcher.start(i);
            int end = sb.length() - value.length() + matcher.end(i);
            sb.replace(start, end, this.mask);
          }
        }
      }
      return sb.toString();

    }

    return null;
  }

}

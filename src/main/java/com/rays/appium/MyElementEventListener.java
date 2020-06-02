package com.rays.appium;

import io.appium.java_client.events.api.general.ElementEventListener;
import java.util.Arrays;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created on 2020/6/2.
 */
public final class MyElementEventListener implements ElementEventListener {

  @Override
  public void beforeClickOn(WebElement element, WebDriver driver) {
    System.out.println("beforeClickOn text: " + element.getText());
  }

  @Override
  public void afterClickOn(WebElement element, WebDriver driver) {
    System.out.println("afterClickOn text: " + element.getText());
  }

  @Override
  public void beforeChangeValueOf(WebElement element, WebDriver driver) {
    System.out.println("beforeChangeValueOf text: " + element.getText());
  }

  @Override
  public void beforeChangeValueOf(WebElement element, WebDriver driver,
      CharSequence[] keysToSend) {
    System.out.println("beforeChangeValueOf"
        + " text: " + element.getText()
        + " keysToSend: " + Arrays.toString(keysToSend)
    );
  }

  @Override
  public void afterChangeValueOf(WebElement element, WebDriver driver) {
    System.out.println("afterChangeValueOf text: " + element.getText());
  }

  @Override
  public void afterChangeValueOf(WebElement element, WebDriver driver,
      CharSequence[] keysToSend) {
    System.out.println("afterChangeValueOf"
        + " text: " + element.getText()
        + " keysToSend: " + Arrays.toString(keysToSend)
    );
  }

  @Override
  public void beforeGetText(WebElement element, WebDriver driver) {
    System.out.println("beforeGetText"
        + " text: " + element.getText()
    );
  }

  @Override
  public void afterGetText(WebElement element, WebDriver driver, String text) {
    System.out.println("afterGetText"
        + " text: " + element.getText()
        + " text: " + text
    );
  }
}

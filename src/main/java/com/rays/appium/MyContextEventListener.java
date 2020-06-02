package com.rays.appium;

import io.appium.java_client.events.api.mobile.ContextEventListener;
import org.openqa.selenium.WebDriver;

/**
 * Created on 2020/6/2.
 */
public final class MyContextEventListener implements ContextEventListener {

  @Override
  public void beforeSwitchingToContext(WebDriver driver, String context) {
    System.out.println("beforeSwitchingToContext context: " + context);
  }

  @Override
  public void afterSwitchingToContext(WebDriver driver, String context) {
    System.out.println("afterSwitchingToContext context: " + context);
  }
}

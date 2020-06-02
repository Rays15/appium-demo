package com.rays.appium;

import io.appium.java_client.events.api.general.NavigationEventListener;
import org.openqa.selenium.WebDriver;

/**
 * Created on 2020/6/2.
 */
public final class MyNavigationEventListener implements NavigationEventListener {

  @Override
  public void beforeNavigateTo(String url, WebDriver driver) {
    System.out.println("beforeNavigateTo url: " + url);
  }

  @Override
  public void afterNavigateTo(String url, WebDriver driver) {
    System.out.println("afterNavigateTo url: " + url);
  }

  @Override
  public void beforeNavigateBack(WebDriver driver) {

  }

  @Override
  public void afterNavigateBack(WebDriver driver) {

  }

  @Override
  public void beforeNavigateForward(WebDriver driver) {

  }

  @Override
  public void afterNavigateForward(WebDriver driver) {

  }

  @Override
  public void beforeNavigateRefresh(WebDriver driver) {

  }

  @Override
  public void afterNavigateRefresh(WebDriver driver) {

  }
}

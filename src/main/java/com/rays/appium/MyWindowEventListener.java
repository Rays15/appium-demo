package com.rays.appium;

import io.appium.java_client.events.api.general.WindowEventListener;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;

/**
 * Created on 2020/6/2.
 */
public final class MyWindowEventListener implements WindowEventListener {

  public static void main(String[] args) {
    String reg = "(\\d+(\\.\\d{0,2})?)|(\\.\\d{1,2})";
    System.out.println(Float.parseFloat("1."));
  }

  @Override
  public void beforeWindowChangeSize(WebDriver driver, Window window, Dimension targetSize) {

  }

  @Override
  public void afterWindowChangeSize(WebDriver driver, Window window, Dimension targetSize) {

  }

  @Override
  public void beforeWindowIsMoved(WebDriver driver, Window window, Point targetPoint) {

  }

  @Override
  public void afterWindowIsMoved(WebDriver driver, Window window, Point targetPoint) {

  }

  @Override
  public void beforeWindowIsMaximized(WebDriver driver, Window window) {

  }

  @Override
  public void afterWindowIsMaximized(WebDriver driver, Window window) {

  }

  @Override
  public void beforeSwitchToWindow(String windowName, WebDriver driver) {
    System.out.println("beforeSwitchToWindow windowName: " + windowName);
  }

  @Override
  public void afterSwitchToWindow(String windowName, WebDriver driver) {
    System.out.println("afterSwitchToWindow windowName: " + windowName);
  }
}

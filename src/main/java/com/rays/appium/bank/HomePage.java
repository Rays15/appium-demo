package com.rays.appium.bank;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import java.util.List;

/**
 * Created on 2020/6/2.
 */
public class HomePage {

  @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.Button\")")
  public List<MobileElement> buttons;

  @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\")")
  public List<MobileElement> textViews;

  @AndroidFindBy(uiAutomator = "new UiSelector().text(\"转账\")")
  public List<MobileElement> btnTransfer;

  @AndroidFindBy(uiAutomator = "new UiSelector().textMatches(\"[\\s\\S]+\")")
  public List<MobileElement> textMatches;

}

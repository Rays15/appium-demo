package com.rays.appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import java.util.List;
import org.openqa.selenium.remote.RemoteWebElement;

/**
 * Created on 2020/6/2.
 */
public class Page1 {

//  @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Appium Test\")")
  @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.Button\")")
  public List<MobileElement> buttons;

  @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Appium Test\")")
  public MobileElement btnAppium;

}

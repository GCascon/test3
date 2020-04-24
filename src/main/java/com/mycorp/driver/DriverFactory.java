package com.mycorp.driver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory {
	
	public RemoteWebDriver getChromeDriverInstance() {
		return new ChromeDriver();
	}

	public RemoteWebDriver getFirefoxDriverInstance() {
		return new FirefoxDriver();
	}

	public RemoteWebDriver getEdgeDriverInstance() {
		return new EdgeDriver();
	}

	public RemoteWebDriver getInternetExplorerDriverInstance() {
		return new InternetExplorerDriver();
	}

	public RemoteWebDriver getOperaDriverInstance() {
		return new OperaDriver();
	}

	public RemoteWebDriver getPhantomJSDriverInstance() {
		return new PhantomJSDriver();
	}


}

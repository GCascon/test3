package com.mycorp;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.Response;
import com.mycorp.driver.DriverFactory;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import io.github.bonigarcia.wdm.OperaDriverManager;
import io.github.bonigarcia.wdm.PhantomJsDriverManager;
import io.github.bonigarcia.wdm.VoidDriverManager;


/**
 * Unit test for simple BrowserManagerEnumTest.
 */
public class BrowserManagerEnumTest {

	
    @Test
    public void shouldCheckOf() throws Exception {
    	
        BrowserManagerEnum of = BrowserManagerEnum.of( "test" );
        Assert.assertEquals( BrowserManagerEnum.NONE, of );
        of = BrowserManagerEnum.of( "perry" );
        Assert.assertEquals( BrowserManagerEnum.NONE, of );
        of = BrowserManagerEnum.of( null );
        Assert.assertEquals( BrowserManagerEnum.NONE, of );
        Assert.assertTrue( of.getBrowserManager() instanceof VoidDriverManager );
        Assert.assertTrue( of.getBrowserManager( "1" ) instanceof VoidDriverManager );
        Assert.assertTrue( of.getDriver(new DriverFactory()) instanceof RemoteWebDriver );
    }

    @Test
    public void shouldCheckOfChrome() throws Exception {
    	
        BrowserManagerEnum of = BrowserManagerEnum.of( "test" );
        
        DriverFactory myDriver = new DriverFactory();
        DriverFactory spyMyDriver = Mockito.spy(myDriver);
        Mockito.doReturn(generateRemoteWebDriver()).when(spyMyDriver).getChromeDriverInstance();
        Mockito.doReturn(generateRemoteWebDriver()).when(spyMyDriver).getFirefoxDriverInstance();
        Mockito.doReturn(generateRemoteWebDriver()).when(spyMyDriver).getEdgeDriverInstance();
        
        Mockito.doReturn(generateRemoteWebDriver()).when(spyMyDriver).getInternetExplorerDriverInstance();
        Mockito.doReturn(generateRemoteWebDriver()).when(spyMyDriver).getOperaDriverInstance();
        Mockito.doReturn(generateRemoteWebDriver()).when(spyMyDriver).getPhantomJSDriverInstance();
        
        Assert.assertEquals( BrowserManagerEnum.NONE, of );
        of = BrowserManagerEnum.of( "perry" );
        Assert.assertEquals( BrowserManagerEnum.NONE, of );
        
        of = BrowserManagerEnum.of( "chrome" );
        Assert.assertEquals( BrowserManagerEnum.CHROME, of );
        Assert.assertTrue( of.getBrowserManager() instanceof ChromeDriverManager );
        Assert.assertTrue( of.getBrowserManager( "1" ) instanceof ChromeDriverManager );
        Assert.assertTrue( of.getDriver(spyMyDriver) instanceof RemoteWebDriver );
        
    }
    
    @Test
    public void shouldCheckOfEdge() throws Exception {
    	DriverFactory myDriver = new DriverFactory();
    	DriverFactory spyMyDriver = Mockito.spy(myDriver);
        Mockito.doReturn(generateRemoteWebDriver()).when(spyMyDriver).getEdgeDriverInstance();
        
    	BrowserManagerEnum of = BrowserManagerEnum.of( "edge" );
        Assert.assertEquals( BrowserManagerEnum.EDGE, of );
        Assert.assertTrue( of.getBrowserManager() instanceof EdgeDriverManager );
        Assert.assertTrue( of.getBrowserManager( "1" ) instanceof EdgeDriverManager );
        Assert.assertTrue( of.getDriver(spyMyDriver) instanceof RemoteWebDriver );
    }
    
    @Test
    public void shouldCheckOfFirefox() throws Exception {
    	DriverFactory myDriver = new DriverFactory();
    	DriverFactory spyMyDriver = Mockito.spy(myDriver);
        Mockito.doReturn(generateRemoteWebDriver()).when(spyMyDriver).getFirefoxDriverInstance();
        
    	BrowserManagerEnum of = BrowserManagerEnum.of( "firefox" );
    	Assert.assertEquals( BrowserManagerEnum.FIREFOX, of );
        Assert.assertTrue( of.getBrowserManager() instanceof FirefoxDriverManager );
        Assert.assertTrue( of.getBrowserManager( "1" ) instanceof FirefoxDriverManager );
        Assert.assertTrue( of.getDriver(spyMyDriver) instanceof RemoteWebDriver );
    }
    
    @Test
    public void shouldCheckOfIE() throws Exception {
    	DriverFactory myDriver = new DriverFactory();
    	DriverFactory spyMyDriver = Mockito.spy(myDriver);
        Mockito.doReturn(generateRemoteWebDriver()).when(spyMyDriver).getInternetExplorerDriverInstance();
        
    	BrowserManagerEnum of = BrowserManagerEnum.of( "ie" );
        Assert.assertEquals( BrowserManagerEnum.IE, of );
        Assert.assertTrue( of.getBrowserManager() instanceof InternetExplorerDriverManager );
        Assert.assertTrue( of.getBrowserManager( "1" ) instanceof InternetExplorerDriverManager );
        Assert.assertTrue( of.getDriver(spyMyDriver) instanceof RemoteWebDriver );
    }
    
    @Test
    public void shouldCheckOfMarionette() throws Exception {
    	DriverFactory myDriver = new DriverFactory();
    	DriverFactory spyMyDriver = Mockito.spy(myDriver);
        Mockito.doReturn(generateRemoteWebDriver()).when(spyMyDriver).getFirefoxDriverInstance();
        
    	BrowserManagerEnum of = BrowserManagerEnum.of( "marionette" );
        Assert.assertEquals( BrowserManagerEnum.MARIONETTE, of );
        Assert.assertTrue( of.getBrowserManager() instanceof FirefoxDriverManager );
        Assert.assertTrue( of.getBrowserManager( "1" ) instanceof FirefoxDriverManager );
        Assert.assertTrue( of.getDriver(spyMyDriver) instanceof RemoteWebDriver );
    }
    
    @Test
    public void shouldCheckOfOpera() throws Exception {
    	DriverFactory myDriver = new DriverFactory();
    	DriverFactory spyMyDriver = Mockito.spy(myDriver);
        Mockito.doReturn(generateRemoteWebDriver()).when(spyMyDriver).getOperaDriverInstance();
        
    	BrowserManagerEnum of = BrowserManagerEnum.of( "opera" );
        Assert.assertEquals( BrowserManagerEnum.OPERA, of );
        Assert.assertTrue( of.getBrowserManager() instanceof OperaDriverManager );
        Assert.assertTrue( of.getBrowserManager( "1" ) instanceof OperaDriverManager );
        Assert.assertTrue( of.getDriver(spyMyDriver) instanceof RemoteWebDriver );
    }
    
    @Test
    public void shouldCheckOfPhantomjs() throws Exception {
    	DriverFactory myDriver = new DriverFactory();
    	DriverFactory spyMyDriver = Mockito.spy(myDriver);
        Mockito.doReturn(generateRemoteWebDriver()).when(spyMyDriver).getPhantomJSDriverInstance();
        
    	BrowserManagerEnum of = BrowserManagerEnum.of( "phantomjs" );
        Assert.assertEquals( BrowserManagerEnum.PHANTOMJS, of );
        Assert.assertTrue( of.getBrowserManager() instanceof PhantomJsDriverManager );
        Assert.assertTrue( of.getBrowserManager( "1" ) instanceof PhantomJsDriverManager );
        Assert.assertTrue( of.getDriver(spyMyDriver) instanceof RemoteWebDriver );
    }
    
    private RemoteWebDriver generateRemoteWebDriver() {
    	DesiredCapabilities dc = new DesiredCapabilities( BrowserType.MOCK, "mock-version", Platform.ANY );
    	RemoteWebDriver mock = new RemoteWebDriver( dc ) {
            /**
             * {@inheritDoc}
             *
             * @see RemoteWebDriver#execute(String, Map)
             */
            @Override
            protected Response execute( final String driverCommand, final Map< String, ? > parameters ) {
                return new Response();
            }

            /**
             * {@inheritDoc}
             *
             * @see RemoteWebDriver#startSession(Capabilities, Capabilities)
             */
            @Override
            protected void startSession( final Capabilities desiredCapabilities, final Capabilities requiredCapabilities ) {
                setSessionId( "mock" );
            }
        };
        return mock;
    }

}

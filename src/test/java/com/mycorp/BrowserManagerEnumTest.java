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

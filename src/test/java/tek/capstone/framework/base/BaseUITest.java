package tek.capstone.framework.base;


import io.cucumber.java.*;
import tek.capstone.framework.utilities.CommonUtility;

public class BaseUITest extends CommonUtility {

	@Before
	public void setupTest() {
		super.setupBrowser();
	}
	
	@After
	public void closeTest(Scenario scenario) {
		if(scenario.isFailed()) {
			byte[] screenShot = takeScreenShotAsBytes();
			scenario.attach(screenShot, "image/png", scenario.getName()+"Scenario Failed");
		}
		super.quitBrowser();
	}
	
}

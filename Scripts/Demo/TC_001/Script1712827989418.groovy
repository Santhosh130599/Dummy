import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.webui.driver.DriverFactory
import javax.swing.JOptionPane


WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.PWA_Url)

WebUI.click(findTestObject('MP_Product_TestCases/Onboarding Test cases/PWA/Close Button LoginScreen'))

WebUI.click(findTestObject('MP_Product_TestCases/Onboarding Test cases/PWA/Username_Field'))

// Initialize the mobile number variable
def mobileNumber = ""

// Loop until a valid mobile number is provided
while (mobileNumber.isEmpty()) 
	{
    // Ask the user to input the mobile number using a dialog box
    mobileNumber = JOptionPane.showInputDialog("Onboard Username", "Please enter Login ID to Onboard:")
}
WebUI.setText(findTestObject('MP_Product_TestCases/Onboarding Test cases/PWA/Username_Field'), mobileNumber)

WebUI.click(findTestObject('MP_Product_TestCases/Onboarding Test cases/PWA/Submit button_Login Screen'))

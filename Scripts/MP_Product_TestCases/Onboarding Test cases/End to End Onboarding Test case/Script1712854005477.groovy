import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import java.util.concurrent.TimeUnit as TimeUnit
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword as WebUIAbstractKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import groovy.ui.Console
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import javax.swing.JOptionPane
import org.testng.Assert
import org.eclipse.persistence.jpa.jpql.Assert.AssertException
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.NoSuchElementException as NoSuchElementException

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.PWA_Url)

WebUI.click(findTestObject('MP_Product_TestCases/Onboarding Test cases/PWA/Close Button LoginScreen'))

WebUI.click(findTestObject('MP_Product_TestCases/Onboarding Test cases/PWA/Username_Field'))

/*def Onboard_Username = ""

	while(Onboard_Username.isEmpty())
		{
			Onboard_Username = JOptionPane.showInputDialog("Onboard Username", "Please enter Login ID to Onboard:")
	
		}
WebUI.setText(findTestObject('MP_Product_TestCases/Onboarding Test cases/PWA/Username_Field'), Onboard_Username)
*/

Onboard_Username = CustomKeywords.'not_Onboarded_Retailer.NonOnboardedRetailer.DBLogin'(GlobalVariable.DB_SRID)

WebUI.sendKeys(findTestObject('MP_Product_TestCases/Onboarding Test cases/PWA/Username_Field'), Onboard_Username)


WebUI.click(findTestObject('MP_Product_TestCases/Onboarding Test cases/PWA/Submit button_Login Screen'))

def PasswordField = findTestObject('MP_Product_TestCases/Onboarding Test cases/PWA/Password_field')

def MobileNumberField = findTestObject('MP_Product_TestCases/Onboarding Test cases/PWA/Onboard_mobileNumber_Field')

def Checkbox = findTestObject('MP_Product_TestCases/Onboarding Test cases/PWA/Checkbox_Contract')

def SignInButton = findTestObject('MP_Product_TestCases/Onboarding Test cases/PWA/Onboardbutton_SiginButton')

def ContractAgreeButton = findTestObject('MP_Product_TestCases/Onboarding Test cases/PWA/Contract_Agree_Button')

def Change_NewPassword = findTestObject('MP_Product_TestCases/Onboarding Test cases/PWA/ChangePassword_New Password')

def Change_ConfirmPassword = findTestObject('MP_Product_TestCases/Onboarding Test cases/PWA/Confirmation Password')

WebUI.delay(10)

try {
    // Check if password field is present
    if (WebUI.verifyElementPresent(PasswordField, 10, FailureHandling.OPTIONAL)) 
	{
        WebUI.click(PasswordField)
		
		def Password = ""
		
		while(Password.isEmpty())
		{
			Password = JOptionPane.showInputDialog("Password for onboard", "Please enter Default Password to onboard the user:")
			
		}
        WebUI.setText(PasswordField, Password)

       WebUI.delay(5)
	   
    } 
	else
		// If password field not present, fill mobile number
		// Check if checkbox is present
	 {
        WebUI.click(MobileNumberField)
		
		def MobileNumber = ""
		
		while(MobileNumber.isEmpty())
		{
			MobileNumber = JOptionPane.showInputDialog("Mobile Number for Onboard", "Please Enter the Mobile Number to Onboard")
		}
		
        WebUI.setText(MobileNumberField,MobileNumber)

        try {
            if (WebUI.verifyElementPresent(Checkbox, 15, FailureHandling.OPTIONAL)) 
				{
                WebUI.click(Checkbox)

                WebUI.click(ContractAgreeButton, FailureHandling.STOP_ON_FAILURE)

                WebUI.delay(5)

                WebUI.verifyElementChecked(Checkbox, 10, FailureHandling.STOP_ON_FAILURE)

                WebUI.click(SignInButton)
            } 
			else 
				{
                WebUI.click(SignInButton)
            }
        }
        catch (NoSuchElementException checkboxException) {
            println('Checkbox not found.')
        } 
    }
}
catch (NoSuchElementException passwordFieldException) {
    // Handle NoSuchElementException for password field not found
    println('Password field not found.')
} 
catch (Exception e) {
    // Log any other exceptions that occur during execution
    println("An error occurred: $e.getMessage()")
} 

// Onboard OTP Config
def Onboard_OTP = findTestObject('MP_Product_TestCases/Onboarding Test cases/PWA/OnBoard__OTP_Field')
WebUI.delay(10)
if (WebUI.verifyElementPresent(Onboard_OTP, 10, FailureHandling.OPTIONAL)) 
{
	WebUI.delay(10)
    WebUI.click(Onboard_OTP)

    WebUI.delay(10)

    OTP = CustomKeywords.'otp.Onboard_OTP.DBLogin'(Onboard_Username)

    WebUI.delay(10)

    WebUI.sendKeys(findTestObject('MP_Product_TestCases/Onboarding Test cases/PWA/OnBoard__OTP_Field'), OTP)

    WebUI.delay(10)

    WebUI.click(findTestObject('MP_Product_TestCases/Onboarding Test cases/PWA/OTP_Submit'))
}
else
{
	WebUI.click(SignInButton)
	
	if(WebUI.verifyElementPresent(Change_NewPassword, 10, FailureHandling.STOP_ON_FAILURE))
	{
		def NewPassword = ""
		def ConfirmPassword = ""
		
		WebUI.click(Change_NewPassword)
		
		while(NewPassword.isEmpty())
		{
			NewPassword = JOptionPane.showInputDialog("Change Default Password to New Password", "Please Enter the New Password")
		}
		
		WebUI.setText(Change_NewPassword, NewPassword)
		
		WebUI.delay(4)
		
		WebUI.click(Change_ConfirmPassword)
		
		while(ConfirmPassword.isEmpty())
		{
			
			ConfirmPassword = JOptionPane.showInputDialog("Confirm Password", "Please Enter the Confirm Password")
		}
		
		WebUI.setText(Change_ConfirmPassword, ConfirmPassword)
		
		WebUI.click(SignInButton)
			
	}
	
	else
	{
		// Set a condition that will always evaluate to false
		def condition = false
		Assert.assertTrue(condition, "Test cases Failed Due to the Change Password field is not Present ")
	}
	
	
}


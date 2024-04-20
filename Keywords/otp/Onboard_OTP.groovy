package otp

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import java.security.PublicKey
import java.security.interfaces.RSAKey
import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement

import org.eclipse.jdt.internal.compiler.ast.ThisReference

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.entity.global.GlobalVariableEntity

import groovy.json.StringEscapeUtils
import groovy.ui.Console
import internal.GlobalVariable
import databaseConnectionCredentials.CredentialsDetails

public class Onboard_OTP {

	//Database Credentials are Taking from the Global Variable//

	String Username = GlobalVariable.DB_Username
	String Password = GlobalVariable.DB_Password
	String Port = GlobalVariable.Port
	String Host = GlobalVariable.Host
	String Url = "jdbc:postgresql://" + GlobalVariable.Host + ":" + GlobalVariable.Port + "/" + GlobalVariable.DB_Name



	@Keyword
	public String DBLogin(String LoginID)
	{
		Connection Conn = DriverManager.getConnection(Url, Username, Password)
		Statement S = Conn.createStatement();
		String searchData = ('\'' + LoginID) + '\''
		String queryString = ('select "SU_Id" from "SADM_Users" where "SU_Login_Id" ='+ searchData+'and "SU_Otp_Generated_Date" is not null limit 1')
		ResultSet rs = S.executeQuery(queryString)
		String OTPValue , UserID
		while (rs.next())
		{
			UserID = rs.getString('SU_Id')
			Console.println(UserID)
		}
		WebUI.delay(10)
		String queryOTP = ('select "SU_Otp" from "SADM_Users" where "SU_Id" ='+ UserID+'order by "SU_Otp_Valid_From" desc fetch first 1 row only')
		ResultSet rs1 = S.executeQuery(queryOTP)
		while (rs1.next())
		{
			OTPValue = rs1.getString('SU_Otp')
			Console.println(OTPValue)
		}

		return OTPValue
	}
}

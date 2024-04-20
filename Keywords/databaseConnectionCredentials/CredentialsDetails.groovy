package databaseConnectionCredentials

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

import internal.GlobalVariable

public class CredentialsDetails {

	public String Port = "5432";
	public String Host = "qadb-postgres13-ivydev01-in.cgmzbgnryhj7.ap-south-1.rds.amazonaws.com";

	//BNL Database Credentials
	public String BNLUsername = "ivyretailassist_bnlindia_qa_appuser";
	public String BNLPassword = "Ivyretailassistbnlinqaapp**0422!";
	public String BNLUrl = "jdbc:postgresql://" + Host + ":" + Port + "/" + "ivyretailassist_bnlindia_qa";

	//Mccain02 Database Credentials
	public String MccainUsername = "ivyretailassist_mccainindia_qa_qauser";
	public String MccainPassword = "retai78y656rtretdd";
	public String MccainUrl = "jdbc:postgresql://" + Host + ":" + Port + "/" + "ivyretailassist_mccainindia_qa";

	//Bajaj Database Credentials
	public String BajajUsername = "ivyretailassist_bajajindia_qa_qauser";
	public String BajajPassword = "Ivyretasatkbajajqauser0890*84";
	public String BajajUrl = "jdbc:postgresql://" + Host + ":" + Port + "/" + "ivyretailassist_bajajindia_qa";

	//Nestle Database Credentials
	public String NestleUsername = "ivyretailassist_nestleindia_d6_qa_qauser";
	public String NestlePassword = "Ivyretasatknestleqauser0890*84";
	public String NestleUrl = "jdbc:postgresql://" + Host + ":" + Port + "/" + "ivyretailassist_nestleindia_d6_qa";

	//FC Database Credentials
	public String FC_Username = "ivyretailassist_fcnigeria_qa_qauser";
	public String FC_Password = "Ivyretasstfcnigeriaqauser02341*23";
	public String FC_Url = "jdbc:postgresql://" + Host + ":" + Port + "/" + "ivyretailassist_fcnigeria_qa";

}

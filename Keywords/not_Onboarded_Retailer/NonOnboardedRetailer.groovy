package not_Onboarded_Retailer

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

import java.security.PublicKey
import java.security.interfaces.RSAKey
import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement


public class NonOnboardedRetailer {
	//Database Credentials are Taking from the Global Variable//

	String Username = GlobalVariable.DB_Username
	String Password = GlobalVariable.DB_Password
	String Port = GlobalVariable.Port
	String Host = GlobalVariable.Host
	String Url = "jdbc:postgresql://" + GlobalVariable.Host + ":" + GlobalVariable.Port + "/" + GlobalVariable.DB_Name



	@Keyword
	public String DBLogin(String ID)
	{
		Connection Conn = DriverManager.getConnection(Url, Username, Password)
		Statement S = Conn.createStatement();
		String SRID = ('\'' + ID) + '\''
		String queryString = 
		'''select Su."SU_Id" ,SU."SU_Login_Id" ,su."SU_Login_Time" ,su."SU_Isactive" ,
ar."ARTR_Id" ,ar."ARTR_Code" ,ar."ARTR_Name" ,ar."ARTR_Isactive"
from "SADM_Users" su 
inner join "ADM_User_Retailer_Mapping" aurm on su."SU_Id"  = aurm."AURM_SU_Id"  and "AURM_Isactive"
inner join "ADM_Retailer" ar on aurm."AURM_ARTR_Id" = ar."ARTR_Id" and ar."ARTR_Isactive" 
inner join "ADM_Distributor_Retailer_Mapping" adrm on ar."ARTR_Id"  = adrm."ADRM_ARTR_Id" and adrm."ADRM_Isactive"
inner join "ADM_Distributor" ad on adrm."ADRM_AD_Id" = ad."AD_Id"  and ad."AD_Isactive" 
where su."SU_Isactive" and su."SU_Login_Time" is null and Su."SU_SR_Id" = '${SRID}' and su."SU_Login_Id" is not null
limit 1;'''
		ResultSet rs = S.executeQuery(queryString)
		String UserId
		while (rs.next())
		{
			UserId = rs.getString('SU_Login_Id')
			Console.println(UserId)
		}
				return UserId
	}
}

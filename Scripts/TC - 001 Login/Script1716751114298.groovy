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
import internal.GlobalVariable as GlobalVariable

'Define Variables'
String wrongPassword = 'wrongPassword'

'Open Browser'
WebUI.openBrowser(GlobalVariable.url)

'Wait for Page Load'
WebUI.waitForPageLoad(15)

'Initialize flag to track login success'
boolean loginSuccess = false

'List of passwords to try'
List<String> passwords = [wrongPassword, GlobalVariable.password]

'Attempt login with different passwords'
for (String password : passwords) {
'Input Username'
WebUI.setText(findTestObject('Object Repository/Page_HRSV Dashboard/input_text'), GlobalVariable.username)

'Input Password'
WebUI.setText(findTestObject('Object Repository/Page_HRSV Dashboard/input_password'), password)

'Click on Login Button'
WebUI.click(findTestObject('Object Repository/Page_HRSV Dashboard/button_Login'))

'Wait for 2 seconds'
WebUI.delay(2)
}

'Check if login was Invalid'
//
//if (WebUI.verifyElementPresent(findTestObject('Object Repository/Page_HRSV Dashboard/div_Username andor Password is invalid'), 5)) {
//	loginSuccess = false
//} else  {
//	'If login fails, clear the input fields'
//	WebUI.clearText(findTestObject('Object Repository/Page_HRSV Dashboard/input_password'))
////	WebUI.clearText(findTestObject('Object Repository/Page_HRSV Dashboard/div_Username andor Password is invalid'))
//}

if (loginSuccess) {
	WebUI.verifyElementPresent(findTestObject('Object Repository/Page_HRSV Dashboard/div_Username andor Password is invalid'), 5)
} else {
	WebUI.verifyAlertNotPresent(5)
}
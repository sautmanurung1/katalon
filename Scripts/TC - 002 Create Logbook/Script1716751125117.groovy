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
import org.openqa.selenium.By
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType

'Define Variable'
String tanggal = '12-02-2024'
String modeKerja = 'WFH'
String project = 'Vision'
String namaTim = 'Keren'
String useCase = 'Fixing'
String kegiatan = 'Programming'
String hasil = 'Bagus'
String capaian = '50'
String nextStep = 'Final'
String path = 'Tak tau'
String detailPekerjaan = 'saya sudah mengerjakan'
String waktuKerja = 'Jam Lembur'

WebUI.callTestCase(findTestCase('TC - 001 Login'), [('Username'): GlobalVariable.username, ('Password'): GlobalVariable.password])

WebUI.click(findTestObject('Object Repository/Page_HRSV Dashboard/Page_HRSV Logbook/button_Tambah Logbook'))
WebUI.delay(4)

WebUI.setText(findTestObject('Object Repository/Page_HRSV Dashboard/Page_HRSV Logbook/input_Tanggal_tanggal'), tanggal)
WebUI.delay(2)

String waktuSaatIni = LocalTime.now().format(DateTimeFormatter.ofPattern("h:mm a"))

String xpathDinamis = "//input[@value='" + waktuSaatIni + "']"

TestObject elementTimePicker = new TestObject()
elementTimePicker.addProperty("xpath", ConditionType.EQUALS, xpathDinamis)

WebUI.click(elementTimePicker)
WebUI.click(findTestObject('Object Repository/Page_HRSV Dashboard/Page_HRSV Logbook/li_230 PM'))
WebUI.delay(2)

TestObject elementTimePickerSelesai = new TestObject()
elementTimePickerSelesai.addProperty("xpath", ConditionType.EQUALS, xpathDinamis)

WebUI.click(elementTimePickerSelesai)
WebUI.click(findTestObject('Object Repository/Page_HRSV Dashboard/Page_HRSV Logbook/li_630 PM'))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_HRSV Dashboard/Page_HRSV Logbook/select_mode_kerja'), modeKerja, false)
WebUI.delay(10)

WebUI.setText(findTestObject('Object Repository/Page_HRSV Dashboard/Page_HRSV Logbook/input_Project_project'), project)
WebUI.delay(5)

WebUI.setText(findTestObject('Object Repository/Page_HRSV Dashboard/Page_HRSV Logbook/input_Nama Tim_nama_tim'), namaTim)
WebUI.delay(5)

WebUI.setText(findTestObject('Object Repository/Page_HRSV Dashboard/Page_HRSV Logbook/input_Use Case_use_case'), useCase)
WebUI.delay(5)

WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_HRSV Dashboard/Page_HRSV Logbook/select_materi'), kegiatan, false)
WebUI.delay(10)

WebUI.setText(findTestObject('Object Repository/Page_HRSV Dashboard/Page_HRSV Logbook/input_Hasil_hasil'), hasil)
WebUI.delay(6)

WebUI.setText(findTestObject('Object Repository/Page_HRSV Dashboard/Page_HRSV Logbook/input_Capaian_capaian'), capaian)
WebUI.delay(6)

WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_HRSV Dashboard/Page_HRSV Logbook/select_next_step'), nextStep, false)
WebUI.delay(10)

WebUI.setText(findTestObject('Object Repository/Page_HRSV Dashboard/Page_HRSV Logbook/input_PathFilename_file_name'), path)
WebUI.delay(6)

WebUI.setText(findTestObject('Object Repository/Page_HRSV Dashboard/Page_HRSV Logbook/textarea_Detail Pekerjaan_detail_pekerjaan'), detailPekerjaan)
WebUI.delay(6)

WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_HRSV Dashboard/Page_HRSV Logbook/select_jam_kerja'), waktuKerja, false)
WebUI.delay(10)

'Close the Browser'
//WebUI.closeBrowser()
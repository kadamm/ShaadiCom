package MobileBankingBaseTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class MobileBankingBaseClass {

	static Properties pro;
	static XSSFSheet sh1;
	XSSFWorkbook wb;

	@BeforeSuite
	public void Setup() throws FileNotFoundException, IOException
	{
		pro = new Properties();
		pro.load(new FileInputStream("src\\test\\resources\\mobileWidgetid.properties"));
		Driver.initializeDriver();
		initializeExcel();
	}


	public static String getElementByID(String element)
	{
		return pro.getProperty(element);
	}

	private void initializeExcel() throws IOException {
		File src=new File("src\\test\\resources\\test_data.xlsx");
		FileInputStream fis=new FileInputStream(src);
		wb=new XSSFWorkbook(fis);
		sh1= wb.getSheetAt(0);
	}

	public static String getRowValue(int row, int col) {
		DataFormatter formatter = new DataFormatter(Locale.US);
		String value=formatter.formatCellValue(sh1.getRow(row).getCell(col));
		//String value =sh1.getRow(row).getCell(col).getStringCellValue();
		return value;

	}

	public static int getTestCaseRowFromTitle(String titile) {
		int Lastrow=sh1.getLastRowNum();
		int i=0;
		for(i=0;i<Lastrow;i++)
		{
			String value =sh1.getRow(i).getCell(0).getStringCellValue();
			if(value.equalsIgnoreCase(titile))
			{
				return i;
			}
		}
		return i;
	}
	
	@AfterSuite
	public void closexcel() throws IOException {
		wb.close();
	}
	
}

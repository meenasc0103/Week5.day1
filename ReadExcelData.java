package Week5.day2;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		XSSFWorkbook workbook = new XSSFWorkbook("data/createlead.xlsx");
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		//XSSFRow dataRow = sheet.getRow(1);
		int rowcount = sheet.getLastRowNum();
		
		short ColumnCount = sheet.getRow(0).getLastCellNum();
		for(int i = 1;i<=rowcount;i++) {
			XSSFRow dataRow = sheet.getRow(i);
			
			for (int j = 0; j < ColumnCount; j++) {
				XSSFCell CompanyName = dataRow.getCell(j);
				String datavalue = CompanyName.getStringCellValue();
				System.out.println(datavalue);
			}
			
		}
		
		workbook.close();
		}
	}




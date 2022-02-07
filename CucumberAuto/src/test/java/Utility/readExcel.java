package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readExcel {

	public void readExcelData(String filePath,String fileName,String sheetName) throws IOException{

		File file =    new File(filePath+"\\"+fileName);					//Create an object of File class to open xlsx file
		FileInputStream inputStream = new FileInputStream(file);			//Create an object of FileInputStream class to read excel file
		Workbook excelWorkbook = null;
		String fileExtensionName = fileName.substring(fileName.indexOf("."));		//Find the file extension by splitting file name in substring  and getting only extension name
		if(fileExtensionName.equals(".xlsx")){								//Check condition if the file is xlsx file
			excelWorkbook = new XSSFWorkbook(inputStream);					//If it is xlsx file then create object of XSSFWorkbook class
		}
		else if(fileExtensionName.equals(".xls")){
			excelWorkbook = new HSSFWorkbook(inputStream);					//If it is xls file then create object of HSSFWorkbook class
		}

		Sheet excelSheet = excelWorkbook.getSheet(sheetName);		//Read sheet inside the workbook by its name
		int rowCount = excelSheet.getLastRowNum()-excelSheet.getFirstRowNum();		//Find number of rows in excel file
		for (int i = 0; i < rowCount+1; i++) {		//Create a loop over all the rows of excel file to read it
			Row row = excelSheet.getRow(i);
			for (int j = 0; j < row.getLastCellNum(); j++) {					//Create a loop to print cell values in a row

				Cell cell1 = excelSheet.getRow(i).getCell(j);   

				switch(cell1.getCellType()) {
				case STRING:
					System.out.println(cell1.getRichStringCellValue().getString());
					break;
				case NUMERIC:
					if (DateUtil.isCellDateFormatted(cell1)) {
						System.out.println(cell1.getDateCellValue());
					} else {
						System.out.println(cell1.getNumericCellValue());
					}
					break;
				case BOOLEAN:
					System.out.println(cell1.getBooleanCellValue());
					break;
				default:
					System.out.println();
				}
			}
			System.out.println();
		} 
	}  

	public void writeExcelData (String filePath,String fileName,String sheetName, String Message) {
		File file =    new File(filePath+"\\"+fileName);					
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheet("TestData");
		Row row = sheet.createRow(1);
		Cell cell = row.createCell(1);

		//If it is a string, we need to set the cell type as string 
		//if it is numeric, we need to set the cell type as number
		cell.setCellType();
		cell.setCellValue("SoftwareTestingMaterial.com");
		FileOutputStream fos = new FileOutputStream(file);
		workbook.write(fos);
		fos.close();
		System.out.println("END OF WRITING DATA IN EXCEL");
	}

}


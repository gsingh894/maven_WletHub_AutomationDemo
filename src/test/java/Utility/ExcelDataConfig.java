package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;


import org.apache.poi.ss.usermodel.DataFormatter;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig {
	XSSFWorkbook wb;
	XSSFSheet sheet1;
	FileInputStream fis;
	FileOutputStream fos;
	File out_src;
	String[][] tabArray;
	public int totalColumns;

	public ExcelDataConfig(String excelpath){
		try {
			File src = new File(excelpath);
			out_src = new File(excelpath);
			fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} 
	}

	public String getDataNew(String sheetName,int row, int col){
		try {
			sheet1 = wb.getSheet(sheetName);
			DataFormatter formatter = new DataFormatter();
			String data = formatter.formatCellValue(sheet1.getRow(row).getCell(col));	
			return data;
		} catch (Exception e) {
			return null;
		}		
	}

	public int getRowCountNew(String sheetName) {

		int row = wb.getSheet(sheetName).getLastRowNum();
		row = row+1;
		return row;

	}

	public int getColumnCountforotherExcelsNew(String sheetName, int row){

		try {
			int column = wb.getSheet(sheetName).getRow(row).getLastCellNum();
			return column;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public String[][] getDatafromExcel(String sheetName, int startColumn) throws Exception { 
		int startRow =1;
		int ci, cj;
		int totalRows = getRowCountNew(sheetName);
		int rowStoredinArray = totalRows-startRow;
		int totalColumns = getColumnCountforotherExcelsNew(sheetName, startRow);
		tabArray=new String[rowStoredinArray][totalColumns];
		ci = 0;
		for (int i=startRow;i<totalRows;i++, ci++) { 
			cj=0;
			for (int j=startColumn;j<totalColumns;j++, cj++){
				tabArray[ci][cj]=getDataNew(sheetName,i,j);
			}
		}
		return tabArray;
	}
}

package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constant.Constant;

public class ExcelUtilities {
	
	static FileInputStream f; //It's an inbuilt class used to read files
	   static XSSFWorkbook wb; //In built class in apache - to read details from the workbook
	   static XSSFSheet sh; //to read details from the sheet
	   
	   public static String getStringData(int a,int b,String sheet) throws IOException
	   {
	   	f=new FileInputStream(Constant.TESTDATA);
	   	wb=new XSSFWorkbook(f);
	   	sh=wb.getSheet(sheet); //it is a method used to get details from the sheet
	   	XSSFRow r=sh.getRow(a); //XSSFRow is a inbuilt class in apache used to read details from the row
	   	XSSFCell c=r.getCell(b); //XSSFCell is a inbuilt class in apache used to read details from the cell
	   	return c.getStringCellValue(); //used to get string value from the cell
	   }
	   
	   public static String getIntegerData(int a,int b,String sheet) throws IOException
	   {
		   f=new FileInputStream(Constant.TESTDATA);
		   wb=new XSSFWorkbook(f);
		   sh=wb.getSheet(sheet);
		   XSSFRow r=sh.getRow(a);
		   XSSFCell c=r.getCell(b);
		   int x=(int)c.getNumericCellValue(); //to get the numeric double value
		   return String.valueOf(x); //type conversion
	   }

}

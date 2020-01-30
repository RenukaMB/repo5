package ExcelDataDriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.apache.poi.ss.usermodel.Cell;


public class DataDrivenbook {

	public static void main(String[] args) throws IOException
	{
		ArrayList<String> a=new ArrayList<String>();
		//FileInputStream it as a power to read any file in java
		FileInputStream file=new FileInputStream("C://Users//debasis panda//Desktop//Renuka//Rest_API_Practice//src//test//java//ExcelDataDriven//dataofbook.xlsx");
		XSSFWorkbook workbook1=new XSSFWorkbook(file);
		int numberofsheets = workbook1.getNumberOfSheets();
		for(int i=0;i<numberofsheets;i++)
		{
			if(workbook1.getSheetName(i).equalsIgnoreCase("testingdata"))
			{
				XSSFSheet sheets=workbook1.getSheetAt(i);//sheet is a collection of rows
				//identify testcase column by scanning the entire 1st row
				Iterator<Row> rows=sheets.iterator();//row is a collection of cells
				Row firstrow=rows.next();// finding a first row
				Iterator<Cell> cells=firstrow.cellIterator();//iterating the cells values in first row
				
				int k=0;
				int column = 0;
				while(cells.hasNext())// hash next() will used to check next cell is present or not
				{
				Cell value=cells.next();//it will get all next cell values to compare 
				if(value.getStringCellValue().equalsIgnoreCase("TestCase"))//it will get the string value of cells and compare
				{
					column=k;
										//get a desire column  compare the cell value 
				}
				k++;			
				}
				System.out.println(column);
				//once column is identified than scan entire testcase column to identify purchase testcase row
				//after getting into column  we are pointing to next row 
				while(rows.hasNext())
				{
				Row	r=rows.next();
				if(r.getCell(column).getStringCellValue().equalsIgnoreCase("Purchase"))
				{
					//after you grab purchase testcase row=pull all the data of that row and feed into test
					
				Iterator<Cell> cellvalue=r.cellIterator();
				while(cellvalue.hasNext())
				{
					System.out.println(cellvalue.next().getStringCellValue());
				}
				
				}
				}
				
}
			
		}
		
	}

}

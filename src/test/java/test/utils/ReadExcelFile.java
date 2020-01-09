package test.utils;

import java.io.File;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadExcelFile {
	public String readCell(int row,int col) throws IOException, BiffException
	{
		Workbook wb=Workbook.getWorkbook(new File(Constants.CONTENT_LETTER_FILE_PATH));
		Sheet sh=wb.getSheet(0);
		return sh.getCell(row,col).getContents();
	}

}

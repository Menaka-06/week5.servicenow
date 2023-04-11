package week5day2.devproj;
	import java.io.IOException;

	import org.apache.poi.xssf.usermodel.XSSFCell;
	import org.apache.poi.xssf.usermodel.XSSFRow;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	public class ExcelSheetInput {

		public static String[][] inputData(String excelSheet) throws IOException {
			XSSFWorkbook wb = new XSSFWorkbook("./DataforExcel/servicenowxl.xlsx");
			XSSFSheet sheet = wb.getSheet(excelSheet);
			int RowNum = sheet.getLastRowNum();
			short CellNum = sheet.getRow(0).getLastCellNum();
			//pass data
			String[][] data= new String[RowNum][CellNum];
		for (int i = 1; i <=RowNum; i++) 
		{
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j <CellNum; j++) 
			{
				XSSFCell cell = row.getCell(j);
			
			data[i-1][j] = cell.getStringCellValue();
			System.out.println(cell.getStringCellValue());
		}
			}
		wb.close();
		return data;
		}}

	



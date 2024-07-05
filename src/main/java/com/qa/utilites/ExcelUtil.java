

public class ExcelUtil {
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook book;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style;

	public static int getRowCount(String filePath, String sheetName) throws IOException {
		fis = new FileInputStream(filePath);
		book = new XSSFWorkbook(fis);
		sheet = book.getSheet(sheetName);
		int rows = sheet.getLastRowNum();
		book.close();
		fis.close();
		return rows;
	}

	public static int getCellCount(String filePath, String sheetName) throws IOException {
		fis = new FileInputStream(filePath);
		book = new XSSFWorkbook(fis);
		sheet = book.getSheet(sheetName);
		int rows = sheet.getLastRowNum();
		int cells = sheet.getRow(0).getLastCellNum();
		book.close();
		fis.close();
		return cells;
	}

	public static String readExcelFile(String filePath, String sheetName, int rowNum, int cellNum) throws IOException {
		fis = new FileInputStream(filePath);
		book = new XSSFWorkbook(fis);
		sheet = book.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		cell = sheet.getRow(0).getCell(cellNum);
		String data;
		try {
			data = cell.toString();
		} catch (Exception e) {
			data = "";
		}
		book.close();
		fis.close();
		return data;

	}

	public static void writeExcelFile(String filePath, String sheetName, int rowNum, int cellNum, String data)
			throws IOException {
		fis = new FileInputStream(filePath);
		book = new XSSFWorkbook(fis);
		sheet = book.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		cell = row.createCell(cellNum);
		cell.setCellValue(data);
		fos = new FileOutputStream(filePath);
		book.write(fos);
		book.close();
		fis.close();
		fos.close();

}

package ultis;

import constants.FrameworkConstants;
import exception.InvalidInputOutputException;
import exception.InvalidPathForExcelException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ExcelUtils {
    private ExcelUtils() {

    }

    public static List<Map<String,String>> getTestDetails(String sheetname){
        List<Map<String,String>> list = null;
        System.out.println(FrameworkConstants.getExcelFilePath());
        try(FileInputStream fs = new FileInputStream(FrameworkConstants.getExcelFilePath())) {

            XSSFWorkbook workbook = new XSSFWorkbook(fs);
            XSSFSheet sheet = workbook.getSheet(sheetname);

            int lastrownum = sheet.getLastRowNum();
            int lastcolnum = sheet.getRow(0).getLastCellNum();

            Map<String,String> map =null;
            list = new ArrayList<>();

            for(int i=1; i<=lastrownum;i++) {
                map = new HashMap<>();
                for(int j=0;j<lastcolnum;j++) {
                    String key = sheet.getRow(0).getCell(j).getStringCellValue();
                    XSSFCell cell = sheet.getRow(i).getCell(j);
                    String value = cell.getCellType() == CellType.STRING ? cell.getStringCellValue() : String.valueOf((int) cell.getNumericCellValue());
                    map.put(key, value);
                }
                list.add(map);
            }
            workbook.close();

        } catch (FileNotFoundException e) {
            throw new InvalidPathForExcelException("Excel file given is not found");
        } catch (IOException e) {
            throw new InvalidInputOutputException("Some IO exception while reading excel file");
        }
//        System.out.println(list);
        return list;

    }


}




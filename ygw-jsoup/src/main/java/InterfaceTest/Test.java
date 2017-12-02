package InterfaceTest;

import http.Request;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by weiyg on 01/12/2017.
 */
public class Test {
    public static void main(String[] args) {
        try {
            String excelPath = "D:\\Java\\Study\\jsoup\\InterFaceTestCase.xlsx";    // 创建 Excel 文件的输入流对象
            FileInputStream excelFileInputStream = new FileInputStream(excelPath);
            XSSFWorkbook workbook = new XSSFWorkbook(excelFileInputStream);   // XSSFWorkbook 就代表一个 Excel 文件,创建其对象，就打开这个 Excel 文件
            excelFileInputStream.close();   //输入流使用后，及时关闭！这是文件流操作中极好的一个习惯！

            XSSFSheet sheetData = workbook.getSheetAt(0);

            System.out.println("存在"+sheetData.getLastRowNum()+"行数据"+"\n"+"存在"+sheetData.getPhysicalNumberOfRows()+"列数据");
            Map<String,Object> map=new HashMap<String,Object>();
            for (int rowIndex = 1; rowIndex <= sheetData.getLastRowNum(); rowIndex++) {
                XSSFRow row = sheetData.getRow(rowIndex);
                if (row == null && rowIndex <= sheetData.getLastRowNum()) {
                    System.out.println("[current row is null,rowIndex is" + rowIndex + " ]");
                    continue;
                }
                System.out.println("current rowIndex：" + "[" + rowIndex + "]");
                String groupIndex = row.getCell(13).getRawValue();
                System.out.println(groupIndex);
            }
            workbook.close();            // 操作完毕后，记得要将打开的 XSSFWorkbook 关闭

        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}

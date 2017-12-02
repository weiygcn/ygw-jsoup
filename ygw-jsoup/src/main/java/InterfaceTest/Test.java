package InterfaceTest;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

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
            Map<Integer, Map<String, Object>> map = new Map<Integer, Map<String, Object>>() {
                @Override
                public int size() {
                    return 0;
                }

                @Override
                public boolean isEmpty() {
                    return false;
                }

                @Override
                public boolean containsKey(Object key) {
                    return false;
                }

                @Override
                public boolean containsValue(Object value) {
                    return false;
                }

                @Override
                public Map<String, Object> get(Object key) {
                    return null;
                }

                @Override
                public Map<String, Object> put(Integer key, Map<String, Object> value) {
                    return null;
                }

                @Override
                public Map<String, Object> remove(Object key) {
                    return null;
                }

                @Override
                public void putAll(Map<? extends Integer, ? extends Map<String, Object>> m) {

                }

                @Override
                public void clear() {

                }

                @Override
                public Set<Integer> keySet() {
                    return null;
                }

                @Override
                public Collection<Map<String, Object>> values() {
                    return null;
                }

                @Override
                public Set<Entry<Integer, Map<String, Object>>> entrySet() {
                    return null;
                }

                @Override
                public boolean equals(Object o) {
                    return false;
                }

                @Override
                public int hashCode() {
                    return 0;
                }
            };

            for (int rowIndex = 1; rowIndex <= sheetData.getLastRowNum(); rowIndex++) {
                XSSFRow row = sheetData.getRow(rowIndex);
                if (row == null && rowIndex <= sheetData.getLastRowNum()) {
                    System.out.println("[current row is null,rowIndex is" + rowIndex + " ]");
                    continue;
                }
                System.out.println("current rowIndex：" + "[" + rowIndex + "]");
                Map<String,Object> mapsoon=new Map<String, Object>() {
                    @Override
                    public int size() {
                        return 0;
                    }

                    @Override
                    public boolean isEmpty() {
                        return false;
                    }

                    @Override
                    public boolean containsKey(Object key) {
                        return false;
                    }

                    @Override
                    public boolean containsValue(Object value) {
                        return false;
                    }

                    @Override
                    public Object get(Object key) {
                        return null;
                    }

                    @Override
                    public Object put(String key, Object value) {
                        return null;
                    }

                    @Override
                    public Object remove(Object key) {
                        return null;
                    }

                    @Override
                    public void putAll(Map<? extends String, ?> m) {

                    }

                    @Override
                    public void clear() {

                    }

                    @Override
                    public Set<String> keySet() {
                        return null;
                    }

                    @Override
                    public Collection<Object> values() {
                        return null;
                    }

                    @Override
                    public Set<Entry<String, Object>> entrySet() {
                        return null;
                    }
                };

                for (int cell=0;cell<row.getPhysicalNumberOfCells();cell++){
                    int titleRow=0;
                    XSSFRow rowFirst = sheetData.getRow(titleRow);
//
//                    String No=row.getCell(1).getRawValue();
//                    String APIPurposeValue=row.getCell(2).getRawValue();
//                    String APIHostValue=row.getCell(3).getRawValue();
//                    String RequestURLValue=row.getCell(4).getRawValue();
//                    String RequestMethodValue=row.getCell(5).getRawValue();
//                    String HeaderContentTypeValue=row.getCell(6).getRawValue();
//                    String HeaderXCertTokenValue=row.getCell(7).getRawValue();
//                    String HeaderXCertUidValue=row.getCell(8).getRawValue();
//                    String RequestBodyValue=row.getCell(9).getRawValue();
//                    String EncryptionValue=row.getCell(10).getRawValue();
//                    String CheckPointValue=row.getCell(11).getRawValue();
//                    String ActiveValue=row.getCell(12).getRawValue();
//                    String CorrelationValue=row.getCell(13).getRawValue();
//                    String groupID = row.getCell(14).getRawValue();

                    String key=rowFirst.getCell(cell).getRawValue();
                    String value= row.getCell(cell).getRawValue();
                    mapsoon.put(key,value);
                    map.put(rowIndex,mapsoon);
                    System.out.println(mapsoon.get("RequestURL"));
                    System.out.println("=====================");
//                    System.out.println(map.toString());

                }
            }
            System.out.println(map.toString());
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

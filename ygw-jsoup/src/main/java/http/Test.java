package http;

import java.util.Date;
import java.text.SimpleDateFormat;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fcibook.quick.http.QuickHttp;
import com.microsoft.schemas.office.visio.x2012.main.CellType;
import org.apache.http.entity.ContentType;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * XSSFSheet 代表 Excel 文件中的一张表格,
 * 我们通过 getSheetAt(0) 指定表格索引来获取对应表格,
 * 注意表格索引从 0 开始！
 * 开始循环表格数据,表格的行索引从 0 开始
 * sheet.getLastRowNum() : 获取当前表格中最后一行数据对应的行索引
 * XSSFRow 代表一行数据
 */
public class Test {
    static Long startTime = System.currentTimeMillis();

    public static void main(String args[]) {
        Request req = new Request();
        try {
            String excelPath = "D:\\\\Study\\\\InterFaceTestCase.xlsx";            // 创建 Excel 文件的输入流对象
            FileInputStream excelFileInputStream = new FileInputStream(excelPath);
            XSSFWorkbook workbook = new XSSFWorkbook(excelFileInputStream);            // XSSFWorkbook 就代表一个 Excel 文件,创建其对象，就打开这个 Excel 文件
            excelFileInputStream.close();            //输入流使用后，及时关闭！这是文件流操作中极好的一个习惯！

            XSSFSheet sheetData = workbook.getSheetAt(0);
            XSSFSheet sheetReport = workbook.getSheetAt(2);


            System.out.println("存在"+sheetData.getLastRowNum()+"行数据"+"\n"+"存在"+sheetData.getPhysicalNumberOfRows()+"列数据");
            for (int rowIndex = 1; rowIndex <= sheetData.getLastRowNum(); rowIndex++) {
                XSSFRow row = sheetData.getRow(rowIndex);
                if (row == null && rowIndex <= sheetData.getLastRowNum()) {
                    System.out.println("[current row is null,rowIndex is" + rowIndex + " ]");
                    continue;
                }

                //测试数据sheet页表列字段定义及取值
                XSSFCell No = row.getCell(0);
                XSSFCell apihost = row.getCell(2);//Request Domain
                XSSFCell requestURL = row.getCell(3); // Interface Address
                XSSFCell requestMethod = row.getCell(4); //Request Type
                XSSFCell headerContentType = row.getCell(5); //Head Context Type
                XSSFCell headerXCertToken = row.getCell(6); //token Infomation
                XSSFCell headerXCertUid = row.getCell(7);// UID Infomation
                XSSFCell requestBody = row.getCell(8);//Request Body
                XSSFCell checkPoint = row.getCell(10);//Response

                System.out.println("current rowIndex：" + "[" + rowIndex + "]");

                //测试报告sheet页字段定义
                int currentLastRowIndex = sheetReport.getLastRowNum(); //获取存在数据的最后一行index
                int newRowIndex = currentLastRowIndex + 1; //定义执行写入数据的行index
                XSSFRow newRow = sheetReport.createRow(newRowIndex);
                int sheetReportCell_No_Index = 1;
                int sheetReportCell_apiInterface_Index = 2;
                int sheetReportCell_Report_Index = 3;
                int sheetReportCell_Response_Index = 4;
                int sheetReportCell_sTime_Index = 5;
                int sheetReportCell_Excut_Index = 6;

                Date nowTime = new Date();
                new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒").format(nowTime);

                final String uid = headerXCertUid.getRawValue();
                final String url = apihost.toString().trim() + requestURL.toString().trim();
                final String body = requestBody == null ? "" : requestBody.toString();

                HashMap<String, Object> map = req.apiTest(url, body, headerXCertToken.toString(), uid);

                XSSFCell newNo = newRow.createCell(sheetReportCell_No_Index, Cell.CELL_TYPE_STRING);
                newNo.setCellValue(No.getRawValue());
                XSSFCell apiInterface = newRow.createCell(sheetReportCell_apiInterface_Index, Cell.CELL_TYPE_STRING);
                apiInterface.setCellValue(url);
                XSSFCell Report = newRow.createCell(sheetReportCell_Report_Index, Cell.CELL_TYPE_STRING);
                Report.setCellValue(map.get("report").toString());
                XSSFCell sTime = newRow.createCell(sheetReportCell_sTime_Index, Cell.CELL_TYPE_STRING);
                sTime.setCellValue(map.get("sTime").toString());
                XSSFCell Response = newRow.createCell(sheetReportCell_Response_Index, Cell.CELL_TYPE_STRING);
                Response.setCellValue(map.get("interfaceResp").toString());
                XSSFCell ExcuteTime = newRow.createCell(sheetReportCell_Excut_Index, Cell.CELL_TYPE_STRING);
                ExcuteTime.setCellValue(nowTime.toString());

                FileOutputStream fileOutputStream = new FileOutputStream(excelPath);
                workbook.write(fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
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

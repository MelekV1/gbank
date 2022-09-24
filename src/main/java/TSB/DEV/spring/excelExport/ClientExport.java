package TSB.DEV.spring.excelExport;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import TSB.DEV.spring.model.Client;
 
public class ClientExport {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<Client> listUsers;
     
    public ClientExport(List<Client> listUsers) {
        this.listUsers = listUsers;
        workbook = new XSSFWorkbook();
    }
 
 
    private void writeHeaderLine() {
        sheet = workbook.createSheet("Users");
         
        Row row = sheet.createRow(0);
         
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
        
        createCell(row, 0, "ID client", style);    
        createCell(row, 1, "Nom de client", style);      
        createCell(row, 2, "Numero de Tel", style);       
//        createCell(row, 2, "FirstName", style);    
//        createCell(row, 3, "LastName", style);
         
    }
     
    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        }
        else if (value instanceof Long) {
            cell.setCellValue((Long) value);
        }
        else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }
     
    private void writeDataLines() {
        int rowCount = 1;
 
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);
                 
        for (Client user : listUsers) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
             
          createCell(row, columnCount++, user.getId(), style);
            createCell(row, columnCount++, user.getNom(), style);
            createCell(row, columnCount++, user.getNumTel(), style);
            //createCell(row, columnCount++, user.getLastName(), style);
           // createCell(row, columnCount++, "--", style);
             
        }
    }
     
    public void export(HttpServletResponse response) throws IOException {
        writeHeaderLine();
        writeDataLines();
         
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
         
        outputStream.close();
         
    }
}
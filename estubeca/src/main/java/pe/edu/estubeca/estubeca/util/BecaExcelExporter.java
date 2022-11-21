package pe.edu.estubeca.estubeca.util;

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
import pe.edu.estubeca.estubeca.entities.Beca;


public class BecaExcelExporter {

    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<Beca> beca;


    public BecaExcelExporter (List<Beca> becas) {
        this.beca = becas;
        workbook = new XSSFWorkbook();
    }

    private void writeHeaderLine() {
        sheet = workbook.createSheet("Lista de Becas");
        Row row = sheet.createRow(0);
        CellStyle style = workbook.createCellStyle();

        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);

        createCell(row, 0, "ID", style);
        createCell(row, 1, "Title", style);
        createCell(row, 2, "Imagen", style);
        createCell(row, 3, "Description", style);
        createCell(row, 4, "Requisitos", style);
        createCell(row, 5, "Telefono", style);
        createCell(row, 6, "URL", style);
        createCell(row, 7, "Beneficios", style);
    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style) {

        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);

        if(value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if(value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        } else {
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

        for( Beca result: beca) {

            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            createCell(row, columnCount++, String.valueOf(result.getId()), style);
            createCell(row, columnCount++, result.getTitle(), style);
            createCell(row, columnCount++, result.getImgUrl(), style);
            createCell(row, columnCount++, result.getDescription(), style);
            createCell(row, columnCount++, result.getRequisitos(), style);
            createCell(row, columnCount++, result.getTelefono(), style);
            createCell(row, columnCount++, result.getUrlPage(), style);
            createCell(row, columnCount++, result.getBeneficios(), style);
        }
    }


    public void export(HttpServletResponse response) throws IOException {

        writeHeaderLine(); //write the header
        writeDataLines(); //write the data

        ServletOutputStream servletOutput = response.getOutputStream();
        workbook.write(servletOutput);
        workbook.close();

        servletOutput.close();


    }
}

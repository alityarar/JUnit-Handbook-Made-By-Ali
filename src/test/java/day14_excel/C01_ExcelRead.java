package day14_excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ExcelRead {
    @Test
    public void readExcel() throws IOException {


        String dosyaYolu="src/resources/ulkeler.xlsx";

        FileInputStream fis= new FileInputStream(dosyaYolu);

        Workbook workbook= WorkbookFactory.create(fis);

        Sheet sheet= workbook.getSheet("Dünyada Ülkeler Listesi");

        Row row=sheet.getRow(1);
        Cell cell=row.getCell(1);

        System.out.println(cell);

        String expectedText="Dünya";
        String actualText=cell.toString();

        Assert.assertEquals(expectedText,actualText);


    }
}

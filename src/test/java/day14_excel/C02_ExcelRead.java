package day14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;

public class C02_ExcelRead {
    @Test
    public void readExcelTest() throws Exception {

        String dosyaYolu="src/resources/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);

        String actualData=workbook
                            .getSheet("Dünyada Ülkeler Listesi")
                            .getRow(2)
                            .getCell(2).toString();

        System.out.println(actualData);

    }
}

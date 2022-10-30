package day15_writeExcel_screenshot;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C01_ExcelWrite {

    @Test
    public void WriteExcel() throws IOException {

        String dosyaYolu="src/resources/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);

        //4.hucreye yeni bir cell olusturalim
        workbook.getSheet("Sayfa")
                .getRow(0)
                .createCell(5)
                .setCellValue("Nufus");

        //Altina bir data girelim

        //4.hucreye yeni bir cell olusturalim
        workbook.getSheet("Sayfa")
                .getRow(1)
                .createCell(5)
                .setCellValue("Bilinmiyor");


        //Dosyayi kaydedelim

        FileOutputStream fos=new FileOutputStream(dosyaYolu);
        workbook.write(fos);

        //Dosyayi kapatalim

        fis.close();
        fos.close();




    }
}

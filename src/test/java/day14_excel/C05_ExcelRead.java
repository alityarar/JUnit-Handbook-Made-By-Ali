package day14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C05_ExcelRead {

    @Test
    public void test() throws IOException {

        String dosyaYolu="src/resources/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);

        //Sayfa 1 e gidip
        //Satir sayisinin 25\ kullanilan satir sayisinin ise 12 oldugunu test edin

        int sonSatirIndex=workbook.getSheet("Sayfa1").getLastRowNum();
        int expectedSatir=28;

        Assert.assertEquals(expectedSatir,sonSatirIndex+1);


        int kullanilanSatirSayisi=workbook.getSheet("Sayfa1").getPhysicalNumberOfRows();

        //.getPhysicalNumberOfRows()   bize kullanilan satir sayisini verir

        int expectedKullanilanSatir=12;

        Assert.assertEquals(expectedKullanilanSatir,kullanilanSatirSayisi);


    }
}

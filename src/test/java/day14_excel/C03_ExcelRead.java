package day14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_ExcelRead {
    @Test
    public void test() throws IOException {

        /*
        input olarak verilen satirno ve sutunno degerlerini parametre
        olarak alip o celldeki datayi String olarak bana donduren bir
        method olusturun
         */

        int satirNo=2;
        int sutunNo=2;

        String expectedText="Düny";

        String actualText=banaDataGetir(satirNo-1,sutunNo-1); //Cunku excel index ile calisir


        Assert.assertEquals(expectedText,actualText);

    }

    public static String banaDataGetir(int satirIndex, int sutunIndex) throws IOException {

        String istenenData="";

        String dosyaYolu="src/resources/ulkeler.xlsx";

        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);
        istenenData=workbook
                .getSheet("Dünyada Ülkeler Listesi")
                .getRow(satirIndex)
                .getCell(sutunIndex)
                .toString();




        return istenenData;
    }
}

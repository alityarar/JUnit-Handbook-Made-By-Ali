package day14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C04ExcelRead {
    @Test
    public void test1() throws IOException {


        String dosyaYolu="src/resources/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);

        //ulkeler sutununu yazdiralim

        int sonsatir=workbook.getSheet("Dünyada Ülkeler Listesi").getLastRowNum();
        System.out.println(sonsatir);

        String satirdakiData="";

        for (int i = 0; i <=sonsatir ; i++) {

            satirdakiData=C03_ExcelRead.banaDataGetir(i,1);
            System.out.println(satirdakiData);
        }

    }
}

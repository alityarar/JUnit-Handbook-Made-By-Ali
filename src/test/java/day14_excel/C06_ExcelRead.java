package day14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C06_ExcelRead {

    @Test
    public void test() throws IOException {



        /*
        Excel dosyasindaki tum verileri classimiza alip bir Javva objesine
        store edelim. Boylece her seferinde excel e ulas satir sutun yapmayalim

        Database yapisinda olan excel i koyabilecegimiz en uygun java objesi
        map dir.
         */

        Map<String,String> ulkelerMap=new HashMap<>();

        String dosyaYolu="src/resources/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);
        int sonSatirIndex=workbook.getSheet("Dünyada Ülkeler Listesi").getLastRowNum();

        for (int i = 0; i <=sonSatirIndex ; i++) {
            String key=workbook.getSheet("Dünyada Ülkeler Listesi").getRow(i).getCell(0).toString();

            //value ise i.satirdaki 1,2,3.indexdeki data olacak

            String value = workbook.getSheet("Dünyada Ülkeler Listesi").getRow(i).getCell(1).toString()
                    +"/ "
                    +workbook.getSheet("Dünyada Ülkeler Listesi").getRow(i).getCell(2).toString()
                    +"/ "
                    +workbook.getSheet("Dünyada Ülkeler Listesi").getRow(i).getCell(3).toString();

            ulkelerMap.put(key,value);
            System.out.println(key+", "+value);





        }
        System.out.println(ulkelerMap);

        //Listede Gana oldugunu test edelim

        Assert.assertTrue(ulkelerMap.keySet().contains("Dünya"));








    }

}

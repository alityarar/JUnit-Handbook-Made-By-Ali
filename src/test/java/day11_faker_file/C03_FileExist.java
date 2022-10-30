package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C03_FileExist {

    @Test
    public void test(){


        System.out.println(System.getProperty("user.dir"));
        //C:\Users\Ders\Desktop\com.Batch59JUnit
        //Bana icinde oldugum projenin dosya yolunu (path) verir

        System.out.println(System.getProperty("user.home"));
        //C:\Users\Ders  yani benim bilgisayarimin benim kullanici yolumu verdi

        //C:\Users\Ders\Desktop\text.txt"

        String dosyayolu=System.getProperty("user.home")+"\\Desktop\\text.txt";
        System.out.println(dosyayolu);

        /*
        Bilgisayarimizdaki bir dosyanin varligini test etmek icin
        once o dosyaya ulasmaliyiz. Java da dosyaya erisim icin dosya yolu (path) ihtiyaci vardir
        Her bilgisayarin kullanici adi farkli olacagindan masaustu dosya yolu da birbirinden
        farkli olacaktir. Testlerimizin tum bilgisayarlarda calismasi icin dosya yolunu
        DINAMIK yapmak zorundayiz

        Bunun icin

        Her bilgisayarin birbirinden farkli olan yolunu bulmak icin

        String farkliKisim=System.getproperty("user.home")

        Herkesin bilgisayarinda ortak olan kisim ise

        String ortakKisim="\Desktop\text.txt"

        String dosyayolu=farkliKisim+ortakKisim;

         */
        System.out.println(Files.exists(Paths.get(dosyayolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyayolu)));

    }

}

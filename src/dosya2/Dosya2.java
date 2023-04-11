/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dosya2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
class DosyaOlusturma{
       void dosyalamaElit(String isim,String soyisim,String mail){
           try {
                 File dosya = new File("ElitUye.txt");
                 System.out.println("dfgf");
                  FileWriter yazici = new FileWriter(dosya,false);
                  System.out.println("dfgf");
                  BufferedWriter yaz = new BufferedWriter(yazici);
                   yaz.write(isim+" "+soyisim+" "+mail);
                   yaz.close();
                  System.out.println("Yazma İşlemi Başarılı");
           } catch (IOException e) {
               System.out.println("veri yazılmadı!!");
           }
       }
       void dosyalamaGenel(String isim,String soyisim,String mail){
           try {
                 File dosya = new File("GenelUye.txt");
                  FileWriter yazici = new FileWriter(dosya,false);
                  BufferedWriter yazma = new BufferedWriter(yazici);
                   yazma.write(isim+"  "+soyisim+"   "+mail);
                   yazma.close();
                  System.out.println("Yazma İşlemi Başarılı");
           } catch (IOException e) {
               System.out.println("veri yazılmadı!!");
           }
       }
}
class dosyaOkuma{

 
  private  static void readFile(File myFile) throws IOException
     { 
    int lineNumber = 0;
         try
         {
         BufferedReader reader = new BufferedReader(new FileReader(myFile));
         String satir = reader.readLine();
             while (satir!=null) {
              if(satir.length()>0){
               lineNumber++;
              }
              satir = reader.readLine();                
             }    
         }catch(final IOException e){}
         System.out.println("Verilen Dökümandaki Satır Sayısı: "+lineNumber);
     }
      
    void satır(String yol) 
        throws FileNotFoundException, IOException{
         MailSender m=new MailSender();
        
        BufferedReader inputStream = null;
		PrintWriter outputStream = null;
             
		try {
			inputStream = new BufferedReader(new FileReader(yol));
 			String satir;
			while ((satir = inputStream.readLine()) != null) {
				//konsola yazdırma
                                String [] dizi=satir.split(" ");
				System.out.println(dizi[2]);
                               
			}
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
			
		}
    }

     void dosyaOku(String yol ) throws IOException{
         
       File dosya=new File(yol);

       char[] data=new char[(int)dosya.length()];

       try {

          FileReader fr=new FileReader(dosya);

          fr.read(data);//Dosyadan okunan veri char dizisine aktarılıyor

      }

      catch (IOException e) {
        System.err.println("Dosya okunamadı");//Hata oluştuğunda uyarı mesajı döner

      } 
       File myFile=new File(yol);
       readFile(myFile);
       String veri="";
       for (int i = 0; i <data.length; i++) {
            veri+=data[i];
        }
       String[] bol = veri.split(" ");
        for(int j = 0; j <bol.length; j++) {
            if((j+1)%3 ==0){
             System.out.println(bol[j]);
            } 
        }
        
    }
}
public class Dosya2 {
    public static void main(String[] args) throws IOException {
        DosyaOlusturma olustur=new DosyaOlusturma();
        dosyaOkuma okuma=new dosyaOkuma();
        Scanner input=new Scanner(System.in);
        System.out.println("hoşgeldiniz");
        System.out.println("1- Elit üye ekleme ");
        System.out.println("2- Genel üye ekleme ");
        System.out.println("3- Mail gönderme ");
        System.out.print("şeçiminiz: ");
        int giris=input.nextInt();
        String isim,soyisim,email;
        switch (giris) {
            case 1:
                System.out.print("\nLütfen isminizi girinz:");
                isim=input.next();
                //soyisim=input.nextLine();
                System.out.print("\nLitfen soyisminizi girinz:");
                soyisim=input.next();
                System.out.print("\nlitfen email girinz:");
                email=input.next();
                olustur.dosyalamaElit(isim, soyisim, email);
                break;
            case 2:
                 System.out.print("\nLütfen isminizi girinz:");
                isim=input.next();
                //soyisim=input.nextLine();
                System.out.print("\nLitfen soyisminizi girinz:");
                soyisim=input.next();
                System.out.print("\nlitfen email girinz:");
                email=input.next();
                olustur.dosyalamaElit(isim, soyisim, email);
                break;
            case 3:
                System.out.println("1- Elit üye mail ");
                System.out.println("2- Genel üye mail");
                System.out.println("3- tüm üyelere mail ");
                int giris2=input.nextInt();
                switch (giris2) {
                    case 1:
                        String yol="C:\\Users\\evind\\OneDrive\\Belgeler\\NetBeansProjects\\dosya2\\ElitUye.txt";
                        //okuma.dosyaOku(yol);
                        okuma.satır(yol);
                        break;
                    case 2:
                        
                        break;
                    default:
                        throw new AssertionError();
                }
                break;
            default:
                throw new AssertionError();
               
        }
      
    }
    
}

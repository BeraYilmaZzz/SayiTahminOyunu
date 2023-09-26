import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Random rand = new Random() ; // rastgele sayı seçme komutumuz
        int number = rand.nextInt(100);  // 100 e kadar olan sayıların içinden seçtiriyoruz

        int [] wrong = new int [5]; // 5 satırlık dizi oluşturuyoruz

        Scanner inp = new Scanner(System.in);
        int right = 0 ;
        boolean isSign = false;
        boolean isWin = false;
        System.out.println(number); // rastgele seçilen kodu ekrana yazdıran kod, dilerseniz silebilirsiniz.

        do { // while (right < 5) ; olana kadar bu döngüyü devam ettirtiyoruz

            System.out.print("Sayı giriniz = ");
            int value = inp.nextInt();
            if (value < 0 || value > 100) {
                System.out.println("Lütfen geçerli aralıklarda bir değer giriniz !!!");
                if(isSign){
                    right += 1;
                    System.out.println("Çok fazla hatalı giriş yaptınız. Kalan hak : " + (5 - right));
                }else{
                    isSign = true;
                    System.out.println("Bir daha hatalı girişinizde hakkınızdan düşülecektir.");
                }
            } else {
                if (value == number) {
                    isWin = true;
                    break;
                } else {
                    wrong[right] = value;
                    right += 1;
                    if (value < number) {
                        System.out.println("Girdiğiniz sayı hedeften küçüktür !");
                    } else {
                        System.out.println("Girdiğiniz sayı hedeften büyüktür !");
                    }
                    System.out.println("Kalan Hakkınız = " + (5 - right));
                }
            }
        }while (right < 5) ;
        if(isWin){
            System.out.println("KAZANDINIZ TEBRİKLER");
        }else{
            System.out.println("KAYBETTİNİZ !! ");
            System.out.println("Yanlış tahminleriniz = " + Arrays.toString(wrong));
        }
    }
}


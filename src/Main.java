import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Değişkenlerin tanımlanması
        double kmFiyat = 0.10, tutar;
        int gidilecekKM, yolculukTipi, yas, durum = 0, secim;

        //Scanner sınıfının import edilmesi
        Scanner input = new Scanner(System.in);

        //Program kapanana kadar çalışmasına devam edilmesi için while kullanılmıştır.
        while (durum == 0) {
            //Kullanıcıdan Gidilicek KM bilgisinin alınması
            System.out.print("Mesafeyi KM türünde giriniz : ");
            gidilecekKM = input.nextInt();

            //Kullanıcıdan yaş bilgisinin alınması
            System.out.print("Lütfen yaşınızı giriniz : ");
            yas = input.nextInt();

            //Kullanıcıdan yolculuk tipi bilgisinin alınması
            System.out.println("Yolculuk tipini seçiniz.");
            System.out.println("1 => Tek Yön\n2 => Gidiş - Dönüş");
            yolculukTipi = input.nextInt();

            tutar = gidilecekKM * kmFiyat;

            if (yas < 0 || gidilecekKM <= 0 || (yolculukTipi < 1 || yolculukTipi > 2)) {
                System.out.println("Hatalı bir değer girişi yapıldı. Lütfen tekrar deneyiniz.");
            } else {
                //Yaş bilgisine göre indirim hesaplama
                if (yas < 12) {
                    tutar = tutar * 0.50;
                } else if (yas > 12 && yas < 24) {
                    tutar = tutar * 0.9;
                } else if (yas > 65) {
                    tutar = tutar * 0.7;
                } else {
                    tutar = tutar;
                }

                //Yolculuk tpinie göre indirim hesaplama
                if (yolculukTipi == 2) {
                    tutar = (tutar * 0.8) * 2;
                } else {
                    tutar = tutar;
                }

                //Sonucun ekrana yazdırılması
                System.out.println("Bilet Fiyatınız : " + tutar + " TL");

                //Tekrar seçim yapılması için kullanıcıdan alınacak seçim
                System.out.println("1-Tekrar Hesapla\n2-Kapat");
                secim = input.nextInt();
                if (secim == 2) {
                    durum = -1;
                    System.out.println("Sistem kapatılmıştır. İyi günler dileriz.");
                } else if (secim == 1) {
                    durum = 0;
                } else {
                    System.out.println("Hatalı seçim yaptınız.");
                    durum = -1;
                }
            }
        }
    }
}
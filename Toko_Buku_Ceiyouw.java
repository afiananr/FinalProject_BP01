/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Toko.Buku;

import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Toko_Buku_Ceiyouw {
     
    
    public static final String bluewhite = "\u001B[34;47m";
    public static final String blue = "\u001B[34m";
    public static final String white = "\u001B[47m";
    public static final String reset = "\u001B[0m";
    static LocalDateTime currentDateTime = LocalDateTime.now();
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    static Scanner s = new Scanner(System.in);
    static int total, uang;
    static String nama;
    static String daftar [][]={
        {"Hello", "Tere Liye", "99000"}, {"Bumi", "Tere Liye", "99000"},
        {"Educated", "Tara Westover", "128000"}, {"Dilan", "Pidi Baiq", "153000"},
        {"Tabi", "Marchella FP", "189000"}, {"Pulang", "Tere Liye", "99000"},
        {"Sapiens", "Yuval NH", "125000"}, {"Meditation", "Marcus A", "89000"},
        {"Insecurity", "Alvi S", "89000"}, {"Nebula", "Tere Liye","99000"}
    };
    static ArrayList<String> keranjangBuku = new ArrayList<>();

    public static void main(String[] args) {
        //tampilan awal
        System.out.println(blue+ "====================================================="+reset);
        System.out.println(bluewhite+"         Selamat Datang Di Toko Buku Ceiyouw         "+reset);
        System.out.println(blue+ "====================================================="+reset);
        System.out.print("Silakan tulis nama anda: ");
        nama = s.next();
        menu ();
    }
    
    public static void menu (){
        //tampilan menu
        System.out.println("");
        System.out.println(blue+"Hallo... "+nama+" <3"+reset+"\nSilakan pilih menu");
        System.out.println("1. Daftar buku\n2. Cari buku\n3. Cek keranjang\n4. Exit");
        System.out.print("Ketik disini: ");
        int pilih = s.nextInt();
        switch (pilih){
            case 1:
                daftarbuku();break;
            case 2:
                caribuku();break;
            case 3:
                cekkeranjang();break;
            case 4:
                System.out.println(blue+ "====================================================="+reset);
                System.out.println(bluewhite+"            Terimakasih Telah Berkunjung            "+reset);
                System.out.println(blue+ "====================================================="+reset);
                System.exit(0);
            default:
                menu ();  
        }
    }
        
    public static void daftarbuku (){
        //menu daftar buku
        System.out.println("");
        System.out.println(blue+ "====================================================="+reset);
        System.out.println(bluewhite+"              DAFTAR BUKU YANG TERSEDIA              "+reset);
        System.out.println(blue+ "====================================================="+reset);
        System.out.println(white+"|         Judul         |    Penulis    |   Harga   |"+reset);
        for (int i = 0; i < daftar.length - 1; i++) {
            for (int j = 0; j < daftar.length - i - 1; j++) {
                if (daftar[j][0].compareTo(daftar[j + 1][0]) > 0) {
                    String[] temp = daftar[j];
                    daftar[j] = daftar[j + 1];
                    daftar[j + 1] = temp;
                }
            }
        }
        for (String[] book : daftar) {
            System.out.printf("%-25s %-15s Rp %-10s %n", book[0], book[1], book[2]);
        }
        daftarbuku2 ();
    }
    
    public static void daftarbuku2 (){
        //tampilan menu untuk menu daftar buku
        System.out.println("");
        System.out.println(blue+"Silakan pilih menu"+reset);
        System.out.println("1. Cari buku\n2. Masukkan Keranjang\n3. Back");
        System.out.print("Ketik disini: ");
        int pilih = s.nextInt();
        switch (pilih){
            case 1:
                caribuku();break;
            case 2:
                masukkeranjang();break;
            case 3:
                menu ();break;
            default:
                daftarbuku2 ();  
        }
    }

    public static void caribuku (){
        //menu untuk mencari buku
        System.out.println("");
        System.out.println(blue+"Buku apa yang ingin anda cari?? "+reset);    
        System.out.print("Ketik judul buku disini: ");
        String cari = s.next();
        boolean found = false;
        for (String[] book : daftar) {
            if (book[0].equalsIgnoreCase(cari)) {
                found = true;
                System.out.println(blue+ "====================================================="+reset);
                System.out.println(bluewhite+"              DAFTAR BUKU YANG TERSEDIA              "+reset);
                System.out.println(blue+ "====================================================="+reset);
                System.out.println(white+"|         Judul         |    Penulis    |   Harga   |"+reset);
                System.out.printf("%-25s %-15s Rp %-10s %n", book[0], book[1], book[2]);
                daftarbuku2 ();
                break;
            }
        }
        if (!found) {
            System.out.println(blue+ "====================================================="+reset);
            System.out.println(bluewhite+"              DAFTAR BUKU YANG TERSEDIA              "+reset);
            System.out.println(blue+ "====================================================="+reset);
            System.out.println(white+"|         Judul         |    Penulis    |   Harga   |"+reset);
            System.out.println("            -                   -             -      ");
            daftarbuku2 ();
        }
    }
    
    public static void masukkeranjang(){
        //untuk memasukkan buku ke dalam keranjang
        boolean tambah = false;
        while (tambah == false){
            System.out.println("");
            System.out.println(blue+"Masukkan buku ke dalam keranjang!! "+reset); 
            System.out.print("Ketik judul buku disini: ");
            String keranjang = s.next();
            boolean found = false;
            for (String[] book : daftar) {
                if (book[0].equalsIgnoreCase(keranjang)) {
                    found = true;
                    keranjangBuku.add(keranjang);
                    System.out.println(white+"Buku berhasil ditambahkan"+reset);
                    System.out.println("\nTambah buku? (y/n)");
                    System.out.print("Ketik disini: ");
                    String pilih = s.next();
                    if (pilih.equalsIgnoreCase ("n")){
                        tambah = true;
                        menu();
                    }
                }
            }
            if (!found) {
                System.out.println(white+"Maaf, judul buku tidak tersedia"+reset);
                System.out.println("\nTambah buku? (y/n)");
                System.out.print("Ketik disini: ");
                String pilih = s.next();
                    if (pilih.equalsIgnoreCase ("n")){
                        tambah = true;
                        menu();
                    }
            }
        }   
    }

    public static void cekkeranjang (){
        //daftar pembelian
        System.out.println("");
        System.out.println("Nama: "+nama);
        System.out.println(blue+ "====================================================="+reset);
        System.out.println(bluewhite+"                 List Keranjang Anda                 "+reset);
        System.out.println(blue+ "====================================================="+reset);
        System.out.println(white+"|         Judul         |    Penulis    |   Harga   |"+reset);
        total = 0;
        if (keranjangBuku.isEmpty()) {
            System.out.println("            -                   -             -      "); 
            keranjangkosong ();
        } else {
            for (String buku : keranjangBuku) {
                boolean adaBuku = false;
                for (String[] book : daftar) {
                    if (book[0].equalsIgnoreCase(buku)) {
                        System.out.printf("%-25s %-15s Rp %-10s %n", book[0], book[1], book[2]);
                        int hargaBuku = Integer.parseInt(book[2]);
                        total += hargaBuku;
                        adaBuku = true;
                        break;  
                    }
                }
            }
        System.out.println("");
        System.out.println(white+"Total:                                    Rp "+total+"  "+reset);
        keranjangisi ();
        }
    }
    
    public static void keranjangkosong (){
        // tampilan menu jika keranjang kosong
        System.out.println("");
        System.out.println(blue+"Silakan pilih menu"+reset);
        System.out.println("1. Back to menu\n2. Exit");
        System.out.print("Ketik disini: ");
        int pilih = s.nextInt();
        switch (pilih){
            case 1:
                menu();break;
            case 2:
                System.out.println(blue+ "====================================================="+reset);
                System.out.println(bluewhite+"            Terimakasih Telah Berkunjung            "+reset);
                System.out.println(blue+ "====================================================="+reset);
                System.exit(0);
            default:
                keranjangkosong ();
        }
    }
    
    public static void keranjangisi (){
        // tampilan menu isi keranjang
        System.out.println("");
        System.out.println(blue+"Silakan pilih menu"+reset);
        System.out.println("1. Checkout\n2. Tambah item\n3. Hapus item\n4. Back");
        System.out.print("Ketik disini: ");
        int pilih = s.nextInt();
        switch (pilih){
            case 1:
                do{
                    System.out.println("");
                    System.out.println(white+"Total harga pembelian Rp "+total+reset);
                    System.out.print("Masukkan uang pembayaran: Rp ");
                    uang = s.nextInt();
                    if (uang < total){
                        System.out.println(white+ "Maaf uang anda tidak cukup"+reset);
                    }
                }
                while (total >= uang);
                struk();
                break;
            case 2:
                masukkeranjang ();
            case 3:
                hapus ();
            case 4:
                menu ();
            default:
                keranjangisi ();
        }         
    }
    
    public static void hapus (){
        boolean tambah = false;
        while (tambah == false){
            System.out.println("");
            System.out.println(blue+"Masukkan judul buku yang ingin dihapus!! "+reset); 
            System.out.print("Ketik judul buku disini: ");
            String keranjang = s.next();
            boolean found = false;
            for (String[] book : daftar) {
                if (book[0].equalsIgnoreCase(keranjang)) {
                    found = true;
                    keranjangBuku.remove(keranjang);
                    System.out.println(white+"Item berhasil dihapus dalam keranjang"+reset);
                    System.out.println("\nHapus item lagi? (y/n)");
                    System.out.print("Ketik disini: ");
                    String pilih = s.next();
                    if (pilih.equalsIgnoreCase ("n")){
                        tambah = true;
                        menu();
                    }
                }
            }
            if (!found) {
                System.out.println(white+"Maaf, tidak ada item dalam keranjang"+reset);
                System.out.println("\nHapus item lagi? (y/n)");
                System.out.print("Ketik disini: ");
                String pilih = s.next();
                    if (pilih.equalsIgnoreCase ("n")){
                        tambah = true;
                        menu();
                    }
            }
        }
    }
    
    public static void struk (){
        System.out.println(""); 
        System.out.println(blue+ "====================================================="+reset);
        System.out.println(bluewhite+"                  Ceiyouw Bookstore                  "+reset);
        System.out.println(bluewhite+"                       SURABAYA                      "+reset);
        System.out.println(blue+ "====================================================="+reset);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy , HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);
        System.out.println("Tercatat pada: "+formattedDateTime+"\nAtas nama: "+nama+"\nPesanan Anda:");
        System.out.println("");
        System.out.println(white+"|         Item                          |   Harga   |"+reset);
        for (String buku : keranjangBuku) {
            boolean adaBuku = false;
            for (String[] book : daftar) {
                if (book[0].equalsIgnoreCase(buku)) {
                    System.out.printf("%-40s Rp %-10s %n", book[0], book[2]);
//                    int hargaBuku = Integer.parseInt(book[2]);
//                    total += hargaBuku;
                    adaBuku = true;
                    break;  
                }
            }
        }
        System.out.println("");
        System.out.println(white+"Total:                                   Rp "+total+"  "+reset);
        System.out.println("Uang Pembayaran:                         Rp "+uang);
        int kembalian = uang - total;
        System.out.println("Uang Kembalian:                          Rp "+kembalian);
        System.out.println("");
        System.out.println(blue+ "====================================================="+reset);
        System.out.println(bluewhite+"            Terimakasih Telah Berkunjung             "+reset);
        System.out.println(blue+ "====================================================="+reset);
        System.exit(0);
    }
}
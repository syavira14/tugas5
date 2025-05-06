import java.util.ArrayList; //untuk menyimpan daftar posisi di mana kata ditemukan
import java.util.Scanner; //untuk membaca input dari pengguna melalui konsol.

public class studycase3 { //Kelas studycase3 adalah kelas utama yang berisi metode main, titik masuk program.
    public static void main(String[] args) { //Metode main adalah titik awal eksekusi program.
        Scanner scanner = new Scanner(System.in); // objek Scanner dibuat untuk membaca input dari pengguna.

        System.out.println("=== SISTEM PENCARIAN KATA ===");
        System.out.print("Masukkan teks: ");
        String teks = scanner.nextLine(); //Meminta pengguna untuk memasukkan teks yang akan dicari. Input disimpan dalam variabel teks.

        System.out.print("Masukkan kata yang dicari: ");
        String kataCari = scanner.nextLine(); //Meminta pengguna untuk memasukkan kata yang ingin dicari dalam teks. Input disimpan dalam variabel kataCari.

        // Lakukan pencarian kata
        ArrayList<Integer> posisiDitemukan = cariKata(teks, kataCari); //Memanggil metode cariKata untuk mencari kata dalam teks. Hasil pencarian, yaitu daftar posisi di mana kata ditemukan, disimpan dalam ArrayList<Integer> bernama posisiDitemukan.

        System.out.println("\nHASIL PENCARIAN:");
        if (posisiDitemukan.size() > 0) { //untuk mendapatkan jumlah elemen dalam posisiDitemukan, yang berisi indeks di mana kata yang dicari ditemukan.> 0: Kondisi ini memeriksa apakah ada elemen dalam posisiDitemukan. Jika lebih besar dari 0, berarti kata yang dicari ditemukan dalam teks.
            System.out.println("Kata '" + kataCari + "' ditemukan sebanyak " + // untuk memberi tahu pengguna kata yang dicari dan bahwa kata tersebut ditemukan.
                               posisiDitemukan.size() + " kali pada posisi:"); //Menampilkan jumlah kemunculan kata yang ditemukan dalam teks.serta "kali pada posisi"

            for (int i = 0; i < posisiDitemukan.size(); i++) { // Loop ini digunakan untuk mengiterasi setiap elemen dalam posisiDitemukan. Variabel i berfungsi sebagai indeks untuk mengakses elemen dalam ArrayList.
                System.out.println("- Indeks ke-" + posisiDitemukan.get(i) + //Indeks ke-" + posisiDitemukan.get(i): Mencetak indeks di mana kata ditemukan.posisiDitemukan.get(i) mengakses elemen pada indeks i dari ArrayList, yang merupakan indeks di mana kata yang dicari ditemukan dalam teks.
                                   " (karakter ke-" + (posisiDitemukan.get(i) + 1) + ")"); //Menampilkan posisi karakter dalam teks. Karena indeks dalam pemrograman biasanya dimulai dari 0, maka ditambahkan 1 untuk menampilkan posisi karakter yang lebih intuitif bagi pengguna (dimulai dari 1).
            }

            // Tampilkan teks dengan highlight kata yang ditemukan
            System.out.println("\nTeks dengan highlight:");
            tampilkanTeksHighlight(teks, kataCari, posisiDitemukan); //Memanggil metode tampilkanTeksHighlight untuk menampilkan teks asli dengan kata yang ditemukan diberi tanda (highlight) agar lebih mudah dikenali.
        } else {
            System.out.println("Kata '" + kataCari + "' tidak ditemukan dalam teks."); //Jika tidak ada posisi yang ditemukan (ukuran posisiDitemukan adalah 0), maka program akan mencetak pesan bahwa kata tidak ditemukan dalam teks.
        }

        scanner.close(); //Menutup objek Scanner untuk mencegah kebocoran sumber daya. 
    }

    public static ArrayList<Integer> cariKata(String teks, String kata) { //public static: Menandakan bahwa metode ini dapat diakses dari luar kelas dan tidak memerlukan instansiasi objek dari kelas tersebut untuk dipanggil.ArrayList<Integer>: Tipe data yang dikembalikan oleh metode ini. Metode ini akan mengembalikan sebuah ArrayList yang berisi indeks di mana kata ditemukan dalam teks.cariKata: Nama metode yang menjelaskan fungsinya, yaitu mencari kata dalam teks.String teks: Parameter pertama, yaitu teks yang akan dicari.String kata: Parameter kedua, yaitu kata yang ingin dicari dalam teks.
        ArrayList<Integer> posisi = new ArrayList<>(); //ArrayList<Integer> posisi: Mendeklarasikan dan menginisialisasi sebuah ArrayList kosong yang akan digunakan untuk menyimpan indeks di mana kata ditemukan dalam teks.

        // Konversi ke lowercase untuk pencarian case-insensitive
        String teksLower = teks.toLowerCase(); //untuk memastikan pencarian tidak sensitif terhadap huruf besar/kecil.
        String kataLower = kata.toLowerCase(); //Mengonversi kata yang dicari menjadi huruf kecil dengan cara yang sama.

        int panjangKata = kataLower.length(); //panjangKata: Menyimpan panjang dari kata yang dicari.
        int panjangTeks = teksLower.length(); //panjangTeks: Menyimpan panjang dari teks yang akan dicari.

        // Lakukan linear search
        for (int i = 0; i <= panjangTeks - panjangKata; i++) { //for loop: Digunakan untuk mengiterasi setiap karakter dalam teks hingga batas yang ditentukan. Loop ini akan berjalan dari indeks 0 hingga panjangTeks - panjangKata, sehingga tidak akan melampaui batas saat mengambil substring.
            // Periksa apakah substring dari posisi i sampai i+panjangKata sama dengan kata
            String potongan = teksLower.substring(i, i + panjangKata); //teksLower.substring(i, i + panjangKata): Mengambil substring dari teks mulai dari indeks i hingga i + panjangKata. Ini akan menghasilkan potongan teks yang panjangnya sama dengan kata yang dicari.

            if (potongan.equals(kataLower)) { //potongan.equals(kataLower): Memeriksa apakah substring yang diambil sama dengan kata yang dicari. Jika sama, maka kata ditemukan.
                posisi.add(i); //Jika kata ditemukan, indeks i (posisi di mana kata ditemukan) ditambahkan ke ArrayList posisi.

                // Optional: Skip ke akhir kata yang ditemukan untuk menghindari overlap
                // i += panjangKata - 1;
            }
        }

        return posisi;
    }

    public static void tampilkanTeksHighlight(String teks, String kata, ArrayList<Integer> posisi) {
        StringBuilder hasil = new StringBuilder(teks); //Menggunakan StringBuilder untuk menyimpan teks yang akan dimodifikasi.

        // Tambahkan marker untuk highlight (dari posisi terjauh dulu untuk menghindari pergeseran indeks)
        for (int i = posisi.size() - 1; i >= 0; i--) { //for loop: Mengiterasi daftar posisi dari belakang ke depan. Ini dilakukan untuk menghindari pergeseran indeks saat menambahkan marker.
            int pos = posisi.get(i); //Mengambil posisi indeks dari ArrayList posisi.
            hasil.insert(pos + kata.length(), "]"); //Menyisipkan tanda ] setelah kata yang ditemukan.
            hasil.insert(pos, "["); //Menyisipkan tanda [ sebelum kata yang ditemukan. Dengan cara ini, kata yang dicari akan dikelilingi oleh tanda kurung siku.
        }

        System.out.println(hasil.toString()); //Mencetak hasil akhir,di mana kata yang dicari telah diberi tanda untuk menandakan keberadaannya dalam teks.
    }
}

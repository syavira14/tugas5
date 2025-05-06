import java.util.ArrayList; //Baris ini mengimpor kelas ArrayList dari paket java.util, yang digunakan untuk menyimpan daftar produk secara dinamis.
import java.util.Scanner; //kelas Scanner untuk membaca input dari pengguna melalui konsol.

class Produk { //Kelas Produk didefinisikan untuk merepresentasikan data produk. Kelas ini memiliki lima atribut: id, nama, kategori, harga, dan stok.
    String id; //tipe data untuk huruf
    String nama;
    String kategori;
    double harga; //tipe data untuk angka yg pecahan atau desimal
    int stok; // menyimpan bilangan bulat

    public Produk(String id, String nama, String kategori, double harga, int stok) { //Ini adalah konstruktor untuk kelas Produk. Ketika objek Produk dibuat, konstruktor ini akan menginisialisasi atribut-atributnya dengan nilai yang diberikan sebagai parameter.
        this.id = id;
        this.nama = nama;
        this.kategori = kategori;
        this.harga = harga;
        this.stok = stok;
    }

    @Override
    public String toString() { //Metode toString() di-override untuk memberikan representasi string dari objek Produk. 
        return String.format("%-5s | %-25s | %-15s | Rp %.2f | Stok: %d",
                             id, nama, kategori, harga, stok); //Ini akan memformat output dengan ID, nama, kategori, harga, dan stok produk.
    }
}

public class studycase2 { //Kelas studycase2 adalah kelas utama yang berisi metode main, titik masuk program.
    public static void main(String[] args) {
        // Data produk
        Produk[] daftarProduk = { //Array daftarProduk diisi dengan beberapa objek Produk, masing-masing diinisialisasi dengan ID, nama, kategori, harga, dan stok.
            new Produk("P001", "Laptop Asus VivoBook", "Elektronik", 8500000, 10),
            new Produk("P002", "Smartphone Samsung Galaxy", "Elektronik", 5000000, 15),
            new Produk("P003", "Kemeja Formal Pria", "Fashion", 250000, 50),
            new Produk("P004", "Sepatu Lari Nike", "Fashion", 1200000, 25),
            new Produk("P005", "Buku Pemrograman Java", "Buku", 150000, 30),
            new Produk("P006", "Mouse Gaming Logitech", "Elektronik", 350000, 20),
            new Produk("P007", "Novel Bumi Manusia", "Buku", 95000, 40),
            new Produk("P008", "Tas Ransel", "Fashion", 300000, 35)
        };

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== SISTEM PENCARIAN PRODUK ===");
        System.out.println("Kategori tersedia: Elektronik, Fashion, Buku");
        System.out.print("Masukkan kategori produk: ");
        String kategoriCari = scanner.nextLine();

        System.out.print("Masukkan harga minimum: Rp ");
        double hargaMin = scanner.nextDouble();

        System.out.print("Masukkan harga maksimum: Rp ");
        double hargaMax = scanner.nextDouble();

        // Lakukan pencarian linear multi-kriteria
        ArrayList<Produk> hasilPencarian = cariProdukByKriteria(daftarProduk, kategoriCari, hargaMin, hargaMax); //Metode cariProdukByKriteria dipanggil untuk mencari produk berdasarkan kategori, harga minimum, dan harga maksimum yang dimasukkan oleh pengguna. Hasil pencarian disimpan dalam ArrayList<Produk> bernama hasilPencarian.

        System.out.println("\nHASIL PENCARIAN:");
        System.out.println("===============================================================");
        System.out.printf("%-5s | %-25s | %-15s | %-10s | %-10s\n",
                          "ID", "Nama Produk", "Kategori", "Harga", "Stok");
        System.out.println("---------------------------------------------------------------");

        if (hasilPencarian.size() > 0) { //hasilPencarian.size(): Metode size() dari ArrayList digunakan untuk mendapatkan jumlah elemen yang ada dalam hasilPencarian. Ini akan mengembalikan jumlah produk yang ditemukan berdasarkan kriteria pencarian. > 0: Kondisi ini memeriksa apakah ada produk yang ditemukan. Jika ukuran hasilPencarian lebih besar dari 0, berarti ada produk yang memenuhi kriteria pencarian.
            for (Produk p : hasilPencarian) { //for (Produk p : hasilPencarian): Ini adalah loop for-each yang digunakan untuk iterasi melalui setiap objek Produk dalam hasilPencarian. Variabel p akan merepresentasikan setiap produk dalam daftar saat iterasi berlangsung.
                System.out.println(p); //untuk mencetak representasi string dari objek Produk.
            }
        } else { //else: Jika kondisi sebelumnya (hasilPencarian.size() > 0) tidak terpenuhi, maka blok kode di dalam else akan dieksekusi.
            System.out.println("Tidak ada produk yang sesuai dengan kriteria pencarian.");
        }
        System.out.println("===============================================================");

        scanner.close(); //Scanner ditutup untuk mencegah kebocoran sumber daya. Ini adalah praktik yang baik setelah selesai menggunakan objek Scanner.
    }

    public static ArrayList<Produk> cariProdukByKriteria(Produk[] daftarProduk,
                                                         String kategori,
                                                         double hargaMin,
                                                         double hargaMax) { //public static: Menandakan bahwa metode ini dapat diakses dari luar kelas dan tidak memerlukan instansiasi objek dari kelas tersebut untuk dipanggil.
//ArrayList<Produk>: Tipe data yang dikembalikan oleh metode ini. Metode ini akan mengembalikan sebuah ArrayList yang berisi objek Produk yang memenuhi kriteria pencarian.
//cariProdukByKriteria: Nama metode yang menjelaskan fungsinya, yaitu mencari produk berdasarkan kriteria yang diberikan.
//Produk[] daftarProduk: Parameter pertama, yaitu array dari objek Produk yang berisi daftar produk yang akan dicari.
//String kategori: Parameter kedua, yaitu kategori produk yang ingin dicari.
//double hargaMin: Parameter ketiga, yaitu harga minimum yang menjadi batas bawah pencarian.
//double hargaMax: Parameter keempat, yaitu harga maksimum yang menjadi batas atas pencarian.
        ArrayList<Produk> hasilPencarian = new ArrayList<>(); //ArrayList<Produk> hasilPencarian: Mendeklarasikan dan menginisialisasi sebuah ArrayList kosong yang akan digunakan untuk menyimpan produk-produk yang memenuhi kriteria pencarian. ArrayList digunakan karena ukurannya dapat berubah-ubah, sehingga lebih fleksibel dibandingkan array biasa.

        for (int i = 0; i < daftarProduk.length; i++) { //for (int i = 0; i < daftarProduk.length; i++): Loop ini digunakan untuk mengiterasi setiap elemen dalam array daftarProduk. Variabel i berfungsi sebagai indeks untuk mengakses elemen array.
            Produk produk = daftarProduk[i]; //Produk produk = daftarProduk[i];: Mengambil objek Produk dari array daftarProduk pada indeks i dan menyimpannya dalam variabel produk untuk digunakan dalam pemeriksaan kriteria.

            // Periksa apakah produk memenuhi semua kriteria
            if (produk.kategori.equalsIgnoreCase(kategori) && //if statement: Memeriksa apakah produk saat ini memenuhi semua kriteria pencarian.produk.kategori.equalsIgnoreCase(kategori): Memeriksa apakah kategori produk saat ini sama dengan kategori yang dicari, tanpa memperhatikan huruf besar atau kecil.
                produk.harga >= hargaMin && //produk.harga >= hargaMin: Memeriksa apakah harga produk lebih besar atau sama dengan harga minimum yang ditentukan.
                produk.harga <= hargaMax) { //produk.harga <= hargaMax: Memeriksa apakah harga produk lebih kecil atau sama dengan harga maksimum yang ditentukan. Jika semua kondisi di atas terpenuhi, maka produk dianggap memenuhi kriteria pencarian.
                hasilPencarian.add(produk); //menyimpan produk yang sesuai untuk ditampilkan kepada pengguna setelah pencarian selesai.
            }
        }

        return hasilPencarian; //return hasilPencarian;: Mengembalikan hasil pencarian kepada pemanggil metode, sehingga dapat digunakan untuk menampilkan produk yang ditemukan.
    }
}

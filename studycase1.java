import java.util.Scanner; //Baris ini mengimpor kelas Scanner dari paket java.util, yang digunakan untuk membaca input dari pengguna melalui konsol.

class Mahasiswa { //Kelas Mahasiswa didefinisikan untuk merepresentasikan data mahasiswa. Kelas ini memiliki empat atribut: nim (Nomor Induk Mahasiswa), nama, jurusan, dan ipk (Indeks Prestasi Kumulatif).
    String nim;
    String nama;
    String jurusan;
    double ipk;

    public Mahasiswa(String nim, String nama, String jurusan, double ipk) { //Ini adalah konstruktor untuk kelas Mahasiswa. Ketika objek Mahasiswa dibuat, konstruktor ini akan menginisialisasi atribut-atributnya dengan nilai yang diberikan sebagai parameter.
        this.nim = nim;
        this.nama = nama;
        this.jurusan = jurusan;
        this.ipk = ipk;
    }

    @Override
    public String toString() { //Metode toString() di-override untuk memberikan representasi string dari objek Mahasiswa. Ini akan memformat output dengan NIM, nama, jurusan, dan IPK mahasiswa.
        return String.format("NIM: %s\nNama: %s\nJurusan: %s\nIPK: %.2f", nim, nama, jurusan, ipk);
    }
}

public class studycase1 { Kelas studycase1 adalah kelas utama yang berisi metode main, titik masuk program.
    public static void main(String[] args) {
        // Data mahasiswa
        Mahasiswa[] daftarMahasiswa = { //Array daftarMahasiswa diisi dengan beberapa objek Mahasiswa, masing-masing diinisialisasi dengan NIM, nama, jurusan, dan IPK.
            new Mahasiswa("2023001", "Budi Santoso", "Teknik Informatika", 3.75),
            new Mahasiswa("2023002", "Andi Wijaya", "Sistem Informasi", 3.50),
            new Mahasiswa("2023003", "Dewi Lestari", "Teknik Komputer", 3.90),
            new Mahasiswa("2023004", "Rina Maulana", "Teknik Informatika", 3.60),
            new Mahasiswa("2023005", "Doni Kusuma", "Manajemen Informatika", 3.25),
            new Mahasiswa("2023006", "Sinta Rahma", "Sistem Informasi", 3.85),
            new Mahasiswa("2023007", "Rudi Hermawan", "Teknik Komputer", 3.40)
        };

        Scanner scanner = new Scanner(System.in); //Kode ini membuat objek Scanner untuk membaca input dari pengguna. Program meminta pengguna untuk memasukkan NIM mahasiswa yang ingin dicari.

        System.out.println("=== SISTEM PENCARIAN DATA MAHASISWA ===");
        System.out.print("Masukkan NIM Mahasiswa yang dicari: ");
        String nimCari = scanner.nextLine();

        // Lakukan pencarian linear
        Mahasiswa hasilPencarian = cariMahasiswaByNIM(daftarMahasiswa, nimCari); //Metode cariMahasiswaByNIM dipanggil untuk mencari mahasiswa berdasarkan NIM yang dimasukkan oleh pengguna. Hasil pencarian disimpan dalam variabel hasilPencarian.

        System.out.println("\nHASIL PENCARIAN:"); //Program menampilkan hasil pencarian.
        if (hasilPencarian != null) {//Jika mahasiswa ditemukan, informasi mahasiswa ditampilkan menggunakan metode toString().
            System.out.println("Mahasiswa ditemukan!");
            System.out.println(hasilPencarian);
        } else { //Jika tidak ditemukan, pesan yang sesuai ditampilkan.
            System.out.println("Mahasiswa dengan NIM " + nimCari + " tidak ditemukan.");
        }

        scanner.close(); //Setelah itu, objek Scanner ditutup.
    }

    public static Mahasiswa cariMahasiswaByNIM(Mahasiswa[] daftarMahasiswa, String nim) { //public static: Menandakan bahwa metode ini dapat diakses dari luar kelas dan tidak memerlukan instansiasi objek dari kelas tersebut untuk dipanggil. Mahasiswa: Tipe data yang dikembalikan oleh metode ini. Metode ini akan mengembalikan objek Mahasiswa jika ditemukan, atau null jika tidak ditemukan. cariMahasiswaByNIM: Nama metode yang menjelaskan fungsinya, yaitu mencari mahasiswa berdasarkan NIM. Mahasiswa[] daftarMahasiswa: Parameter pertama, yaitu array dari objek Mahasiswa yang berisi daftar mahasiswa yang akan dicari. String nim: Parameter kedua, yaitu NIM yang ingin dicari.
        for (int i = 0; i < daftarMahasiswa.length; i++) { //for loop: Digunakan untuk iterasi melalui setiap elemen dalam array daftarMahasiswa. Variabel i digunakan sebagai indeks untuk mengakses elemen array. daftarMahasiswa.length: Mengambil panjang array daftarMahasiswa, sehingga loop akan berjalan sebanyak jumlah mahasiswa yang ada dalam array.
            // Bandingkan NIM mahasiswa saat ini dengan NIM yang dicari
            if (daftarMahasiswa[i].nim.equals(nim)) { //daftarMahasiswa[i].nim: Mengakses atribut nim dari objek Mahasiswa pada indeks i.
//.equals(nim): Metode equals digunakan untuk membandingkan string. Ini memeriksa apakah NIM mahasiswa saat ini sama dengan NIM yang dicari (nim).
//Jika kondisi ini benar (NIM ditemukan), maka blok kode di dalam if akan dieksekusi.
                return daftarMahasiswa[i]; //Jika NIM yang dicari ditemukan, metode ini akan mengembalikan objek Mahasiswa yang sesuai dengan NIM tersebut. Proses pencarian akan berhenti di sini, dan tidak akan melanjutkan iterasi lebih lanjut.
            }
        }
        // Jika tidak ditemukan
        return null; //Jika loop selesai dan tidak ada NIM yang cocok ditemukan, maka metode ini akan mengembalikan null. Ini menandakan bahwa mahasiswa dengan NIM yang dicari tidak ada dalam daftar.
    }
}

public class Kereta {
    private String namaKereta; // Variabel untuk menyimpan nama kereta
    private int jumlahTiket; // Variabel untuk menyimpan jumlah tiket yang tersedia
    private Ticket[] tiket; // Array untuk menyimpan objek tiket penumpang

    // Konstruktor default untuk kereta komuter dengan jumlah tiket 1000
    public Kereta() {
        namaKereta = "komuter";
        jumlahTiket = 1000;
        tiket = new Ticket[jumlahTiket];
    }
    // Konstruktor untuk kereta dengan nama khusus dan jumlah tiket tertentu
    public Kereta(String namaKereta, int jumlahTiket) {
        this.namaKereta = namaKereta;
        this.jumlahTiket = jumlahTiket;
        this.tiket = new Ticket[jumlahTiket];
    }

    // Metode untuk menambahkan tiket tanpa asal dan tujuan
    public void tambahTiket(String namaPenumpang) {
        if (jumlahTiket > 0) {
            tiket[jumlahTiket - 1] = new Ticket(); // membuat objek baru
            tiket[jumlahTiket - 1].setNamaPenumpang(new String[]{namaPenumpang}); // mengatur nama penumpang pada objek baru
            jumlahTiket--; // mengurangi jumlah tiket yang tersedia
            System.out.println("==================================================");
            System.out.println("Tiket berhasil dipesan");
        } else {
            System.out.println("==================================================");
            System.out.println("Kereta telah habis dipesan, silahkan cari jadwal keberangkatan lainnya");
        }

        // Menampilkan sisa tiket hanya jika kereta adalah komuter dan sisa tiket kurang dari 30
        if (namaKereta.equals("komuter") && jumlahTiket < 30) {
            System.out.println("Sisa tiket tersedia: " + jumlahTiket);
        }
    }

    // Metode untuk menambahkan tiket dengan asal dan tujuan
    public void tambahTiket(String namaPenumpang, String asal, String tujuan) {
        if (jumlahTiket > 0) {
            tiket[jumlahTiket - 1] = new Ticket();
            tiket[jumlahTiket - 1].setNamaPenumpang(new String[]{namaPenumpang});
            tiket[jumlahTiket - 1].setAsal(new String[]{asal});
            tiket[jumlahTiket - 1].setTujuan(new String[]{tujuan});
            jumlahTiket--;

            // Menampilkan sisa tiket hanya jika kereta bukan komuter dan sisa tiket kurang dari 30
            if (!namaKereta.equals("komuter") && jumlahTiket < 30) {
                System.out.println("==================================================");
                System.out.println("Tiket berhasil dipesan Sisa tiket tersedia: " + jumlahTiket);
            }
        } else {
            System.out.println("==================================================");
            System.out.println("Kereta telah habis dipesan, silahkan cari jadwal keberangkatan lainnya");
        }
    }

    // Metode untuk menampilkan daftar penumpang
    public void tampilkanTiket() {
        System.out.println("==================================================");
        // menampilkan titik dua pada Daftar penumpang kereta komuter
        if (namaKereta.equals("komuter")) {
            System.out.println("Daftar penumpang kereta api " + namaKereta + ":");
        } else {
            // menampilkan Daftar penumpang kereta Jayabaya tanpa titik dua
            System.out.println("Daftar penumpang kereta api " + namaKereta);
        }
        System.out.println("------------------------------");
        // Loop untuk mencetak detail setiap penumpang
        for (int i = tiket.length - 1; i >= 0; i--) {
            // Memeriksa apakah objek tiket tidak null
            if (tiket[i] != null) {
                // Loop untuk setiap nama penumpang
                for (String nama : tiket[i].getNamaPenumpang()) {
                    System.out.println("Nama: " + nama);
                }
                // Cetak asal dan tujuan jika kereta bukan komuter
                if (!namaKereta.equals("komuter")) {
                    for (int j = 0; j < tiket[i].getAsal().length; j++) {
                        System.out.println("Asal: " + tiket[i].getAsal()[j]);
                        System.out.println("Tujuan: " + tiket[i].getTujuan()[j]);
                        System.out.println("------------------------------");
                    }
                }
            }
        }
    }
}
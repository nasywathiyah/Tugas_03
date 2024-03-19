public class Kereta {
    private String namaKereta; 
    private int jumlahTiket; 
    private Ticket[] tiket; 

    public Kereta() {
        namaKereta = "komuter";
        jumlahTiket = 1000;
        tiket = new Ticket[jumlahTiket];
    }

    public Kereta(String namaKereta, int jumlahTiket) {
        this.namaKereta = namaKereta;
        this.jumlahTiket = jumlahTiket;
        this.tiket = new Ticket[jumlahTiket];
    }

    public void tambahTiket(String namaPenumpang) {
        if (jumlahTiket > 0) {
            tiket[jumlahTiket - 1] = new Ticket();
            tiket[jumlahTiket - 1].setNamaPenumpang(new String[]{namaPenumpang});
            jumlahTiket--;
            System.out.println("==================================================");
            System.out.println("Tiket berhasil dipesan");
        } else {
            System.out.println("==================================================");
            System.out.println("Kereta telah habis dipesan, silahkan cari jadwal keberangkatan lainnya");
        }

        if (namaKereta.equals("komuter") && jumlahTiket < 30) {
            System.out.println("Sisa tiket tersedia: " + jumlahTiket);
        }
    }

    public void tambahTiket(String namaPenumpang, String asal, String tujuan) {
        if (jumlahTiket > 0) {
            tiket[jumlahTiket - 1] = new Ticket();
            tiket[jumlahTiket - 1].setNamaPenumpang(new String[]{namaPenumpang});
            tiket[jumlahTiket - 1].setAsal(new String[]{asal});
            tiket[jumlahTiket - 1].setTujuan(new String[]{tujuan});
            jumlahTiket--;

            if (!namaKereta.equals("komuter") && jumlahTiket < 30) {
                System.out.println("==================================================");
                System.out.println("Tiket berhasil dipesan Sisa tiket tersedia: " + jumlahTiket);
            }
        } else {
            System.out.println("==================================================");
            System.out.println("Kereta telah habis dipesan, silahkan cari jadwal keberangkatan lainnya");
        }
    }

    public void tampilkanTiket() {
        System.out.println("==================================================");
        if (namaKereta.equals("komuter")) {
            System.out.println("Daftar penumpang kereta api " + namaKereta + ":");
        } else {
            System.out.println("Daftar penumpang kereta api " + namaKereta);
        }
        System.out.println("------------------------------");
        for (int i = tiket.length - 1; i >= 0; i--) {
            if (tiket[i] != null) {
                for (String nama : tiket[i].getNamaPenumpang()) {
                    System.out.println("Nama: " + nama);
                }
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
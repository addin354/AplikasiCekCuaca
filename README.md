# AplikasiCekCuaca

AplikasiCekCUaca adalah aplikasi Java GUI yang memungkinkan pengguna untuk memeriksa cuaca suatu kota menggunakan API dari OpenWeatherMap. Aplikasi ini juga memungkinkan pengguna untuk menyimpan data cuaca ke file CSV, serta memuat data dari CSV untuk ditampilkan di antarmuka.

## Identitas
- Nama : Addin Husnan Nadhari
- Npm : 2210010037
- Kelas : 5B Nonreg Bajarmasin
  
## Fitur

- **Cek Cuaca Kota**: Pengguna dapat memasukkan nama kota dan menekan tombol "Cek Cuaca" untuk mendapatkan informasi suhu dan kondisi cuaca terkini.
- **Tambah Kota Favorit**: Pengguna dapat menambahkan kota ke daftar favorit untuk akses cepat.
- **Simpan ke CSV**: Data cuaca yang telah dicari dapat disimpan dalam format CSV untuk referensi di masa depan.
- **Muat Data dari CSV**: Data yang tersimpan di CSV dapat dimuat kembali ke aplikasi.
  
## Teknologi yang Digunakan

- Java Swing untuk antarmuka pengguna.
- API OpenWeatherMap untuk mendapatkan data cuaca.
- JSON untuk parsing data dari API OpenWeatherMap.
- Pengelolaan file CSV untuk menyimpan dan memuat data cuaca.

## Persyaratan

- **Java Development Kit (JDK)** versi 8 atau yang lebih baru.
- **API Key** dari OpenWeatherMap untuk akses ke data cuaca. Aplikasi ini sudah menyertakan API key default, tetapi disarankan untuk mendapatkan key Anda sendiri [di sini](https://openweathermap.org/api).

## Cara Menggunakan

1. **Jalankan Program**: Buka file `CekCuacaFrame.java` di IDE Anda dan jalankan programnya.
2. **Memeriksa Cuaca Kota**:
   - Masukkan nama kota di kolom teks `txtKota`.
   - Klik tombol `Cek Cuaca` untuk menampilkan suhu dan kondisi cuaca kota tersebut.
   - Hasil cuaca akan ditampilkan di tabel `tblCuaca`.
3. **Menambahkan Kota ke Favorit**:
   - Klik `Tambah Ke Favorit` untuk menyimpan kota ke dalam daftar `cmbKotaFavorit` untuk akses cepat.
4. **Menyimpan Data ke CSV**:
   - Klik tombol `Simpan ke CSV`, pilih lokasi penyimpanan, dan simpan data dalam format CSV.
5. **Memuat Data dari CSV**:
   - Klik tombol `Muat Data dari CSV`, pilih file CSV yang ingin dimuat, dan data akan ditampilkan di tabel `tblCuaca`.

## Struktur Program

- **CekCuacaFrame**: Kelas utama untuk GUI aplikasi.
- **cekCuaca()**: Fungsi untuk memanggil API OpenWeatherMap dan mendapatkan data cuaca berdasarkan nama kota yang dimasukkan.
- **isKotaFavorit(String kota)**: Fungsi untuk memeriksa apakah kota sudah ada di daftar favorit.
- **simpanDataKeCSV()**: Fungsi untuk menyimpan data cuaca yang ditampilkan di tabel `tblCuaca` ke dalam file CSV.
- **muatDataDariCSV()**: Fungsi untuk memuat data dari file CSV ke tabel `tblCuaca`.

## Catatan

Pastikan koneksi internet aktif saat menggunakan fitur "Cek Cuaca", karena aplikasi perlu mengambil data dari API OpenWeatherMap. 
 

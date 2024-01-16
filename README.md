**I. Deskripsi Singkat :**
Diketahui bahwa BAAK saat ini membutuhkan sebuah aplikasi untuk kebutuhan mahasiswa dan proses kegiatan mahasiswa di IT Del. Setiap fungsi dikerjakan dengan menggunakan Rest API atau Microservice, Database yang digunakan adalah database MySQL, dan Semua proses data dilakukan dengan format JSON

**II. Deskripsi Role :**
Role yang terdapat pada sistem ini terdiri dari 2 yaitu:
1. Admin (BAAK)
Pengguna yang akan mengelola data-data untuk kebutuhan sistem.
2. Mahasiswa
Pengguna yang akan melakukan request dan fungsi-fungsi yang berhubungan dengan mahasiswa.

**III. DESKRIPSI PROSES/FUNGSI :**  
Daftar proses dari sistem adalah sebagai berikut:
1. Register mahasiswa
Pengguna memasukkan nomor KTP, NIM, Nama Lengkap dan Nomor Handphone Username(Email) dan Password untuk melakukan registrasi pertama kali.
2. Autentikasi (Login/Logout)
Pengguna memasukkan username dan password untuk bisa masuk ke dalam sistem dan dapat mengakses menu dalam sistem. Setelah login berhasil, maka akan ditampilkan menu-menu atau fungsi-fungsi kepada pengguna. Pengguna juga bisa Logout, setelah  Logout maka pengguna keluar dari program.
3. Melakukan Booking Ruangan
Mahasiswa dapat melakukan booking ruangan untuk keperluan pertemuan atau kegiatan mahasiswa dan baak akan melakukan approve ruangan yang di-request. (Catatan : Ruangan yang di-booking pada waktu yang sama, otomatis tidak bisa  melakukan request dan memberikan pesan bahwa ruangan telah di-booking).
5. Melakukan Request Surat
Mahasiswa dapat melakukan request surat kepada baak dan baak akan melakukan approve surat jika surat sudah selesai. 
6. Melakukan Request Izin Keluar Kampus
Mahasiswa dapat melakukan request izin keluar kampus kepada baak dan baak akan melakukan approve izin. 
7. Melakukan Request Izin Bermalam (IB)
Mahasiswa dapat melakukan request izin bermalam (IB) kepada baak dan baak akan melakukan approve izin. (Catatan : Izin bermalam hanya bisa request pada hari Jumat diatas jam 17.00 dan hari Sabtu (08.00 – 17.00, jika direquest di luar waktu tersebut, maka sistem otomatis melakukan cancel)
8. Pembelian Kaos
Mahasiswa dapat melakukan pembelian kaos melalui aplikasi dengan menampilkan 5 jenis ukuran dan harganya(Contoh ukuran : S, M, L, XL, XXL). Mahasiswa wajib melakukan pembayaran untuk pemesanan kaos agar pemesanan berhasil. Selama belum melakukan pembayaran, maka pemesanan tidak akan berhasil. Pembayaran dilakukan dengan mamasukkan jenis pembayaran dan jumlah nominal yang sesuai dengan harga. Jika tidak sesuai dengan harga, maka otomatis pembayaran tidak berhasil. 
9. Melihat report/laporan/history
BAAK dan Mahasiswa dapat melihat daftar request yang telah dilakukan.
10. Melakukan cancel
Mahasiswa dapat melakukan cancel pemesanan yang telah dipesan dengan menghapus semua data berdasarkan request yang telah di-booking.
11. Kelola Data
BAAK dapat melakukan Kelola data (CRUD) untuk keperluan fungsi-fungsi sesuai dengan desain database.

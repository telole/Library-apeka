# Project Recycle View Library

Ini adalah proyek sederhana untuk belajar Recycle View menggunakan Git & Android Studio

## 👥 Tim
- M Alfian Fauzi (21)
- Madina Al Aliy Fi Sabill (23)
- Meutya Candra Dewi (26)
- Naraya Agastya (28)
- Nur Aimah Auliya Aprilianingrum (29)

## 📱 Fitur
- Splash screen
- List buku
- Detail buku
  
## 🔧 Teknologi
- Kotlin
- Android Studio
- Git + GitHub

## 📸 Penjelasan Kode
Pada bagian Andoid Manifest.xml terjadi penambahan dan perubahan kode seperti ini
<img width="831" height="300" alt="image" src="https://github.com/user-attachments/assets/496a2383-77b8-4d81-bc07-3e6331ab4e6a" />

<img width="3276" height="3964" alt="activity_detail xml" src="https://github.com/user-attachments/assets/d3cac474-7c82-4cad-b352-1da97ab11569" />
penjelasan kode :
- LinearLayout: Container utama yang menyusun elemen secara vertikal.

-match_parent: Lebar dan tinggi mengikuti ukuran layar.

-padding="16dp": Memberi jarak 16dp dari tepi layout.

-tools:context=".DetailActivity": Menandakan layout ini dipakai oleh DetailActivity.
<img width="3276" height="1864" alt="activity_main xml" src="https://github.com/user-attachments/assets/97551b9b-4010-4b96-a721-6d9b017bb9d9" />
penjelasan kode: 
-LinearLayout → Layout utama dengan orientasi vertikal dan padding 8dp.

-RecyclerView → Komponen untuk menampilkan daftar data (dalam hal ini daftar buku).

-match_parent → RecyclerView memenuhi seluruh layar.

-id="@+id/recyclerView" → Digunakan untuk menghubungkan dengan kode di MainActivity.
<img width="3348" height="3040" alt="activity_splash xml" src="https://github.com/user-attachments/assets/5b7a4c3f-f6ac-4c87-b759-095b8e26df2f" />
penjelasan: 
-RelativeLayout → Layout utama, latar belakang putih.

-ImageView (id: logoImage) → Menampilkan logo perpustakaan di tengah layar.

-TextView → Menampilkan teks “Perpustakaan Kita” di bawah logo, dengan ukuran besar (24sp), tebal, dan warna hitam.
<img width="3132" height="3376" alt="DetailActivity kt" src="https://github.com/user-attachments/assets/24560cda-7759-4da7-b862-e1f70ebaa043" />
penjelasan:
DetailActivity digunakan untuk menampilkan detail buku.

setContentView(R.layout.activity_detail) → menampilkan layout.

findViewById → menghubungkan variabel dengan komponen UI (ImageView & TextView).

intent.get...Extra → mengambil data (judul, penulis, tahun, gambar) yang dikirim dari activity sebelumnya.

setImageResource & text → menampilkan data ke UI.
<img width="3276" height="3124" alt="MainActivity kt" src="https://github.com/user-attachments/assets/cba81cb9-7561-4e70-9b5b-10af67e8f43b" /> 
penjelasan:
MainActivity berfungsi untuk menampilkan daftar buku dalam bentuk list dengan RecyclerView.

setContentView(R.layout.activity_main) → menampilkan layout utama.

recyclerView.layoutManager = LinearLayoutManager(this) → mengatur list agar tampil vertikal.

listBuku → membuat data dummy berisi judul, penulis, tahun, dan gambar.

recyclerView.adapter = BukuAdapter(listBuku) → menghubungkan data dengan RecyclerView melalui adapter.
<img width="2236" height="1612" alt="Buku kt" src="https://github.com/user-attachments/assets/7ac60f3a-e1c8-4c06-a1bd-0e6f74e1daee" />
penjelasan: 
Buku adalah data class yang merepresentasikan 1 objek buku dengan 4 properti:

judul: String → judul buku

penulis: String → nama penulis

tahun: String → tahun terbit

gambar: Int → ID resource gambar (misalnya R.drawable.icon)

Fungsinya sebagai model data yang dipakai MainActivity, RecyclerView, dan DetailActivity untuk menyimpan & menampilkan informasi buku.
<img width="3816" height="6148" alt="BukuAdapter kt" src="https://github.com/user-attachments/assets/1020bc8f-b13e-4b0a-97ce-6ff09bd4271b" />
penjelasan: 
1. BookViewHolder

Menyimpan referensi ke elemen UI di item_buku.xml (gambar, judul, penulis, tahun, tombol "Lihat").

2. onCreateViewHolder

Membuat item tampilan list dari layout item_buku.xml.

3. onBindViewHolder

Mengisi data buku ke item list.

Atur gambar, judul, penulis, tahun sesuai dengan objek Buku.

Saat tombol Lihat ditekan → membuat Intent ke DetailActivity dan mengirim data buku lewat putExtra.

4. getItemCount

Mengembalikan jumlah item di daftar buku.
<img width="4604" height="6148" alt="item_buku xml" src="https://github.com/user-attachments/assets/e43ef36e-4758-4e92-9548-68c89e3a9033" />
penjelasan:
- MaterialCardView → wadah utama, memberikan efek kartu dengan sudut melengkung (cardCornerRadius) dan bayangan (cardElevation).

- LinearLayout horizontal → membagi area jadi 2 bagian: gambar di kiri, detail buku + tombol di kanan.

    - ImageView (imgBuku) → menampilkan gambar sampul buku.

    - LinearLayout vertical → berisi teks + tombol.

      - TextView (tvJudul) → menampilkan judul buku (tebal & besar).

      - TextView (tvPenulis) → menampilkan nama penulis.

      - TextView (tvTahun) → menampilkan tahun terbit.

      - Button (btnLihat) → tombol untuk membuka detail buku.

## 📸 Tampilan dari Hasil Aplikasi
- Tampilan Awal Setelah memasuki Aplikasi 
<img src="https://github.com/user-attachments/assets/a34f3c29-6082-43d4-a6a5-e91d9fecde27" height="250"/>
Tampilan 
<img src="https://github.com/user-attachments/assets/39c1b2d2-6f63-48d4-b8f5-af5803bda0b3" height="300"/>
<img src="https://github.com/user-attachments/assets/6edd6bfe-c759-4f65-a327-afb0edd40e4b" height="300"/>
<img src="https://github.com/user-attachments/assets/8e1f3a18-b842-42ac-aac6-3b2354662763" height="300"/>
<img src="https://github.com/user-attachments/assets/b046f1ad-04ad-4ab0-a100-f5a5efb69384" height="300"/>
<img src="https://github.com/user-attachments/assets/d74656fd-6bc5-4c6d-8d3c-f7b460ca789e" height="300"/>






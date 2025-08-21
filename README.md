📱Menampilkan Data Dari Api ke Recycle View

Pembuatan project ini bertujuan untuk menampilkan data yang diambil dari API ke dalam tampilan RecyclerView pada aplikasi Android. Dengan menggunakan library Retrofit untuk komunikasi dengan REST API, Gson untuk parsing data JSON, dan Glide untuk memuat gambar, aplikasi ini dapat menampilkan data secara dinamis. Praktikum ini dirancang untuk memahami cara kerja API, RecyclerView, serta pengelolaan data melalui Adapter.

👥 Daftar Anggota Tim

- M Alfian Fauzi ( 21 )
- Madina A.A.F.S ( 23 )
- Meutya Candra Dewi ( 26)
- Naraya Agastya (28)
- Nur Aimah Aulia A.(29)

🎯 Tujuan Project

Tujuan dari laporan ini adalah untuk mendokumentasikan proses perancangan dan pembuatan aplikasi Android yang menampilkan data dari API ke dalam RecyclerView. Laporan ini menjelaskan tentang penerapan berbagai komponen utama dalam pemrograman Android, seperti Retrofit untuk mengambil data dari API, RecyclerView untuk menampilkan data secara dinamis, serta Glide untuk memuat gambar dari URL.

- Penjelasan Apa itu API?
 API (Application Programming Interface) adalah perantara yang memungkinkan aplikasi berkomunikasi atau bertukar data dengan aplikasi lain. Contohnya,      aplikasi Android mengambil data dari server melalui endpoint API dalam format JSON.

- Penjelasan Apa itu Retrofit?
Retrofit adalah library HTTP yang mempermudah komunikasi dengan REST API, seperti melakukan request GET, POST, dan mengonversi JSON menjadi objek Kotlin menggunakan GsonConverterFactory.

- Penjelasan Apa itu Gson?
Gson digunakan untuk serialisasi (Kotlin → JSON) dan deserialisasi (JSON → Kotlin) sehingga data dapat diolah dalam aplikasi Android.

- Penjelasan Apa itu Glide?
Glide adalah library untuk memuat gambar dari URL ke ImageView dengan caching dan manajemen memori yang efisien.

Penjelasan Praktikum 
1.buat proyek baru dengan nama app5-recycleview 
2.di dalam build gradle,tambahkan dependencie berikut 
  dependencies {
        implementation ("androidx.recyclerview:recyclerview:1.3.2")
         implementation ("androidx.cardview:cardview:1.0.0")
          implementation ("com.squareup.retrofit2:retrofit:2.9.0")
           implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
            implementation ("com.github.bumptech.glide:glide:4.16.0")
        
3.di dalam manifest tambahkan permision supaya aplikasi android bisa mengakses internet
<uses-permission android:name="android.permission.INTERNET" />

![WhatsApp Image 2025-08-21 at 11 03 40_df934f31](https://github.com/user-attachments/assets/113078d1-bd2b-41c0-a17e-bc1a74fba9c6)

Baris ini digunakan untuk memberi tahu sistem Android bahwa aplikasi memerlukan akses internet. Tanpa permission ini, aplikasi tidak akan bisa melakukan request ke API, mengunduh data, atau memuat konten dari web.

![WhatsApp Image 2025-08-21 at 10 20 52_3446b0bf](https://github.com/user-attachments/assets/21f8417a-bf4b-4e91-84be-399c0fce5a72)
![WhatsApp Image 2025-08-21 at 10 20 52_1a07dd86](https://github.com/user-attachments/assets/6ff30cc8-20b8-4aa1-ac97-dc7097feebb1)

DetailActivity adalah turunan dari AppCompatActivity.
onCreate(): Dipanggil saat Activity dibuat.
setContentView(): Menghubungkan activity dengan layout XML activity_detail.

val imgDetail = findViewById<ImageView>(R.id.imgBuku)
val tvJudulDetail = findViewById<TextView>(R.id.tvJudul)
val tvPenulisDetail = findViewById<TextView>(R.id.tvPenulis)
val tvTahunDetail = findViewById<TextView>(R.id.tvTahun)
Untuk Menghubungkan elemen layout dengan variabel Kotlin.

Val judul = intent.getStringExtra("judul")
val penulis = intent.getStringExtra("penulis")
val tahun = intent.getStringExtra("tahun")
val gambarUrl = intent.getStringExtra("gambar")
Data ini dikirim dari MainActivity saat user memilih item di RecyclerView.

tvJudulDetail.text = judul
tvPenulisDetail.text = penulis
tvTahunDetail.text = tahun
Mengisi TextView dengan data dari intent.

Glide.with(this)
    .load(gambarUrl)
    .into(imgDetail)
Glide digunakan untuk memuat gambar dari URL ke ImageView.

![WhatsApp Image 2025-08-21 at 10 20 53_d4831d92](https://github.com/user-attachments/assets/72fe844d-36a6-4b4a-b917-2cfc93b26a2e)
findViewById(R.id.recyclerView): Menghubungkan RecyclerView dari layout activity_main.xml dengan variabel recyclerView.
LinearLayoutManager(this): Mengatur tata letak RecyclerView agar menampilkan data secara vertikal (default).

ApiClient.instance.getBuku(): Memanggil fungsi getBuku() di ApiService untuk mendapatkan daftar buku dari API.
enqueue(): Menjalankan request API secara asynchronous (tidak menghambat UI).
Callback<List<Buku>>: Menangani response dari API, yang berupa list objek Buku.

response.isSuccessful: Mengecek apakah request berhasil (kode status 200 OK).
response.body() ?: emptyList(): Mengambil data dari response, jika null maka gunakan list kosong.
adapter = BukuAdapter(applicationContext, bukuList): Membuat adapter untuk menghubungkan data dengan RecyclerView.
recyclerView.adapter = adapter: Menampilkan data ke RecyclerView.
Jika gagal, tampilkan pesan "Gagal memuat data".

onFailure(): Dipanggil jika ada error (misalnya tidak ada internet atau server down).
Toast.makeText(...): Menampilkan pesan error ke pengguna.
Log.e(): Mencatat error ke log untuk debugging.

![WhatsApp Image 2025-08-21 at 10 20 53_734d3af4](https://github.com/user-attachments/assets/8e343f12-aea7-4879-8ad5-ec11ac6acf36)
ApiService: Interface yang berisi definisi endpoint API.
Retrofit: Library untuk melakukan request HTTP ke server.
GsonConverterFactory: Digunakan untuk mengonversi data JSON dari API ke objek Kotlin.

object ApiClient {
object di Kotlin berarti singleton (hanya ada satu instance).
Kelas ini digunakan untuk menyediakan konfigurasi Retrofit.

BASE_URL adalah alamat utama API.

by lazy: Inisialisasi hanya dilakukan ketika pertama kali dipanggil (hemat memori).
Retrofit.Builder():
baseUrl(BASE_URL) → Menentukan URL utama API.
addConverterFactory(GsonConverterFactory.create()) → Agar response JSON bisa otomatis diubah menjadi objek Kotlin.
build() → Membuat instance Retrofit.
retrofit.create(ApiService::class.java) → Membuat implementasi dari interface ApiService.

![WhatsApp Image 2025-08-21 at 10 20 54_a60d5c87](https://github.com/user-attachments/assets/b269637c-172e-4670-a426-5f864323a345)
<uses-permission android:name="android.permission.INTERNET"
Memberikan izin agar aplikasi dapat mengakses internet.
, Wajib jika aplikasi menggunakan API atau mengambil data online.

android:allowBackup="true" → Mengizinkan backup data aplikasi.
android:dataExtractionRules & fullBackupContent → Aturan backup.
android:icon → Icon aplikasi.
android:label → Nama aplikasi yang tampil di layar.
android:roundIcon → Icon bulat (untuk launcher modern).
android:supportsRtl="true" → Mendukung layout Right-to-Left (misal bahasa Arab).
android:theme → Tema default aplikasi.

android:name=".SplashScreen" → Activity bernama SplashScreen.
android:exported="true" → Bisa diakses dari luar aplikasi.
intent-filter → Menentukan aktivitas ini sebagai entry point aplikasi:
MAIN → Aktivitas utama.
LAUNCHER → Aktivitas pertama saat aplikasi dijalankan.

<activity android:name=".MainActivity" /
<activity android:name=".DetailActivity" /
Mendefinisikan aktivitas lain yang ada dalam aplikasi.

![WhatsApp Image 2025-08-21 at 10 20 54_1d98c28a](https://github.com/user-attachments/assets/067a7612-6d4b-4b06-9565-aaa2f6acb7c8)
1. File build.gradle.kts (:app)
Ini adalah file Gradle (Kotlin DSL) untuk konfigurasi module app di Android. Bagian-bagian penting:

a. compileOptions
compileOptions {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

Menentukan versi Java yang digunakan untuk kompilasi.
JavaVersion.VERSION_11 → Aplikasi ini menggunakan Java 11.

b. kotlinOptions
kotlinOptions {
    jvmTarget = "11"
}

Menentukan target JVM untuk Kotlin adalah Java 11.

c. dependencies
dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.github.bumptech.glide:glide:4.16.0")
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

Penjelasan:
libs.androidx.core.ktx, appcompat, activity, constraintlayout → Library dasar Android.
material → Material Design components.
Retrofit (2.9.0) → Untuk koneksi API/HTTP.
Converter-Gson → Untuk parsing JSON ke objek Kotlin.
Glide (4.16.0) → Untuk memuat dan menampilkan gambar (image loader).
JUnit & Espresso → Untuk unit testing dan UI testing.

2. Emulator Android (UI Aplikasi)

Aplikasi menampilkan daftar buku dengan desain Material Card. Setiap item berisi:
Cover buku (dimuat pakai Glide dari URL atau resource).
Judul & Penulis.
Tahun terbit.
Button “Lihat Buku” (kemungkinan membuka detail buku).
Ini adalah contoh aplikasi berbasis RecyclerView + Adapter, yang menampilkan list buku dengan layout card.

Hubungan Keduanya
Retrofit → Kemungkinan digunakan untuk mengambil data buku dari API.
Glide → Untuk menampilkan gambar cover buku.
Material → Untuk styling tombol dan card.
Gradle dependencies → Semua library di kiri digunakan untuk membangun UI di kanan.

![WhatsApp Image 2025-08-21 at 10 20 55_9b28705c](https://github.com/user-attachments/assets/cdc200b3-391c-498d-b2b5-68cb4c9f9fe6)
<manifest ...>: Tag root dari file AndroidManifest.xml.

<application ...>: Tag ini berisi konfigurasi global untuk seluruh aplikasi. Beberapa atribut penting terlihat di sini:

android:icon dan android:roundIcon: Menentukan lokasi ikon aplikasi.

android:label: Menentukan nama aplikasi yang akan ditampilkan di perangkat.

android:supportsRtl: Mengaktifkan dukungan untuk layout dari kanan ke kiri (Right-to-Left), penting untuk bahasa seperti Arab atau Ibrani.

<activity ...>: Deklarasi setiap layar atau "halaman" dalam aplikasi. Gambar tersebut menunjukkan adanya dua aktivitas (.Splashscreen dan .MainActivity).

<intent-filter>: Konfigurasi yang memberitahu sistem Android bagaimana cara meluncurkan aktivitas.

android.intent.action.MAIN: Menandai aktivitas ini sebagai titik masuk (entry point) utama atau aktivitas yang akan pertama kali diluncurkan saat pengguna membuka aplikasi.

android.intent.category.LAUNCHER: Menandai bahwa aktivitas ini harus ditampilkan di drawer aplikasi (daftar aplikasi di perangkat).

















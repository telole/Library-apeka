# Project RecyclerView  ( Library )

Project RecycleView ini merupakan project aplikasi sederhana dengan pembuatan berbasis Android Studio yang dibuat dengan bentuk berupa daftar buku.

## 👥 Tim
- M Alfian Fauzi ( 21 )
- Madina Al Aliy Fi Sabill ( 23 )
- Meutya Candra Dewi ( 26 )
- Naraya Agastya ( 28 )
- Nur Aimah Auliya Aprilianingrum ( 29 )

## 📱 Fitur
- Splash screen
- Daftar buku (RecyclerView)
- Detail buku
  
## 🔧 Teknologi
- Kotlin
- Android Studio
- Git + GitHub

## 📸 Penjelasan Kode
1. AndroidManifest.xml
<img width="750" height="650" alt="Screenshot 2025-08-20 165627" src="https://github.com/user-attachments/assets/76c1bba2-1969-4fe2-a5c0-61853ee6435c" />

Penjelasan : Kode pada AndroidManifest.xml berfungsi untuk mengatur identitas aplikasi dan mendeklarasikan semua activity yang akan dijalankan. Pada bagian <application>, mengatur properti penting seperti ikon, nama aplikasi, dan tema aplikasi. Pada File ini terdapat tiga activity utama, yakni SplashScreen, MainActivity, dan DetailActivity. Pada SplashScreen diberikan atribut exported="true" serta intent-filter dengan action MAIN dan kategori LAUNCHER. Hal ini membuat SplashScreen menjadi halaman pertama yang dijalankan ketika aplikasi dibuka. Sedangkan pada MainActivity terdaftar sebagai activity utama yang menampilkan daftar siswa, namun hanya dapat dijalankan setelah SplashScreen selesai, dikarenakan tidak memiliki intent-filter. dan Pada DetailActivity digunakan untuk menampilkan informasi detail dari siswa yang dipilih oleh pengguna. Activity ini hanya bisa dipanggil dari dalam aplikasi, tanpa adanya intent-filter.


2. Buku
<img width="380" height="180" alt="Screenshot 2025-08-20 175907" src="https://github.com/user-attachments/assets/4485c65e-33bc-4f2b-908c-573d9ce77c16" />

Penjelasan : Kode pada file Buku.kt berfungsi sebagai model data dari informasi setiap buku yang akan ditampilkan dan disimpan pada aplikasi. File ini berupa data Class Book yyang memiliki empat properti utama, yaitu title sebagai (judul buku), author sebagai (penulis buku), year sebagai (tahun terbit), dan imageRes sebagai (ID resource untuk gambar sampul) yang akan menjadi struktur data pada RecyclerView.


3. BukuAdapter

Penjelasan : Kode pada BukuAdapter digunakan untuk menghubungkan data buku dengan tampilan pada RecyclerView. Pada onCreateViewHolder(), layout item di-inflate agar setiap buku memiliki tampilan sendiri. Kemudian pada onBindViewHolder(), data dari objek buku seperti judul, penulis, tahun, dan gambar diikat (bind) ke TextView maupun ImageView. Selain itu, di dalam method ini juga ditambahkan listener pada item view, sehingga ketika sebuah buku dipilih, adapter membuat Intent menuju DetailActivity dan mengirimkan data buku tersebut melalui putExtra(). Dengan cara ini, BookAdapter tidak hanya menampilkan data, tetapi juga mengatur perpindahan ke halaman detail saat item diklik.


4. DetailActivity
<img width="650" height="550" alt="image" src="https://github.com/user-attachments/assets/f86dfa21-bc99-409a-8f54-a8fcda938080" />

Penjelasan : Kode pada DetailActivity digunakan untuk menampilkan detail dari buku yang dipilih pengguna. Pada method onCreate(), layout detail dipanggil dengan setContentView(R.layout.activity_detail). Setelah itu, data buku diterima melalui Intent yang dikirimkan dari BookAdapter menggunakan getIntent(). Data tersebut diambil menggunakan method seperti getStringExtra("judul"), getStringExtra("penulis"), getIntExtra("tahun", 0), atau getIntExtra("gambar", 0). Nilai yang diperoleh kemudian di-bind ke komponen tampilan, misalnya TextView untuk judul dan penulis, serta ImageView untuk gambar cover buku. Dengan cara ini, DetailActivity hanya bertugas membaca data yang sudah dikirim adapter dan menampilkannya di layout, tanpa perlu tahu bagaimana data tersebut dipilih sebelumnya.


5. MainActivity
<img width="650" height="450" alt="image" src="https://github.com/user-attachments/assets/9e89bbbd-e595-4c1a-9c20-49e873264eaf" />

Penjelasan : Kode pada MainActivity adalah activity utama yang menampilkan daftar buku. Pada onCreate(), layout utama diatur dengan setContentView(R.layout.activity_main). Komponen RecyclerView diambil dengan findViewById(R.id.recyclerView). Data dummy dibuat melalui pemanggilan DummyData.getBooks(), hasilnya berupa List<Book>. Data ini dipasangkan ke BookAdapter adapter = new BookAdapter(bookList);. Setelah itu, RecyclerView diatur dengan recyclerView.setLayoutManager(new LinearLayoutManager(this)) agar tampil vertikal. Terakhir, adapter dihubungkan dengan recyclerView.setAdapter(adapter). Selain menampilkan daftar, di adapter juga disediakan listener klik item yang akan membuat Intent menuju DetailActivity sambil membawa data buku lewat putExtra("judul", book.getJudul()), dan seterusnya.


6. SplashScreen
<img width="750" height="350" alt="image" src="https://github.com/user-attachments/assets/34a2aa7e-cb89-4f2a-adae-9027707db48d" />

Penjelasan : Kode pada SplashScreen merupakan activity pertama yang dijalankan aplikasi. Pada method onCreate(Bundle savedInstanceState), layout splash di-inflate menggunakan setContentView(R.layout.activity_splash). Activity ini dideklarasikan di AndroidManifest.xml dengan intent-filter berisi MAIN dan LAUNCHER, sehingga sistem Android tahu untuk menjadikannya entry point aplikasi. Biasanya, di dalam SplashScreen terdapat kode Handler.postDelayed() atau Coroutine yang berfungsi menunda beberapa detik sebelum memanggil startActivity(new Intent(this, MainActivity.class)). Setelah itu, finish() dipanggil agar SplashScreen ditutup dan pengguna dialihkan ke MainActivity. Dengan cara ini, SplashScreen berfungsi sebagai jembatan awal sebelum ke halaman utama.

## 📸 Tampilan dari Hasil Aplikasi
- Tampilan awal Setelah pengguna memasuki aplikasi, muncul logo selama beberapa detik
<img src="https://github.com/user-attachments/assets/a34f3c29-6082-43d4-a6a5-e91d9fecde27" height="400"/>
<img src="https://github.com/user-attachments/assets/39c1b2d2-6f63-48d4-b8f5-af5803bda0b3" height="400"/>
- Tampilan ketika pengguna memasuki halaman utama aplikasi

- Tampilan ketika pengguna ingin melihat informasi buku secara lebih detail
<img src="https://github.com/user-attachments/assets/6edd6bfe-c759-4f65-a327-afb0edd40e4b" height="400"/>

- Tampilan ketika informasi buku ditampilkan secara detail
<img src="https://github.com/user-attachments/assets/8e1f3a18-b842-42ac-aac6-3b2354662763" height="400"/>






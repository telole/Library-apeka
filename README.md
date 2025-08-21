📱Menampilkan Data Dari Api ke Recycle View

Pembuatan project ini bertujuan untuk menampilkan data yang diambil dari API ke dalam tampilan RecyclerView pada aplikasi Android. Dengan menggunakan library Retrofit untuk komunikasi dengan REST API, Gson untuk parsing data JSON, dan Glide untuk memuat gambar, aplikasi ini dapat menampilkan data secara dinamis. Praktikum ini dirancang untuk memahami cara kerja API, RecyclerView, serta pengelolaan data melalui Adapter.

👥 Daftar Anggota Tim

-M Alfian Fauzi ( 21 )
-Madina A.A.F.S ( 23 )
-Meutya Candra Dewi ( 26)
-Naraya Agastya (28)
-Nur Aimah Aulia A.(29)

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



![WhatsApp Image 2025-08-21 at 10 20 52_3446b0bf](https://github.com/user-attachments/assets/21f8417a-bf4b-4e91-84be-399c0fce5a72)

![WhatsApp Image 2025-08-21 at 10 20 52_1a07dd86](https://github.com/user-attachments/assets/6ff30cc8-20b8-4aa1-ac97-dc7097feebb1)
![WhatsApp Image 2025-08-21 at 10 20 53_d4831d92](https://github.com/user-attachments/assets/72fe844d-36a6-4b4a-b917-2cfc93b26a2e)
![WhatsApp Image 2025-08-21 at 10 20 53_734d3af4](https://github.com/user-attachments/assets/8e343f12-aea7-4879-8ad5-ec11ac6acf36)
![WhatsApp Image 2025-08-21 at 10 20 54_a60d5c87](https://github.com/user-attachments/assets/b269637c-172e-4670-a426-5f864323a345)
![WhatsApp Image 2025-08-21 at 10 20 54_1d98c28a](https://github.com/user-attachments/assets/067a7612-6d4b-4b06-9565-aaa2f6acb7c8)
![WhatsApp Image 2025-08-21 at 10 20 55_9b28705c](https://github.com/user-attachments/assets/cdc200b3-391c-498d-b2b5-68cb4c9f9fe6)
















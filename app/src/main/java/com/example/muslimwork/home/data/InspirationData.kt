package com.example.muslimwork.home.data
import com.example.muslimwork.R
import com.example.muslimwork.home.model.InspirationModel
import java.util.ArrayList

object InspirationData {
    // Variable Menyimpan Data
    private val inspirationimage = intArrayOf(
        R.drawable.img_inspiration,
        R.drawable.yakin_saja,
        R.drawable.mengejar_dunia,
        R.drawable.sedekah_dengan_lisan,
        R.drawable.tidak_memaafkan
    )
    // Memasukan Data Ke Model
    val listData: ArrayList<InspirationModel>
    get() {
        // Membuat Variable Untuk Kumpulan Model
        val list = arrayListOf<InspirationModel>()
        // Untuk Tiap2 Gambar Pada Variable inspirationImage
        // Masukan Datanya Ke Variable list
        for (position in inspirationimage.indices) {
            // Buat Dahulu Variable model
            val inspiration = InspirationModel()
            // Memasukan Gambar Sesuai Posisinya Dari Variable inspirationImage Di
            // Ke Dalam Variable Yang Ada Di Model
            inspiration.inspirationImage = inspirationimage[position]
            // Tambahkan Variable inspiration
            list.add(inspiration)
        }
        return list
    }
}
package com.ute.kt_lan2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ute.kt_lan2.databinding.ActivityMainBinding
import android.content.Intent
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvHoTen.text = "Ho ten: Pham Duy Hung"
        binding.tvMaSinhVien.text = "Ma sinh vien: 2415053122116"
        binding.tvLopHp.text = "Lop HP: 126LTDTDĐ01"
        binding.btnTaoCongViec.setOnClickListener {
            val tenCongViec = binding.edtTenCongViec.text.toString()
            val moTa = binding.edtMoTa.text.toString()

            // Tao Intent chuyen sang ChiTietCongViecActivity va truyen du lieu
            val intent = Intent(this, ChiTietCongViecActivity::class.java).apply {
                putExtra("EXTRA_TEN_CV", tenCongViec)
                putExtra("EXTRA_MO_TA", moTa)
            }
            startActivity(intent)
        }
    }
}
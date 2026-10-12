package com.ute.kt_lan2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ute.kt_lan2.databinding.ActivityChiTietCongViecBinding
class ChiTietCongViecActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChiTietCongViecBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChiTietCongViecBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tenCongViec = intent.getStringExtra("EXTRA_TEN_CV") ?: ""
        val moTa = intent.getStringExtra("EXTRA_MO_TA") ?: ""

        binding.tvTenCongViecChiTiet.text = "Ten cong viec: $tenCongViec"
        binding.tvMoTaChiTiet.text = "Mo ta: $moTa"
    }
}
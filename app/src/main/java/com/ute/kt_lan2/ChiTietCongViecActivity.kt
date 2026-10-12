package com.ute.kt_lan2

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.ute.kt_lan2.databinding.ActivityChiTietCongViecBinding

class ChiTietCongViecActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChiTietCongViecBinding
    private var tenHienTai = ""
    private var moTaHienTai = ""

    private val editLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChiTietCongViecBinding.inflate(layoutInflater)
        setContentView(binding.root)

        tenHienTai = intent.getStringExtra("EXTRA_TEN_CONG_VIEC") ?: ""
        moTaHienTai = intent.getStringExtra("EXTRA_MO_TA") ?: ""

        binding.tvTenCongViecChiTiet.text = "Ten cong viec: $tenHienTai"
        binding.tvMoTaChiTiet.text = "Mo ta: $moTaHienTai"

        binding.btnChinhSua.setOnClickListener {
            val intent = Intent(this, ChinhSuaCongViecActivity::class.java).apply {
                putExtra("EXTRA_TEN_CU", tenHienTai)
                putExtra("EXTRA_MO_TA_CU", moTaHienTai)
            }
            editLauncher.launch(intent)
        }
    }
}
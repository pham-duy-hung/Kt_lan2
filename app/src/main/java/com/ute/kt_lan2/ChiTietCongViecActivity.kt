package com.ute.kt_lan2

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.ute.kt_lan2.databinding.ActivityChiTietCongViecBinding

class ChiTietCongViecActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChiTietCongViecBinding
    private var congViecHienTai: CongViec? = null

    private val editLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val data = result.data
            val congViecMoi = data?.getSerializableExtra("EXTRA_CONG_VIEC_MOI") as? CongViec
            if (congViecMoi != null) {
                congViecHienTai = congViecMoi
                hienThiThongTin()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChiTietCongViecBinding.inflate(layoutInflater)
        setContentView(binding.root)

        congViecHienTai = intent.getSerializableExtra("EXTRA_CONG_VIEC") as? CongViec

        hienThiThongTin()

        binding.btnChinhSua.setOnClickListener {
            val intent = Intent(this, ChinhSuaCongViecActivity::class.java).apply {
                putExtra("EXTRA_CONG_VIEC_CU", congViecHienTai)
            }
            editLauncher.launch(intent)
        }
    }

    private fun hienThiThongTin() {
        congViecHienTai?.let {
            binding.tvTenCongViecChiTiet.text = "Ten cong viec: ${it.tenCongViec}"
            binding.tvMoTaChiTiet.text = "Mo ta: ${it.moTa}"
        }
    }
}
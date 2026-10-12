package com.ute.kt_lan2

import android.os.Bundle
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.ute.kt_lan2.databinding.ActivityChinhSuaCongViecBinding

class ChinhSuaCongViecActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChinhSuaCongViecBinding
    private var congViecCu: CongViec? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChinhSuaCongViecBinding.inflate(layoutInflater)
        setContentView(binding.root)

        congViecCu = intent.getSerializableExtra("EXTRA_CONG_VIEC_CU") as? CongViec

        congViecCu?.let {
            binding.edtSuaTenCongViec.setText(it.tenCongViec)
            binding.edtSuaMoTa.setText(it.moTa)
        }

        binding.btnLuu.setOnClickListener {
            val tenMoi = binding.edtSuaTenCongViec.text.toString().trim()
            val moTaMoi = binding.edtSuaMoTa.text.toString().trim()

            if (tenMoi.isEmpty()) {
                binding.edtSuaTenCongViec.error = "Ten cong viec khong duoc de trống!"
                return@setOnClickListener
            }

            val congViecMoi = congViecCu?.apply {
                tenCongViec = tenMoi
                moTa = moTaMoi
            } ?: CongViec(tenMoi, moTaMoi, false)

            val resultIntent = Intent().apply {
                putExtra("EXTRA_CONG_VIEC_MOI", congViecMoi)
            }
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}
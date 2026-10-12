package com.ute.kt_lan2

import android.os.Bundle
import android.content.Intent
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.ute.kt_lan2.databinding.ActivityChinhSuaCongViecBinding

class ChinhSuaCongViecActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChinhSuaCongViecBinding
    private var congViecCu: CongViec? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChinhSuaCongViecBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val options = arrayOf("Thấp", "Trung bình", "Cao")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, options)
        binding.spinnerMucDo.adapter = adapter

        congViecCu = intent.getSerializableExtra("EXTRA_CONG_VIEC_CU") as? CongViec

        congViecCu?.let {
            binding.edtSuaTenCongViec.setText(it.tenCongViec)
            binding.edtSuaMoTa.setText(it.moTa)
            val spinnerPosition = adapter.getPosition(it.mucDoUuTien)
            binding.spinnerMucDo.setSelection(spinnerPosition)
        }

        binding.btnLuu.setOnClickListener {
            val tenMoi = binding.edtSuaTenCongViec.text.toString().trim()
            val moTaMoi = binding.edtSuaMoTa.text.toString().trim()
            val mucDoMoi = binding.spinnerMucDo.selectedItem.toString()

            if (tenMoi.isBlank()) {
                binding.edtSuaTenCongViec.error = "Ten cong viec khong duoc de trong hoac chua toan khoang trang!"
                binding.edtSuaTenCongViec.requestFocus()
                return@setOnClickListener
            }

            val congViecMoi = congViecCu?.apply {
                tenCongViec = tenMoi
                moTa = moTaMoi
                mucDoUuTien = mucDoMoi
            } ?: CongViec(tenMoi, moTaMoi, false, mucDoMoi)

            val resultIntent = Intent().apply {
                putExtra("EXTRA_CONG_VIEC_MOI", congViecMoi)
            }
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}
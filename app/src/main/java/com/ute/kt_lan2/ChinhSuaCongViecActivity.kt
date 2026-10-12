package com.ute.kt_lan2

import android.os.Bundle
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.ute.kt_lan2.databinding.ActivityChinhSuaCongViecBinding

class ChinhSuaCongViecActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChinhSuaCongViecBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChinhSuaCongViecBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tenCu = intent.getStringExtra("EXTRA_TEN_CU") ?: ""
        val moTaCu = intent.getStringExtra("EXTRA_MO_TA_CU") ?: ""

        binding.edtSuaTenCongViec.setText(tenCu)
        binding.edtSuaMoTa.setText(moTaCu)
        binding.btnLuu.setOnClickListener {
            val tenMoi = binding.edtSuaTenCongViec.text.toString()
            val moTaMoi = binding.edtSuaMoTa.text.toString()

            val resultIntent = Intent().apply {
                putExtra("EXTRA_TEN_MOI", tenMoi)
                putExtra("EXTRA_MO_TA_MOI", moTaMoi)
            }
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}
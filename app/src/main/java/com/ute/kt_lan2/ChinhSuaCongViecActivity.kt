package com.ute.kt_lan2

import android.os.Bundle
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
    }
}
package com.ute.kt_lan2

import java.io.Serializable

data class CongViec(
    var tenCongViec: String,
    var moTa: String,
    var trangThai: Boolean = false,
    var mucDoUuTien: String = "Trung bình"
) : Serializable {

    fun layThongTinChiTiet(): String {
        val trangThaiStr = if (trangThai) "Da hoan thanh" else "Chua hoan thanh"
        return "Ten: $tenCongViec\nMo ta: $moTa\nTrang thai: $trangThaiStr"
    }
}
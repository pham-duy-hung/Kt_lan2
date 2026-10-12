package com.ute.kt_lan2

import java.io.Serializable

data class CongViec(
    var tenCongViec: String,
    var moTa: String,
    var trangThai: Boolean = false 
) : Serializable
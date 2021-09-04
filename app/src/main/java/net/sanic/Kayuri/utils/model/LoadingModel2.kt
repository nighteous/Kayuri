package net.sanic.Kayuri.utils.model

import net.sanic.Kayuri.utils.CommonViewModel2

data class LoadingModel2(
    val loading: CommonViewModel2.Loading,
    val isListEmpty: Boolean,
    val errorCode: Int,
    val errorMsg: Int
)
package com.nwar.data.mapper

import com.nwar.data.model.Account
import com.nwar.data.model.WifiInfoModel
import com.nwar.domain.entity.User
import com.nwar.domain.entity.WifiInfo

fun User.toAccount() = Account(this.id, this.password, this.name, this.token)

fun WifiInfo.toWifiInfoModel() = WifiInfoModel(this.name, this.macAdd)
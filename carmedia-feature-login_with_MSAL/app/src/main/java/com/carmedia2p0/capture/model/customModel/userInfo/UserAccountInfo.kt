package com.carmedia2p0.capture.model.customModel.userInfo

import com.microsoft.identity.client.Account

data class UserAccountInfo(
    val accessToken: String? = null,
    val activeAccount: Account? = null
)

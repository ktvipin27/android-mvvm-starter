package com.ktvipin.mvvmstarter.data.local.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Vipin KT on 02/06/20
 */
@Entity
data class Demo(
    @PrimaryKey val id: Int,
    val name: String
)
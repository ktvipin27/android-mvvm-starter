package com.ktvipin27.mvvmstarter.data.local.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Vipin KT on 02/06/20
 */
@Entity
data class Person(
    @PrimaryKey val id: Int,
    val name: String
)
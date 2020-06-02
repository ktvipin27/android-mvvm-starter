package com.ktvipin27.mvvmstarter.data.local.db.dao

import androidx.room.Dao
import com.ktvipin27.mvvmstarter.data.local.db.entity.Person

/**
 * Created by Vipin KT on 02/06/20
 */
@Dao
interface PersonDao : BaseDao<Person>
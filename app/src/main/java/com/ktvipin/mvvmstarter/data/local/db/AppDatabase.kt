package com.ktvipin.mvvmstarter.data.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.ktvipin.mvvmstarter.data.local.db.converter.PersonToStringConverter
import com.ktvipin.mvvmstarter.data.local.db.dao.PersonDao
import com.ktvipin.mvvmstarter.data.local.db.entity.Person

@Database(
    entities = [Person::class],
    version = 1
)
@TypeConverters(PersonToStringConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun personDao(): PersonDao

    companion object {
        private const val DB_NAME = "app-db"
        private val lock = Any()
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            synchronized(lock) {
                if (INSTANCE == null) {
                    INSTANCE = createDB(context)
                }
                return INSTANCE as AppDatabase
            }
        }

        private fun createDB(context: Context): AppDatabase {
            val database: Builder<AppDatabase> =
                Room.databaseBuilder(context, AppDatabase::class.java, DB_NAME)

            return database
                //.addMigrations()
                .addCallback(object : Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        //todo initialise db here
                    }
                })
                .build()
        }
    }
}
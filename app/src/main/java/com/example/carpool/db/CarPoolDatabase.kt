package com.example.carpool.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [User::class, Car::class], version = 1)
abstract class CarPoolDatabase: RoomDatabase() {

    abstract val carPoolDao: CarPoolDao

    // TODO: Singleton mı yapıcaz emin değilim, google it
    companion object {
        @Volatile
        private var INSTANCE: CarPoolDatabase? = null
        fun getInstance(context: Context): CarPoolDatabase {
            synchronized(this) {
                var instance: CarPoolDatabase? = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        CarPoolDatabase::class.java,
                        "carpool_data_database",

                    ).build()
                }
                return instance
            }

        }
    }
}
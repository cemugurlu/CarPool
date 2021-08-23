package com.example.carpool.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.carpool.model.UserEntity


@Database(entities = [UserEntity::class, Car::class], version = 1)
abstract class CarPoolDatabase: RoomDatabase() {

    abstract fun carPoolDao(): CarPoolDao

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
package com.example.cupcake.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//  Define entities used in this database
@Database(
    entities = [OrderEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    // Access DAO
    abstract fun orderDao(): OrderDao

    companion object {

        // Singleton instance (important)
        @Volatile
        private var INSTANCE: AppDatabase? = null

        // Get database instance
        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {

                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "cupcake_db" //  database name (shown in Inspector)
                )
                    // Optional safety (not required, but useful)
                    .fallbackToDestructiveMigration()
                    .build()

                INSTANCE = instance
                instance
            }
        }
    }
}

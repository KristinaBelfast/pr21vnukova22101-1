package com.example.pr21vnukova22101.ui.theme

    import android.content.Context
    import android.database.sqlite.SQLiteDatabase
    import android.database.sqlite.SQLiteOpenHelper

    class DatabaseHelper(context: Context?) :
        SQLiteOpenHelper(
            context,
            DatabaseHelper.Companion.DATABASE_NAME,
            null,
            DatabaseHelper.Companion.SCHEMA
        ) {
        override fun onCreate(db: SQLiteDatabase) {
            db.execSQL(
                ("CREATE TABLE users (" + DatabaseHelper.Companion.COLUMN_ID
                        + " INTEGER PRIMARY KEY AUTOINCREMENT," + DatabaseHelper.Companion.COLUMN_NAME
                        + " TEXT, " + DatabaseHelper.Companion.COLUMN_YEAR + " INTEGER);")
            )
            // добавление начальных данных
            db.execSQL(
                ("INSERT INTO " + DatabaseHelper.Companion.TABLE + " (" + DatabaseHelper.Companion.COLUMN_NAME
                        + ", " + DatabaseHelper.Companion.COLUMN_YEAR + ") VALUES ('Том Смит', 1981);")
            )
        }

        override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
            db.execSQL("DROP TABLE IF EXISTS " + DatabaseHelper.Companion.TABLE)
            onCreate(db)
        }

        companion object {
            private const val DATABASE_NAME = "userstore.db" // название бд
            private const val SCHEMA = 1 // версия базы данных
            const val TABLE: String = "users" // название таблицы в бд

            // названия столбцов
            const val COLUMN_ID: String = "_id"
            const val COLUMN_NAME: String = "name"
            const val COLUMN_YEAR: String = "year"
        }
    }

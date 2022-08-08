package com.example.mineralidentification

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import com.example.mineralidentification.objectClasses.Mineral
import com.example.mineralidentification.objectClasses.Rock
import com.example.mineralidentification.ui.home.MineralIdentificationFragment

private const val TAG = "MineralDatabase"
const val COL_NAME = "NAME"
const val COL_COLOR = "COLOR"
const val COL_STREAK = "STREAK"
const val COL_LUSTER = "LUSTER"
const val COL_HARDNESS = "HARDNESS"
const val COL_CLEAVAGE = "CLEAVAGE"
const val COL_DENSITY = "DENSITY"
const val COL_DESCRIPTION = "DESCRIPTION"
const val COL_FRACTURE = "FRACTURE"
const val COL_COLORROCK = "COLOR"
const val COL_HARDNESSROCK = "HARDNESS"
const val COL_NAMEROCK = "NAME"
const val COL_TEXTURE = "TEXTURE"
const val COL_FIRST = "FIRST"
const val COL_SECOND = "SECOND"
const val COL_THIRD = "THIRD"

private const val DATABASE_NAME = "MINERALS & ROCKS"
private const val TABLE_MINERALS = "MINERALS"
private const val TABLE_RECENT = "RECENT"
private const val ROCK_TABLE = "ROCK"


private const val DATABASE_VERSION = 13

class DataBaseHandler(private val context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        val createTableMinerals = "CREATE TABLE " + TABLE_MINERALS + "(" + COL_NAME + " VARCHAR(256) UNIQUE, " + COL_COLOR +
                " VARCHAR(256), " + COL_STREAK + " VARCHAR(256), " + COL_LUSTER + " VARCHAR(256), " + COL_HARDNESS + " INTEGER, " +
                COL_CLEAVAGE + " VARCHAR(256), " + COL_DENSITY + " INTEGER, " + COL_DESCRIPTION + " VARCHAR(256))"

        db?.execSQL(createTableMinerals)

    }
    /*if (newVersion > oldVersion) {
        val createTableRocks = "CREATE TABLE " + TABLE_ROCKS + "(" + COL_NAMEROCK + " VARCHAR(256) UNIQUE, " +
                COL_COLORROCK + " VARCHAR(256), " + COL_FIRST + " VARCHAR(256), " + COL_SECOND +
                " VARCHAR(256), " + COL_THIRD + " VARCHAR(256), " + COL_HARDNESSROCK + " INTEGER, " + COL_TEXTURE + " VARCHAR(256), " + COL_DESCRIPTION + " VARCHAR(256))"
        db?.execSQL(createTableRocks)
    }*/
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        if (newVersion > oldVersion) {
            /*val createNewTable = "CREATE TABLE IF NOT EXISTS " + TABLE_NEW + "(" + COL_NAME + " VARCHAR(256) UNIQUE, " + COL_COLOR +
                    " VARCHAR(256), " + COL_STREAK + " VARCHAR(256), " + COL_LUSTER + " VARCHAR(256), " + COL_HARDNESS + " INTEGER, " +
                    COL_CLEAVAGE + " VARCHAR(256), " + COL_DENSITY + " INTEGER, " + COL_DESCRIPTION + " VARCHAR(256), " +
                    COL_FRACTURE + " VARCHAR(256))"
            db?.execSQL(createNewTable)

            val dropTable = "DROP TABLE IF EXISTS minerals"
            db?.execSQL(dropTable)
            val renameTable = "ALTER TABLE new RENAME TO minerals"
            db?.execSQL(renameTable)
            val dropRock = "DROP TABLE IF EXISTS rock"
            db?.execSQL(dropRock)*/
            val createRock = "CREATE TABLE " + ROCK_TABLE + "(" + COL_NAMEROCK + " VARCHAR(256) UNIQUE, " + COL_COLORROCK + " VARCHAR(256), " +
                    COL_FIRST + " VARCHAR(256), " + COL_SECOND + " VARCHAR(256), " + COL_THIRD + " VARCHAR(256), " + COL_HARDNESSROCK +  " INTEGER, "+ COL_TEXTURE + " VARCHAR(256))"
            db?.execSQL(createRock)

        }
        /*
        if (newVersion > oldVersion) {
            val createTable = "CREATE TABLE " + ROCK_TABLE + "(" + COL_NAMEROCK + " VARCHAR(256) UNIQUE, " + COL_COLORROCK + " VARCHAR(256), " +
                    COL_FIRST + " VARCHAR(256), " + COL_SECOND + " VARCHAR(256), " + COL_THIRD + " VARCHAR(256), " + COL_HARDNESSROCK +
                    " INTEGER, " + COL_TEXTURE + " VARCHAR(256))"
            db?.execSQL(createTable)
        }*/
    }

    fun insertMinerals(mineral : Mineral) {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(COL_NAME, mineral.name)
        cv.put(COL_COLOR, mineral.color)
        cv.put(COL_STREAK, mineral.streak)
        cv.put(COL_LUSTER, mineral.luster)
        cv.put(COL_HARDNESS, mineral.hardness)
        cv.put(COL_CLEAVAGE, mineral.cleavage)
        cv.put(COL_DENSITY, mineral.density)
        cv.put(COL_DESCRIPTION, mineral.description)
        cv.put(COL_FRACTURE, mineral.fracture)
        val result = db.insert(TABLE_MINERALS, null, cv)
        if (result == (-1).toLong()) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
        }
    }
    fun insertRocks(rock : Rock) {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(COL_NAMEROCK, rock.name)
        cv.put(COL_COLORROCK, rock.color)
        cv.put(COL_FIRST, rock.composition1)
        cv.put(COL_SECOND, rock.composition2)
        cv.put(COL_THIRD, rock.composition3)
        cv.put(COL_HARDNESSROCK, rock.hardness)
        cv.put(COL_TEXTURE, rock.texture)
        val result = db.insert(ROCK_TABLE, null, cv)
        if (result == (-1).toLong()) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
        }
    }
    //rocks searches
    fun readRocks() : MutableList<Rock> {
        val list: MutableList<Rock> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $ROCK_TABLE"
        val result = db.rawQuery(query, null)
        if (result.moveToFirst()) {
            do {
                val rock = Rock()
                rock.name = result.getString(result.getColumnIndex(COL_NAMEROCK))
                rock.color = result.getString(result.getColumnIndex(COL_COLORROCK))
                rock.composition1 = result.getString(result.getColumnIndex(COL_FIRST))
                rock.composition2 = result.getString(result.getColumnIndex(COL_SECOND))
                rock.composition3 = result.getString(result.getColumnIndex(COL_THIRD))
                rock.hardness = result.getString(result.getColumnIndex(COL_HARDNESSROCK)).toDouble()
                rock.texture = result.getString(result.getColumnIndex(COL_TEXTURE))
                list.add(rock)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readRocksForColorAndComp1(color: String, comp1: String) : MutableList<Rock> {
        val list: MutableList<Rock> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $ROCK_TABLE where $COL_COLORROCK=? and $COL_FIRST=?"
        val result = db.rawQuery(query, arrayOf(color, comp1))
        if (result.moveToFirst()) {
            do {
                val rock = Rock()
                rock.name = result.getString(result.getColumnIndex(COL_NAMEROCK))
                rock.color = result.getString(result.getColumnIndex(COL_COLORROCK))
                rock.composition1 = result.getString(result.getColumnIndex(COL_FIRST))
                rock.composition2 = result.getString(result.getColumnIndex(COL_SECOND))
                rock.composition3 = result.getString(result.getColumnIndex(COL_THIRD))
                rock.hardness = result.getString(result.getColumnIndex(COL_HARDNESSROCK)).toDouble()
                rock.texture = result.getString(result.getColumnIndex(COL_TEXTURE))
                list.add(rock)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readRocksForColorAndComp2(color: String, comp2: String) : MutableList<Rock> {
        val list: MutableList<Rock> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $ROCK_TABLE where $COL_COLORROCK=? and $COL_SECOND=?"
        val result = db.rawQuery(query, arrayOf(color, comp2))
        if (result.moveToFirst()) {
            do {
                val rock = Rock()
                rock.name = result.getString(result.getColumnIndex(COL_NAMEROCK))
                rock.color = result.getString(result.getColumnIndex(COL_COLORROCK))
                rock.composition1 = result.getString(result.getColumnIndex(COL_FIRST))
                rock.composition2 = result.getString(result.getColumnIndex(COL_SECOND))
                rock.composition3 = result.getString(result.getColumnIndex(COL_THIRD))
                rock.hardness = result.getString(result.getColumnIndex(COL_HARDNESSROCK)).toDouble()
                rock.texture = result.getString(result.getColumnIndex(COL_TEXTURE))
                list.add(rock)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readRocksForColorAndComp3(color: String, comp3: String) : MutableList<Rock> {
        val list: MutableList<Rock> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $ROCK_TABLE where $COL_COLORROCK=? and $COL_THIRD=?"
        val result = db.rawQuery(query, arrayOf(color, comp3))
        if (result.moveToFirst()) {
            do {
                val rock = Rock()
                rock.name = result.getString(result.getColumnIndex(COL_NAMEROCK))
                rock.color = result.getString(result.getColumnIndex(COL_COLORROCK))
                rock.composition1 = result.getString(result.getColumnIndex(COL_FIRST))
                rock.composition2 = result.getString(result.getColumnIndex(COL_SECOND))
                rock.composition3 = result.getString(result.getColumnIndex(COL_THIRD))
                rock.hardness = result.getString(result.getColumnIndex(COL_HARDNESSROCK)).toDouble()
                rock.texture = result.getString(result.getColumnIndex(COL_TEXTURE))
                list.add(rock)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readRocksForColorAndTexture(color: String, texture: String) : MutableList<Rock> {
        val list: MutableList<Rock> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $ROCK_TABLE where $COL_COLORROCK=? and $COL_TEXTURE=?"
        val result = db.rawQuery(query, arrayOf(color, texture))
        if (result.moveToFirst()) {
            do {
                val rock = Rock()
                rock.name = result.getString(result.getColumnIndex(COL_NAMEROCK))
                rock.color = result.getString(result.getColumnIndex(COL_COLORROCK))
                rock.composition1 = result.getString(result.getColumnIndex(COL_FIRST))
                rock.composition2 = result.getString(result.getColumnIndex(COL_SECOND))
                rock.composition3 = result.getString(result.getColumnIndex(COL_THIRD))
                rock.hardness = result.getString(result.getColumnIndex(COL_HARDNESSROCK)).toDouble()
                rock.texture = result.getString(result.getColumnIndex(COL_TEXTURE))
                list.add(rock)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readRocksForColorAndHardness(color: String, hardness: String) : MutableList<Rock> {
        val list: MutableList<Rock> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $ROCK_TABLE where $COL_COLORROCK=? and $COL_HARDNESSROCK=?"
        val result = db.rawQuery(query, arrayOf(color, hardness))
        if (result.moveToFirst()) {
            do {
                val rock = Rock()
                rock.name = result.getString(result.getColumnIndex(COL_NAMEROCK))
                rock.color = result.getString(result.getColumnIndex(COL_COLORROCK))
                rock.composition1 = result.getString(result.getColumnIndex(COL_FIRST))
                rock.composition2 = result.getString(result.getColumnIndex(COL_SECOND))
                rock.composition3 = result.getString(result.getColumnIndex(COL_THIRD))
                rock.hardness = result.getString(result.getColumnIndex(COL_HARDNESSROCK)).toDouble()
                rock.texture = result.getString(result.getColumnIndex(COL_TEXTURE))
                list.add(rock)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readRocksForComp1AndComp2(comp1: String, comp2: String) : MutableList<Rock> {
        val list: MutableList<Rock> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $ROCK_TABLE where $COL_FIRST=? and $COL_SECOND=?"
        val result = db.rawQuery(query, arrayOf(comp1, comp2))
        if (result.moveToFirst()) {
            do {
                val rock = Rock()
                rock.name = result.getString(result.getColumnIndex(COL_NAMEROCK))
                rock.color = result.getString(result.getColumnIndex(COL_COLORROCK))
                rock.composition1 = result.getString(result.getColumnIndex(COL_FIRST))
                rock.composition2 = result.getString(result.getColumnIndex(COL_SECOND))
                rock.composition3 = result.getString(result.getColumnIndex(COL_THIRD))
                rock.hardness = result.getString(result.getColumnIndex(COL_HARDNESSROCK)).toDouble()
                rock.texture = result.getString(result.getColumnIndex(COL_TEXTURE))
                list.add(rock)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readRocksForComp1AndComp3(comp1: String, comp3: String) : MutableList<Rock> {
        val list: MutableList<Rock> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $ROCK_TABLE where $COL_FIRST=? and $COL_THIRD=?"
        val result = db.rawQuery(query, arrayOf(comp1, comp3))
        if (result.moveToFirst()) {
            do {
                val rock = Rock()
                rock.name = result.getString(result.getColumnIndex(COL_NAMEROCK))
                rock.color = result.getString(result.getColumnIndex(COL_COLORROCK))
                rock.composition1 = result.getString(result.getColumnIndex(COL_FIRST))
                rock.composition2 = result.getString(result.getColumnIndex(COL_SECOND))
                rock.composition3 = result.getString(result.getColumnIndex(COL_THIRD))
                rock.hardness = result.getString(result.getColumnIndex(COL_HARDNESSROCK)).toDouble()
                rock.texture = result.getString(result.getColumnIndex(COL_TEXTURE))
                list.add(rock)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readRocksForComp1AndTexture(comp1: String, texture: String) : MutableList<Rock> {
        val list: MutableList<Rock> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $ROCK_TABLE where $COL_FIRST=? and $COL_TEXTURE=?"
        val result = db.rawQuery(query, arrayOf(comp1, texture))
        if (result.moveToFirst()) {
            do {
                val rock = Rock()
                rock.name = result.getString(result.getColumnIndex(COL_NAMEROCK))
                rock.color = result.getString(result.getColumnIndex(COL_COLORROCK))
                rock.composition1 = result.getString(result.getColumnIndex(COL_FIRST))
                rock.composition2 = result.getString(result.getColumnIndex(COL_SECOND))
                rock.composition3 = result.getString(result.getColumnIndex(COL_THIRD))
                rock.hardness = result.getString(result.getColumnIndex(COL_HARDNESSROCK)).toDouble()
                rock.texture = result.getString(result.getColumnIndex(COL_TEXTURE))
                list.add(rock)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readRocksForComp1AndHardness(comp1: String, hardness: String) : MutableList<Rock> {
        val list: MutableList<Rock> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $ROCK_TABLE where $COL_FIRST=? and $COL_HARDNESSROCK=?"
        val result = db.rawQuery(query, arrayOf(comp1, hardness))
        if (result.moveToFirst()) {
            do {
                val rock = Rock()
                rock.name = result.getString(result.getColumnIndex(COL_NAMEROCK))
                rock.color = result.getString(result.getColumnIndex(COL_COLORROCK))
                rock.composition1 = result.getString(result.getColumnIndex(COL_FIRST))
                rock.composition2 = result.getString(result.getColumnIndex(COL_SECOND))
                rock.composition3 = result.getString(result.getColumnIndex(COL_THIRD))
                rock.hardness = result.getString(result.getColumnIndex(COL_HARDNESSROCK)).toDouble()
                rock.texture = result.getString(result.getColumnIndex(COL_TEXTURE))
                list.add(rock)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readRocksForComp2AndComp3(comp2: String, comp3: String) : MutableList<Rock> {
        val list: MutableList<Rock> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $ROCK_TABLE where $COL_SECOND=? and $COL_THIRD=?"
        val result = db.rawQuery(query, arrayOf(comp2, comp3))
        if (result.moveToFirst()) {
            do {
                val rock = Rock()
                rock.name = result.getString(result.getColumnIndex(COL_NAMEROCK))
                rock.color = result.getString(result.getColumnIndex(COL_COLORROCK))
                rock.composition1 = result.getString(result.getColumnIndex(COL_FIRST))
                rock.composition2 = result.getString(result.getColumnIndex(COL_SECOND))
                rock.composition3 = result.getString(result.getColumnIndex(COL_THIRD))
                rock.hardness = result.getString(result.getColumnIndex(COL_HARDNESSROCK)).toDouble()
                rock.texture = result.getString(result.getColumnIndex(COL_TEXTURE))
                list.add(rock)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readRocksForComp2AndTexture(comp2: String, texture: String) : MutableList<Rock> {
        val list: MutableList<Rock> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $ROCK_TABLE where $COL_SECOND=? and $COL_TEXTURE=?"
        val result = db.rawQuery(query, arrayOf(comp2, texture))
        if (result.moveToFirst()) {
            do {
                val rock = Rock()
                rock.name = result.getString(result.getColumnIndex(COL_NAMEROCK))
                rock.color = result.getString(result.getColumnIndex(COL_COLORROCK))
                rock.composition1 = result.getString(result.getColumnIndex(COL_FIRST))
                rock.composition2 = result.getString(result.getColumnIndex(COL_SECOND))
                rock.composition3 = result.getString(result.getColumnIndex(COL_THIRD))
                rock.hardness = result.getString(result.getColumnIndex(COL_HARDNESSROCK)).toDouble()
                rock.texture = result.getString(result.getColumnIndex(COL_TEXTURE))
                list.add(rock)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readRocksForComp2AndHardness(comp2: String, hardness: String) : MutableList<Rock> {
        val list: MutableList<Rock> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $ROCK_TABLE where $COL_SECOND=? and $COL_HARDNESSROCK=?"
        val result = db.rawQuery(query, arrayOf(comp2, hardness))
        if (result.moveToFirst()) {
            do {
                val rock = Rock()
                rock.name = result.getString(result.getColumnIndex(COL_NAMEROCK))
                rock.color = result.getString(result.getColumnIndex(COL_COLORROCK))
                rock.composition1 = result.getString(result.getColumnIndex(COL_FIRST))
                rock.composition2 = result.getString(result.getColumnIndex(COL_SECOND))
                rock.composition3 = result.getString(result.getColumnIndex(COL_THIRD))
                rock.hardness = result.getString(result.getColumnIndex(COL_HARDNESSROCK)).toDouble()
                rock.texture = result.getString(result.getColumnIndex(COL_TEXTURE))
                list.add(rock)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readRocksForComp3AndTexture(comp3: String, texture: String) : MutableList<Rock> {
        val list: MutableList<Rock> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $ROCK_TABLE where $COL_THIRD=? and $COL_TEXTURE=?"
        val result = db.rawQuery(query, arrayOf(comp3, texture))
        if (result.moveToFirst()) {
            do {
                val rock = Rock()
                rock.name = result.getString(result.getColumnIndex(COL_NAMEROCK))
                rock.color = result.getString(result.getColumnIndex(COL_COLORROCK))
                rock.composition1 = result.getString(result.getColumnIndex(COL_FIRST))
                rock.composition2 = result.getString(result.getColumnIndex(COL_SECOND))
                rock.composition3 = result.getString(result.getColumnIndex(COL_THIRD))
                rock.hardness = result.getString(result.getColumnIndex(COL_HARDNESSROCK)).toDouble()
                rock.texture = result.getString(result.getColumnIndex(COL_TEXTURE))
                list.add(rock)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readRocksForComp3AndHardness(comp3: String, hardness: String) : MutableList<Rock> {
        val list: MutableList<Rock> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $ROCK_TABLE where $COL_THIRD=? and $COL_HARDNESSROCK=?"
        val result = db.rawQuery(query, arrayOf(comp3, hardness))
        if (result.moveToFirst()) {
            do {
                val rock = Rock()
                rock.name = result.getString(result.getColumnIndex(COL_NAMEROCK))
                rock.color = result.getString(result.getColumnIndex(COL_COLORROCK))
                rock.composition1 = result.getString(result.getColumnIndex(COL_FIRST))
                rock.composition2 = result.getString(result.getColumnIndex(COL_SECOND))
                rock.composition3 = result.getString(result.getColumnIndex(COL_THIRD))
                rock.hardness = result.getString(result.getColumnIndex(COL_HARDNESSROCK)).toDouble()
                rock.texture = result.getString(result.getColumnIndex(COL_TEXTURE))
                list.add(rock)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readRocksForTextureAndHardness(texture: String, hardness: String) : MutableList<Rock> {
        val list: MutableList<Rock> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $ROCK_TABLE where $COL_TEXTURE=? and $COL_HARDNESSROCK=?"
        val result = db.rawQuery(query, arrayOf(texture, hardness))
        if (result.moveToFirst()) {
            do {
                val rock = Rock()
                rock.name = result.getString(result.getColumnIndex(COL_NAMEROCK))
                rock.color = result.getString(result.getColumnIndex(COL_COLORROCK))
                rock.composition1 = result.getString(result.getColumnIndex(COL_FIRST))
                rock.composition2 = result.getString(result.getColumnIndex(COL_SECOND))
                rock.composition3 = result.getString(result.getColumnIndex(COL_THIRD))
                rock.hardness = result.getString(result.getColumnIndex(COL_HARDNESSROCK)).toDouble()
                rock.texture = result.getString(result.getColumnIndex(COL_TEXTURE))
                list.add(rock)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }

    fun readRocksForColor(color: String) : MutableList<Rock> {
        val list: MutableList<Rock> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $ROCK_TABLE where $COL_COLORROCK=?"
        val result = db.rawQuery(query, arrayOf(color))
        if (result.moveToFirst()) {
            do {
                val rock = Rock()
                rock.name = result.getString(result.getColumnIndex(COL_NAMEROCK))
                rock.color = result.getString(result.getColumnIndex(COL_COLORROCK))
                rock.composition1 = result.getString(result.getColumnIndex(COL_FIRST))
                rock.composition2 = result.getString(result.getColumnIndex(COL_SECOND))
                rock.composition3 = result.getString(result.getColumnIndex(COL_THIRD))
                rock.hardness = result.getString(result.getColumnIndex(COL_HARDNESSROCK)).toDouble()
                rock.texture = result.getString(result.getColumnIndex(COL_TEXTURE))
                list.add(rock)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readRocksForTexture(texture: String) : MutableList<Rock> {
        val list: MutableList<Rock> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $ROCK_TABLE where $COL_TEXTURE=?"
        val result = db.rawQuery(query, arrayOf(texture))
        if (result.moveToFirst()) {
            do {
                val rock = Rock()
                rock.name = result.getString(result.getColumnIndex(COL_NAMEROCK))
                rock.color = result.getString(result.getColumnIndex(COL_COLORROCK))
                rock.composition1 = result.getString(result.getColumnIndex(COL_FIRST))
                rock.composition2 = result.getString(result.getColumnIndex(COL_SECOND))
                rock.composition3 = result.getString(result.getColumnIndex(COL_THIRD))
                rock.hardness = result.getString(result.getColumnIndex(COL_HARDNESSROCK)).toDouble()
                rock.texture = result.getString(result.getColumnIndex(COL_TEXTURE))
                list.add(rock)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readRocksForHardness(hardness: String) : MutableList<Rock> {
        val list: MutableList<Rock> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $ROCK_TABLE where $COL_HARDNESSROCK=?"
        val result = db.rawQuery(query, arrayOf(hardness))
        if (result.moveToFirst()) {
            do {
                val rock = Rock()
                rock.name = result.getString(result.getColumnIndex(COL_NAMEROCK))
                rock.color = result.getString(result.getColumnIndex(COL_COLORROCK))
                rock.composition1 = result.getString(result.getColumnIndex(COL_FIRST))
                rock.composition2 = result.getString(result.getColumnIndex(COL_SECOND))
                rock.composition3 = result.getString(result.getColumnIndex(COL_THIRD))
                rock.hardness = result.getString(result.getColumnIndex(COL_HARDNESSROCK)).toDouble()
                rock.texture = result.getString(result.getColumnIndex(COL_TEXTURE))
                list.add(rock)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readRocksForComposition1(composition1: String) : MutableList<Rock> {
        val list: MutableList<Rock> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $ROCK_TABLE where $COL_FIRST=?"
        val result = db.rawQuery(query, arrayOf(composition1))
        if (result.moveToFirst()) {
            do {
                val rock = Rock()
                rock.name = result.getString(result.getColumnIndex(COL_NAMEROCK))
                rock.color = result.getString(result.getColumnIndex(COL_COLORROCK))
                rock.composition1 = result.getString(result.getColumnIndex(COL_FIRST))
                rock.composition2 = result.getString(result.getColumnIndex(COL_SECOND))
                rock.composition3 = result.getString(result.getColumnIndex(COL_THIRD))
                rock.hardness = result.getString(result.getColumnIndex(COL_HARDNESSROCK)).toDouble()
                rock.texture = result.getString(result.getColumnIndex(COL_TEXTURE))
                list.add(rock)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readRocksForComposition2(composition2: String) : MutableList<Rock> {
        val list: MutableList<Rock> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $ROCK_TABLE where $COL_SECOND=?"
        val result = db.rawQuery(query, arrayOf(composition2))
        if (result.moveToFirst()) {
            do {
                val rock = Rock()
                rock.name = result.getString(result.getColumnIndex(COL_NAMEROCK))
                rock.color = result.getString(result.getColumnIndex(COL_COLORROCK))
                rock.composition1 = result.getString(result.getColumnIndex(COL_FIRST))
                rock.composition2 = result.getString(result.getColumnIndex(COL_SECOND))
                rock.composition3 = result.getString(result.getColumnIndex(COL_THIRD))
                rock.hardness = result.getString(result.getColumnIndex(COL_HARDNESSROCK)).toDouble()
                rock.texture = result.getString(result.getColumnIndex(COL_TEXTURE))
                list.add(rock)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readRocksForComposition3(composition3: String) : MutableList<Rock> {
        val list: MutableList<Rock> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $ROCK_TABLE where $COL_THIRD=?"
        val result = db.rawQuery(query, arrayOf(composition3))
        if (result.moveToFirst()) {
            do {
                val rock = Rock()
                rock.name = result.getString(result.getColumnIndex(COL_NAMEROCK))
                rock.color = result.getString(result.getColumnIndex(COL_COLORROCK))
                rock.composition1 = result.getString(result.getColumnIndex(COL_FIRST))
                rock.composition2 = result.getString(result.getColumnIndex(COL_SECOND))
                rock.composition3 = result.getString(result.getColumnIndex(COL_THIRD))
                rock.hardness = result.getString(result.getColumnIndex(COL_HARDNESSROCK)).toDouble()
                rock.texture = result.getString(result.getColumnIndex(COL_TEXTURE))
                list.add(rock)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readRocksForColorComp1AndComp2(color: String, comp1: String, comp2: String) : MutableList<Rock> {
        val list: MutableList<Rock> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $ROCK_TABLE where $COL_COLORROCK=? and $COL_FIRST=? and $COL_SECOND=?"
        val result = db.rawQuery(query, arrayOf(color, comp1, comp2))
        if (result.moveToFirst()) {
            do {
                val rock = Rock()
                rock.name = result.getString(result.getColumnIndex(COL_NAMEROCK))
                rock.color = result.getString(result.getColumnIndex(COL_COLORROCK))
                rock.composition1 = result.getString(result.getColumnIndex(COL_FIRST))
                rock.composition2 = result.getString(result.getColumnIndex(COL_SECOND))
                rock.composition3 = result.getString(result.getColumnIndex(COL_THIRD))
                rock.hardness = result.getString(result.getColumnIndex(COL_HARDNESSROCK)).toDouble()
                rock.texture = result.getString(result.getColumnIndex(COL_TEXTURE))
                list.add(rock)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readRocksForColorComp1AndComp3(color: String, comp1: String, comp3: String) : MutableList<Rock> {
        val list: MutableList<Rock> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $ROCK_TABLE where $COL_COLORROCK=? and $COL_FIRST=? and $COL_THIRD=?"
        val result = db.rawQuery(query, arrayOf(color, comp1, comp3))
        if (result.moveToFirst()) {
            do {
                val rock = Rock()
                rock.name = result.getString(result.getColumnIndex(COL_NAMEROCK))
                rock.color = result.getString(result.getColumnIndex(COL_COLORROCK))
                rock.composition1 = result.getString(result.getColumnIndex(COL_FIRST))
                rock.composition2 = result.getString(result.getColumnIndex(COL_SECOND))
                rock.composition3 = result.getString(result.getColumnIndex(COL_THIRD))
                rock.hardness = result.getString(result.getColumnIndex(COL_HARDNESSROCK)).toDouble()
                rock.texture = result.getString(result.getColumnIndex(COL_TEXTURE))
                list.add(rock)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readRocksForColorComp1AndTexture(color: String, comp1: String, texture: String) : MutableList<Rock> {
        val list: MutableList<Rock> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $ROCK_TABLE where $COL_COLORROCK=? and $COL_FIRST=? and $COL_TEXTURE=?"
        val result = db.rawQuery(query, arrayOf(color, comp1, texture))
        if (result.moveToFirst()) {
            do {
                val rock = Rock()
                rock.name = result.getString(result.getColumnIndex(COL_NAMEROCK))
                rock.color = result.getString(result.getColumnIndex(COL_COLORROCK))
                rock.composition1 = result.getString(result.getColumnIndex(COL_FIRST))
                rock.composition2 = result.getString(result.getColumnIndex(COL_SECOND))
                rock.composition3 = result.getString(result.getColumnIndex(COL_THIRD))
                rock.hardness = result.getString(result.getColumnIndex(COL_HARDNESSROCK)).toDouble()
                rock.texture = result.getString(result.getColumnIndex(COL_TEXTURE))
                list.add(rock)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readRocksForColorComp1AndHardness(color: String, comp1: String, hardness: String) : MutableList<Rock> {
        val list: MutableList<Rock> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $ROCK_TABLE where $COL_COLORROCK=? and $COL_FIRST=? and $COL_HARDNESSROCK=?"
        val result = db.rawQuery(query, arrayOf(color, comp1, hardness))
        if (result.moveToFirst()) {
            do {
                val rock = Rock()
                rock.name = result.getString(result.getColumnIndex(COL_NAMEROCK))
                rock.color = result.getString(result.getColumnIndex(COL_COLORROCK))
                rock.composition1 = result.getString(result.getColumnIndex(COL_FIRST))
                rock.composition2 = result.getString(result.getColumnIndex(COL_SECOND))
                rock.composition3 = result.getString(result.getColumnIndex(COL_THIRD))
                rock.hardness = result.getString(result.getColumnIndex(COL_HARDNESSROCK)).toDouble()
                rock.texture = result.getString(result.getColumnIndex(COL_TEXTURE))
                list.add(rock)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readRocksForColorComp2AndComp3(color: String, comp2: String, comp3: String) : MutableList<Rock> {
        val list: MutableList<Rock> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $ROCK_TABLE where $COL_COLORROCK=? and $COL_SECOND=? and $COL_THIRD=?"
        val result = db.rawQuery(query, arrayOf(color, comp2, comp3))
        if (result.moveToFirst()) {
            do {
                val rock = Rock()
                rock.name = result.getString(result.getColumnIndex(COL_NAMEROCK))
                rock.color = result.getString(result.getColumnIndex(COL_COLORROCK))
                rock.composition1 = result.getString(result.getColumnIndex(COL_FIRST))
                rock.composition2 = result.getString(result.getColumnIndex(COL_SECOND))
                rock.composition3 = result.getString(result.getColumnIndex(COL_THIRD))
                rock.hardness = result.getString(result.getColumnIndex(COL_HARDNESSROCK)).toDouble()
                rock.texture = result.getString(result.getColumnIndex(COL_TEXTURE))
                list.add(rock)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readRocksForColorComp2AndTexture(color: String, comp2: String, texture: String) : MutableList<Rock> {
        val list: MutableList<Rock> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $ROCK_TABLE where $COL_COLORROCK=? and $COL_SECOND=? and $COL_TEXTURE=?"
        val result = db.rawQuery(query, arrayOf(color, comp2, texture))
        if (result.moveToFirst()) {
            do {
                val rock = Rock()
                rock.name = result.getString(result.getColumnIndex(COL_NAMEROCK))
                rock.color = result.getString(result.getColumnIndex(COL_COLORROCK))
                rock.composition1 = result.getString(result.getColumnIndex(COL_FIRST))
                rock.composition2 = result.getString(result.getColumnIndex(COL_SECOND))
                rock.composition3 = result.getString(result.getColumnIndex(COL_THIRD))
                rock.hardness = result.getString(result.getColumnIndex(COL_HARDNESSROCK)).toDouble()
                rock.texture = result.getString(result.getColumnIndex(COL_TEXTURE))
                list.add(rock)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readRocksForColorComp2AndHardness(color: String, comp2: String, hardness: String) : MutableList<Rock> {
        val list: MutableList<Rock> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $ROCK_TABLE where $COL_COLORROCK=? and $COL_SECOND=? and $COL_HARDNESSROCK=?"
        val result = db.rawQuery(query, arrayOf(color, comp2, hardness))
        if (result.moveToFirst()) {
            do {
                val rock = Rock()
                rock.name = result.getString(result.getColumnIndex(COL_NAMEROCK))
                rock.color = result.getString(result.getColumnIndex(COL_COLORROCK))
                rock.composition1 = result.getString(result.getColumnIndex(COL_FIRST))
                rock.composition2 = result.getString(result.getColumnIndex(COL_SECOND))
                rock.composition3 = result.getString(result.getColumnIndex(COL_THIRD))
                rock.hardness = result.getString(result.getColumnIndex(COL_HARDNESSROCK)).toDouble()
                rock.texture = result.getString(result.getColumnIndex(COL_TEXTURE))
                list.add(rock)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readRocksForColorComp3AndTexture(color: String, comp3: String, texture: String) : MutableList<Rock> {
        val list: MutableList<Rock> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $ROCK_TABLE where $COL_COLORROCK=? and $COL_THIRD=? and $COL_TEXTURE=?"
        val result = db.rawQuery(query, arrayOf(color, comp3, texture))
        if (result.moveToFirst()) {
            do {
                val rock = Rock()
                rock.name = result.getString(result.getColumnIndex(COL_NAMEROCK))
                rock.color = result.getString(result.getColumnIndex(COL_COLORROCK))
                rock.composition1 = result.getString(result.getColumnIndex(COL_FIRST))
                rock.composition2 = result.getString(result.getColumnIndex(COL_SECOND))
                rock.composition3 = result.getString(result.getColumnIndex(COL_THIRD))
                rock.hardness = result.getString(result.getColumnIndex(COL_HARDNESSROCK)).toDouble()
                rock.texture = result.getString(result.getColumnIndex(COL_TEXTURE))
                list.add(rock)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readRocksForColorComp3AndHardness(color: String, comp3: String, hardness: String) : MutableList<Rock> {
        val list: MutableList<Rock> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $ROCK_TABLE where $COL_COLORROCK=? and $COL_THIRD=? and $COL_HARDNESSROCK=?"
        val result = db.rawQuery(query, arrayOf(color, comp3, hardness))
        if (result.moveToFirst()) {
            do {
                val rock = Rock()
                rock.name = result.getString(result.getColumnIndex(COL_NAMEROCK))
                rock.color = result.getString(result.getColumnIndex(COL_COLORROCK))
                rock.composition1 = result.getString(result.getColumnIndex(COL_FIRST))
                rock.composition2 = result.getString(result.getColumnIndex(COL_SECOND))
                rock.composition3 = result.getString(result.getColumnIndex(COL_THIRD))
                rock.hardness = result.getString(result.getColumnIndex(COL_HARDNESSROCK)).toDouble()
                rock.texture = result.getString(result.getColumnIndex(COL_TEXTURE))
                list.add(rock)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readRocksForColorTextureAndHardness(color: String, texture: String, hardness: String) : MutableList<Rock> {
        val list: MutableList<Rock> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $ROCK_TABLE where $COL_COLORROCK=? and $COL_TEXTURE=? and $COL_HARDNESSROCK=?"
        val result = db.rawQuery(query, arrayOf(color, texture, hardness))
        if (result.moveToFirst()) {
            do {
                val rock = Rock()
                rock.name = result.getString(result.getColumnIndex(COL_NAMEROCK))
                rock.color = result.getString(result.getColumnIndex(COL_COLORROCK))
                rock.composition1 = result.getString(result.getColumnIndex(COL_FIRST))
                rock.composition2 = result.getString(result.getColumnIndex(COL_SECOND))
                rock.composition3 = result.getString(result.getColumnIndex(COL_THIRD))
                rock.hardness = result.getString(result.getColumnIndex(COL_HARDNESSROCK)).toDouble()
                rock.texture = result.getString(result.getColumnIndex(COL_TEXTURE))
                list.add(rock)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readRocksForComp1Comp2AndComp3(comp1: String, comp2: String, comp3: String) : MutableList<Rock> {
        val list: MutableList<Rock> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $ROCK_TABLE where $COL_FIRST=? and $COL_SECOND=? and $COL_THIRD=?"
        val result = db.rawQuery(query, arrayOf(comp1, comp2, comp3))
        if (result.moveToFirst()) {
            do {
                val rock = Rock()
                rock.name = result.getString(result.getColumnIndex(COL_NAMEROCK))
                rock.color = result.getString(result.getColumnIndex(COL_COLORROCK))
                rock.composition1 = result.getString(result.getColumnIndex(COL_FIRST))
                rock.composition2 = result.getString(result.getColumnIndex(COL_SECOND))
                rock.composition3 = result.getString(result.getColumnIndex(COL_THIRD))
                rock.hardness = result.getString(result.getColumnIndex(COL_HARDNESSROCK)).toDouble()
                rock.texture = result.getString(result.getColumnIndex(COL_TEXTURE))
                list.add(rock)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readRocksForComp1Comp2AndTexture(comp1: String, comp2: String, texture: String) : MutableList<Rock> {
        val list: MutableList<Rock> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $ROCK_TABLE where $COL_FIRST=? and $COL_SECOND=? and $COL_TEXTURE=?"
        val result = db.rawQuery(query, arrayOf(comp1, comp2, texture))
        if (result.moveToFirst()) {
            do {
                val rock = Rock()
                rock.name = result.getString(result.getColumnIndex(COL_NAMEROCK))
                rock.color = result.getString(result.getColumnIndex(COL_COLORROCK))
                rock.composition1 = result.getString(result.getColumnIndex(COL_FIRST))
                rock.composition2 = result.getString(result.getColumnIndex(COL_SECOND))
                rock.composition3 = result.getString(result.getColumnIndex(COL_THIRD))
                rock.hardness = result.getString(result.getColumnIndex(COL_HARDNESSROCK)).toDouble()
                rock.texture = result.getString(result.getColumnIndex(COL_TEXTURE))
                list.add(rock)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readRocksForComp1Comp3AndTexture(comp1: String, comp3: String, texture: String) : MutableList<Rock> {
        val list: MutableList<Rock> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $ROCK_TABLE where $COL_FIRST=? and $COL_THIRD=? and $COL_TEXTURE=?"
        val result = db.rawQuery(query, arrayOf(comp1, comp3, texture))
        if (result.moveToFirst()) {
            do {
                val rock = Rock()
                rock.name = result.getString(result.getColumnIndex(COL_NAMEROCK))
                rock.color = result.getString(result.getColumnIndex(COL_COLORROCK))
                rock.composition1 = result.getString(result.getColumnIndex(COL_FIRST))
                rock.composition2 = result.getString(result.getColumnIndex(COL_SECOND))
                rock.composition3 = result.getString(result.getColumnIndex(COL_THIRD))
                rock.hardness = result.getString(result.getColumnIndex(COL_HARDNESSROCK)).toDouble()
                rock.texture = result.getString(result.getColumnIndex(COL_TEXTURE))
                list.add(rock)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readRocksForComp1Comp3AndHardness(comp1: String, comp3: String, hardness: String) : MutableList<Rock> {
        val list: MutableList<Rock> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $ROCK_TABLE where $COL_FIRST=? and $COL_THIRD=? and $COL_HARDNESSROCK=?"
        val result = db.rawQuery(query, arrayOf(comp1, comp3, hardness))
        if (result.moveToFirst()) {
            do {
                val rock = Rock()
                rock.name = result.getString(result.getColumnIndex(COL_NAMEROCK))
                rock.color = result.getString(result.getColumnIndex(COL_COLORROCK))
                rock.composition1 = result.getString(result.getColumnIndex(COL_FIRST))
                rock.composition2 = result.getString(result.getColumnIndex(COL_SECOND))
                rock.composition3 = result.getString(result.getColumnIndex(COL_THIRD))
                rock.hardness = result.getString(result.getColumnIndex(COL_HARDNESSROCK)).toDouble()
                rock.texture = result.getString(result.getColumnIndex(COL_TEXTURE))
                list.add(rock)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readRocksForComp1TextureAndHardness(comp1: String, texture: String, hardness: String) : MutableList<Rock> {
        val list: MutableList<Rock> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $ROCK_TABLE where $COL_FIRST=? and $COL_TEXTURE=? and $COL_HARDNESSROCK=?"
        val result = db.rawQuery(query, arrayOf(comp1, texture, hardness))
        if (result.moveToFirst()) {
            do {
                val rock = Rock()
                rock.name = result.getString(result.getColumnIndex(COL_NAMEROCK))
                rock.color = result.getString(result.getColumnIndex(COL_COLORROCK))
                rock.composition1 = result.getString(result.getColumnIndex(COL_FIRST))
                rock.composition2 = result.getString(result.getColumnIndex(COL_SECOND))
                rock.composition3 = result.getString(result.getColumnIndex(COL_THIRD))
                rock.hardness = result.getString(result.getColumnIndex(COL_HARDNESSROCK)).toDouble()
                rock.texture = result.getString(result.getColumnIndex(COL_TEXTURE))
                list.add(rock)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readRocksForComp2Comp3AndTexture(comp2: String, comp3: String, texture: String) : MutableList<Rock> {
        val list: MutableList<Rock> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $ROCK_TABLE where $COL_SECOND=? and $COL_THIRD=? and $COL_TEXTURE=?"
        val result = db.rawQuery(query, arrayOf(comp2, comp3, texture))
        if (result.moveToFirst()) {
            do {
                val rock = Rock()
                rock.name = result.getString(result.getColumnIndex(COL_NAMEROCK))
                rock.color = result.getString(result.getColumnIndex(COL_COLORROCK))
                rock.composition1 = result.getString(result.getColumnIndex(COL_FIRST))
                rock.composition2 = result.getString(result.getColumnIndex(COL_SECOND))
                rock.composition3 = result.getString(result.getColumnIndex(COL_THIRD))
                rock.hardness = result.getString(result.getColumnIndex(COL_HARDNESSROCK)).toDouble()
                rock.texture = result.getString(result.getColumnIndex(COL_TEXTURE))
                list.add(rock)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readRocksForComp2Comp3AndHardness(comp2: String, comp3: String, hardness: String) : MutableList<Rock> {
        val list: MutableList<Rock> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $ROCK_TABLE where $COL_SECOND=? and $COL_THIRD=? and $COL_HARDNESSROCK=?"
        val result = db.rawQuery(query, arrayOf(comp2, comp3, hardness))
        if (result.moveToFirst()) {
            do {
                val rock = Rock()
                rock.name = result.getString(result.getColumnIndex(COL_NAMEROCK))
                rock.color = result.getString(result.getColumnIndex(COL_COLORROCK))
                rock.composition1 = result.getString(result.getColumnIndex(COL_FIRST))
                rock.composition2 = result.getString(result.getColumnIndex(COL_SECOND))
                rock.composition3 = result.getString(result.getColumnIndex(COL_THIRD))
                rock.hardness = result.getString(result.getColumnIndex(COL_HARDNESSROCK)).toDouble()
                rock.texture = result.getString(result.getColumnIndex(COL_TEXTURE))
                list.add(rock)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readRocksForComp2TextureAndHardness(comp2: String, texture: String, hardness: String) : MutableList<Rock> {
        val list: MutableList<Rock> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $ROCK_TABLE where $COL_SECOND=? and $COL_TEXTURE=? and $COL_HARDNESSROCK=?"
        val result = db.rawQuery(query, arrayOf(comp2, texture, hardness))
        if (result.moveToFirst()) {
            do {
                val rock = Rock()
                rock.name = result.getString(result.getColumnIndex(COL_NAMEROCK))
                rock.color = result.getString(result.getColumnIndex(COL_COLORROCK))
                rock.composition1 = result.getString(result.getColumnIndex(COL_FIRST))
                rock.composition2 = result.getString(result.getColumnIndex(COL_SECOND))
                rock.composition3 = result.getString(result.getColumnIndex(COL_THIRD))
                rock.hardness = result.getString(result.getColumnIndex(COL_HARDNESSROCK)).toDouble()
                rock.texture = result.getString(result.getColumnIndex(COL_TEXTURE))
                list.add(rock)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readRocksForComp3TextureAndHardness(comp3: String, texture: String, hardness: String) : MutableList<Rock> {
        val list: MutableList<Rock> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $ROCK_TABLE where $COL_THIRD=? and $COL_TEXTURE=? and $COL_HARDNESSROCK=?"
        val result = db.rawQuery(query, arrayOf(comp3, texture, hardness))
        if (result.moveToFirst()) {
            do {
                val rock = Rock()
                rock.name = result.getString(result.getColumnIndex(COL_NAMEROCK))
                rock.color = result.getString(result.getColumnIndex(COL_COLORROCK))
                rock.composition1 = result.getString(result.getColumnIndex(COL_FIRST))
                rock.composition2 = result.getString(result.getColumnIndex(COL_SECOND))
                rock.composition3 = result.getString(result.getColumnIndex(COL_THIRD))
                rock.hardness = result.getString(result.getColumnIndex(COL_HARDNESSROCK)).toDouble()
                rock.texture = result.getString(result.getColumnIndex(COL_TEXTURE))
                list.add(rock)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readRocksForColorComp1Comp2AndComp3(color: String, comp1: String, comp2: String, comp3: String) : MutableList<Rock> {
        val list: MutableList<Rock> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $ROCK_TABLE where $COL_COLORROCK=? and $COL_FIRST=? and $COL_SECOND=? and $COL_THIRD=?"
        val result = db.rawQuery(query, arrayOf(color, comp1, comp2, comp3))
        if (result.moveToFirst()) {
            do {
                val rock = Rock()
                rock.name = result.getString(result.getColumnIndex(COL_NAMEROCK))
                rock.color = result.getString(result.getColumnIndex(COL_COLORROCK))
                rock.composition1 = result.getString(result.getColumnIndex(COL_FIRST))
                rock.composition2 = result.getString(result.getColumnIndex(COL_SECOND))
                rock.composition3 = result.getString(result.getColumnIndex(COL_THIRD))
                rock.hardness = result.getString(result.getColumnIndex(COL_HARDNESSROCK)).toDouble()
                rock.texture = result.getString(result.getColumnIndex(COL_TEXTURE))
                list.add(rock)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }

    fun readRocksForColorComp1Comp2AndTexture(color: String, comp1: String, comp2: String, texture: String) : MutableList<Rock> {
        val list: MutableList<Rock> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $ROCK_TABLE where $COL_COLORROCK=? and $COL_FIRST=? and $COL_SECOND=? and $COL_TEXTURE=?"
        val result = db.rawQuery(query, arrayOf(color, comp1, comp2, texture))
        if (result.moveToFirst()) {
            do {
                val rock = Rock()
                rock.name = result.getString(result.getColumnIndex(COL_NAMEROCK))
                rock.color = result.getString(result.getColumnIndex(COL_COLORROCK))
                rock.composition1 = result.getString(result.getColumnIndex(COL_FIRST))
                rock.composition2 = result.getString(result.getColumnIndex(COL_SECOND))
                rock.composition3 = result.getString(result.getColumnIndex(COL_THIRD))
                rock.hardness = result.getString(result.getColumnIndex(COL_HARDNESSROCK)).toDouble()
                rock.texture = result.getString(result.getColumnIndex(COL_TEXTURE))
                list.add(rock)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readRocksForColorComp1Comp2AndHardness(color: String, comp1: String, comp2: String, hardness: String) : MutableList<Rock> {
        val list: MutableList<Rock> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $ROCK_TABLE where $COL_COLORROCK=? and $COL_FIRST=? and $COL_SECOND=? and $COL_HARDNESSROCK=?"
        val result = db.rawQuery(query, arrayOf(color, comp1, comp2, hardness))
        if (result.moveToFirst()) {
            do {
                val rock = Rock()
                rock.name = result.getString(result.getColumnIndex(COL_NAMEROCK))
                rock.color = result.getString(result.getColumnIndex(COL_COLORROCK))
                rock.composition1 = result.getString(result.getColumnIndex(COL_FIRST))
                rock.composition2 = result.getString(result.getColumnIndex(COL_SECOND))
                rock.composition3 = result.getString(result.getColumnIndex(COL_THIRD))
                rock.hardness = result.getString(result.getColumnIndex(COL_HARDNESSROCK)).toDouble()
                rock.texture = result.getString(result.getColumnIndex(COL_TEXTURE))
                list.add(rock)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readRocksForColorComp1Comp3AndTexture(color: String, comp1: String, comp3: String, texture: String) : MutableList<Rock> {
        val list: MutableList<Rock> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $ROCK_TABLE where $COL_COLORROCK=? and $COL_FIRST=? and $COL_THIRD=? and $COL_TEXTURE=?"
        val result = db.rawQuery(query, arrayOf(color, comp1, comp3, texture))
        if (result.moveToFirst()) {
            do {
                val rock = Rock()
                rock.name = result.getString(result.getColumnIndex(COL_NAMEROCK))
                rock.color = result.getString(result.getColumnIndex(COL_COLORROCK))
                rock.composition1 = result.getString(result.getColumnIndex(COL_FIRST))
                rock.composition2 = result.getString(result.getColumnIndex(COL_SECOND))
                rock.composition3 = result.getString(result.getColumnIndex(COL_THIRD))
                rock.hardness = result.getString(result.getColumnIndex(COL_HARDNESSROCK)).toDouble()
                rock.texture = result.getString(result.getColumnIndex(COL_TEXTURE))
                list.add(rock)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readRocksForColorComp1Comp3AndHardness(color: String, comp1: String, comp3: String, hardness: String) : MutableList<Rock> {
        val list: MutableList<Rock> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $ROCK_TABLE where $COL_COLORROCK=? and $COL_FIRST=? and $COL_THIRD=? and $COL_HARDNESSROCK=?"
        val result = db.rawQuery(query, arrayOf(color, comp1, comp3, hardness))
        if (result.moveToFirst()) {
            do {
                val rock = Rock()
                rock.name = result.getString(result.getColumnIndex(COL_NAMEROCK))
                rock.color = result.getString(result.getColumnIndex(COL_COLORROCK))
                rock.composition1 = result.getString(result.getColumnIndex(COL_FIRST))
                rock.composition2 = result.getString(result.getColumnIndex(COL_SECOND))
                rock.composition3 = result.getString(result.getColumnIndex(COL_THIRD))
                rock.hardness = result.getString(result.getColumnIndex(COL_HARDNESSROCK)).toDouble()
                rock.texture = result.getString(result.getColumnIndex(COL_TEXTURE))
                list.add(rock)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readRocksForColorComp2Comp3AndTexture(color: String, comp2: String, comp3: String, texture: String) : MutableList<Rock> {
        val list: MutableList<Rock> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $ROCK_TABLE where $COL_COLORROCK=? and $COL_SECOND=? and $COL_THIRD=? and $COL_TEXTURE=?"
        val result = db.rawQuery(query, arrayOf(color, comp2, comp3, texture))
        if (result.moveToFirst()) {
            do {
                val rock = Rock()
                rock.name = result.getString(result.getColumnIndex(COL_NAMEROCK))
                rock.color = result.getString(result.getColumnIndex(COL_COLORROCK))
                rock.composition1 = result.getString(result.getColumnIndex(COL_FIRST))
                rock.composition2 = result.getString(result.getColumnIndex(COL_SECOND))
                rock.composition3 = result.getString(result.getColumnIndex(COL_THIRD))
                rock.hardness = result.getString(result.getColumnIndex(COL_HARDNESSROCK)).toDouble()
                rock.texture = result.getString(result.getColumnIndex(COL_TEXTURE))
                list.add(rock)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readRocksForColorComp2Comp3AndHardness(color: String, comp2: String, comp3: String, hardness: String) : MutableList<Rock> {
        val list: MutableList<Rock> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $ROCK_TABLE where $COL_COLORROCK=? and $COL_SECOND=? and $COL_THIRD=? and $COL_HARDNESSROCK=?"
        val result = db.rawQuery(query, arrayOf(color, comp2, comp3, hardness))
        if (result.moveToFirst()) {
            do {
                val rock = Rock()
                rock.name = result.getString(result.getColumnIndex(COL_NAMEROCK))
                rock.color = result.getString(result.getColumnIndex(COL_COLORROCK))
                rock.composition1 = result.getString(result.getColumnIndex(COL_FIRST))
                rock.composition2 = result.getString(result.getColumnIndex(COL_SECOND))
                rock.composition3 = result.getString(result.getColumnIndex(COL_THIRD))
                rock.hardness = result.getString(result.getColumnIndex(COL_HARDNESSROCK)).toDouble()
                rock.texture = result.getString(result.getColumnIndex(COL_TEXTURE))
                list.add(rock)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readRocksForColorComp2TextureAndHardness(color: String, comp2: String, texture: String, hardness: String) : MutableList<Rock> {
        val list: MutableList<Rock> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $ROCK_TABLE where $COL_COLORROCK=? and $COL_SECOND=? and $COL_TEXTURE=? and $COL_HARDNESSROCK=?"
        val result = db.rawQuery(query, arrayOf(color, comp2, texture, hardness))
        if (result.moveToFirst()) {
            do {
                val rock = Rock()
                rock.name = result.getString(result.getColumnIndex(COL_NAMEROCK))
                rock.color = result.getString(result.getColumnIndex(COL_COLORROCK))
                rock.composition1 = result.getString(result.getColumnIndex(COL_FIRST))
                rock.composition2 = result.getString(result.getColumnIndex(COL_SECOND))
                rock.composition3 = result.getString(result.getColumnIndex(COL_THIRD))
                rock.hardness = result.getString(result.getColumnIndex(COL_HARDNESSROCK)).toDouble()
                rock.texture = result.getString(result.getColumnIndex(COL_TEXTURE))
                list.add(rock)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readRocksForColorComp3TextureAndHardness(color: String, comp3: String, texture: String, hardness: String) : MutableList<Rock> {
        val list: MutableList<Rock> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $ROCK_TABLE where $COL_COLORROCK=? and $COL_THIRD=? and $COL_TEXTURE=? and $COL_HARDNESSROCK=?"
        val result = db.rawQuery(query, arrayOf(color, comp3, texture, hardness))
        if (result.moveToFirst()) {
            do {
                val rock = Rock()
                rock.name = result.getString(result.getColumnIndex(COL_NAMEROCK))
                rock.color = result.getString(result.getColumnIndex(COL_COLORROCK))
                rock.composition1 = result.getString(result.getColumnIndex(COL_FIRST))
                rock.composition2 = result.getString(result.getColumnIndex(COL_SECOND))
                rock.composition3 = result.getString(result.getColumnIndex(COL_THIRD))
                rock.hardness = result.getString(result.getColumnIndex(COL_HARDNESSROCK)).toDouble()
                rock.texture = result.getString(result.getColumnIndex(COL_TEXTURE))
                list.add(rock)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readRocksForComp1Comp2Comp3AndHardness(comp1: String, comp2: String, comp3: String, hardness: String) : MutableList<Rock> {
        val list: MutableList<Rock> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $ROCK_TABLE where $COL_FIRST=? and $COL_SECOND=? and $COL_THIRD=? and $COL_HARDNESSROCK=?"
        val result = db.rawQuery(query, arrayOf(comp1, comp2, comp3, hardness))
        if (result.moveToFirst()) {
            do {
                val rock = Rock()
                rock.name = result.getString(result.getColumnIndex(COL_NAMEROCK))
                rock.color = result.getString(result.getColumnIndex(COL_COLORROCK))
                rock.composition1 = result.getString(result.getColumnIndex(COL_FIRST))
                rock.composition2 = result.getString(result.getColumnIndex(COL_SECOND))
                rock.composition3 = result.getString(result.getColumnIndex(COL_THIRD))
                rock.hardness = result.getString(result.getColumnIndex(COL_HARDNESSROCK)).toDouble()
                rock.texture = result.getString(result.getColumnIndex(COL_TEXTURE))
                list.add(rock)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readRocksForComp1Comp2Comp3AndTexture(comp1: String, comp2: String, comp3: String, texture: String) : MutableList<Rock> {
        val list: MutableList<Rock> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $ROCK_TABLE where $COL_FIRST=? and $COL_SECOND=? and $COL_THIRD=? and $COL_TEXTURE=?"
        val result = db.rawQuery(query, arrayOf(comp1, comp2, comp3, texture))
        if (result.moveToFirst()) {
            do {
                val rock = Rock()
                rock.name = result.getString(result.getColumnIndex(COL_NAMEROCK))
                rock.color = result.getString(result.getColumnIndex(COL_COLORROCK))
                rock.composition1 = result.getString(result.getColumnIndex(COL_FIRST))
                rock.composition2 = result.getString(result.getColumnIndex(COL_SECOND))
                rock.composition3 = result.getString(result.getColumnIndex(COL_THIRD))
                rock.hardness = result.getString(result.getColumnIndex(COL_HARDNESSROCK)).toDouble()
                rock.texture = result.getString(result.getColumnIndex(COL_TEXTURE))
                list.add(rock)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readRocksForComp1Comp2TextureAndHardness(comp1: String, comp2: String, texture: String, hardness: String) : MutableList<Rock> {
        val list: MutableList<Rock> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $ROCK_TABLE where $COL_FIRST=? and $COL_SECOND=? and $COL_TEXTURE=? and $COL_HARDNESSROCK=?"
        val result = db.rawQuery(query, arrayOf(comp1, comp2, texture, hardness))
        if (result.moveToFirst()) {
            do {
                val rock = Rock()
                rock.name = result.getString(result.getColumnIndex(COL_NAMEROCK))
                rock.color = result.getString(result.getColumnIndex(COL_COLORROCK))
                rock.composition1 = result.getString(result.getColumnIndex(COL_FIRST))
                rock.composition2 = result.getString(result.getColumnIndex(COL_SECOND))
                rock.composition3 = result.getString(result.getColumnIndex(COL_THIRD))
                rock.hardness = result.getString(result.getColumnIndex(COL_HARDNESSROCK)).toDouble()
                rock.texture = result.getString(result.getColumnIndex(COL_TEXTURE))
                list.add(rock)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readRocksForComp1Comp3TextureAndHardness(comp1: String, comp3: String, texture: String, hardness: String) : MutableList<Rock> {
        val list: MutableList<Rock> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $ROCK_TABLE where $COL_FIRST=? and $COL_THIRD=? and $COL_TEXTURE=? and $COL_HARDNESSROCK=?"
        val result = db.rawQuery(query, arrayOf(comp1, comp3, texture, hardness))
        if (result.moveToFirst()) {
            do {
                val rock = Rock()
                rock.name = result.getString(result.getColumnIndex(COL_NAMEROCK))
                rock.color = result.getString(result.getColumnIndex(COL_COLORROCK))
                rock.composition1 = result.getString(result.getColumnIndex(COL_FIRST))
                rock.composition2 = result.getString(result.getColumnIndex(COL_SECOND))
                rock.composition3 = result.getString(result.getColumnIndex(COL_THIRD))
                rock.hardness = result.getString(result.getColumnIndex(COL_HARDNESSROCK)).toDouble()
                rock.texture = result.getString(result.getColumnIndex(COL_TEXTURE))
                list.add(rock)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readRocksForComp2Comp3TextureAndHardness(comp2: String, comp3: String, texture: String, hardness: String) : MutableList<Rock> {
        val list: MutableList<Rock> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $ROCK_TABLE where $COL_SECOND=? and $COL_THIRD=? and $COL_TEXTURE=? and $COL_HARDNESSROCK=?"
        val result = db.rawQuery(query, arrayOf(comp2, comp3, texture, hardness))
        if (result.moveToFirst()) {
            do {
                val rock = Rock()
                rock.name = result.getString(result.getColumnIndex(COL_NAMEROCK))
                rock.color = result.getString(result.getColumnIndex(COL_COLORROCK))
                rock.composition1 = result.getString(result.getColumnIndex(COL_FIRST))
                rock.composition2 = result.getString(result.getColumnIndex(COL_SECOND))
                rock.composition3 = result.getString(result.getColumnIndex(COL_THIRD))
                rock.hardness = result.getString(result.getColumnIndex(COL_HARDNESSROCK)).toDouble()
                rock.texture = result.getString(result.getColumnIndex(COL_TEXTURE))
                list.add(rock)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readRocksForColorComp1Comp2Comp3AndHardness(color: String, comp1: String, comp2: String, comp3: String, hardness: String) : MutableList<Rock> {
        val list: MutableList<Rock> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $ROCK_TABLE where $COL_COLORROCK and $COL_FIRST=? and $COL_SECOND=? and $COL_THIRD=? and $COL_HARDNESSROCK=?"
        val result = db.rawQuery(query, arrayOf(color, comp1, comp2, comp3, hardness))
        if (result.moveToFirst()) {
            do {
                val rock = Rock()
                rock.name = result.getString(result.getColumnIndex(COL_NAMEROCK))
                rock.color = result.getString(result.getColumnIndex(COL_COLORROCK))
                rock.composition1 = result.getString(result.getColumnIndex(COL_FIRST))
                rock.composition2 = result.getString(result.getColumnIndex(COL_SECOND))
                rock.composition3 = result.getString(result.getColumnIndex(COL_THIRD))
                rock.hardness = result.getString(result.getColumnIndex(COL_HARDNESSROCK)).toDouble()
                rock.texture = result.getString(result.getColumnIndex(COL_TEXTURE))
                list.add(rock)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }

    fun readRocksForColorComp1Comp2Comp3AndTexture(color: String, comp1: String, comp2: String, comp3: String, texture: String) : MutableList<Rock> {
        val list: MutableList<Rock> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $ROCK_TABLE where $COL_COLORROCK and $COL_FIRST=? and $COL_SECOND=? and $COL_THIRD=? and $COL_TEXTURE=?"
        val result = db.rawQuery(query, arrayOf(color, comp1, comp2, comp3, texture))
        if (result.moveToFirst()) {
            do {
                val rock = Rock()
                rock.name = result.getString(result.getColumnIndex(COL_NAMEROCK))
                rock.color = result.getString(result.getColumnIndex(COL_COLORROCK))
                rock.composition1 = result.getString(result.getColumnIndex(COL_FIRST))
                rock.composition2 = result.getString(result.getColumnIndex(COL_SECOND))
                rock.composition3 = result.getString(result.getColumnIndex(COL_THIRD))
                rock.hardness = result.getString(result.getColumnIndex(COL_HARDNESSROCK)).toDouble()
                rock.texture = result.getString(result.getColumnIndex(COL_TEXTURE))
                list.add(rock)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readRocksForColorComp1Comp2TextureAndHardness(color: String, comp1: String, comp2: String, texture: String, hardness: String) : MutableList<Rock> {
        val list: MutableList<Rock> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $ROCK_TABLE where $COL_COLORROCK and $COL_FIRST=? and $COL_SECOND=? and $COL_TEXTURE=? and $COL_HARDNESSROCK=?"
        val result = db.rawQuery(query, arrayOf(color, comp1, comp2, texture, hardness))
        if (result.moveToFirst()) {
            do {
                val rock = Rock()
                rock.name = result.getString(result.getColumnIndex(COL_NAMEROCK))
                rock.color = result.getString(result.getColumnIndex(COL_COLORROCK))
                rock.composition1 = result.getString(result.getColumnIndex(COL_FIRST))
                rock.composition2 = result.getString(result.getColumnIndex(COL_SECOND))
                rock.composition3 = result.getString(result.getColumnIndex(COL_THIRD))
                rock.hardness = result.getString(result.getColumnIndex(COL_HARDNESSROCK)).toDouble()
                rock.texture = result.getString(result.getColumnIndex(COL_TEXTURE))
                list.add(rock)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readRocksForColorComp2Comp3TextureAndHardness(color: String, comp2: String, comp3: String, texture: String, hardness: String) : MutableList<Rock> {
        val list: MutableList<Rock> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $ROCK_TABLE where $COL_COLORROCK and $COL_SECOND=? and $COL_THIRD=? and $COL_TEXTURE=? and $COL_HARDNESSROCK=?"
        val result = db.rawQuery(query, arrayOf(color, comp2, comp3, texture, hardness))
        if (result.moveToFirst()) {
            do {
                val rock = Rock()
                rock.name = result.getString(result.getColumnIndex(COL_NAMEROCK))
                rock.color = result.getString(result.getColumnIndex(COL_COLORROCK))
                rock.composition1 = result.getString(result.getColumnIndex(COL_FIRST))
                rock.composition2 = result.getString(result.getColumnIndex(COL_SECOND))
                rock.composition3 = result.getString(result.getColumnIndex(COL_THIRD))
                rock.hardness = result.getString(result.getColumnIndex(COL_HARDNESSROCK)).toDouble()
                rock.texture = result.getString(result.getColumnIndex(COL_TEXTURE))
                list.add(rock)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readRocksForComp1Comp2Comp3TextureAndHardness(comp1: String, comp2: String, comp3: String, texture: String, hardness: String) : MutableList<Rock> {
        val list: MutableList<Rock> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $ROCK_TABLE where $COL_FIRST and $COL_SECOND=? and $COL_THIRD=? and $COL_TEXTURE=? and $COL_HARDNESSROCK=?"
        val result = db.rawQuery(query, arrayOf(comp1, comp2, comp3, texture, hardness))
        if (result.moveToFirst()) {
            do {
                val rock = Rock()
                rock.name = result.getString(result.getColumnIndex(COL_NAMEROCK))
                rock.color = result.getString(result.getColumnIndex(COL_COLORROCK))
                rock.composition1 = result.getString(result.getColumnIndex(COL_FIRST))
                rock.composition2 = result.getString(result.getColumnIndex(COL_SECOND))
                rock.composition3 = result.getString(result.getColumnIndex(COL_THIRD))
                rock.hardness = result.getString(result.getColumnIndex(COL_HARDNESSROCK)).toDouble()
                rock.texture = result.getString(result.getColumnIndex(COL_TEXTURE))
                list.add(rock)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readRocksForColorComp1Comp3TextureAndHardness(color: String, comp1: String, comp3: String, texture: String, hardness: String) : MutableList<Rock> {
        val list: MutableList<Rock> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $ROCK_TABLE where $COL_COLORROCK and $COL_FIRST=? and $COL_THIRD=? and $COL_TEXTURE=? and $COL_HARDNESSROCK=?"
        val result = db.rawQuery(query, arrayOf(color, comp1, comp3, texture, hardness))
        if (result.moveToFirst()) {
            do {
                val rock = Rock()
                rock.name = result.getString(result.getColumnIndex(COL_NAMEROCK))
                rock.color = result.getString(result.getColumnIndex(COL_COLORROCK))
                rock.composition1 = result.getString(result.getColumnIndex(COL_FIRST))
                rock.composition2 = result.getString(result.getColumnIndex(COL_SECOND))
                rock.composition3 = result.getString(result.getColumnIndex(COL_THIRD))
                rock.hardness = result.getString(result.getColumnIndex(COL_HARDNESSROCK)).toDouble()
                rock.texture = result.getString(result.getColumnIndex(COL_TEXTURE))
                list.add(rock)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readRocksForColorComp1Comp2Comp3HardnessAndTexture(color: String, comp1: String, comp2: String, comp3: String, hardness: String, texture: String) : MutableList<Rock> {
        val list: MutableList<Rock> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $ROCK_TABLE where $COL_COLORROCK=? and $COL_FIRST=? and $COL_SECOND=? and $COL_THIRD=? and $COL_HARDNESSROCK=? and $COL_TEXTURE=?"
        val result = db.rawQuery(query, arrayOf(color, comp1, comp2, comp3, hardness, texture))
        if (result.moveToFirst()) {
            do {
                val rock = Rock()
                rock.name = result.getString(result.getColumnIndex(COL_NAME))
                rock.color = result.getString(result.getColumnIndex(COL_COLORROCK))
                rock.composition1 = result.getString(result.getColumnIndex(COL_FIRST))
                rock.composition2 = result.getString(result.getColumnIndex(COL_SECOND))
                rock.composition3 = result.getString(result.getColumnIndex(COL_THIRD))
                rock.hardness = result.getString(result.getColumnIndex(COL_HARDNESSROCK)).toDouble()
                rock.texture = result.getString(result.getColumnIndex(COL_TEXTURE))
                list.add(rock)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }

    //mineral searches
    fun readMinerals() : MutableList<Mineral> {
        val list: MutableList<Mineral> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $TABLE_MINERALS"
        val result = db.rawQuery(query, null)
        if (result.moveToFirst()) {
            do {
                val mineral = Mineral()
                mineral.name = result.getString(result.getColumnIndex(COL_NAME))
                mineral.color = result.getString(result.getColumnIndex(COL_COLOR))
                mineral.streak = result.getString(result.getColumnIndex(COL_STREAK))
                mineral.luster = result.getString(result.getColumnIndex(COL_LUSTER))
                mineral.hardness = result.getString(result.getColumnIndex(COL_HARDNESS)).toDouble()
                mineral.cleavage = result.getString(result.getColumnIndex(COL_CLEAVAGE))
                mineral.density = result.getString(result.getColumnIndex(COL_DENSITY)).toDouble()
                mineral.description = result.getString(result.getColumnIndex(COL_DESCRIPTION))
                mineral.fracture = result.getString(result.getColumnIndex(COL_FRACTURE))
                list.add(mineral)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readMineralsForColor(color: String) : MutableList<Mineral> {
        val list: MutableList<Mineral> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $TABLE_MINERALS where $COL_COLOR=?"
        val result = db.rawQuery(query, arrayOf(color))
        if (result.moveToFirst()) {
            do {
                val mineral = Mineral()
                mineral.name = result.getString(result.getColumnIndex(COL_NAME))
                mineral.color = result.getString(result.getColumnIndex(COL_COLOR))
                mineral.streak = result.getString(result.getColumnIndex(COL_STREAK))
                mineral.luster = result.getString(result.getColumnIndex(COL_LUSTER))
                mineral.hardness = result.getString(result.getColumnIndex(COL_HARDNESS)).toDouble()
                mineral.cleavage = result.getString(result.getColumnIndex(COL_CLEAVAGE))
                mineral.density = result.getString(result.getColumnIndex(COL_DENSITY)).toDouble()
                mineral.description = result.getString(result.getColumnIndex(COL_DESCRIPTION))
                mineral.fracture = result.getString(result.getColumnIndex(COL_FRACTURE))
                list.add(mineral)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readMineralsForLuster(luster: String) : MutableList<Mineral> {
        val list: MutableList<Mineral> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $TABLE_MINERALS where $COL_LUSTER=?"
        val result = db.rawQuery(query, arrayOf(luster))
        if (result.moveToFirst()) {
            do {
                val mineral = Mineral()
                mineral.name = result.getString(result.getColumnIndex(COL_NAME))
                mineral.color = result.getString(result.getColumnIndex(COL_COLOR))
                mineral.streak = result.getString(result.getColumnIndex(COL_STREAK))
                mineral.luster = result.getString(result.getColumnIndex(COL_LUSTER))
                mineral.hardness = result.getString(result.getColumnIndex(COL_HARDNESS)).toDouble()
                mineral.cleavage = result.getString(result.getColumnIndex(COL_CLEAVAGE))
                mineral.density = result.getString(result.getColumnIndex(COL_DENSITY)).toDouble()
                mineral.description = result.getString(result.getColumnIndex(COL_DESCRIPTION))
                mineral.fracture = result.getString(result.getColumnIndex(COL_FRACTURE))
                list.add(mineral)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readMineralsForStreak(streak: String) : MutableList<Mineral> {
        val list: MutableList<Mineral> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $TABLE_MINERALS where $COL_STREAK=?"
        val result = db.rawQuery(query, arrayOf(streak))
        if (result.moveToFirst()) {
            do {
                val mineral = Mineral()
                mineral.name = result.getString(result.getColumnIndex(COL_NAME))
                mineral.color = result.getString(result.getColumnIndex(COL_COLOR))
                mineral.streak = result.getString(result.getColumnIndex(COL_STREAK))
                mineral.luster = result.getString(result.getColumnIndex(COL_LUSTER))
                mineral.hardness = result.getString(result.getColumnIndex(COL_HARDNESS)).toDouble()
                mineral.cleavage = result.getString(result.getColumnIndex(COL_CLEAVAGE))
                mineral.density = result.getString(result.getColumnIndex(COL_DENSITY)).toDouble()
                mineral.description = result.getString(result.getColumnIndex(COL_DESCRIPTION))
                list.add(mineral)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readMineralsForHardness(hardness: String) : MutableList<Mineral> {
        val list: MutableList<Mineral> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $TABLE_MINERALS where $COL_HARDNESS=?"
        val result = db.rawQuery(query, arrayOf(hardness))
        if (result.moveToFirst()) {
            do {
                val mineral = Mineral()
                mineral.name = result.getString(result.getColumnIndex(COL_NAME))
                mineral.color = result.getString(result.getColumnIndex(COL_COLOR))
                mineral.streak = result.getString(result.getColumnIndex(COL_STREAK))
                mineral.luster = result.getString(result.getColumnIndex(COL_LUSTER))
                mineral.hardness = result.getString(result.getColumnIndex(COL_HARDNESS)).toDouble()
                mineral.cleavage = result.getString(result.getColumnIndex(COL_CLEAVAGE))
                mineral.density = result.getString(result.getColumnIndex(COL_DENSITY)).toDouble()
                mineral.description = result.getString(result.getColumnIndex(COL_DESCRIPTION))
                mineral.fracture = result.getString(result.getColumnIndex(COL_FRACTURE))
                list.add(mineral)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readMineralsForCleavage(cleavage: String) : MutableList<Mineral> {
        val list: MutableList<Mineral> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $TABLE_MINERALS where $COL_CLEAVAGE=?"
        val result = db.rawQuery(query, arrayOf(cleavage))
        if (result.moveToFirst()) {
            do {
                val mineral = Mineral()
                mineral.name = result.getString(result.getColumnIndex(COL_NAME))
                mineral.color = result.getString(result.getColumnIndex(COL_COLOR))
                mineral.streak = result.getString(result.getColumnIndex(COL_STREAK))
                mineral.luster = result.getString(result.getColumnIndex(COL_LUSTER))
                mineral.hardness = result.getString(result.getColumnIndex(COL_HARDNESS)).toDouble()
                mineral.cleavage = result.getString(result.getColumnIndex(COL_CLEAVAGE))
                mineral.density = result.getString(result.getColumnIndex(COL_DENSITY)).toDouble()
                mineral.description = result.getString(result.getColumnIndex(COL_DESCRIPTION))
                list.add(mineral)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readMineralsForDensity(density: String) : MutableList<Mineral> {
        val list: MutableList<Mineral> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $TABLE_MINERALS where $COL_DENSITY=?"
        val result = db.rawQuery(query, arrayOf(density))
        if (result.moveToFirst()) {
            do {
                val mineral = Mineral()
                mineral.name = result.getString(result.getColumnIndex(COL_NAME))
                mineral.color = result.getString(result.getColumnIndex(COL_COLOR))
                mineral.streak = result.getString(result.getColumnIndex(COL_STREAK))
                mineral.luster = result.getString(result.getColumnIndex(COL_LUSTER))
                mineral.hardness = result.getString(result.getColumnIndex(COL_HARDNESS)).toDouble()
                mineral.cleavage = result.getString(result.getColumnIndex(COL_CLEAVAGE))
                mineral.density = result.getString(result.getColumnIndex(COL_DENSITY)).toDouble()
                mineral.description = result.getString(result.getColumnIndex(COL_DESCRIPTION))
                mineral.fracture = result.getString(result.getColumnIndex(COL_FRACTURE))
                list.add(mineral)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readMineralsForFracture(fracture: String) : MutableList<Mineral> {
        val list: MutableList<Mineral> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $TABLE_MINERALS where $COL_FRACTURE=?"
        val result = db.rawQuery(query, arrayOf(fracture))
        if (result.moveToFirst()) {
            do {
                val mineral = Mineral()
                mineral.name = result.getString(result.getColumnIndex(COL_NAME))
                mineral.color = result.getString(result.getColumnIndex(COL_COLOR))
                mineral.streak = result.getString(result.getColumnIndex(COL_STREAK))
                mineral.luster = result.getString(result.getColumnIndex(COL_LUSTER))
                mineral.hardness = result.getString(result.getColumnIndex(COL_HARDNESS)).toDouble()
                mineral.cleavage = result.getString(result.getColumnIndex(COL_CLEAVAGE))
                mineral.density = result.getString(result.getColumnIndex(COL_DENSITY)).toDouble()
                mineral.description = result.getString(result.getColumnIndex(COL_DESCRIPTION))
                mineral.fracture = result.getString(result.getColumnIndex(COL_FRACTURE))
                list.add(mineral)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }

    fun readMineralsForColorAndLuster(color: String, luster: String) : MutableList<Mineral> {
        val list: MutableList<Mineral> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $TABLE_MINERALS where $COL_COLOR=? and $COL_LUSTER=?"
        val result = db.rawQuery(query, arrayOf(color, luster))
        if (result.moveToFirst()) {
            do {
                val mineral = Mineral()
                mineral.name = result.getString(result.getColumnIndex(COL_NAME))
                mineral.color = result.getString(result.getColumnIndex(COL_COLOR))
                mineral.streak = result.getString(result.getColumnIndex(COL_STREAK))
                mineral.luster = result.getString(result.getColumnIndex(COL_LUSTER))
                mineral.hardness = result.getString(result.getColumnIndex(COL_HARDNESS)).toDouble()
                mineral.cleavage = result.getString(result.getColumnIndex(COL_CLEAVAGE))
                mineral.density = result.getString(result.getColumnIndex(COL_DENSITY)).toDouble()
                mineral.description = result.getString(result.getColumnIndex(COL_DESCRIPTION))
                mineral.fracture = result.getString(result.getColumnIndex(COL_FRACTURE))
                list.add(mineral)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readMineralsForStreakAndCleavage(streak: String, cleavage: String) : MutableList<Mineral> {
        val list: MutableList<Mineral> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $TABLE_MINERALS where $COL_STREAK=? and $COL_CLEAVAGE=?"
        val result = db.rawQuery(query, arrayOf(streak, cleavage))
        if (result.moveToFirst()) {
            do {
                val mineral = Mineral()
                mineral.name = result.getString(result.getColumnIndex(COL_NAME))
                mineral.color = result.getString(result.getColumnIndex(COL_COLOR))
                mineral.streak = result.getString(result.getColumnIndex(COL_STREAK))
                mineral.luster = result.getString(result.getColumnIndex(COL_LUSTER))
                mineral.hardness = result.getString(result.getColumnIndex(COL_HARDNESS)).toDouble()
                mineral.cleavage = result.getString(result.getColumnIndex(COL_CLEAVAGE))
                mineral.density = result.getString(result.getColumnIndex(COL_DENSITY)).toDouble()
                mineral.description = result.getString(result.getColumnIndex(COL_DESCRIPTION))
                mineral.fracture = result.getString(result.getColumnIndex(COL_FRACTURE))
                list.add(mineral)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readMineralsForLusterAndHardness(luster: String, hardness: String) : MutableList<Mineral> {
        val list: MutableList<Mineral> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $TABLE_MINERALS where $COL_LUSTER=? and $COL_HARDNESS=?"
        val result = db.rawQuery(query, arrayOf(luster, hardness))
        if (result.moveToFirst()) {
            do {
                val mineral = Mineral()
                mineral.name = result.getString(result.getColumnIndex(COL_NAME))
                mineral.color = result.getString(result.getColumnIndex(COL_COLOR))
                mineral.streak = result.getString(result.getColumnIndex(COL_STREAK))
                mineral.luster = result.getString(result.getColumnIndex(COL_LUSTER))
                mineral.hardness = result.getString(result.getColumnIndex(COL_HARDNESS)).toDouble()
                mineral.cleavage = result.getString(result.getColumnIndex(COL_CLEAVAGE))
                mineral.density = result.getString(result.getColumnIndex(COL_DENSITY)).toDouble()
                mineral.description = result.getString(result.getColumnIndex(COL_DESCRIPTION))
                mineral.fracture = result.getString(result.getColumnIndex(COL_FRACTURE))
                list.add(mineral)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readMineralsForCleavageAndLuster(cleavage: String, luster: String) : MutableList<Mineral> {
        val list: MutableList<Mineral> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $TABLE_MINERALS where $COL_CLEAVAGE=? and $COL_LUSTER=?"
        val result = db.rawQuery(query, arrayOf(cleavage, luster))
        if (result.moveToFirst()) {
            do {
                val mineral = Mineral()
                mineral.name = result.getString(result.getColumnIndex(COL_NAME))
                mineral.color = result.getString(result.getColumnIndex(COL_COLOR))
                mineral.streak = result.getString(result.getColumnIndex(COL_STREAK))
                mineral.luster = result.getString(result.getColumnIndex(COL_LUSTER))
                mineral.hardness = result.getString(result.getColumnIndex(COL_HARDNESS)).toDouble()
                mineral.cleavage = result.getString(result.getColumnIndex(COL_CLEAVAGE))
                mineral.density = result.getString(result.getColumnIndex(COL_DENSITY)).toDouble()
                mineral.description = result.getString(result.getColumnIndex(COL_DESCRIPTION))
                mineral.fracture = result.getString(result.getColumnIndex(COL_FRACTURE))
                list.add(mineral)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readMineralsForColorAndHardness(color: String, hardness: String) : MutableList<Mineral> {
        val list: MutableList<Mineral> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $TABLE_MINERALS where $COL_COLOR=? and $COL_HARDNESS=?"
        val result = db.rawQuery(query, arrayOf(color, hardness))
        if (result.moveToFirst()) {
            do {
                val mineral = Mineral()
                mineral.name = result.getString(result.getColumnIndex(COL_NAME))
                mineral.color = result.getString(result.getColumnIndex(COL_COLOR))
                mineral.streak = result.getString(result.getColumnIndex(COL_STREAK))
                mineral.luster = result.getString(result.getColumnIndex(COL_LUSTER))
                mineral.hardness = result.getString(result.getColumnIndex(COL_HARDNESS)).toDouble()
                mineral.cleavage = result.getString(result.getColumnIndex(COL_CLEAVAGE))
                mineral.density = result.getString(result.getColumnIndex(COL_DENSITY)).toDouble()
                mineral.description = result.getString(result.getColumnIndex(COL_DESCRIPTION))
                mineral.fracture = result.getString(result.getColumnIndex(COL_FRACTURE))
                list.add(mineral)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readMineralsForColorAndStreak(color: String, streak: String) : MutableList<Mineral> {
        val list: MutableList<Mineral> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $TABLE_MINERALS where $COL_COLOR=? and $COL_STREAK=?"
        val result = db.rawQuery(query, arrayOf(color, streak))
        if (result.moveToFirst()) {
            do {
                val mineral = Mineral()
                mineral.name = result.getString(result.getColumnIndex(COL_NAME))
                mineral.color = result.getString(result.getColumnIndex(COL_COLOR))
                mineral.streak = result.getString(result.getColumnIndex(COL_STREAK))
                mineral.luster = result.getString(result.getColumnIndex(COL_LUSTER))
                mineral.hardness = result.getString(result.getColumnIndex(COL_HARDNESS)).toDouble()
                mineral.cleavage = result.getString(result.getColumnIndex(COL_CLEAVAGE))
                mineral.density = result.getString(result.getColumnIndex(COL_DENSITY)).toDouble()
                mineral.description = result.getString(result.getColumnIndex(COL_DESCRIPTION))
                mineral.fracture = result.getString(result.getColumnIndex(COL_FRACTURE))
                list.add(mineral)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readMineralsForColorAndCleavage(color: String, cleavage: String) : MutableList<Mineral> {
        val list: MutableList<Mineral> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $TABLE_MINERALS where $COL_COLOR=? and $COL_CLEAVAGE=?"
        val result = db.rawQuery(query, arrayOf(color, cleavage))
        if (result.moveToFirst()) {
            do {
                val mineral = Mineral()
                mineral.name = result.getString(result.getColumnIndex(COL_NAME))
                mineral.color = result.getString(result.getColumnIndex(COL_COLOR))
                mineral.streak = result.getString(result.getColumnIndex(COL_STREAK))
                mineral.luster = result.getString(result.getColumnIndex(COL_LUSTER))
                mineral.hardness = result.getString(result.getColumnIndex(COL_HARDNESS)).toDouble()
                mineral.cleavage = result.getString(result.getColumnIndex(COL_CLEAVAGE))
                mineral.density = result.getString(result.getColumnIndex(COL_DENSITY)).toDouble()
                mineral.description = result.getString(result.getColumnIndex(COL_DESCRIPTION))
                mineral.fracture = result.getString(result.getColumnIndex(COL_FRACTURE))
                list.add(mineral)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readMineralsForCleavageAndHardness(cleavage: String, hardness: String) : MutableList<Mineral> {
        val list: MutableList<Mineral> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $TABLE_MINERALS where $COL_CLEAVAGE=? and $COL_HARDNESS=?"
        val result = db.rawQuery(query, arrayOf(cleavage, hardness))
        if (result.moveToFirst()) {
            do {
                val mineral = Mineral()
                mineral.name = result.getString(result.getColumnIndex(COL_NAME))
                mineral.color = result.getString(result.getColumnIndex(COL_COLOR))
                mineral.streak = result.getString(result.getColumnIndex(COL_STREAK))
                mineral.luster = result.getString(result.getColumnIndex(COL_LUSTER))
                mineral.hardness = result.getString(result.getColumnIndex(COL_HARDNESS)).toDouble()
                mineral.cleavage = result.getString(result.getColumnIndex(COL_CLEAVAGE))
                mineral.density = result.getString(result.getColumnIndex(COL_DENSITY)).toDouble()
                mineral.description = result.getString(result.getColumnIndex(COL_DESCRIPTION))
                mineral.fracture = result.getString(result.getColumnIndex(COL_FRACTURE))
                list.add(mineral)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }

    fun readMineralsForStreakAndHardness(streak: String, hardness: String) : MutableList<Mineral> {
        val list: MutableList<Mineral> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $TABLE_MINERALS where $COL_STREAK=? and $COL_HARDNESS=?"
        val result = db.rawQuery(query, arrayOf(streak, hardness))
        if (result.moveToFirst()) {
            do {
                val mineral = Mineral()
                mineral.name = result.getString(result.getColumnIndex(COL_NAME))
                mineral.color = result.getString(result.getColumnIndex(COL_COLOR))
                mineral.streak = result.getString(result.getColumnIndex(COL_STREAK))
                mineral.luster = result.getString(result.getColumnIndex(COL_LUSTER))
                mineral.hardness = result.getString(result.getColumnIndex(COL_HARDNESS)).toDouble()
                mineral.cleavage = result.getString(result.getColumnIndex(COL_CLEAVAGE))
                mineral.density = result.getString(result.getColumnIndex(COL_DENSITY)).toDouble()
                mineral.description = result.getString(result.getColumnIndex(COL_DESCRIPTION))
                mineral.fracture = result.getString(result.getColumnIndex(COL_FRACTURE))
                list.add(mineral)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readMineralsForColorLusterAndStreak(color: String, luster: String, streak: String) : MutableList<Mineral> {
        val list: MutableList<Mineral> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $TABLE_MINERALS where $COL_COLOR=? and $COL_LUSTER=? and $COL_STREAK=?"
        val result = db.rawQuery(query, arrayOf(color, luster, streak))
        if (result.moveToFirst()) {
            do {
                val mineral = Mineral()
                mineral.name = result.getString(result.getColumnIndex(COL_NAME))
                mineral.color = result.getString(result.getColumnIndex(COL_COLOR))
                mineral.streak = result.getString(result.getColumnIndex(COL_STREAK))
                mineral.luster = result.getString(result.getColumnIndex(COL_LUSTER))
                mineral.hardness = result.getString(result.getColumnIndex(COL_HARDNESS)).toDouble()
                mineral.cleavage = result.getString(result.getColumnIndex(COL_CLEAVAGE))
                mineral.density = result.getString(result.getColumnIndex(COL_DENSITY)).toDouble()
                mineral.description = result.getString(result.getColumnIndex(COL_DESCRIPTION))
                mineral.fracture = result.getString(result.getColumnIndex(COL_FRACTURE))
                list.add(mineral)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readMineralsForColorStreakAndHardness(color: String, streak: String, hardness: String) : MutableList<Mineral> {
        val list: MutableList<Mineral> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $TABLE_MINERALS where $COL_COLOR=? and $COL_STREAK=? and $COL_HARDNESS=?"
        val result = db.rawQuery(query, arrayOf(color, streak, hardness))
        if (result.moveToFirst()) {
            do {
                val mineral = Mineral()
                mineral.name = result.getString(result.getColumnIndex(COL_NAME))
                mineral.color = result.getString(result.getColumnIndex(COL_COLOR))
                mineral.streak = result.getString(result.getColumnIndex(COL_STREAK))
                mineral.luster = result.getString(result.getColumnIndex(COL_LUSTER))
                mineral.hardness = result.getString(result.getColumnIndex(COL_HARDNESS)).toDouble()
                mineral.cleavage = result.getString(result.getColumnIndex(COL_CLEAVAGE))
                mineral.density = result.getString(result.getColumnIndex(COL_DENSITY)).toDouble()
                mineral.description = result.getString(result.getColumnIndex(COL_DESCRIPTION))
                mineral.fracture = result.getString(result.getColumnIndex(COL_FRACTURE))
                list.add(mineral)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readMineralsForColorStreakAndCleavage(color: String, streak: String, cleavage: String) : MutableList<Mineral> {
        val list: MutableList<Mineral> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $TABLE_MINERALS where $COL_COLOR=? and $COL_STREAK=? and $COL_CLEAVAGE=?"
        val result = db.rawQuery(query, arrayOf(color, streak, cleavage))
        if (result.moveToFirst()) {
            do {
                val mineral = Mineral()
                mineral.name = result.getString(result.getColumnIndex(COL_NAME))
                mineral.color = result.getString(result.getColumnIndex(COL_COLOR))
                mineral.streak = result.getString(result.getColumnIndex(COL_STREAK))
                mineral.luster = result.getString(result.getColumnIndex(COL_LUSTER))
                mineral.hardness = result.getString(result.getColumnIndex(COL_HARDNESS)).toDouble()
                mineral.cleavage = result.getString(result.getColumnIndex(COL_CLEAVAGE))
                mineral.density = result.getString(result.getColumnIndex(COL_DENSITY)).toDouble()
                mineral.description = result.getString(result.getColumnIndex(COL_DESCRIPTION))
                mineral.fracture = result.getString(result.getColumnIndex(COL_FRACTURE))
                list.add(mineral)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }

    fun readMineralsForColorLusterAndHardness(color: String, luster: String, streak: String, hardness: String) : MutableList<Mineral> {
        val list: MutableList<Mineral> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $TABLE_MINERALS where $COL_COLOR=? and $COL_LUSTER=? and $COL_STREAK=? and $COL_HARDNESS=?"
        val result = db.rawQuery(query, arrayOf(color, luster, streak, hardness))
        if (result.moveToFirst()) {
            do {
                val mineral = Mineral()
                mineral.name = result.getString(result.getColumnIndex(COL_NAME))
                mineral.color = result.getString(result.getColumnIndex(COL_COLOR))
                mineral.streak = result.getString(result.getColumnIndex(COL_STREAK))
                mineral.luster = result.getString(result.getColumnIndex(COL_LUSTER))
                mineral.hardness = result.getString(result.getColumnIndex(COL_HARDNESS)).toDouble()
                mineral.cleavage = result.getString(result.getColumnIndex(COL_CLEAVAGE))
                mineral.density = result.getString(result.getColumnIndex(COL_DENSITY)).toDouble()
                mineral.description = result.getString(result.getColumnIndex(COL_DESCRIPTION))
                mineral.fracture = result.getString(result.getColumnIndex(COL_FRACTURE))
                list.add(mineral)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }

    fun readMineralsForColorLusterHardnessAndCleavage(color: String, luster: String, streak: String, hardness: String, cleavage: String) : MutableList<Mineral> {
        val list: MutableList<Mineral> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $TABLE_MINERALS where $COL_COLOR=? and $COL_LUSTER=? and $COL_STREAK=? and $COL_HARDNESS=? and $COL_CLEAVAGE=?"
        val result = db.rawQuery(query, arrayOf(color, luster, streak, hardness, cleavage))
        if (result.moveToFirst()) {
            do {
                val mineral = Mineral()
                mineral.name = result.getString(result.getColumnIndex(COL_NAME))
                mineral.color = result.getString(result.getColumnIndex(COL_COLOR))
                mineral.streak = result.getString(result.getColumnIndex(COL_STREAK))
                mineral.luster = result.getString(result.getColumnIndex(COL_LUSTER))
                mineral.hardness = result.getString(result.getColumnIndex(COL_HARDNESS)).toDouble()
                mineral.cleavage = result.getString(result.getColumnIndex(COL_CLEAVAGE))
                mineral.density = result.getString(result.getColumnIndex(COL_DENSITY)).toDouble()
                mineral.description = result.getString(result.getColumnIndex(COL_DESCRIPTION))
                mineral.fracture = result.getString(result.getColumnIndex(COL_FRACTURE))
                list.add(mineral)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }

    fun readMineralsForColorLusterHardnessCleavageAndFracture(color: String, luster: String, streak: String, hardness: String, cleavage: String) : MutableList<Mineral> {
        val list: MutableList<Mineral> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $TABLE_MINERALS where $COL_COLOR=? and $COL_LUSTER=? and $COL_STREAK=? and $COL_HARDNESS=? and $COL_CLEAVAGE=?"
        val result = db.rawQuery(query, arrayOf(color, luster, streak, hardness, cleavage))
        if (result.moveToFirst()) {
            do {
                val mineral = Mineral()
                mineral.name = result.getString(result.getColumnIndex(COL_NAME))
                mineral.color = result.getString(result.getColumnIndex(COL_COLOR))
                mineral.streak = result.getString(result.getColumnIndex(COL_STREAK))
                mineral.luster = result.getString(result.getColumnIndex(COL_LUSTER))
                mineral.hardness = result.getString(result.getColumnIndex(COL_HARDNESS)).toDouble()
                mineral.cleavage = result.getString(result.getColumnIndex(COL_CLEAVAGE))
                mineral.density = result.getString(result.getColumnIndex(COL_DENSITY)).toDouble()
                mineral.description = result.getString(result.getColumnIndex(COL_DESCRIPTION))
                mineral.fracture = result.getString(result.getColumnIndex(COL_FRACTURE))
                list.add(mineral)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readMineralsForColorStreakLusterHardnessCleavageAndDensity(color: String, streak: String, luster: String, hardness: String, cleavage: String, density: String) : MutableList<Mineral> {
        val list: MutableList<Mineral> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $TABLE_MINERALS where $COL_COLOR=? and $COL_STREAK=? and $COL_LUSTER=? and $COL_HARDNESS=? and $COL_CLEAVAGE=? and $COL_DENSITY=?"
        val result = db.rawQuery(query, arrayOf(color, streak, luster, hardness, cleavage, density))
        if (result.moveToFirst()) {
            do {
                val mineral = Mineral()
                mineral.name = result.getString(result.getColumnIndex(COL_NAME))
                mineral.color = result.getString(result.getColumnIndex(COL_COLOR))
                mineral.streak = result.getString(result.getColumnIndex(COL_STREAK))
                mineral.luster = result.getString(result.getColumnIndex(COL_LUSTER))
                mineral.hardness = result.getString(result.getColumnIndex(COL_HARDNESS)).toDouble()
                mineral.cleavage = result.getString(result.getColumnIndex(COL_CLEAVAGE))
                mineral.density = result.getString(result.getColumnIndex(COL_DENSITY)).toDouble()
                mineral.description = result.getString(result.getColumnIndex(COL_DESCRIPTION))
                mineral.fracture = result.getString(result.getColumnIndex(COL_FRACTURE))
                list.add(mineral)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }
    fun readMineralsForColorLusterHardnessCleavageFractureAndDensity(color: String, luster: String, streak: String, hardness: String, cleavage: String, density: String) : MutableList<Mineral> {
        val list: MutableList<Mineral> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $TABLE_MINERALS where $COL_COLOR=? and $COL_LUSTER=? and $COL_STREAK=? and $COL_HARDNESS=? and $COL_CLEAVAGE=? and $COL_DENSITY=?"
        val result = db.rawQuery(query, arrayOf(color, luster, streak, hardness, cleavage, density))
        if (result.moveToFirst()) {
            do {
                val mineral = Mineral()
                mineral.name = result.getString(result.getColumnIndex(COL_NAME))
                mineral.color = result.getString(result.getColumnIndex(COL_COLOR))
                mineral.streak = result.getString(result.getColumnIndex(COL_STREAK))
                mineral.luster = result.getString(result.getColumnIndex(COL_LUSTER))
                mineral.hardness = result.getString(result.getColumnIndex(COL_HARDNESS)).toDouble()
                mineral.cleavage = result.getString(result.getColumnIndex(COL_CLEAVAGE))
                mineral.density = result.getString(result.getColumnIndex(COL_DENSITY)).toDouble()
                mineral.description = result.getString(result.getColumnIndex(COL_DESCRIPTION))
                mineral.fracture = result.getString(result.getColumnIndex(COL_FRACTURE))
                list.add(mineral)
            }
            while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }

}


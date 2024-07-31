package com.example.musclex


import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

fun loadJsonFromAsset(context: Context, fileName: String): String {
    return try {
        context.assets.open(fileName).bufferedReader().use { it.readText() }
    } catch (ex: IOException) {
        ex.printStackTrace()
        ""
    }
}

fun getExercisesFromJson(context: Context, fileName: String): List<Exercise> {
    val jsonString = loadJsonFromAsset(context, fileName)
    val listType = object : TypeToken<List<Exercise>>() {}.type
    return Gson().fromJson(jsonString, listType)
}
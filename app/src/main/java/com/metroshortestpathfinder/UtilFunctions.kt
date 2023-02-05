package com.metroshortestpathfinder

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import com.metroshortestpathfinder.line.*

@SuppressLint("DiscouragedApi")
fun initiateStations(context: Context) {
    var currentId = -1
    for (i in 1..7) {
        val curLineStationNames = context.resources.getStringArray(
            context.resources.getIdentifier(
                "line$i",
                "array",
                context.packageName
            )
        )
        for (stationName in curLineStationNames)
            stationList.add(Station(++currentId, stationName, i))
    }
}

fun findIdFromName(name: String): Int? {
    return stationList.find { it.name == name }?.id
}


fun findStationFromId(id: Int): Station {
    return stationList.find { it.id == id }!!
}

//this func can be better
private fun labelIntersections() {
    //line 1
    stationList.find { it.name == "شهید بهشتی" }?.isIntersection = true
    stationList.find { it.name == "دروازه دولت" }?.isIntersection = true
    stationList.find { it.name == "امام خمینی" }?.isIntersection = true
    stationList.find { it.name == "میدان محمدیه" }?.isIntersection = true
    //line 2
    stationList.find { it.name == "امام حسین" }?.isIntersection = true
    stationList.find { it.name == "دروازه شمیران" }?.isIntersection = true
    stationList.find { it.name == "شهید نواب صفوی" }?.isIntersection = true
    stationList.find { it.name == "شادمان" }?.isIntersection = true
    stationList.find { it.name == "تهران (صادقیه)" }?.isIntersection = true
    //line 3
    stationList.find { it.name == "تیاتر شهر" }?.isIntersection = true
    stationList.find { it.name == "مهدیه" }?.isIntersection = true
    //line 4
    stationList.find { it.name == "میدان شهدا" }?.isIntersection = true
    stationList.find { it.name == "توحید" }?.isIntersection = true
    stationList.find { it.name == "ارم سبز" }?.isIntersection = true
    //line 6
    stationList.find { it.name == "دانشگاه تربیت مدرس" }?.isIntersection = true
}
package com.metroshortestpathfinder

import android.util.Log

class Result(idList: MutableList<Int>) {
    private var resMessage = "شروع از ایستگاه "

    init {
        for (i in idList.indices) {
            if (findStationFromId(idList[i])?.isIntersection!!) {
                try {
                    resMessage += findStationFromId(idList[i])?.name
                    resMessage += " به سمت " + getDirection(idList[i], idList[i + 1]) + " سپس "
                    continue
                } catch (_: IndexOutOfBoundsException) {
                }
            }
            resMessage += " " + findStationFromId(idList[i])?.name + " سپس \n"
        }
    }

    fun printOutPut() {
        Log.d("output", resMessage)
    }
}
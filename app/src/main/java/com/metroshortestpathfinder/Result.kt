//package com.metroshortestpathfinder
//
//import android.util.Log
//
//class Result(idList: MutableList<Int>) {
//    private val resList = mutableListOf<String>()
//    private var resMessage = "حرکت از ایستگاه "
//
//    init {
//        resList.add("حرکت از ایستگاه ")
//        for (i in idList.indices) {
//            if (findStationFromId(idList[i]).isIntersection) {
//                try {
//                    if (resList.contains(getDirection(idList[i], idList[i + 1])) ) {
//                        resList.add(findStationFromId(idList[i]).name)
//                        continue
//                    }
//                    resList.add(findStationFromId(idList[i]).name)
//                    resList.add(" به سمت ")
//                    resList.add(getDirection(idList[i], idList[i + 1]))
//                    continue
//                } catch (_: IndexOutOfBoundsException) {
//                }
//            }
//            resList.add(findStationFromId(idList[i]).name)
//        }
//    }
//
//    fun printOutPut() {
//        Log.d("output", resList.toString())
//    }
//}
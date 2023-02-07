package com.metroshortestpathfinder

fun MutableList<String>.myAdd(input: String): Boolean {
    return if (this.contains(input) && input == " به سمت ") {
        this.add(input)
        true
    } else if (!this.contains(input)) {
        this.add(input)
        true
    } else
        false
}

fun MutableList<Int>.toMySet() {
    try {
        for (index in this.indices) {
            for (i in index + 1 until this.size) {
                if (findStationNameFromId(this[i]) == findStationNameFromId(this[index]))
                    this.removeAt(i)
            }
        }
    } catch (_: java.lang.IndexOutOfBoundsException) {
    }
}
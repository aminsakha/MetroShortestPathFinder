package com.metroshortestpathfinder


fun getDirection(currId: Int, nextId: Int): String {
    when (findStationFromId(currId)?.name) {
        "شهید بهشتی" -> {
            when (findStationFromId(nextId)?.name) {
                "سهروردی" -> return "قایم"
                "شهید مفتح" -> return "کهریزک"
                "میرزای شیرازی" -> return "قایم"
                "مصلی امام خمینی" -> return "تجریش"
            }
        }
        "دروازه دولت" -> {
            when (findStationFromId(nextId)?.name) {
                "دروازه شمیران" -> return "شهید کلاهدوز"
                "سعدی" -> return "کهریزک"
                "فردوسی" -> return "ارم سبز"
                "طالقانی" -> return "تجریش"
            }
        }
        "امام خمینی" -> {
            when (findStationFromId(nextId)?.name) {
                "ملت" -> return "فرهنگسرا"
                "پانزده خرداد" -> return "کهریزک"
                "حسن آباد" -> return "تهران صادقیه"
                "سعدی" -> return "تجریش"
            }
        }
        "میدان محمدیه" -> {
            when (findStationFromId(nextId)?.name) {
                "مهدیه" -> return "میدان صنعت"
                "مولوی" -> return "بسیج"
                "شوش" -> return "ارم سبز"
                "خیام" -> return "تجریش"
            }
        }
        "امام حسین" -> {
            when (findStationFromId(nextId)?.name) {
                "میدان شهدا" -> return "دولت آباد"
                "دروازه شمیران" -> return "ارم سبز"
                "شهید مدنی" -> return "فرهنگسرا"
                "دانشگاه تربیت مدرس" -> return "تجریش"
            }
        }
        "دروازه شمیران" -> {
            when (findStationFromId(nextId)?.name) {
                "دروازه دولت" -> return "ارم سبز"
                "بهارستان" -> return "تهران (صادقیه)"
                "امام حسین" -> return "فرهنگسرا"
                "میدان شهدا" -> return "شهید کلاهدوز"
            }
        }
        "شهید نواب صفوی" -> {
            when (findStationFromId(nextId)?.name) {
                "شادمان" -> return "تهران (صادقیه)"
                "میدان حر" -> return "فرهنگسرا"
                "رودکی" -> return "بسیج"
                "توحید" -> return "میدان صنعت"
            }
        }
        "شادمان" -> {
            when (findStationFromId(nextId)?.name) {
                "دانشگاه شریف" -> return "تهران (صادقیه)"
                "شهید نواب صفوی" -> return "فرهنگسرا"
                "دکتر حبیب الله" -> return "ارم سبز"
                "توحید" -> return "شهید کلاهدوز"
            }
        }
        "تهران (صادقیه)" -> {
            when (findStationFromId(nextId)?.name) {
                "ارم سبز" -> return "شهید سپهبد قاسم سلیمانی"
                "طرشت" -> return "فرهنگسرا"
            }
        }
        "تیاتر شهر" -> {
            when (findStationFromId(nextId)?.name) {
                "منیریه" -> return "آزادگان"
                "میدان انقلاب" -> return "ارم سبز"
                "فردوسی" -> return "شهید کلاهدوز"
            }
        }
        "مهدیه" -> {
            when (findStationFromId(nextId)?.name) {
                "هلال احمر" -> return "میدان صنعت"
                "میدان محمدیه" -> return "بسیج"
                "راه آهن" -> return "آزادگان"
                "منیریه" -> return "قایم"
            }
        }
        "میدان شهدا" -> {
            when (findStationFromId(nextId)?.name) {
                "امیرکبیر" -> return "دولت آباد"
                "امام حسین" -> return "شهید ستاری"
                "دروازه شمیران" -> return "ارم سبز"
                "ابن سینا" -> return "شهید کلاهدوز"
            }
        }
        "توحید" -> {
            when (findStationFromId(nextId)?.name) {
                "مدافعان سلامت" -> return "میدان صنعت"
                "شهید نواب صفوی" -> return "بسیج"
                "شادمان" -> return "ارم سبز"
                "میدانقلاب" -> return "شهید کلاهدوز"
            }
        }
        "ارم سبز" -> {
            when (findStationFromId(nextId)?.name) {
                "ورزشگاه آزادی" -> return "شهید سپهبد قاسم سلیمانی"
                "تهران صادقیه" -> return "فرهنگسرا"
                "شهرک اکباتان" -> return "شهید کلاهدوز"
            }
        }
        "دانشگاه تربیت مدرس" -> {
            when (findStationFromId(nextId)?.name) {
                "شهرک آزمایش" -> return "شهید ستاری"
                "مدافعان سلامت" -> return "بسیج"
                "بوستان گفتگو" -> return "میدان صنعت"
                "امام حسین" -> return "دولت آباد"
            }
        }
    }
    return "null"
}
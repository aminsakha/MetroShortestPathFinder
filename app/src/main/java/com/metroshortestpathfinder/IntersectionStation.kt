package com.metroshortestpathfinder


fun getDirection(currId: Int, nextId: Int): String {
    when (findStationNameFromId(currId)) {
        "شهید بهشتی" -> {
            when (findStationNameFromId(nextId)) {
                "سهروردی" -> return "قایم"
                "شهید مفتح" -> return "کهریزک"
                "میرزای شیرازی" -> return "آزادگان"
                "مصلی امام خمینی" -> return "تجریش"
            }
        }
        "دروازه دولت" -> {
            when (findStationNameFromId(nextId)) {
                "دروازه شمیران" -> return "شهید کلاهدوز"
                "سعدی" -> return "کهریزک"
                "فردوسی" -> return "ارم سبز"
                "طالقانی" -> return "تجریش"
            }
        }
        "امام خمینی" -> {
            when (findStationNameFromId(nextId)) {
                "ملت" -> return "فرهنگسرا"
                "پانزده خرداد" -> return "کهریزک"
                "حسن آباد" -> return "تهران (صادقیه)"
                "سعدی" -> return "تجریش"
            }
        }
        "میدان محمدیه" -> {
            when (findStationNameFromId(nextId)) {
                "مهدیه" -> return "میدان صنعت"
                "مولوی" -> return "بسیج"
                "شوش" -> return "کهریزک"
                "خیام" -> return "تجریش"
            }
        }
        "امام حسین" -> {
            when (findStationNameFromId(nextId)) {
                "میدان شهدا" -> return "دولت آباد"
                "دروازه شمیران" -> return "تهران (صادقیه)"
                "شهید مدنی" -> return "فرهنگسرا"
                "دانشگاه تربیت مدرس" -> return "شهید ستاری"
            }
        }
        "دروازه شمیران" -> {
            when (findStationNameFromId(nextId)) {
                "دروازه دولت" -> return "ارم سبز"
                "بهارستان" -> return "تهران (صادقیه)"
                "امام حسین" -> return "فرهنگسرا"
                "میدان شهدا" -> return "شهید کلاهدوز"
            }
        }
        "شهید نواب صفوی" -> {
            when (findStationNameFromId(nextId)) {
                "شادمان" -> return "تهران (صادقیه)"
                "میدان حر" -> return "فرهنگسرا"
                "رودکی" -> return "بسیج"
                "توحید" -> return "میدان صنعت"
            }
        }
        "شادمان" -> {
            when (findStationNameFromId(nextId)) {
                "دانشگاه شریف" -> return "تهران (صادقیه)"
                "شهید نواب صفوی" -> return "فرهنگسرا"
                "دکتر حبیب الله" -> return "ارم سبز"
                "توحید" -> return "شهید کلاهدوز"
            }
        }
        "تهران (صادقیه)" -> {
            when (findStationNameFromId(nextId)) {
                "ارم سبز" -> return "شهید سپهبد قاسم سلیمانی"
                "طرشت" -> return "فرهنگسرا"
            }
        }
        "تیاتر شهر" -> {
            when (findStationNameFromId(nextId)) {
                "منیریه" -> return "آزادگان"
                "میدان انقلاب اسلامی" -> return "ارم سبز"
                "فردوسی" -> return "شهید کلاهدوز"
                "میدان جهاد" -> return "قایم"
            }
        }
        "مهدیه" -> {
            when (findStationNameFromId(nextId)) {
                "هلال احمر" -> return "میدان صنعت"
                "میدان محمدیه" -> return "بسیج"
                "راه آهن" -> return "آزادگان"
                "منیریه" -> return "قایم"
            }
        }
        "میدان شهدا" -> {
            when (findStationNameFromId(nextId)) {
                "امیرکبیر" -> return "دولت آباد"
                "امام حسین" -> return "شهید ستاری"
                "دروازه شمیران" -> return "ارم سبز"
                "ابن سینا" -> return "شهید کلاهدوز"
            }
        }
        "توحید" -> {
            when (findStationNameFromId(nextId)) {
                "مدافعان سلامت" -> return "میدان صنعت"
                "شهید نواب صفوی" -> return "بسیج"
                "شادمان" -> return "ارم سبز"
                "میدان انقلاب اسلامی" -> return "شهید کلاهدوز"
            }
        }
        "ارم سبز" -> {
            when (findStationNameFromId(nextId)) {
                "ورزشگاه آزادی" -> return "شهید سپهبد قاسم سلیمانی"
                "تهران (صادقیه)" -> return "تهران (صادقیه)"
                "شهرک اکباتان" -> return "شهید کلاهدوز"
            }
        }
        "دانشگاه تربیت مدرس" -> {
            when (findStationNameFromId(nextId)) {
                "شهرک آزمایش" -> return "شهید ستاری"
                "مدافعان سلامت" -> return "بسیج"
                "بوستان گفتگو" -> return "میدان صنعت"
                "امام حسین" -> return "دولت آباد"
            }
        }
    }
    return "غلط"
}
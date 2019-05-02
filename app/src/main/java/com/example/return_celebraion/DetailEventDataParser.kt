package com.example.return_celebraion

import org.jetbrains.anko.db.MapRowParser

class DetailEventDataParser :MapRowParser<DetailEventData> {
    override fun parseRow(columns: Map<String, Any?>): DetailEventData {
        return DetailEventData(
            columns["toname"] as String,
            columns["received"] as String,
            columns["date"] as String,
            columns["forpresent"] as String,
            columns["donecheck"] as String
            )
    }
}
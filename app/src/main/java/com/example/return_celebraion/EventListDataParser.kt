package com.example.return_celebraion

import org.jetbrains.anko.db.MapRowParser

class EventListDataParser : MapRowParser<EventListData> {
    override fun parseRow(columns: Map<String, Any?>): EventListData {
        return EventListData(columns["eventname"] as String)
    }
}
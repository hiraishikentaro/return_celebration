package com.example.return_celebraion

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import org.jetbrains.anko.layoutInflater
import org.jetbrains.anko.textColor

class DetailEventAdapter : ArrayAdapter<DetailEventData> {
    constructor(context: Context?, resource: Int) : super(context, resource)
    constructor(context: Context?, resource: Int, textviewResourceId: Int) : super(context, resource, textviewResourceId)
    constructor(context: Context?, resource: Int, objects: Array<out DetailEventData>?) : super(context, resource, objects)
    constructor(context: Context?, resource: Int, textViewResourceId: Int, objects: Array<out DetailEventData>?) : super(context, resource, textViewResourceId, objects)
    constructor(context: Context?, resource: Int, objects: MutableList<DetailEventData>?) : super(context, resource, objects)
    constructor(context: Context?, resource: Int, textViewResourceId: Int, objects: MutableList<DetailEventData>?) : super(context, resource, textViewResourceId, objects)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var newView = convertView ?: context.layoutInflater.inflate(R.layout.table, null)


        getItem(position)?.run {
            if(to_name != "1") {

                newView.findViewById<TextView>(R.id.rowForName).text = to_name
                newView.findViewById<TextView>(R.id.rowForGive).text = received
                newView.findViewById<TextView>(R.id.rowForDate).text = date
                newView.findViewById<TextView>(R.id.rowForPresent).text = for_present
                if (donecheck == "0"){
                    newView.findViewById<TextView>(R.id.rowForName).setTextColor(Color.RED)
                    newView.findViewById<TextView>(R.id.rowForGive).setTextColor(Color.RED)
                    newView.findViewById<TextView>(R.id.rowForDate).setTextColor(Color.RED)
                    newView.findViewById<TextView>(R.id.rowForPresent).setTextColor(Color.RED)
                }
            }
        }
        return newView
    }
}
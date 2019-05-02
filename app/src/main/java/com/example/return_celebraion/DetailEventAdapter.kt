package com.example.return_celebraion

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import org.jetbrains.anko.layoutInflater

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
                newView.findViewById<TextView>(R.id.forName).text = to_name
                newView.findViewById<TextView>(R.id.forGive).text = received
                newView.findViewById<TextView>(R.id.forDate).text = date
                newView.findViewById<TextView>(R.id.forPresent).text = for_present
                newView.findViewById<TextView>(R.id.forCheck).text = donecheck
            }
        }
        return newView
    }
}
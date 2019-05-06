package jp.co.return_celebraion

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.view.autofill.AutofillId
import android.widget.ArrayAdapter
import android.widget.TextView
import org.jetbrains.anko.layoutInflater


class EventListAdapter : ArrayAdapter<EventListData> {
    constructor(context: Context?, resource: Int) : super(context, resource)
    constructor(context: Context?, resource: Int, textviewResourceId: Int) : super(context, resource, textviewResourceId)
    constructor(context: Context?, resource: Int, objects: Array<out EventListData>?) : super(context, resource, objects)
    constructor(context: Context?, resource: Int, textViewResourceId: Int, objects: Array<out EventListData>?) : super(context, resource, textViewResourceId, objects)
    constructor(context: Context?, resource: Int, objects: MutableList<EventListData>?) : super(context, resource, objects)
    constructor(context: Context?, resource: Int, textViewResourceId: Int, objects: MutableList<EventListData>?) : super(context, resource, textViewResourceId, objects)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var newView = convertView ?: context.layoutInflater.inflate(R.layout.row, null)

        getItem(position)?.run {
            newView.findViewById<TextView>(R.id.rowEventName).text = event_name
        }
        return newView
    }

}
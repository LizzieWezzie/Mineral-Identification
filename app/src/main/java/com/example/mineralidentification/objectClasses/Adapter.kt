package com.example.mineralidentification.objectClasses

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.mineralidentification.R

class Adapter(var cxt: Activity, var resource: Int, var items: ArrayList<Model>) :
    ArrayAdapter<Model>(cxt, resource, items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater : LayoutInflater = LayoutInflater.from(cxt)
        val view : View = inflater.inflate(resource, null)

        val mineralName : TextView = view.findViewById(R.id.textViewCapital)

        mineralName.text = items[position].name
        val imageView  : ImageView = view.findViewById(R.id.imageFlag)

        imageView.setImageDrawable(cxt.resources.getDrawable(items[position].image_source))

        return view
    }

    override fun getItem(position: Int): Model? {
        return super.getItem(position)
    }
}


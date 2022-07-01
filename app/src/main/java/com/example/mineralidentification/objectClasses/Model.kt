package com.example.mineralidentification.objectClasses

import android.content.Context

class Model(var name: String, var image_source: Int) {
    fun getNames(): String {
        return name
    }
    fun setNames(name: String) {
        this.name = name
    }
    fun getImage(): Int {
        return image_source
    }

    fun setImage(image_source: Int) {
        this.image_source = image_source
    }

}
package com.example.mineralidentification.objectClasses

class Rock {
    var name = ""
    var color = ""
    var composition1 = ""
    var composition2 = ""
    var composition3 = ""
    var texture = ""
    var hardness = 0.0

    constructor(name: String, color: String, composition1: String, composition2: String, composition3:
    String, texture: String, hardness: Double) {
        this.name = name
        this.color = color
        this.composition1 = composition1
        this.composition2 = composition2
        this.composition3 = composition3
        this.texture = texture
        this.hardness = hardness
    }

    constructor()
}
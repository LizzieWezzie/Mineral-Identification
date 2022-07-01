package com.example.mineralidentification.objectClasses

class Mineral {
    var name = ""
    var color = ""
    var streak = ""
    var luster = ""
    var hardness = 0.0
    var cleavage = ""
    var density = 0.0
    var description = ""
    var fracture = ""

    constructor(
        name: String, color: String, streak: String, luster: String, hardness: Double,
        cleavage: String, density: Double, description: String, fracture: String) {
        this.name = name
        this.color = color
        this.streak = streak
        this.luster = luster
        this.hardness = hardness
        this.cleavage = cleavage
        this.density = density
        this.fracture = fracture
        this.description = description
    }

    constructor()
}

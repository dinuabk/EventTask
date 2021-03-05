package com.interview.eventtask.model

public class EventTaskModel {

    lateinit var id:String
    lateinit var name:String
    lateinit var localDate:String
    lateinit var localTime:String
    lateinit var info:String
    lateinit var city:String
    lateinit var state:String
    lateinit var country:String
    lateinit var longitude:String
    lateinit var latitude:String

    constructor(id: String,name:String,localDate:String,localTime:String,info:String,city:String,
                state:String,country:String
                ,longitude:String
                ,latitude:String) {
        this.id = id
        this.name = name
        this.localDate = localDate
        this.localTime = localTime
        this.info = info
        this.city = city
        this.state = state
        this.country = country
        this.longitude = longitude
        this.latitude = latitude
    }

    constructor()
}
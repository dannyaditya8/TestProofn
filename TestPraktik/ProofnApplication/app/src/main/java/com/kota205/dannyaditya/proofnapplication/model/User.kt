package com.kota205.dannyaditya.proofnapplication.model

data class User(
    var id: Int,
    var hash: String,
    var firstName: String,
    var lastName: String,
    var fullName: String,
    var activeEmail: String,
    var avatarPathSmall: String,
    var avatarPathMedium: String,
    var avatarPathLarge: String,
    var countryDialCode: CountryDialCode,
    var hashUsablePassword: Boolean,
    var username: String,
    var status: Int

)
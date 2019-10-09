package com.chsltutorials.pacoteviagens.model.entity

import java.math.BigDecimal

data class TripPackage (var destination : List<TripItem>)

data class TripItem (var name : String? = null,
                        var description : String? = null,
                        var dias : Int? = 0,
                        var price : String? = null,
                        var cover : String? = null,
                        var local : String? = null)

data class PackageDetail (var name : String? = null,
                          var picture : String? = null,
                          var description : String? = null,
                          var packageValue : BigDecimal? = BigDecimal.ZERO)





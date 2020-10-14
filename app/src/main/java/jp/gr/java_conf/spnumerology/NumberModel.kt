package jp.gr.java_conf.spnumerology

import io.realm.RealmObject
import jp.gr.java_conf.spnumerology.util.IntentKey

open class NumberModel : RealmObject() {
    var destinyNum_model : Int = 0
    var lifePassNum_model : Int = 0
    var soulNum_model : Int = 0
    var personalNum_model : Int = 0
    var name_model : String = ""
    var year_model : String = ""
    var month_model : String = ""
    var day_model : String = ""
    var birthday_model : String = ""
}
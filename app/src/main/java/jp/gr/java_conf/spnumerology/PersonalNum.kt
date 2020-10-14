package jp.gr.java_conf.spnumerology

class PersonalNum {

    fun calcPersonal(name : String) : Int {

        val upper = name!!.count() - 1
        var consonantNum = 0
        var tempNumber = 0

        for ( i in 0..upper){
            val alphabet = name.substring(i, i + 1)
            consonantNum += changeConsonant(alphabet)
        }

        tempNumber = consonantNum
        tempNumber = if (tempNumber > 9) {
            tempNumber.toString().substring(0,1).toInt() + tempNumber.toString().substring(1,2).toInt()
        } else {
            tempNumber
        }

        val calcNum = if (tempNumber > 9 ) tempNumber.toString().substring(0, 1).toInt() + tempNumber.toString().substring(1, 2).toInt() else 0

        var resultNum =  if (tempNumber < 10) {
            tempNumber
        } else if (judgeMasterNum(tempNumber) != 0) {
            judgeMasterNum(tempNumber)
        } else if (judgeMasterNum(calcNum) != 0) {
            judgeMasterNum(calcNum)
        } else  {
            calcNum
        }
        return resultNum
    }


}
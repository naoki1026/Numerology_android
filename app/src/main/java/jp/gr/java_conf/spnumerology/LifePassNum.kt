package jp.gr.java_conf.spnumerology

class LifePassNum {

    fun calcLifePass(year: String, month: String, day: String) : Int {

        val yearList = listOf(
            year.substring(0,1).toInt(),
            year.substring(1,2).toInt(),
            year.substring(2,3).toInt(),
            year.substring(3,4).toInt()
        )

        val monthList = listOf(
            month.substring(0,1).toInt(),
            month.substring(1,2).toInt()
        )

        val dayList = listOf(
            day.substring(0,1).toInt(),
            day.substring(1,2).toInt()
        )

        val yearSum = yearList[0] + yearList[1] + yearList[2] + yearList[3]
        val monthSum = monthList[0] + monthList[1]
        val daySum = dayList[0] + dayList[1]
        val sumBirthday = yearSum + monthSum + daySum

        val calcNum = if (sumBirthday > 9 ) sumBirthday.toString().substring(0, 1).toInt() + sumBirthday.toString().substring(1, 2).toInt() else 0
        val secondCalcNum = if (calcNum > 9 ) calcNum.toString().substring(0, 1).toInt() + calcNum.toString().substring(1, 2).toInt() else 0

        var resultNum =  if (sumBirthday < 10) {
            sumBirthday
        } else if (judgeMasterNum(sumBirthday) != 0) {
            judgeMasterNum(sumBirthday)
        } else if (calcNum < 10) {
            calcNum
        } else if (judgeMasterNum(calcNum) != 0) {
            judgeMasterNum(calcNum)
        } else if (judgeMasterNum(secondCalcNum) != 0) {
            judgeMasterNum(secondCalcNum)
        } else {
            secondCalcNum
        }

        return resultNum
    }
}
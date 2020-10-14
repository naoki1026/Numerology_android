package jp.gr.java_conf.spnumerology.view.activity

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import io.realm.Realm
import io.realm.kotlin.createObject
import jp.gr.java_conf.spnumerology.*
import jp.gr.java_conf.spnumerology.view.fragment.DatePickerDialogFragment
import jp.gr.java_conf.spnumerology.util.FragmentTag
import jp.gr.java_conf.spnumerology.util.IntentKey
import kotlinx.android.synthetic.main.activity_input.*

class InputActivity : AppCompatActivity(),
    DatePickerDialogFragment.OnDateSetListener {

    var birthday : String = ""
    var name : String = ""
    var year : String = ""
    var month : String = ""
    var day : String = ""
    var lifePassNum : Int = 0
    var destinyNum : Int = 0
    var soulNum : Int = 0
    var personalNum : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)
        setSupportActionBar(toolbar)

        toolbar.apply {
            setNavigationIcon(R.drawable.ic_keyboard_backspace_black_24dp)
            setNavigationOnClickListener {
                finish()
            }
        }
        imageButton.setOnClickListener {
            onDatePickerLaunched()
        }

        registerButton.setOnClickListener {
            inputValidation()
        }
    }

    private fun inputValidation() {
        birthday = inputDateText.text.toString()
        name = inputNameText.text.toString()
        year = birthday!!.substring(0, 4)
        month = birthday!!.substring(4, 6)
        day = birthday!!.substring(6, 8)
        lifePassNum = LifePassNum().calcLifePass(year, month, day)
        destinyNum = DestinyNum().calcDestiny(name)
        soulNum = SoulNum().calcSoul(name)
        personalNum = PersonalNum().calcPersonal(name)

        addNewNumber()

        val intent = Intent(this@InputActivity, ResultActivity::class.java).apply {
            putExtra(IntentKey.LIFEPASS_NUM.name, lifePassNum)
            putExtra(IntentKey.DESTINY_NUM.name, destinyNum)
            putExtra(IntentKey.SOUL_NUM.name, soulNum)
            putExtra(IntentKey.PERSONAL_NUM.name, personalNum)
            putExtra(IntentKey.NAME.name, name)
            putExtra(IntentKey.YEAR.name, year)
            putExtra(IntentKey.MONTH.name, month)
            putExtra(IntentKey.DAY.name, day)
        }
        startActivity(intent)
    }

    private fun addNewNumber() {
        val realm = Realm.getDefaultInstance()

        realm.beginTransaction()
        val newNumber = realm.createObject(NumberModel::class.java)
        newNumber.apply {
            lifePassNum_model = lifePassNum
            destinyNum_model = destinyNum
            soulNum_model  = soulNum
            personalNum_model = personalNum
            name_model  = name
            year_model = year
            month_model = month
            day_model = day
            birthday_model = birthday
        }
        realm.commitTransaction()
        realm.close()
    }

    private fun onDatePickerLaunched() {
        DatePickerDialogFragment()
            .show(supportFragmentManager, FragmentTag.DATE_PICKER.toString())
    }

    override fun onDateSelected(dateString : String) {
        val inputDateText = findViewById(R.id.inputDateText) as EditText
        inputDateText.setText(dateString)
    }

}

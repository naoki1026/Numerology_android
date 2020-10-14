package jp.gr.java_conf.spnumerology.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.realm.Realm
import jp.gr.java_conf.spnumerology.*
import jp.gr.java_conf.spnumerology.util.IntentKey

import kotlinx.android.synthetic.main.activity_result.*
import kotlinx.android.synthetic.main.activity_result.toolbar

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        setSupportActionBar(toolbar)

        toolbar.apply {
            setNavigationIcon(R.drawable.ic_keyboard_backspace_black_24dp)
            setNavigationOnClickListener {
                finish()
            }
        }

        val bundle = intent.extras
        val destinyNum = bundle?.getInt(IntentKey.DESTINY_NUM.name)
        val lifePassNum = bundle?.getInt(IntentKey.LIFEPASS_NUM.name)
        val soulNum = bundle?.getInt(IntentKey.SOUL_NUM.name)
        val personalNum = bundle?.getInt(IntentKey.PERSONAL_NUM.name)
        val name = bundle?.getString(IntentKey.NAME.name)
        val year = bundle?.getString(IntentKey.YEAR.name)
        val month = bundle?.getString(IntentKey.MONTH.name)
        val day = bundle?.getString(IntentKey.DAY.name)
        val birthday = year + "年" + month + "月" + day + "日"

        text_essential.text = destinyNum.toString()
        text_mission.text = lifePassNum.toString()
        text_soul.text = soulNum.toString()
        text_personal.text = personalNum.toString()
        text_name.text = name
        text_birthday.text = birthday

    }



}

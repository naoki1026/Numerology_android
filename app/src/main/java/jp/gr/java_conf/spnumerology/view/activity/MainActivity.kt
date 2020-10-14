package jp.gr.java_conf.spnumerology.view.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.floatingactionbutton.FloatingActionButton
import jp.gr.java_conf.spnumerology.HomeFragment
import jp.gr.java_conf.spnumerology.NumberModel
import jp.gr.java_conf.spnumerology.R
import jp.gr.java_conf.spnumerology.util.IntentKey
import jp.gr.java_conf.spnumerology.view.fragment.DetailFragment
import jp.gr.java_conf.spnumerology.view.fragment.ProfileFragment
import jp.gr.java_conf.spnumerology.view.fragment.OtherFragment


import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),HomeFragment.OnListFragmentInteractionListener {

    lateinit var profileFragment: ProfileFragment
    lateinit var detailFragment: DetailFragment
    lateinit var otherFragment: OtherFragment
    lateinit var homeFragment: HomeFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        homeFragment = HomeFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_layout, homeFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()


        //リソースIDからFloatingActionButtonのビューオブジェクトを取得
        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            goInputScreen()
        }

        btmnav.setOnNavigationItemSelectedListener { item ->

            when(item.itemId){
                R.id.home -> {
                    fab.setVisibility(View.VISIBLE)
                    homeFragment = HomeFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_layout, homeFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
                }
                R.id.detail -> {
                    fab.setVisibility(View.INVISIBLE)
                    detailFragment =
                        DetailFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_layout, detailFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
                }
                R.id.other_menu -> {
                    fab.setVisibility(View.INVISIBLE)
                    otherFragment =
                        OtherFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_layout, otherFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
                }
            }
            true
        }
    }

    override fun onResume() {
        super.onResume()
        updateNumberList()
    }

    private fun updateNumberList() {

        homeFragment = HomeFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_layout, homeFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()

    }

    //InputActivityへの遷移
    private fun goInputScreen() {
        val intent = Intent(this@MainActivity, InputActivity::class.java)
        startActivity(intent)
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onListFragmentInteraction(item: NumberModel?) {
        println(item!!.name_model)
        val intent = Intent(this@MainActivity, ResultActivity::class.java).apply {
            putExtra(IntentKey.LIFEPASS_NUM.name, item!!.lifePassNum_model)
            putExtra(IntentKey.DESTINY_NUM.name, item!!.destinyNum_model)
            putExtra(IntentKey.SOUL_NUM.name, item!!.soulNum_model)
            putExtra(IntentKey.PERSONAL_NUM.name, item!!.personalNum_model)
            putExtra(IntentKey.NAME.name,  item!!.name_model)
            putExtra(IntentKey.YEAR.name, item!!.year_model)
            putExtra(IntentKey.MONTH.name, item!!.month_model)
            putExtra(IntentKey.DAY.name, item!!.day_model)
        }
        startActivity(intent)
    }

}

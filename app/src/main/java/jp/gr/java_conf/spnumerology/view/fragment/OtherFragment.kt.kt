package jp.gr.java_conf.spnumerology.view.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import jp.gr.java_conf.spnumerology.R
import kotlinx.android.synthetic.main.fragment_other.*

/**
 * A simple [Fragment] subclass.
 */
class OtherFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_other, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        button.setOnClickListener { view ->
            goLineApp()
        }
    }

    private fun goLineApp() {
        val uri = "https://line.me/ti/p/QpZ0lyyfat"
        val intent = Intent(Intent.ACTION_VIEW)
        intent.setData(Uri.parse(uri))
        startActivity(intent);


    }


}

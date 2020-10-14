package jp.gr.java_conf.spnumerology

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import io.realm.RealmResults


import jp.gr.java_conf.spnumerology.HomeFragment.OnListFragmentInteractionListener

import kotlinx.android.synthetic.main.fragment_home.view.*

class MyHomeFragmentRecyclerViewAdapter(
    private val mValues: RealmResults<NumberModel>,
    private val mListener: OnListFragmentInteractionListener?
) : RecyclerView.Adapter<MyHomeFragmentRecyclerViewAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as NumberModel
            mListener?.onListFragmentInteraction(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_home, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        holder.mContentView.text = item!!.name_model
        holder.mContentnNum.text = item!!.lifePassNum_model.toString()

        with(holder.mView) {
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = mValues.size
    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mContentView: TextView = mView.content
        val mContentnNum:TextView = mView.lifepass_num
    }
}

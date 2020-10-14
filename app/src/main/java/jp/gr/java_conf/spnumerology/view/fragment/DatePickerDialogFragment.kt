package jp.gr.java_conf.spnumerology.view.fragment

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import jp.gr.java_conf.spnumerology.R
import java.text.SimpleDateFormat
import java.util.*

class DatePickerDialogFragment : DialogFragment(), DatePickerDialog.OnDateSetListener{

    var listener : OnDateSetListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnDateSetListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + "must implememnt OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnDateSetListener {
        fun onDateSelected(dateString: String)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        //ここで本日の日付を取得する
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        return DatePickerDialog(requireActivity(),
            R.style.MySpinnerDatePickerStyle,this, year, month, day)
    }

    override fun onDateSet(datePicker: DatePicker?, year: Int, month: Int, day: Int) {
        val dateString = getDateString(year, month, day)
        listener?.onDateSelected(dateString as String)
        getParentFragmentManager().beginTransaction().remove(this).commit()
    }

    private fun getDateString(year: Int, month: Int, day: Int): Any {
        val calendar = Calendar.getInstance()
        calendar.set(year, month, day)
        val dateFromat = SimpleDateFormat("yyyyMMdd")
        return dateFromat.format(calendar.time)
    }


}
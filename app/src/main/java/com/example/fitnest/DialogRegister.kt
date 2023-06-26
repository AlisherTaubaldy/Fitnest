package com.example.fitnest

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.fitnest.databinding.DialogWindowRegisterBinding

class DialogRegister: DialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val binding: DialogWindowRegisterBinding = DialogWindowRegisterBinding.inflate(inflater, container, false)
        val view: View = binding.getRoot()

        binding.okay.setOnClickListener{
            dialog?.dismiss();
        }
        return view
    }

    override fun onStart() {
        super.onStart()
        val width = (resources.displayMetrics.widthPixels * 0.85).toInt()
        val height = (resources.displayMetrics.heightPixels * 0.50).toInt()
        dialog!!.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    override fun onResume() {
        super.onResume()
        val window = dialog!!.window ?: return
        val params = window.attributes
        params.width = (resources.displayMetrics.widthPixels * 0.75).toInt()
        params.height = (resources.displayMetrics.heightPixels * 0.50).toInt()
        window.attributes = params
    }

}
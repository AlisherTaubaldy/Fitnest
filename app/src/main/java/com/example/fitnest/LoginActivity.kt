package com.example.fitnest

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import java.lang.String

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)

        val logoView: View? = getToolbarLogoView(toolbar)
        logoView?.setOnClickListener{
            finish()
        }

        val login = findViewById<Button>(R.id.login)

        login.setOnClickListener {
            finish()
        }
    }

    fun getToolbarLogoView(toolbar: Toolbar): View? {
        //check if contentDescription previously was set
        val hadContentDescription = TextUtils.isEmpty(toolbar.getLogoDescription())
        val contentDescription =
            String.valueOf(if (!hadContentDescription) toolbar.getLogoDescription() else "logoContentDescription")
        toolbar.setLogoDescription(contentDescription)
        val potentialViews: ArrayList<View> = ArrayList<View>()
        //find the view based on it's content description, set programatically or with android:contentDescription
        toolbar.findViewsWithText(
            potentialViews,
            contentDescription,
            View.FIND_VIEWS_WITH_CONTENT_DESCRIPTION
        )
        //Nav icon is always instantiated at this point because calling setLogoDescription ensures its existence
        var logoIcon: View? = null
        if (potentialViews.size > 0) {
            logoIcon = potentialViews[0]
        }
        //Clear content description if not previously present
        if (hadContentDescription) toolbar.setLogoDescription(null)
        return logoIcon
    }
}
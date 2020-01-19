package com.gsm.firstmvp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.gsm.firstmvp.R
import com.gsm.firstmvp.contact.MainContact
import com.gsm.firstmvp.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContact.View {

    override lateinit var presenter: MainContact.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenter(this)

        button.setOnClickListener { presenter.clickButton() }
    }

    override fun showToast() = Toast.makeText(this, "버튼을 클릭했습니다.", Toast.LENGTH_SHORT).show()
}

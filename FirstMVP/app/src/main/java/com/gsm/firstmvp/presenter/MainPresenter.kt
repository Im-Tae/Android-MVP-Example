package com.gsm.firstmvp.presenter

import com.gsm.firstmvp.contact.MainContact

class MainPresenter(val view: MainContact.View): MainContact.Presenter {

    override fun clickButton() = view.showToast()

}
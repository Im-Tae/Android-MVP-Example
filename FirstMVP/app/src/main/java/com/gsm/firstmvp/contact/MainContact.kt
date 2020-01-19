package com.gsm.firstmvp.contact

interface MainContact {
    interface View {

        val presenter: Presenter

        fun showToast()
    }

    interface Presenter {

        val view: View

        fun clickButton()
    }
}
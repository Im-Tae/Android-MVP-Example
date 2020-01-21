package com.imtae.firstmvp.contract

interface MainContract {
    interface View {

        val presenter: Presenter

        fun showToast()
    }

    interface Presenter {

        val view: View

        fun clickButton()
    }
}
package com.gsm.firstmvp.contact

interface MainContact {
    interface View {
        fun showToast()
    }

    interface Presenter {
        fun clickButton()
    }
}
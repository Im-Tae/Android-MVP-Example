package com.imtae.firstmvp.presenter

import com.imtae.firstmvp.contract.MainContract

class MainPresenter(override val view: MainContract.View): MainContract.Presenter {

    override fun clickButton() = view.showToast()

}
package com.chsltutorials.pacoteviagens.base

interface IBaseContract {
    interface View<P : IBaseContract.Presenter> {
        fun createPresenter(): P
    }

    interface Presenter {
        fun onDetach()
        fun onAttach()
    }
}

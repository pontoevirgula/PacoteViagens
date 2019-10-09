package com.chsltutorials.pacoteviagens.base

import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chsltutorials.pacoteviagens.R
import com.chsltutorials.pacoteviagens.model.util.ConnectivityReceiver
import com.chsltutorials.pacoteviagens.presentation.view.activity.MainActivity

abstract class BaseActivity<P : IBaseContract.Presenter> : AppCompatActivity(), IBaseContract.View<P>, ConnectivityReceiver.ConnectivityReceiverListener {

    private var mSnackBar: Snackbar? = null
    var presenter: P? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = createPresenter()
        registerReceiver(ConnectivityReceiver(),
            IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        )
    }

    override fun onStart() {
        super.onStart()
        presenter?.onAttach()
    }

    override fun onResume() {
        super.onResume()
        ConnectivityReceiver.connectivityReceiverListener = this
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.let { it.onDetach() }
        mSnackBar?.let { it.dismiss() }
    }

    private fun showMessage(isConnected: Boolean) {
        if (!isConnected) {
            val messageToUser = "Você esta sem internet."
            mSnackBar = Snackbar.make(findViewById(R.id.rootLayout), messageToUser, Snackbar.LENGTH_LONG)
            mSnackBar?.duration = Snackbar.LENGTH_INDEFINITE
            mSnackBar?.show()
        } else {
            mSnackBar?.dismiss()
        }
    }

    override fun onNetworkConnectionChanged(isConnected: Boolean) = showMessage(isConnected)

}
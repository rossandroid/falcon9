package morg.ros.falconapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import morg.ros.falconapp.model.ApiClasses
import morg.ros.falconapp.presenter.IMainPresenter
import morg.ros.falconapp.presenter.MainPresenter

class MainActivity : AppCompatActivity() , IMainPresenter {

    var presenterImplementation: MainPresenter? = null
//    var linearLayoutManager: LinearLayoutManager? = null
    var mAdapter: MainAdapter? = null
//    var arrayList: List<ApiClasses.Rocket>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycleView.layoutManager= LinearLayoutManager(this)

        recycleView.setHasFixedSize(true)
        recycleView.setItemAnimator(DefaultItemAnimator())
        recycleView.setFitsSystemWindows(true)

        presenterImplementation = MainPresenter(this)
        presenterImplementation!!.getRocketList()

    }

    override fun showSpinner() {
        recycleView.setVisibility(View.GONE)
        spinner.visibility = View.VISIBLE
        textSpinner.visibility = View.GONE

    }

    override fun hideSpinner() {
        recycleView.setVisibility(View.VISIBLE)
        spinner.visibility = View.GONE
        textSpinner.visibility = View.GONE
    }

    override fun hideSpinnerWithError(Error: String) {
        recycleView.setVisibility(View.GONE)
        spinner.visibility = View.GONE
        textSpinner.text=Error
        textSpinner.visibility = View.VISIBLE
    }

    override fun updateAdapter(list: List<ApiClasses.Rocket>) {
        //arrayList = list
        mAdapter = MainAdapter(list)
        recycleView.setAdapter(mAdapter);
    }

}

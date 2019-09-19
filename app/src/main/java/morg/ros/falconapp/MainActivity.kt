package morg.ros.falconapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import morg.ros.falconapp.model.ApiClasses

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
     }

    override fun hideSpinner() {
    }

    override fun hideSpinnerWithError(Error: String) {
    }

    override fun updateAdapter(list: List<ApiClasses.Rocket>) {
        //arrayList = list
        mAdapter = MainAdapter(list)
        recycleView.setAdapter(mAdapter);


    }
}

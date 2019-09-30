package morg.ros.falconapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import morg.ros.falconapp.model.ApiClasses
import morg.ros.falconapp.presenter.MainPresenter

class MainActivity : AppCompatActivity() , IMainActivity {

    var presenterImplementation: MainPresenter? = null
    var mAdapter: MainAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycleView.layoutManager= LinearLayoutManager(this)

        recycleView.setHasFixedSize(true)
        recycleView.setItemAnimator(androidx.recyclerview.widget.DefaultItemAnimator())
        recycleView.setFitsSystemWindows(true)

        presenterImplementation = MainPresenter(this)
        presenterImplementation!!.getRocketList("falcon9")

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
        mAdapter = MainAdapter(list)
        recycleView.setAdapter(mAdapter);
    }

}

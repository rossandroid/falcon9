package morg.ros.falconapp.presenter

import morg.ros.falconapp.IMainActivity
import morg.ros.falconapp.model.ApiClasses
import morg.ros.falconapp.repository.FalconAPINet

class MainPresenter(iMainActivity: IMainActivity): IMainPresenter {

    private var iMainActivity: IMainActivity

    init{
        this.iMainActivity = iMainActivity
        FalconAPINet.setService(this)
    }

    fun getRocketList(query:String){
        iMainActivity.showSpinner()
        FalconAPINet.search(query)
    }

    override fun onError(error: String) {
        iMainActivity.hideSpinnerWithError(error)
    }

    override fun onSuccess(list: List<ApiClasses.Rocket>) {
        iMainActivity.hideSpinner()
        iMainActivity.updateAdapter(list)
    }
}
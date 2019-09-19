package morg.ros.falconapp.presenter

import morg.ros.falconapp.model.ApiClasses
import morg.ros.falconapp.repository.FalconAPINet
import morg.ros.falconapp.repository.IService

class MainPresenter(
        iMainPresenter: IMainPresenter
) :IService{
    private val iPresenter = iMainPresenter

    fun getRocketList(){
        iPresenter.showSpinner()
        FalconAPINet.search(this)

    }

    override fun onError(error: String) {
        iPresenter.hideSpinnerWithError(error)
    }

    override fun onSuccess(list: List<ApiClasses.Rocket>) {
        iPresenter.hideSpinner()
        iPresenter.updateAdapter(list)
    }
}
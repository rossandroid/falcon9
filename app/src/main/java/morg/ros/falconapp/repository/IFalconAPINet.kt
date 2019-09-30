package morg.ros.falconapp.repository

import io.reactivex.Flowable
import morg.ros.falconapp.model.ApiClasses
import morg.ros.falconapp.presenter.IMainPresenter

interface IFalconAPINet {

    fun setService(iMainPresenter: IMainPresenter)
    fun search(query:String)

    // method exported for testing purpose
    fun get(query:String): Flowable<List<ApiClasses.Rocket>>


}
package morg.ros.falconapp.repository

import io.reactivex.Flowable
import morg.ros.falconapp.model.ApiClasses

interface IFalconAPINet {

    fun search(): Flowable<List<ApiClasses.Rocket>>

    fun search(iService:IService)

}
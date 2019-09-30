package morg.ros.falconapp.presenter

import morg.ros.falconapp.model.ApiClasses

interface IMainPresenter {
    
        fun onError(error: String)
        fun onSuccess(list: List<ApiClasses.Rocket>)

}
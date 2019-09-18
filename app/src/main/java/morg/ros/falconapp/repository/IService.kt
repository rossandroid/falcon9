package morg.ros.falconapp.repository

import morg.ros.falconapp.model.ApiClasses

interface IService {
    
        fun onError(error: String)
        fun onSuccess(list: List<ApiClasses.Rocket>)

}
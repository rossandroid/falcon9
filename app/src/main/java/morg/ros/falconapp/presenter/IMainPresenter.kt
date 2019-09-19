package morg.ros.falconapp.presenter

import morg.ros.falconapp.model.ApiClasses

interface IMainPresenter {


        fun showSpinner()
        fun hideSpinner()
        fun hideSpinnerWithError(Error: String)
        fun updateAdapter(list: List<ApiClasses.Rocket>)
}
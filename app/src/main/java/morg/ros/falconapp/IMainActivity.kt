package morg.ros.falconapp

import morg.ros.falconapp.model.ApiClasses

interface IMainActivity {

        fun showSpinner()
        fun hideSpinner()
        fun hideSpinnerWithError(Error: String)
        fun updateAdapter(list: List<ApiClasses.Rocket>)
}
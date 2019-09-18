package morg.ros.falconapp.repository

import io.reactivex.Flowable
import morg.ros.falconapp.model.ApiClasses
import retrofit2.http.GET

interface FalconAPIService {


        @GET("/v3/launches?rocket_id=falcon9")
        fun search(): Flowable<List<ApiClasses.Rocket>>


}
package morg.ros.falconapp.repository

import io.reactivex.Flowable
import morg.ros.falconapp.model.ApiClasses
import retrofit2.http.GET
import retrofit2.http.Query

interface FalconAPIService {

        @GET("/v3/launches")
        fun search( @Query("rocket_id") query:String): Flowable<List<ApiClasses.Rocket>>

}
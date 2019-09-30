package morg.ros.falconapp.repository

import io.reactivex.Flowable
import morg.ros.falconapp.model.ApiClasses
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import morg.ros.falconapp.presenter.IMainPresenter


object FalconAPINet:IFalconAPINet {


    private val base_url = "https://api.spacexdata.com"
    private var miMainPresenter: IMainPresenter? = null

    val rf = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(base_url)
            .build()

    private var falconAPI = rf.create(FalconAPIService::class.java)


    override fun setService(iMainPresenter: IMainPresenter) {
        miMainPresenter=iMainPresenter
    }

    override
    fun get(query:String): Flowable<List<ApiClasses.Rocket>> = falconAPI.search(query)

    override
    fun search(query:String) {
        get(query)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            miMainPresenter!!.onSuccess(it)
                        },
                        {
                            miMainPresenter!!.onError(it.message.toString())
                        })
            }


}
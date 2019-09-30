package morg.ros.falconapp

import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Flowable
import io.reactivex.subscribers.TestSubscriber
import morg.ros.falconapp.model.ApiClasses
import morg.ros.falconapp.repository.IFalconAPINet
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class FalconAPINetTest {

    @Mock
    lateinit var falconRepo : IFalconAPINet

    @Before
    fun setUp(){
        MockitoAnnotations.initMocks(this)

    }

    @Test
    fun test_get_fake_list_rockets_and_test_data() {
        var ts : TestSubscriber<List<ApiClasses.Rocket>> = TestSubscriber<List<ApiClasses.Rocket>>()

        whenever(falconRepo.get("falcon9")).thenReturn(Flowable.just(getFakeRocketList()))
        falconRepo.get("falcon9").subscribe(ts)

        ts.awaitTerminalEvent()
        ts.assertComplete()
        ts.assertNoErrors()
        ts.assertValueCount(1)

        var listRockets : List<ApiClasses.Rocket> = ts.values()[0]
        assertEquals(listRockets.size, 1)
        assertEquals(listRockets[0].mission_name, "Falcon 9")
    }

    fun getFakeRocketList() : List<ApiClasses.Rocket>{

        var rocket = ApiClasses.Rocket("Falcon 9", "2010-06-04T18:45:00.000Z", true, ApiClasses.Link("https://images2.imgbox.com/d6/12/yxne8mMD_o.png"))
        var fakeRocketList = listOf<ApiClasses.Rocket>(rocket)
        return fakeRocketList
    }
}

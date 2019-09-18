package morg.ros.falconapp

import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Flowable
import io.reactivex.subscribers.TestSubscriber
import morg.ros.falconapp.model.ApiClasses
import morg.ros.falconapp.repository.FalconAPINet
import morg.ros.falconapp.repository.FalconAPIService
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
    lateinit var mockFalconAPIService : FalconAPIService

    @Before
    fun setUp(){
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun test_get_list_rockets_from_server_and_test_type() {
        var ts : TestSubscriber<List<ApiClasses.Rocket>> = TestSubscriber<List<ApiClasses.Rocket>>()
        FalconAPINet.search().subscribe(ts)
        ts.awaitTerminalEvent()
        ts.assertComplete()
        ts.assertNoErrors()
        ts.assertValueCount(1)
        var listRockets : List<ApiClasses.Rocket> = ts.values()[0]
        assertTrue(listRockets[0].mission_name is String)
        //...
    }

    @Test
    fun test_get_fake_list_rockets_and_test_data() {

        //given
        whenever(mockFalconAPIService.search()).thenReturn(Flowable.just(getFakeRocketList()))

        //when
        var ts : TestSubscriber<List<ApiClasses.Rocket>> = TestSubscriber<List<ApiClasses.Rocket>>()

        //then
        mockFalconAPIService.search().subscribe(ts)

        ts.awaitTerminalEvent()
        ts.assertComplete()
        ts.assertNoErrors()
        ts.assertValueCount(1)

        var listRockets : List<ApiClasses.Rocket> = ts.values()[0]
        assertEquals(listRockets.size, 1)
        assertEquals(listRockets[0].mission_name, "Falcon 9")
        //...
    }

    fun getFakeRocketList() : List<ApiClasses.Rocket>{

        var rocket = ApiClasses.Rocket("Falcon 9", "2010-06-04T18:45:00.000Z", true, ApiClasses.Link("https://images2.imgbox.com/d6/12/yxne8mMD_o.png"))
        var fakeRocketList = listOf<ApiClasses.Rocket>(rocket)
        return fakeRocketList
    }
}

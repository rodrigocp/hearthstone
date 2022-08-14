package br.com.rcp.hearthstone.service

import br.com.rcp.hearthstone.api.API
import br.com.rcp.hearthstone.client.DefaultHttpClient
import br.com.rcp.hearthstone.client.HttpClientFactory
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.hamcrest.CoreMatchers.any
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit

private const val BASE_API = "http://www.example.org"

class DefaultServiceTest {
    private val httpClientFactory: HttpClientFactory = mockk()
    private val api: API = mockk()

    @Before
    fun setup() {
        every { api.base } returns BASE_API
        every { httpClientFactory.create() } returns mockk()
    }

    @Test
    fun `when create service expect method call`() {
        val serviceFactory : ServiceFactory = DefaultService(httpClientFactory, api)

        serviceFactory.create(DefaultAPITest::class.java)

        verify {
            api.base
            httpClientFactory.create()
        }
    }

    private interface DefaultAPITest

}

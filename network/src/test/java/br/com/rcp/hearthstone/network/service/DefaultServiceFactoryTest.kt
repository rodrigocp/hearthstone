package br.com.rcp.hearthstone.network.service

import br.com.rcp.hearthstone.network.api.API
import br.com.rcp.hearthstone.network.client.HttpClientFactory
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Before
import org.junit.Test

private const val BASE_API = "http://www.example.org"

class DefaultServiceFactoryTest {
    private val httpClientFactory: HttpClientFactory = mockk()
    private val api: API = mockk()

    @Before
    fun setup() {
        every { api.base } returns BASE_API
        every { httpClientFactory.create() } returns mockk()
    }

    @Test
    fun `when create service expect method call`() {
        val serviceFactory : ServiceFactory = DefaultServiceFactory(httpClientFactory, api)

        serviceFactory.create(DefaultAPITest::class.java)

        verify {
            api.base
            httpClientFactory.create()
        }
    }

    private interface DefaultAPITest

}

package br.com.rcp.hearthstone.client

import br.com.rcp.hearthstone.cache.CacheFactory
import br.com.rcp.hearthstone.interceptors.InterceptorFactory
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Before
import org.junit.Test

class DefaultHttpClientTest {
    private val cache: CacheFactory = mockk()
    private val loggingInterceptor: InterceptorFactory = mockk()
    private val cachingInterceptor: InterceptorFactory = mockk()
    private val headersInterceptor: InterceptorFactory = mockk()

    @Before
    fun setup() {
        every { loggingInterceptor.create() } returns mockk()
        every { cachingInterceptor.create() } returns mockk()
        every { headersInterceptor.create() } returns mockk()
        every { cache.create() } returns mockk()
    }

    @Test
    fun `when create HttpClientFactory expect method call`() {
        val defaultHttpClient = DefaultHttpClient(
            cache,
            loggingInterceptor,
            cachingInterceptor,
            headersInterceptor
        )

        defaultHttpClient.create()

        verify {
            loggingInterceptor.create()
            headersInterceptor.create()
            cachingInterceptor.create()
            cache.create()
        }
    }
}

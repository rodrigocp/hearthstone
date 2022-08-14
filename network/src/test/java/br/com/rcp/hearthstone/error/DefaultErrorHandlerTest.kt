package br.com.rcp.hearthstone.error

import br.com.rcp.hearthstone.commons.providers.StringProvider
import br.com.rcp.hearthstone.core.models.ResponseError
import io.mockk.every
import io.mockk.mockk
import java.io.IOException
import kotlinx.coroutines.runBlocking
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import retrofit2.HttpException
import retrofit2.Response

private const val ERROR = "ERROR"

class DefaultErrorHandlerTest {
    private val stringProvider: StringProvider = mockk()
    private val errorHandler: ErrorHandler = DefaultErrorHandler(stringProvider)

    @Before
    fun setup() {
        every { stringProvider.getStringResource(any()) } returns ERROR
    }

    @Test
    fun `when NetworkError expect NetworkError handled properly`() = runBlocking {
        val result = errorHandler.handle(IOException(""))
        assertEquals(result, ResponseError.Network(ERROR))
    }

    @Test
    fun `when code 400 expect BadRequest handled properly`() = runBlocking {
        assertEquals(interpretHttpErrorByCode(400), ResponseError.BadRequest(""))
    }

    @Test
    fun `when code 401 expect Unauthorized handled properly`() = runBlocking {
        assertEquals(interpretHttpErrorByCode(401), ResponseError.Unauthorized(""))
    }

    @Test
    fun `when code 403 expect AccessDenied handled properly`() = runBlocking {
        assertEquals(interpretHttpErrorByCode(403), ResponseError.AccessDenied(""))
    }

    @Test
    fun `when code 404 expect NotFOund handled properly`() = runBlocking {
        assertEquals(interpretHttpErrorByCode(404), ResponseError.NotFound(""))
    }

    @Test
    fun `when code 503 expect ServiceUnavailable handled properly`() = runBlocking {
        assertEquals(interpretHttpErrorByCode(503), ResponseError.ServiceUnavailable(""))
    }

    @Test
    fun `when code 900 expect Unknown handled properly`() = runBlocking {
        assertEquals(interpretHttpErrorByCode(900), ResponseError.Unknown(""))
    }

    @Test
    fun `when code RuntimeException expect Unknown handled properly`() = runBlocking {
        val result = errorHandler.handle(RuntimeException("bla"))
        assertEquals(result, ResponseError.Unknown("bla"))
    }

    private fun interpretHttpErrorByCode(code: Int) = errorHandler.handle(
        HttpException(
            Response.error<Any>(code, ERROR.toResponseBody("plain/text".toMediaTypeOrNull()))
        )
    )
}

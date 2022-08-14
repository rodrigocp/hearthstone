package br.com.rcp.hearthstone.commons.providers

import io.mockk.every
import io.mockk.mockk
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class DefaultStringProviderTest {
    private val provider: StringProvider = mockk()

    @Before
    fun setup() {
        every { provider.getStringResource(any()) } returns ""
    }

    @Test
    fun `when given any int expect empty string`() {
        assertEquals(provider.getStringResource(Int.MAX_VALUE), "")
        assertEquals(provider.getStringResource(Int.MIN_VALUE), "")
    }
}

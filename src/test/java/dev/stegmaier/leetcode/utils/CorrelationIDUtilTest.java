package dev.stegmaier.leetcode.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.time.Instant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CorrelationIDUtilTest {

  private HttpServletRequest request;
  private HttpSession session;

  @BeforeEach
  void setUp() {
    request = Mockito.mock(HttpServletRequest.class);
    session = Mockito.mock(HttpSession.class);

    // Stub the getSession method to return the mock session
    when(request.getSession()).thenReturn(session);
  }

  @Test
  void testGenerateNewCorrelationId() {
    // Set up mock behavior for the HttpServletRequest
    when(session.getAttribute("correlationId")).thenReturn(null);
    when(request.getRemoteAddr()).thenReturn("127.0.0.1");
    when(request.getHeader("User-Agent")).thenReturn("Mozilla/5.0");
    when(request.getHeader("Referer")).thenReturn("http://localhost");

    // Call the method and capture the result
    String correlationId = CorrelationIDUtil.getCorrelationId(request);

    // Assert that the correlation ID contains the expected parts
    String expectedStart = Instant.now().toString().substring(0, 10); // Only compare the date part
    assertEquals(
        expectedStart, correlationId.substring(0, 10)); // Ensure timestamp matches today's date
    assertEquals("127.0.0.1", correlationId.split("-")[3]); // IP address part
    assertEquals("Mozilla/5.0", correlationId.split("-")[4]); // User-Agent part
    assertEquals("http://localhost", correlationId.split("-")[5]); // Referer part
  }

  @Test
  void testReturnExistingCorrelationIdFromHeader() {
    // Set up mock behavior for the HttpServletRequest
    when(session.getAttribute("correlationId")).thenReturn("existing-id");
    when(request.getHeader("X-Correlation-ID")).thenReturn("12345");

    // Call the method and capture the result
    String correlationId = CorrelationIDUtil.getCorrelationId(request);

    // Assert that the returned correlation ID matches the one from the header
    assertEquals("12345", correlationId);
  }
}

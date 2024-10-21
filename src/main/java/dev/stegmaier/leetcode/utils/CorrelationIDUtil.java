package dev.stegmaier.leetcode.utils;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;

import java.time.Instant;

import static org.slf4j.LoggerFactory.getLogger;

public class CorrelationIDUtil {

    private static final Logger log = getLogger(CorrelationIDUtil.class);

    public static String getCorrelationId(HttpServletRequest request) {

        if(request.getSession().getAttribute("correlationId") == null) {
            StringBuilder builder = new StringBuilder();
            String correlationID;

            builder.append(Instant.now().toString())
                    .append('-')
                    .append(request.getRemoteAddr())
                    .append('-')
                    .append(request.getHeader("User-Agent"))
                    .append('-')
                    .append(request.getHeader("Referer"));

            correlationID = builder.toString();

            log.info("Correlation ID not provided by request, generating new correlation ID: {}", correlationID);
            return correlationID;
        }

        log.info("CorrelationId provided by request: {}", request.getHeader("X-Correlation-ID"));
        return request.getHeader("X-Correlation-ID");
    }
}

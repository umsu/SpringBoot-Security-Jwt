package com.suhyun.auth.security.jwt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//오류 예외를 처리를 위해 사용한다.
@Component
public class JwtAuthEntryPoint implements AuthenticationEntryPoint {

  private static final Logger logger = LoggerFactory.getLogger(JwtAuthEntryPoint.class);

  @Override
  public void commence(HttpServletRequest request,
                       HttpServletResponse response,
                       AuthenticationException e)
          throws IOException, ServletException {

    logger.error("Unauthorized error. Message - {}", e.getMessage());
    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Error -> Unauthorized");
  }
}
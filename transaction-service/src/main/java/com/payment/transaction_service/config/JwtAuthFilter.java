package com.payment.transaction_service.config;

import com.payment.transaction_service.config.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String path = request.getRequestURI();
        // Skip login & register endpoints
        if (path.startsWith("/auth")) {
            filterChain.doFilter(request, response);
            return;
        }

        String header = request.getHeader("Authorization");
        if (header == null || !header.startsWith("Bearer ")) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        String token = header.substring(7);
        String username = JwtUtil.extractUsername(token);

        if (username != null && JwtUtil.validateToken(token)) {
            // ✅ Create Authentication object
            UsernamePasswordAuthenticationToken auth =
                    new UsernamePasswordAuthenticationToken(username, null, new ArrayList<>());

            // ✅ Store in SecurityContext
            SecurityContextHolder.getContext().setAuthentication(auth);
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        // Continue request
        filterChain.doFilter(request, response);
    }
}




package eu.openanalytics.containerproxy.auth.impl.keycloak;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.keycloak.adapters.OIDCAuthenticationError;
import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationFailureHandler;
import org.springframework.security.core.AuthenticationException;


import java.io.IOException;

public class AuthenticationFaillureHandler extends KeycloakAuthenticationFailureHandler {

    final public static String SP_KEYCLOAK_ERROR_REASON = "SP_KEYCLOAK_ERROR_REASON";

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {

        // Note: Keycloak calls sendError before this method gets called, therefore we cannot do much with reuqest.
        // We now set a flag in the session indicating the reason of the Keycloak error.
        // The error page can then properly handle this.

        Object obj = request.getAttribute("org.keycloak.adapters.spi.AuthenticationError");
        if (obj instanceof org.keycloak.adapters.OIDCAuthenticationError) {
            OIDCAuthenticationError authError = (OIDCAuthenticationError)  obj;
            request.getSession().setAttribute(SP_KEYCLOAK_ERROR_REASON, authError.getReason());
        }
    }
}

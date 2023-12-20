package com.zufar.icedlatte.email.api;

import com.zufar.icedlatte.email.api.token.TimeTokenCache;
import com.zufar.icedlatte.email.api.token.TokenCache;
import com.zufar.icedlatte.email.api.token.TokenManager;
import com.zufar.icedlatte.email.exception.InvalidTokenException;
import com.zufar.icedlatte.security.api.UserRegistrationService;
import com.zufar.icedlatte.security.dto.ConfirmEmailRequest;
import com.zufar.icedlatte.security.dto.UserRegistrationRequest;
import com.zufar.icedlatte.security.dto.UserRegistrationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailTokenConformer {

    private final UserRegistrationService userRegistrationService;
    private final TokenManager tokenManager;

    public UserRegistrationResponse confirmEmailByCode(ConfirmEmailRequest confirmEmailRequest) {
        UserRegistrationRequest userRegistrationRequest = tokenManager.validateToken(confirmEmailRequest);
        return userRegistrationService.register(userRegistrationRequest);
    }
}

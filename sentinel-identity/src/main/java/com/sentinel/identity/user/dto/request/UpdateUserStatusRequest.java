package com.sentinel.identity.user.dto.request;

import com.sentinel.common.enums.AccountStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UpdateUserStatusRequest {
    @NotNull(message = "Account status is required")
    private AccountStatus status;
}

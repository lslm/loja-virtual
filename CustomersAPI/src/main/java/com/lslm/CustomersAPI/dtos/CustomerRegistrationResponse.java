package com.lslm.CustomersAPI.dtos;

import java.util.UUID;

public record CustomerRegistrationResponse(
        UUID id,
        String name,
        String email
) {
}

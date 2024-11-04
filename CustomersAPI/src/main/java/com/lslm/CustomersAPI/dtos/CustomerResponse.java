package com.lslm.CustomersAPI.dtos;

import java.util.UUID;

public record CustomerResponse(
        UUID id,
        String nome,
        String email
) {
}

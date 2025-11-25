package com.GreenPeak.model;

import java.util.UUID;

public record UserDTO(UUID uuid, String email, String password) {
}

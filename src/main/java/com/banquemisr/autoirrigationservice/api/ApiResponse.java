package com.banquemisr.autoirrigationservice.api;

import lombok.*;

import java.util.Map;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ApiResponse<T> {
    private String message;
    private String debugMessage;
    private Map<String, Set<String>> errors;
    private T response;
}

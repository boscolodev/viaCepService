package com.gbs.apiaddress.api.dto;

import lombok.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ApiError implements Serializable {
    private static final long serialVersionUID = 1L;

    private Instant timestamp;
    private Integer status;
    private String error;
    private String mensage;
    private String path;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApiError apiError = (ApiError) o;
        return Objects.equals(timestamp, apiError.timestamp) && Objects.equals(status, apiError.status) && Objects.equals(error, apiError.error) && Objects.equals(mensage, apiError.mensage) && Objects.equals(path, apiError.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timestamp, status, error, mensage, path);
    }

    @Override
    public String toString() {
        return "ApiError{" +
                "timestamp=" + timestamp +
                ", status=" + status +
                ", error='" + error + '\'' +
                ", mensage='" + mensage + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}

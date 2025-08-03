package com.alura.LiteraArula.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Book (
    @JsonProperty("title") @NotNull String titulo,
    @JsonProperty("authors") @NotNull List<Person> autores,
    @JsonProperty("languages") @NotNull List<String> linguagens,
    @JsonProperty("download_count") @NotNull Integer quantidadeDownloads,
    @JsonProperty("summaries") @NotNull List<String> sumario
) {}

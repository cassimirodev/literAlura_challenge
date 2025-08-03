package com.alura.LiteraArula.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;


@JsonIgnoreProperties(ignoreUnknown = true)
public record Person(
        @JsonProperty ("name") @NotNull String nome,
        @JsonProperty("birth_year") @NotNull Integer anoNascimento,
        @JsonProperty("death_year") @NotNull Integer anoFalecimento
) {}
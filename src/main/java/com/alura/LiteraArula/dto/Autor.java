package com.alura.LiteraArula.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Autor(
        @JsonProperty("name") String nomeAutor,
        @JsonProperty("birth_year") Integer anoNascimento,
        @JsonProperty("death_year") Integer anoFalecimento
) {}
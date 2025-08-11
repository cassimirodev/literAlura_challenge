package com.alura.LiteraAlura.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Book (
    @JsonProperty("title")  String titulo,
    @JsonProperty("languages")  List<String> linguagens,
    @JsonProperty("download_count")  Integer quantidadeDownloads,
    @JsonProperty("summaries")  List<String> sumario,
    @JsonProperty("authors") List<Autor> autor
) {}

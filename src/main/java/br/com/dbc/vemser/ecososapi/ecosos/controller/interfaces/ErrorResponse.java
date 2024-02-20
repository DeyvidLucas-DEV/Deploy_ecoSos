package br.com.dbc.vemser.ecososapi.ecosos.controller.interfaces;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ErrorResponse {
    private String timestamp = "2024-01-28 12:19:40.523872";
    private int status;
    private List<String> errors = Arrays.asList(
            "erro: descrição",
            "erro: descrição"
    );


}

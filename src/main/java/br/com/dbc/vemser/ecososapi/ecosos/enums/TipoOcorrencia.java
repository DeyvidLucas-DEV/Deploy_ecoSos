package br.com.dbc.vemser.ecososapi.ecosos.enums;

public enum TipoOcorrencia {
    QUEIMADA,
    TERREMOTO,
    ENCHENTE,
    DESLIZAMENTO,
    FURACAO,
    TSUNAMI,
    CICLONE;

    public static TipoOcorrencia obterPorNumero(int numero) {
        if (numero >= 1 && numero <= values().length) {
            return values()[numero - 1];
        } else {
            throw new IllegalArgumentException("Número de ocorrência inválido: " + numero);
        }
    }

    public static TipoOcorrencia obterPorNome(String nome) {
        for (TipoOcorrencia ocorrencia : values()) {
            if (ocorrencia.name().equalsIgnoreCase(nome)) {
                return ocorrencia;
            }
        }
        throw new IllegalArgumentException("Ocorrência inválida: " + nome);
    }

}

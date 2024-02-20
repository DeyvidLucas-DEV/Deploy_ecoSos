package br.com.dbc.vemser.ecososapi.ecosos.enums;

public enum TipoRisco {
    BAIXO,
    MEDIO,
    ALTO;

    public static TipoRisco obterPorNumero(int numero) {
        if (numero >= 1 && numero <= values().length) {
            return values()[numero - 1];
        } else {
            throw new IllegalArgumentException("Número de nível de risco inválido: " + numero);
        }
    }

    public static TipoRisco obterPorNome(String risco) {
        for (TipoRisco ocorrencia : values()) {
            if (ocorrencia.name().equalsIgnoreCase(risco)) {
                return ocorrencia;
            }
        }
        throw new IllegalArgumentException("Nível de risco inválido: " + risco);
    }
}
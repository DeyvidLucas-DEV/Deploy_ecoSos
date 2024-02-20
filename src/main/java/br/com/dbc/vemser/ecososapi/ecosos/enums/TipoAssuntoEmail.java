package br.com.dbc.vemser.ecososapi.ecosos.enums;

public enum TipoAssuntoEmail {
    CADASTRO_REALIZADO_COM_SUCESSO("Cadastro Realizado com Sucesso"),
    CADASTRO_ATUALIZADO_COM_SUCESSO("Cadastro Atualizado com Sucesso"),
    REGISTRO_REMOVIDO_DA_BASE_DE_USUARIOS("Registro removido da base de usuários."),
    ENDERECO_CADASTRADO_COM_SUCESSO("Endereco Cadastrado com Sucesso"),
    ENDERECO_REMOVIDO_DA_BASE_DE_USUARIOS("Endereço removido da base de usuários.");
    private final String assunto;

    TipoAssuntoEmail(String assunto) {
        this.assunto = assunto;
    }

    public String getAssunto() {
        return this.assunto;
    }

}
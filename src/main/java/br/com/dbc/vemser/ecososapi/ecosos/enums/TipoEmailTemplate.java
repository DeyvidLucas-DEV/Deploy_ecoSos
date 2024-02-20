package br.com.dbc.vemser.ecososapi.ecosos.enums;


import br.com.dbc.vemser.ecososapi.ecosos.exceptions.RegraDeNegocioException;

public enum TipoEmailTemplate {
    CADASTRO_REALIZADO_COM_SUCESSO("email-register.ftl"),
    CADASTRO_ATUALIZADO_COM_SUCESSO("email-update.ftl"),
    REGISTRO_REMOVIDO_DA_BASE_DE_USUARIOS("email-delete.ftl"),
    ENDERECO_CADASTRADO_COM_SUCESSO("address-register.ftl"),
    ENDERECO_REMOVIDO_DA_BASE_DE_USUARIOS("address-delete.ftl");

    private final String template;

    TipoEmailTemplate(String template) {
        this.template = template;
    }

    public String getTemplate() {
        return this.template;
    }
    public static TipoEmailTemplate ofTemplate (String template) throws Exception{
        for (TipoEmailTemplate tipo : values()) {
            if (tipo.template.equals(template)) {
                return tipo;
            }
        }
        throw new RegraDeNegocioException("Template não encontrado");
    }
}
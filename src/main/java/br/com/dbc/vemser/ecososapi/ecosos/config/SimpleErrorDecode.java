package br.com.dbc.vemser.ecososapi.ecosos.config;

import br.com.dbc.vemser.ecososapi.ecosos.exceptions.RegraDeNegocioException;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.rmi.UnexpectedException;

public class SimpleErrorDecode implements ErrorDecoder {

    private static final Logger logger = LoggerFactory.getLogger(SimpleErrorDecode.class);

    @Override
    public Exception decode(String methodKey, Response response) {
        Response.Body body = response.body();
        if (body == null) {
            return new UnexpectedException("Erro inesperado");
        }

        try {
            String bodyString = IOUtils.toString(body.asInputStream());
            switch (response.status()) {
                case 400:
                    return new RegraDeNegocioException(bodyString);
                default:
                    logger.error("Erro genérico: {}", bodyString);
                    return new Exception("Erro genérico");
            }
        } catch (IOException e) {
            logger.error("Erro ao processar resposta: {}", e.getMessage());
            return e;
        }
    }
}
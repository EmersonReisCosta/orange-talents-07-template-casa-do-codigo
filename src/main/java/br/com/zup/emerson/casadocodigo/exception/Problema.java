package br.com.zup.emerson.casadocodigo.exception;

public class Problema {

    private String campo;

    private String erro;

    public Problema(String campo, String erro) {
        this.campo = campo;
        this.erro = erro;
    }

    public String getCampo() {
        return campo;
    }

    public String getErro() {
        return erro;
    }

}
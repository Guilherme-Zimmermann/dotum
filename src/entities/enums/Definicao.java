package src.entities.enums;

public enum Definicao {
    
    Pagar(0),
    Receber(1);

    private int code;

    private Definicao(int code){
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static Definicao valueOf(int code){
        for (Definicao value : Definicao.values()){
            if (value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Código de definição inválido!");
    }
}

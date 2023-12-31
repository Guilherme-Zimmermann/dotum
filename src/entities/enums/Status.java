package src.entities.enums;

public enum Status {
    
    PAGO(0),
    PENDENTE(1);

    private int code;

    public int getCode() {
        return code;
    }

    private Status(int code){
        this.code = code;
    }

    public static Status valueOf(int code){
        for (Status value : Status.values()){
            if (value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Código de status inválido");
    }
}

package src.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

import src.entities.enums.Definicao;
import src.entities.enums.Status;

public class Conta {

    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    private static int nextId = 1;
    private Integer id;     // Id da conta
    private Definicao definicao;   // Definir se a conta é para receber ou pagar
    private Double valor;   // Valor da conta
    private String descricao;   // Descrição da conta
    private Date dataDeVencimento; // Data de vencimento da conta
    private Status status;  // Status da conta (Pago / Pendente)

    public Conta(){
    }

    public Conta(Definicao definicao, Double valor, String descricao, Date dataDeVencimento, Status status) {
        this.id = nextId++;
        this.definicao = definicao;
        this.valor = valor;
        this.descricao = descricao;
        this.dataDeVencimento = dataDeVencimento;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Definicao getDefinicao() {
        return definicao;
    }

    public void setDefinicao(Definicao definicao) {
        this.definicao = definicao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataDeVencimento() {
        return dataDeVencimento;
    }

    public void setDataDeVencimento(Date dataDeVencimento) {
        this.dataDeVencimento = dataDeVencimento;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString(){
        return getId() + " | "+ getDefinicao() + " | " + getValor() + " | " + sdf.format(getDataDeVencimento()) + " | " + getStatus();
    }
}

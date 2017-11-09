package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "parcela")
public class Parcela implements Serializable {

    @EmbeddedId
    private ParcelaId parcelaId;

    @NotNull(message = "O valor deve ser informado")
    @Min(value = 0, message = "O valor não pode ser negativo")
    @Column(name = "valor", nullable = false, columnDefinition = "decimal(12,2)")
    private Double valor;

    @NotNull(message = "O vencimento não pode ser nulo")
    @Temporal(TemporalType.DATE)
    @Column(name = "vencimento", nullable = false)
    private Calendar vencimento;

    @Min(value = 0, message = "O valor do pagamento não pode ser negativo")
    @Column(name = "valor_pagamento", columnDefinition = "decimal(12,2)")
    private Double valorPagamento;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_pagamento")
    private Calendar dataPagamento;

    public Parcela() {
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.parcelaId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Parcela other = (Parcela) obj;
        if (!Objects.equals(this.parcelaId, other.parcelaId)) {
            return false;
        }
        return true;
    }

    public ParcelaId getParcelaId() {
        return parcelaId;
    }

    public void setParcelaId(ParcelaId parcelaId) {
        this.parcelaId = parcelaId;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Calendar getVencimento() {
        return vencimento;
    }

    public void setVencimento(Calendar vencimento) {
        this.vencimento = vencimento;
    }

    public Double getValorPagamento() {
        return valorPagamento;
    }

    public void setValorPagamento(Double valorPagamento) {
        this.valorPagamento = valorPagamento;
    }

    public Calendar getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Calendar dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

}

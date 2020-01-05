package br.com.orcamentofamiliar

import br.com.orcamentofamiliar.enums.TipoDeItemDeOrcamento

import java.time.LocalDate
import java.time.Month

class ItemDeOrcamento {

    String descricao
    Month mes
    TipoDeItemDeOrcamento tipo
    BigDecimal valorEstimado
    boolean pago
    BigDecimal valorPago
    LocalDate dataPagamento

    static belongsTo = [
            orcamento: Orcamento
    ]

    static constraints = {
    }
}

package br.com.orcamentofamiliar

import grails.gorm.services.Service

@Service(ItemDeOrcamento)
interface ItemDeOrcamentoService {

    ItemDeOrcamento get(Serializable id)

    List<ItemDeOrcamento> list(Map args)

    Long count()

    void delete(Serializable id)

    ItemDeOrcamento save(ItemDeOrcamento itemDeOrcamento)

}
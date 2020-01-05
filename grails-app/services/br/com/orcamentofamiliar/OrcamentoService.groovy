package br.com.orcamentofamiliar

import grails.gorm.services.Service

@Service(Orcamento)
interface OrcamentoService {

    Orcamento get(Serializable id)

    List<Orcamento> list(Map args)

    Long count()

    void delete(Serializable id)

    Orcamento save(Orcamento orcamento)

}
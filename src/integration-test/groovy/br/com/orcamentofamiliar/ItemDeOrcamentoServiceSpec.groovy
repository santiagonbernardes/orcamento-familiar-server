package br.com.orcamentofamiliar

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ItemDeOrcamentoServiceSpec extends Specification {

    ItemDeOrcamentoService itemDeOrcamentoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new ItemDeOrcamento(...).save(flush: true, failOnError: true)
        //new ItemDeOrcamento(...).save(flush: true, failOnError: true)
        //ItemDeOrcamento itemDeOrcamento = new ItemDeOrcamento(...).save(flush: true, failOnError: true)
        //new ItemDeOrcamento(...).save(flush: true, failOnError: true)
        //new ItemDeOrcamento(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //itemDeOrcamento.id
    }

    void "test get"() {
        setupData()

        expect:
        itemDeOrcamentoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<ItemDeOrcamento> itemDeOrcamentoList = itemDeOrcamentoService.list(max: 2, offset: 2)

        then:
        itemDeOrcamentoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        itemDeOrcamentoService.count() == 5
    }

    void "test delete"() {
        Long itemDeOrcamentoId = setupData()

        expect:
        itemDeOrcamentoService.count() == 5

        when:
        itemDeOrcamentoService.delete(itemDeOrcamentoId)
        sessionFactory.currentSession.flush()

        then:
        itemDeOrcamentoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        ItemDeOrcamento itemDeOrcamento = new ItemDeOrcamento()
        itemDeOrcamentoService.save(itemDeOrcamento)

        then:
        itemDeOrcamento.id != null
    }
}

package br.com.orcamentofamiliar

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.NO_CONTENT
import static org.springframework.http.HttpStatus.OK
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY

import grails.gorm.transactions.ReadOnly
import grails.gorm.transactions.Transactional

@ReadOnly
class ItemDeOrcamentoController {

    ItemDeOrcamentoService itemDeOrcamentoService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond itemDeOrcamentoService.list(params), model:[itemDeOrcamentoCount: itemDeOrcamentoService.count()]
    }

    def show(Long id) {
        respond itemDeOrcamentoService.get(id)
    }

    @Transactional
    def save(ItemDeOrcamento itemDeOrcamento) {
        if (itemDeOrcamento == null) {
            render status: NOT_FOUND
            return
        }
        if (itemDeOrcamento.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond itemDeOrcamento.errors
            return
        }

        try {
            itemDeOrcamentoService.save(itemDeOrcamento)
        } catch (ValidationException e) {
            respond itemDeOrcamento.errors
            return
        }

        respond itemDeOrcamento, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(ItemDeOrcamento itemDeOrcamento) {
        if (itemDeOrcamento == null) {
            render status: NOT_FOUND
            return
        }
        if (itemDeOrcamento.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond itemDeOrcamento.errors
            return
        }

        try {
            itemDeOrcamentoService.save(itemDeOrcamento)
        } catch (ValidationException e) {
            respond itemDeOrcamento.errors
            return
        }

        respond itemDeOrcamento, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        itemDeOrcamentoService.delete(id)

        render status: NO_CONTENT
    }
}

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
class OrcamentoController {

    OrcamentoService orcamentoService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond orcamentoService.list(params), model:[orcamentoCount: orcamentoService.count()]
    }

    def show(Long id) {
        respond orcamentoService.get(id)
    }

    @Transactional
    def save(Orcamento orcamento) {
        if (orcamento == null) {
            render status: NOT_FOUND
            return
        }
        if (orcamento.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond orcamento.errors
            return
        }

        try {
            orcamentoService.save(orcamento)
        } catch (ValidationException e) {
            respond orcamento.errors
            return
        }

        respond orcamento, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(Orcamento orcamento) {
        if (orcamento == null) {
            render status: NOT_FOUND
            return
        }
        if (orcamento.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond orcamento.errors
            return
        }

        try {
            orcamentoService.save(orcamento)
        } catch (ValidationException e) {
            respond orcamento.errors
            return
        }

        respond orcamento, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        orcamentoService.delete(id)

        render status: NO_CONTENT
    }
}

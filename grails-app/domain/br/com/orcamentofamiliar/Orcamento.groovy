package br.com.orcamentofamiliar

import java.time.Year

class Orcamento {

    Year ano

	static hasMany = [
			itens: ItemDeOrcamento
	]

	static constraints = {
	}
}

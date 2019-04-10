package br.unisinos;

import java.io.IOException;

public class HillClimbing {

	public static final int INTERACOES = 100;

	public Rota menorCaminho(Rota rotaAtual) throws IOException {
		Rota rotaAdjacente;
		int contador = 0;
		String comparaRotas = null;
		while (contador < INTERACOES) {
			//Atualiza Adjacente
			rotaAdjacente = obtemRotaAdjacente(new Rota(rotaAtual));
			//Compara Distancia
			if (rotaAdjacente.getDistanciaTotal() <= rotaAtual.getDistanciaTotal()) {
				comparaRotas = " Rota melhorada";
				rotaAtual.gravaLog(rotaAtual + " |      "+ rotaAtual.getTotalStringDistance());
				//Reinicia Contador
				contador = 0;
				rotaAtual = new Rota(rotaAdjacente);
			} else
				comparaRotas = " - interação # " + contador++;
			System.out.println("       | " + comparaRotas);
			System.out.print(rotaAtual + " |      " + rotaAtual.getTotalStringDistance());
		}
		if (contador == INTERACOES)
			System.out.println("       | Melhor interação");
		else
			System.out.println("     | " + comparaRotas);
		return rotaAtual;
	}

	private Rota obtemRotaAdjacente(Rota route) throws IOException {
		int x1 = 0, x2 = 0;
		while (x1 == x2) {
			x1 = (int) (route.getCidades().size() * Math.random());
			x2 = (int) (route.getCidades().size() * Math.random());
		}
		Cidade city1 = route.getCidades().get(x1);
		Cidade city2 = route.getCidades().get(x2);
		route.getCidades().set(x2, city1);
		route.getCidades().set(x1, city2);
		//System.out.println("   x1 = " + x1 + "    x2 = " + x2 + " " + route.getTotalDistance());
		//route.gravaLog(route + " |      "+ route.getTotalStringDistance());
		return route;
	}
}

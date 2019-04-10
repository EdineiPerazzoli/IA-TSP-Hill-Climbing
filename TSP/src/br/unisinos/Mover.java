package br.unisinos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Mover {

	ReadFile rf = new ReadFile();
	ArrayList<Cidade> inicializaCidades = rf.mapa();

	public static void main(String[] args) throws IOException {
		Mover driver = new Mover();
		Rota route = new Rota(driver.inicializaCidades);
		printHeading(route);
		System.out.println(route + " |      " + route.getTotalStringDistance());

		new HillClimbing().menorCaminho(route);
	}

	public static void printHeading(Rota rota) {
		String cabecalho1 = "Route";
		String cabecalho2 = "Distancia () | Compara adjacente com rota atual";
		int tamanhoCidade = 0;
		for (int x = 0; x < rota.getCidades().size(); x++)
			tamanhoCidade += rota.getCidades().get(x).getId().length();
		int arrayLength = tamanhoCidade + rota.getCidades().size() * 2;
		int partialLength = (arrayLength - cabecalho1.length()) / 2;
		for (int x = 0; x < partialLength; x++)
			System.out.print(" ");
		System.out.print(cabecalho1);
		for (int x = 0; x < partialLength; x++)
			System.out.print(" ");
		if ((arrayLength % 2) == 0)
			System.out.print(" ");
		System.out.println(" | " + cabecalho2);
		tamanhoCidade += cabecalho2.length() + 3;
		for (int x = 0; x < tamanhoCidade + rota.getCidades().size() * 2; x++)
			System.out.println("-");
		System.out.println("");
	}
}

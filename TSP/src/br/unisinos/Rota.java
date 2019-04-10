package br.unisinos;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Rota {
	private ArrayList<Cidade> cidades = new ArrayList<Cidade>();

	public Rota(ArrayList<Cidade> cities) {
		this.cidades.addAll(cities);
		Collections.shuffle(this.cidades);
	}

	public Rota(Rota route) {
		route.cidades.stream().forEach(x -> cidades.add(x));
	}

	public ArrayList<Cidade> getCidades() {
		return cidades;
	}

	public double getDistanciaTotal() {
		int citiesSize = this.cidades.size();
		return this.cidades.stream().mapToDouble(x -> {
			int cityIndex = this.cidades.indexOf(x);
			double returnValue = 0;
			if (cityIndex < citiesSize - 1)
				returnValue = x.distanciaEntreCidade(this.cidades.get(cityIndex + 1));
			return returnValue;
		}).sum() + this.cidades.get(citiesSize - 1).distanciaEntreCidade(this.cidades.get(0));
	}

	public String getTotalStringDistance() {
		String returnValue = String.format("%.0f", this.getDistanciaTotal());
		if (returnValue.length() == 7)
			returnValue = " " + returnValue;
		return returnValue;
	}

	public String toString() {
		return Arrays.toString(cidades.toArray());
	}

	public void gravaLog(String log) throws IOException {
		FileWriter arq = new FileWriter("C:\\Users\\Edinei\\OneDrive\\Unisinos\\IA\\TSP\\log.txt");
		PrintWriter gravarArq = new PrintWriter(arq);
		gravarArq.printf(log);
		try {
			arq.flush();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

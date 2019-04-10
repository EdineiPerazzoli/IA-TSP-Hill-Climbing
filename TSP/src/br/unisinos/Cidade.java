package br.unisinos;

public class Cidade {
	private String Id;
	private double y;
	private double x;
	
	public Cidade(String id, double x, double y) {
		this.Id = id;
		this.y = y;
		this.x = x;
	}

	public String getId() {
		return Id;
	}

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

	public double distanciaEntreCidade(Cidade city) {
		double deltaY = city.getY() - this.getY();
		double deltaX = city.getX() - this.getX();
		double a = Math.sqrt(Math.pow(deltaY,2) + Math.pow(deltaX, 2));
		return a;
	}

	@Override
	public String toString() {
		return Id;
	}
}

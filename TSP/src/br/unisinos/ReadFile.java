package br.unisinos;
import java.io.*;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.plaf.FileChooserUI;
public class ReadFile{
	
	public ArrayList<Cidade> mapa(){
		ArrayList<Cidade> loadCity = new ArrayList<>();
		String dados[];
		try{
			String nome;
			
			nome = "C:\\Users\\Edinei\\OneDrive\\Unisinos\\IA\\TSP\\berlin52_tsp.txt";
			BufferedReader br = new BufferedReader(new FileReader(nome));
			while(br.ready()){
				String linha = br.readLine();
				dados = linha.split(" ");
				String name = dados[0];
				double lat = Double.parseDouble(dados[1]);
				double lon = Double.parseDouble(dados[2]);
				loadCity.add(new Cidade(name, lat, lon));
				//System.out.println(lat);
				//System.out.println(loadCity.toString());
			}
			br.close();
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
		return loadCity; 
		
   } 
	public void gravaLog(String log) throws IOException {
	    FileWriter arq = new FileWriter("C:\\Users\\Edinei\\OneDrive\\Unisinos\\IA\\TSP\\log.txt");
	    PrintWriter gravarArq = new PrintWriter(arq);
	    gravarArq.printf(log);
	    try {
			arq.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	 
}
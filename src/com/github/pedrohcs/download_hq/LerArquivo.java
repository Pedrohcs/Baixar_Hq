package com.github.pedrohcs.download_hq;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LerArquivo {
	
	private int tamanho;
	private String nomeArquivo = "Paginas_Hq.txt";
	private String linha = "";
	private String delimitador = ",";
	private String[] paginas = new String[tamanho];
	private int contador;
	private String prefixoUrl = "https://hqbr.com.br";

	
	public LerArquivo(int tamanho) {
		this.tamanho = tamanho;
	}
	
	public void lerArquivo() throws FileNotFoundException {
		File arquivo = new File(this.nomeArquivo);
		try {
	        FileReader fileReader = new FileReader(arquivo);
	        BufferedReader bufferedReader = new BufferedReader(fileReader);
	        this.linha = bufferedReader.readLine();
	        this.paginas = linha.split(this.delimitador);
	        this.contador = 0;
	        while (contador < this.tamanho) {
	        	this.paginas[contador] = paginas[contador].replaceAll("\"", "");
	        	this.paginas[contador] = this.prefixoUrl + paginas[contador];
	        	contador ++;
	        }
	        fileReader.close();
	        bufferedReader.close();
		} catch (IOException e) {
	    	e.printStackTrace();
	    }
	}
	
	public int getTamanho() {
		return this.tamanho;
	}
	
	public String  getPagina(int num) {
		return this.paginas[num];
	}
	
	public String [] getPaginas() {
		return this.paginas;
	}

}

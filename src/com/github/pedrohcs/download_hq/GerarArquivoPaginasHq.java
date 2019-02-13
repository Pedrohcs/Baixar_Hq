package com.github.pedrohcs.download_hq;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GerarArquivoPaginasHq {
	private String paginas;
	private String comparacaoPaginas = "pages = [";
	
	public void lerArquivo(String nomeArquivoHtml) throws IOException {
		try {
		      FileReader arquivoHtml = new FileReader(nomeArquivoHtml);
		      BufferedReader lerArquivoHtml = new BufferedReader(arquivoHtml);
		      String linha = lerArquivoHtml.readLine(); 
		      while (linha != null) {
		    	  if (linha.contains(this.comparacaoPaginas)) {
		    		  this.paginas = linha;
		    	  }	 
		    	  linha = lerArquivoHtml.readLine();
		      }
		      arquivoHtml.close();
		    } catch (IOException e) {
		        System.err.printf("Erro na abertura do arquivo: %s.\n",
		          e.getMessage());
		    }
		    FileWriter arquivoPaginas = new FileWriter("Paginas_Hq.txt");
		    PrintWriter gravarArquivoPaginas = new PrintWriter(arquivoPaginas);
		    paginas = paginas.replace("      pages = [", "");
		    paginas = paginas.replace("]", "");
		    gravarArquivoPaginas.printf(paginas);
		    arquivoPaginas.close();
		    System.out.println();
	}
	
	
}


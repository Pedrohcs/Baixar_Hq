import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CapturaNumPaginas {
	private String comparacaoNumPaginas = "<option value=";
	private int numPaginas;
	private String numPg;
	private Pattern pat = Pattern.compile("> (\\d\\d) <");
	
	public void setNumPagina(String nomeArquivoHtml) {
		try {
		      FileReader arquivoHtml = new FileReader(nomeArquivoHtml);
		      BufferedReader lerArquivoHtml = new BufferedReader(arquivoHtml);
		      String linha = lerArquivoHtml.readLine(); 
		      while (linha != null) {
		    	  if (linha.contains(this.comparacaoNumPaginas)) {
		    		  this.numPg = linha;
		    	  }	 
		    	  linha = lerArquivoHtml.readLine();
		      }
		      arquivoHtml.close();
		    } catch (IOException e) {
		        System.err.printf("Erro na abertura do arquivo: %s.\n",
		          e.getMessage());
		    }
			
		
		Matcher mat = this.pat.matcher(numPg);
		if(mat.find()) {
			this.numPaginas = Integer.parseInt(mat.group(1));
		}
	}
	
	public int getNumPagina() {
		return this.numPaginas;
	}
	

}

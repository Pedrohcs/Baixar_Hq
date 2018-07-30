import java.io.File;

public class Diretorio {
	
	private int contador;
	private String nomePasta;
	private String [] nomeArquivo;
	private String urlPadraoPagina = "https://hqbr.com.br/hqs/uploads/picture/image/";
	
	public Diretorio(int tamanho) {
		this.nomeArquivo = new String [tamanho];
	}
	
	private void setNomePasta(String pagina) {
		this.nomePasta = pagina.replace(this.urlPadraoPagina, "");
		this.nomePasta = nomePasta.replaceAll("/", " - ");
		this.nomePasta = nomePasta.replace(".jpg", "");

	}
	
	public String criacaoRepositorio(String pagina, String nomeDiretorio) {
		setNomePasta(pagina);
		File diretorio = new File(nomeDiretorio);
		if (!diretorio.exists()) {
		   diretorio.mkdir();
		   return "Diretorio Criado";
		} else {
		   return "Diretório já existente";
		}
	}
	
	public String getNomePasta() {
		return this.nomePasta;
	}
	
	
	public void setNomeArquivo(int tamanho, String nomeDiretorio) {
		this.contador = 0;
		while (contador < tamanho) {
			if ((contador >= 10) && (contador < 100)) {
				nomeArquivo[contador] = nomeDiretorio + "\\" + this.nomePasta+" #0"+contador+".jpg";
			}
			else if (contador >= 100) {
				nomeArquivo[contador] = nomeDiretorio + "\\" + this.nomePasta+" #"+contador+".jpg";
			}
			else {
				nomeArquivo[contador] = nomeDiretorio + "\\" + this.nomePasta+" #00"+contador+".jpg";
			}
			contador ++;
		}
	}
	
	public String getNomeArquivo(int num) {
		return nomeArquivo[num];
	}
	
	public String [] getNomeArquivos() {
		return this.nomeArquivo;
	}
	

}


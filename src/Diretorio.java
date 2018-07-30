import java.io.File;

public class Diretorio {
	
	private int contador;
	private String nomePasta;
	private String [] nomeArquivo;
	private String caminhoPasta;
	private String urlPadraoPagina = "https://hqbr.com.br/hqs/uploads/picture/image/";
	private String caminhoPadraoPasta = "C:\\Users\\pedro\\eclipse-workspace\\Baixar_Hq\\";
	
	public Diretorio(int tamanho) {
		this.nomeArquivo = new String [tamanho];
	}
	
	private void setNomePasta(String pagina) {
		this.nomePasta = pagina.replace(this.urlPadraoPagina, "");
		this.nomePasta = nomePasta.replaceAll("/", " - ");
		this.nomePasta = nomePasta.replace(".jpg", "");
		setCaminhoPasta();
	}
	
	private void setCaminhoPasta() {
		this.caminhoPasta = this.caminhoPadraoPasta + this.nomePasta;
	}
	
	public String criacaoRepositorio(String pagina) {
		setNomePasta(pagina);
		setCaminhoPasta();
		File diretorio = new File(caminhoPasta);
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
	
	public String getCaminhoPasta() {
		return this.caminhoPasta;
	}
	
	public void setNomeArquivo(int tamanho) {
		this.contador = 0;
		while (contador < tamanho) {
			if ((contador >= 10) && (contador < 100)) {
				nomeArquivo[contador] = this.caminhoPasta+"\\"+this.nomePasta+" #0"+contador+".jpg";
			}
			else if (contador >= 100) {
				nomeArquivo[contador] = this.caminhoPasta+"\\"+this.nomePasta+" #"+contador+".jpg";
			}
			else {
				nomeArquivo[contador] = this.caminhoPasta+"\\"+this.nomePasta+" #00"+contador+".jpg";
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


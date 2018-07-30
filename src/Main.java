import java.io.IOException;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) throws IOException {
		
		String nome;
		
		nome = JOptionPane.showInputDialog("Digite a url da HQ");
		
		CapturaHtml captura = new CapturaHtml(nome);
		
		captura.capHtml();
		
		GerarArquivoPaginasHq arquivo = new GerarArquivoPaginasHq();
		
		arquivo.lerArquivo(captura.getNomeArquivoHtml());
		
		CapturaNumPaginas capturaNum = new CapturaNumPaginas();
		
		capturaNum.setNumPagina(captura.getNomeArquivoHtml());
		
		int numPgs;
		
		numPgs = capturaNum.getNumPagina();
		
		LerArquivo leitor = new LerArquivo(numPgs);
		
		leitor.lerArquivo();
		
		Diretorio diretorio = new Diretorio(leitor.getPaginas().length);
		
		diretorio.criacaoRepositorio(leitor.getPagina(0));
		
		diretorio.setNomeArquivo(leitor.getPaginas().length);
		
		Download conexao = new Download();
		
		conexao.download(leitor.getPaginas().length, leitor.getPaginas(), diretorio.getNomeArquivos());
		
	}

}

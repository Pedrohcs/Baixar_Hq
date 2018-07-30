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
		
		String nomeDiretorio;
		
		nomeDiretorio = JOptionPane.showInputDialog("Digite o nome do diretorio");
		
		Diretorio diretorio = new Diretorio(leitor.getPaginas().length);
		
		diretorio.criacaoRepositorio(leitor.getPagina(0), nomeDiretorio);
		
		diretorio.setNomeArquivo(leitor.getPaginas().length, nomeDiretorio);
		
		Download conexao = new Download();
		
		conexao.download(leitor.getPaginas().length, leitor.getPaginas(), diretorio.getNomeArquivos());
		
		JOptionPane.showMessageDialog(null, "Download finalizado");
		
	}

}

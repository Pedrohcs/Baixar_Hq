import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class CapturaHtml {
	
	private String nomeArquivoHtml = "HTML_Pagina.txt";
	private String nomeUrl;
	
	public CapturaHtml(String nome) {
		this.nomeUrl = nome;
	}
	
	public void capHtml() {
		URL url = null;
        File file = new File(this.nomeArquivoHtml);
        try {
        	System.setProperty("http.agent", "Chrome");
            url = new URL(this.nomeUrl);
            this.lerPagina(url, file);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	public void lerPagina(URL url, File file) throws IOException {
		BufferedReader in =
            new BufferedReader(new InputStreamReader(url.openStream()));

		BufferedWriter out = new BufferedWriter(new FileWriter(file));

	    String inputLine;
	
	    while ((inputLine = in.readLine()) != null) {
	        out.write(inputLine);
	        out.newLine();
	    }

	    in.close();
	    out.flush();
	    out.close();
	}
	
	public String getNomeArquivoHtml() {
		return this.nomeArquivoHtml;
	}

}

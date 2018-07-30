import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class Download {
	
	private int contador;
	
	public void download(int num, String [] paginas, String [] arquivos) {
		while (contador < num) {
			try {
				// 1MB de buffer
				final int BUFFER_SIZE = 1024 * 1024;
				System.setProperty("http.agent", "Chrome");
				URL url = new URL(paginas[contador]);
				BufferedInputStream stream = new BufferedInputStream(
					url.openStream(), BUFFER_SIZE);
				BufferedOutputStream fos = new BufferedOutputStream(
					new FileOutputStream(arquivos[contador]));
				byte buf[] = new byte[BUFFER_SIZE];
				int numBytesRead;
				do {
					numBytesRead = stream.read(buf);
					if (numBytesRead > 0) {
						fos.write(buf, 0, numBytesRead);
					}
				} while (numBytesRead > 0);
				fos.flush();
				fos.close();
				stream.close();
				buf = null;
				}	
			 	catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				}
				catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
				contador ++;
		}
	}

}

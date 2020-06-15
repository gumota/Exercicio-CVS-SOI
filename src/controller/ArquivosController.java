package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ArquivosController implements IArquivosController {

	public ArquivosController() {
		super();
	}

	@Override
	public void createFile(String path, String nome, String texto) throws IOException {

		boolean existe;
		File dir = new File(path);
		File arq = new File(path, nome);

		if (dir.exists() && dir.isDirectory()) {
			existe = false;
			if (arq.exists()) {
				existe = true;
			}
			FileWriter fileWriter = new FileWriter(arq, existe);
			PrintWriter print = new PrintWriter(fileWriter);
			print.write(texto);
			print.flush();
			print.close();
			fileWriter.close();
		} else {

			throw new IOException("Diretório inválido, ou seja, não existe ou não é diretório");

		}
	}

	@Override
	public String readFile(String path, String nome) throws IOException {

		File arq = new File(path, nome);
		if (arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			String texto = "";
			while (linha != null) {
				System.out.println(linha);
				texto += linha;
				linha = buffer.readLine();

			}
			buffer.close();
			leitor.close();
			fluxo.close();
			return texto;
		} else {
			throw new IOException("Arquivo inválido");

		}
	}

}
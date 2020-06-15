package view;

import java.io.IOException;

import controller.ArquivosController;
import controller.IArquivosController;

public class Principal {
	public static void main(String[] args) {

		IArquivosController arqCont = new ArquivosController();

		String path = "C:\\Users\\gustavomota\\Desktop\\Arquivos Java";
		String nameArqRead = "relatorio.txt";
		String nameArqCreate = "relatorio.cvs";
		
		try {
			String texto = arqCont.readFile(path, nameArqRead);
			arqCont.createFile(path, nameArqCreate, texto);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

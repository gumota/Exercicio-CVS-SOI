  
package controller;

import java.io.IOException;

public interface IArquivosController {

	public void createFile(String path, String nome, String texto)throws IOException;
	public String readFile(String path, String nome)throws IOException;
	
}
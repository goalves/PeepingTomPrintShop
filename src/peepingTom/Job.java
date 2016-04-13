package peepingTom;

/*
 * Classe Job: exemplo de modelo enviado pelo cliente para o servidor, 
 * cont�m somente o nome do trabalho para ser enviado para testes de execu��o.
 */
public class Job {
	private String data;
	
	/*
	 * Construtor da classe
	 */
	public Job(String data){
		this.data = data;
	}
	
	public String getData()
	{
		return data;
	}

}
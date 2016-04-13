package peepingTom;

import java.util.ArrayList;

/*
 * Classe JobsPackage: classe serve como compactação de Jobs para criação de uma fila
 */
public class JobsPackage {
	private Integer maximumSize;
	private ArrayList<Job> jobsList;

	/*
	 * Construtor da classe
	 */
	public JobsPackage(int size)
	{
		this.maximumSize = size;
		this.jobsList = new ArrayList<Job>();
	}
	
	/*
	 * Adiciona Job a um pacote. Função sem nenhum código voltado para processamento paralelo visto que todo ele
	 * será adicionado nas outras funções na classe PrinterManager
	 */
	
	public boolean addJobToPackage(Job job) throws InterruptedException
	{
        if (jobsList.size() < maximumSize) {
            jobsList.add(job);
            return true;
        } else {
            return false;
        }
	}
	
	/*
	 * Método para pegar os dados atuais e limpar a lista de jobs;
	 * */
	public synchronized ArrayList<Job> clearJobList()
	{
        ArrayList<Job> list = jobsList;
        this.jobsList = new ArrayList<>(maximumSize);
        
        return list;
	}
	
	/*
	 * Método para pegar a lista de jobs atual (precisa ser synchronized ou chamada de métodos que estão bounded por synchronized)
	 */
	public synchronized ArrayList<Job> getJobsList() {
		return this.jobsList;
	}

	/*
	 * Função que verifica se o pacote já está cheio (também precisa ser synchronized para não gerar race-conditions)
	 */
	public synchronized boolean isPackageFull()
	{
		if(this.maximumSize.equals(this.jobsList.size()))
		{
			return true;
		}
		return false;
	}
	
	public int getSize() {
		return maximumSize;
	}
	
	public void setSize(int size)
	{
		this.maximumSize = size;
	}
	

}

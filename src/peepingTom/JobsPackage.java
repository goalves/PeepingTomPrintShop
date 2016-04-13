package peepingTom;

import java.util.ArrayList;

/*
 * Classe JobsPackage: classe serve como compacta��o de Jobs para cria��o de uma fila
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
	 * Adiciona Job a um pacote. Fun��o sem nenhum c�digo voltado para processamento paralelo visto que todo ele
	 * ser� adicionado nas outras fun��es na classe PrinterManager
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
	 * M�todo para pegar os dados atuais e limpar a lista de jobs;
	 * */
	public synchronized ArrayList<Job> clearJobList()
	{
        ArrayList<Job> list = jobsList;
        this.jobsList = new ArrayList<>(maximumSize);
        
        return list;
	}
	
	/*
	 * M�todo para pegar a lista de jobs atual (precisa ser synchronized ou chamada de m�todos que est�o bounded por synchronized)
	 */
	public synchronized ArrayList<Job> getJobsList() {
		return this.jobsList;
	}

	/*
	 * Fun��o que verifica se o pacote j� est� cheio (tamb�m precisa ser synchronized para n�o gerar race-conditions)
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

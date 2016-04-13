package peepingTom;

public class Printer {
	private int printerLimit;
	
	/*
	 * Construtor da classe
	 */
	public Printer(int printerLimit)
	{
		this.printerLimit = printerLimit;
	}
	
	/*
	 * Função de Impressão da impressora, utilizando o wait time de 5 segundos como está na definição do trabalho
	 */
	public boolean print(JobsPackage jPackage) throws InterruptedException
	{
		if (isFinished())
			return false;
		for(Job j : jPackage.getJobsList())
			System.out.println("Imprinindo " + j.getData());
		Thread.sleep(5000);
		printerLimit--;
		return true;
	}

	/*
	 * Função que verifica se a impressora chegou ao seu limite de impressão
	 */
	public boolean isFinished()
	{
		if (printerLimit == 0)
			return true;
		else 
			return false;
	}
}

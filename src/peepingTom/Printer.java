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
	 * Fun��o de Impress�o da impressora, utilizando o wait time de 5 segundos como est� na defini��o do trabalho
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
	 * Fun��o que verifica se a impressora chegou ao seu limite de impress�o
	 */
	public boolean isFinished()
	{
		if (printerLimit == 0)
			return true;
		else 
			return false;
	}
}

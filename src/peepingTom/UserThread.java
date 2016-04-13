package peepingTom;

public class UserThread extends Thread {
	private Job job;
	private PrinterManager printerManager;
	
	public UserThread(Job job, PrinterManager pManager)
	{
		this.job = job;
		this.printerManager = pManager;
	}
	
	/*
	 * Thread do usu�rio pega o seu modelo de cart�o (job) e envia pro servidor da impressora,
	 * tanto faz se ele criou o pacote ou n�o. Por�m a cria��o do pacote � feita em um "servidor"
	 * no meio do caminho. Deixei isso rodando na fun��o PrinterManager pois � mais "racional"
	 * 
	 * Ap�s pedir a cria��o do pacote ele pede a impress�o do seu documento, que s� � feito quando a lista termina;
	 * */
    public void run() {   
    	try {
    		while(!printerManager.getPrinter().isFinished())
    		{
    			printerManager.addToPackage(job);
    		}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
}
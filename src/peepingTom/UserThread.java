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
	 * Thread do usuário pega o seu modelo de cartão (job) e envia pro servidor da impressora,
	 * tanto faz se ele criou o pacote ou não. Porém a criação do pacote é feita em um "servidor"
	 * no meio do caminho. Deixei isso rodando na função PrinterManager pois é mais "racional"
	 * 
	 * Após pedir a criação do pacote ele pede a impressão do seu documento, que só é feito quando a lista termina;
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
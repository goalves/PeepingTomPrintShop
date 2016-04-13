package peepingTom;

import java.util.ArrayList;

public class PrinterManager extends Thread {
   private JobsPackage jPackage;
   private Printer printer;
   private ArrayList<Job> jobs;
   private ArrayList<UserThread> threads;
   private int clients;
	
   /*
	* Construtor da classe
	*/
    public PrinterManager(int numberOfClients,int maximumPackageSize, int printerLimit) {
        jPackage = new JobsPackage(maximumPackageSize);
        jobs = new ArrayList<Job>();
        threads = new ArrayList<UserThread>();
        this.clients = numberOfClients;
        printer = new Printer(printerLimit);
    }
    

    /*
     * Função que cria e executa as threads de usuário para simulação assim como executa o laço que pede para que a impressora
     * imprima o pacote atual
     * (non-Javadoc)
     * @see java.lang.Thread#run()
     */
   @Override
    public void run(){
		// Adiciona 20 jobs criados por usuários (threads) diferentes
	    for(int i = 0; i < clients ; i++)
			threads.add(new UserThread(new Job("Job " + Integer.toString(i)), this));
	    
		for(UserThread t : threads)
			t.start();
        
		
        while(!printer.isFinished()){
            if(jPackage.isPackageFull())
            {
                try {
                    printer.print(jPackage);
                } catch (InterruptedException ex) {
                    System.out.println("Something went wrong");
                }
                jPackage.getJobsList().removeAll(jobs);
                unlock();
            } 
        }
    }
    
   
   /*
    * Função para adicionar um job ao pacote que está dentro da manager
    */
    public void addToPackage(Job job) throws InterruptedException {
        // Adiciona o job ao pacote existente
        synchronized(jPackage) {
            if (jPackage.addJobToPackage(job)) {
                jPackage.wait();
            }else{
                //Caso não consiga mais inserir, o pacote deve estar cheio, mandar Imprimir
                jPackage.wait();
            }
        }
    }
    
    /*
     * Função que notifica todos as threads esperando pelo notify no pacote
     */
    public void unlock(){
        synchronized(jPackage){
        	jPackage.notifyAll();
        }
        
    }
    
    public Printer getPrinter() {
        return printer;
    }
}

package controller;


import java.util.concurrent.Semaphore;

public class ThreadCorredor extends Thread {

	private int idPessoa;
	private Semaphore semaforo;

	
	public ThreadCorredor(int idPessoa, Semaphore semaforo) {
		this.idPessoa = idPessoa;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		pessoaAndando();

		try {
			semaforo.acquire();
			pessoaPorta();	
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}

		
	}

	private void pessoaAndando() {
		int distanciaFinal = 200;
		int distanciaPercorrida = 0;
		int deslocamento = (int) (Math.random() * (7 - 4)) + 4;
		
		while (distanciaPercorrida < distanciaFinal) {
			   distanciaPercorrida += deslocamento;
			   System.out.println("Pessoa " + idPessoa + " andou " + deslocamento + "m. Distância percorrida: " + distanciaPercorrida + "m.");
			   
	}
	}

	private void pessoaPorta() {
	    System.out.println("Pessoa " + idPessoa + " abriu a porta");

	    int aberturaDaPorta = 1;
	     
	    try {
	      sleep(aberturaDaPorta * 1000 | 2000);
	    } catch (InterruptedException e) {
	      e.printStackTrace();
	    }

	    System.out.println("Pessoa " + idPessoa + " fechou a porta");
	  }	
	    
		
	

}
package com.xiaomai.study.thread.interrupt;

public class PrimeGenerator extends Thread{

	@Override
	public void run() {
		long number = 1l;
		while(true){
			if(isPrime(number)){
				System.out.printf("Number %d is Prime \n",number);
			}
			if(isInterrupted()){
				System.out.println("The Prime Generator has been Interrupted");
			}
			number++;
		}
	}

	private boolean isPrime(long number) {
		if(number<=2){
			return true;
		}
		for(long i=2;i<number;i++){
			if((number%i)==0){
				return false;
			}
		}
		return true;
	}
}

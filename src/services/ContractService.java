package services;

import java.time.LocalDate;

import entities.Contract;
import entities.Installment;

public class ContractService {
	
	private OnlinePaymentService onlinePaymentService; //interface

	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}
	
	//metodo 
	public void processContract(Contract contract, int months) {
		
		contract.getInstallment().add(new Installment(LocalDate.of(2018, 7, 25), 206.04));
		contract.getInstallment().add(new Installment(LocalDate.of(2018, 8, 25), 208.08));
		
	}
	
}

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
		
		double basicQuota = contract.getTotalValue() / months; // 600/3 = 200
		
		for (int i = 1; i <= months; i++) {
			LocalDate dueDate = contract.getDate().plusMonths(i); //data original mais quantidade de meses "i"
		
			double interest = onlinePaymentService.interest(basicQuota, i); // calcula o juros de cada mes
			double fee = onlinePaymentService.paymentFee(basicQuota + interest); //taxa
			double quota = basicQuota + interest + fee;
			
			//instanciando e armazenando contrato dentro da minha ArrayList
			contract.getInstallment().add(new Installment(dueDate, quota));
		}
		
		
		         
	}
	
}

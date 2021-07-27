package com.caioproject.WebService.entities.enums;

public enum OrderStatus {

	WAITING_PAYMENT(1), // declarando qual vai ser o codigo do status
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	// todo o processo para conseguir declarar o codigo de cada status
	
	private int code;
	
	private OrderStatus (int code) {
		this.code = code;
	}
	
	public int getCode () {
		return code;
	}
	
	public static OrderStatus valueOf (int code) { // dentro do metodo o FOR vai percorrer todos os codigo para identificar qual é o status 
		for (OrderStatus value : OrderStatus.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus code"); // caso nao encontrar o codigo lanca a exceçao  informando o erro
	}
	
}

package com.caioproject.WebService.entities.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.caioproject.WebService.entities.Order;
import com.caioproject.WebService.entities.Product;

@Embeddable // anotação para informar que é uma classe auxiliar para ser uma chave composta
public class OrderItemPK implements Serializable{ // essa classe faz a uniao das classes product e order, é uma classe auxiliar para ser uma chave composta 
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "order_id") // informando o nome da chave primaria 
	private Order order;
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItemPK other = (OrderItemPK) obj;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		return true;
	}
}

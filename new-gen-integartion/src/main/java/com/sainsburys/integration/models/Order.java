package com.sainsburys.integration.models;

import java.io.Serializable;
import java.sql.Date;

public class Order implements Serializable{
	private static final long serialVersionUID = 1L;
	private int orderId;
	private int quantity;
	private Date shipmentDate;
	private int vehicleId;
	private String supplierId;
	private String supplierName;
	private String productId;
	private String productName;
	private String depotId;
	private String channel;
	
	public Date getShipmentDate() {
		return shipmentDate;
	}

	public void setShipmentDate(Date shipmentDate) {
		this.shipmentDate = shipmentDate;
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDepotId() {
		return depotId;
	}

	public void setDepotId(String depotId) {
		this.depotId = depotId;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", quantity=" + quantity + ", shipmentDate=" + shipmentDate
				+ ", vehicleId=" + vehicleId + ", supplierId=" + supplierId + ", supplierName=" + supplierName
				+ ", productId=" + productId + ", productName=" + productName + ", depotId=" + depotId + ", channel="
				+ channel + "]";
	}


}

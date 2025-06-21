package com.ahbap.ToptanTrack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootApplication
@SpringBootTest
@EnableJpaRepositories(basePackages = "com.ahbap")
class ToptanTrackApplicationTests {

	@Autowired
	public DataHalper dataHalper;

	@BeforeEach
	public void initialize()  {


		if (!dataHalper.findAll().isEmpty()) {
			dataHalper.deleteAll();
			ProductEntity product = new ProductEntity();
			product.name = "Laptop";
			product.addedBy = "Fatih";
			product.stock = 10;
			product.byPrice =  BigDecimal.valueOf(1500.00);
			product.sellPrice = BigDecimal.valueOf(1800.00);
			product.datetime = LocalDateTime.now();

			dataHalper.save(product);
		}
		else {
			ProductEntity product = new ProductEntity();
			product.name = "Laptop";
			product.addedBy = "Fatih";
			product.stock = 10;
			product.byPrice =  BigDecimal.valueOf(1500.00);
			product.sellPrice = BigDecimal.valueOf(1800.00);
			product.datetime = LocalDateTime.now();
			dataHalper.save(product);
		}

	}

	@Test
	public void findByName()  {

		assertEquals("laptop".toUpperCase(),dataHalper.findByName("Laptop").get(0).name);

	}
	@Test
	public void findAll()  {
		assertEquals(1,dataHalper.findAll().size());
	}
	@Test
	public void findByByPrice() {


		assertEquals("laptop".toUpperCase(),dataHalper.findByByPrice(BigDecimal.valueOf(1500)).get(0).name);
	}

	@Test
	public void findSellPrice() {

		assertEquals("laptop".toUpperCase(),dataHalper.findBySellPrice(BigDecimal.valueOf(1800)).get(0).name);
	}



	@Test
	public void getProductsWithStockLessThan()  {

		assertEquals("laptop".toUpperCase(),dataHalper.getProductsWithStockLessThan(75).get(0).name);
	}
	@Test
	public void deleteByName()  {

        assertTrue(dataHalper.deleteByName("Laptop"));
	}
	@Test
	public void updateAddStockTrue()  {

        assertTrue(dataHalper.updateADDStock(7, "Laptop"));
	}
	@Test
	public void updateAddStockFalse()  {

		assertFalse(dataHalper.updateADDStock(-7, "Laptop"));
	}

	@Test
	public void UpdatePriceTrue(){

		assertTrue(dataHalper.updateByPrice(BigDecimal.valueOf(850),"Laptop".toUpperCase()));
	}
	@Test
	public void UpdatePriceFalse(){

		assertFalse(dataHalper.updateByPrice(BigDecimal.valueOf(1900.00),"Laptop".toUpperCase()));
	}
	@Test
	public void UpdateSellPriceTrue(){

		assertTrue(dataHalper.updateSellPrice(BigDecimal.valueOf(1850),"laptop".toUpperCase()));
	}
	@Test
	public void UpdateSellPriceFalse(){

		assertFalse(dataHalper.updateSellPrice(BigDecimal.valueOf(1250),"laptop".toUpperCase()));
	}
	@Test
	public void updateSellPriceAndByPrice(){

		assertTrue(dataHalper.updateSellPriceAndByPrice(BigDecimal.valueOf(12870),BigDecimal.valueOf(12550),"laptop".toUpperCase()));
	}
	@Test
	public void updateToReduceStock()  {

		dataHalper.updateToReduceStock(1,"Laptop");
		assertEquals(9,dataHalper.findByName("laptop").get(0).stock);
	}


	@Test
	void updateADDStock()  {

		dataHalper.updateADDStock(10,"Laptop");
		assertEquals(20,dataHalper.findByName("laptop").get(0).stock);

	}

	@Test
	void totalStockQuantity()
	{
		assertEquals(1,dataHalper.totalStockQuantity());
	}
	@Test
	void MaxSellPrice()
	{
		var pe = new ProductEntity();
		pe.sellPrice = BigDecimal.valueOf(1500.00);
		pe.byPrice = BigDecimal.valueOf(1200.00);
		pe.name = "sarj";
		pe.addedBy = "Hikmet";
		pe.stock = 12;
		dataHalper.save(pe);
		assertEquals("Laptop".toUpperCase(),dataHalper.MaxSellPrice().name);
	}

	@Test
	void MinSellPrice()
	{
		var pe = new ProductEntity();
		pe.sellPrice = BigDecimal.valueOf(1500.00);
		pe.byPrice = BigDecimal.valueOf(1200.00);
		pe.name = "sarj";
		pe.addedBy = "Hikmet";
		pe.stock = 12;

		dataHalper.save(pe);
		assertEquals("sarj".toUpperCase(),dataHalper.MinSellPrice().name);
	}
	@Test
	void MaxByPrice()
	{
		var pe = new ProductEntity();
		pe.sellPrice = BigDecimal.valueOf(1500.00);
		pe.byPrice = BigDecimal.valueOf(1000.00);
		pe.name = "sarj";
		pe.addedBy = "Hikmet";
		pe.stock = 12;
		dataHalper.save(pe);
		assertEquals("Laptop".toUpperCase(),dataHalper.MaxByPrice().name);
	}

	@Test
	void MinByPrice()
	{
		var pe = new ProductEntity();
		pe.sellPrice = BigDecimal.valueOf(1500.00);
		pe.byPrice = BigDecimal.valueOf(1000.00);
		pe.name = "sarj";
		pe.addedBy = "Hikmet";
		pe.stock = 12;

		dataHalper.save(pe);
		assertEquals("sarj".toUpperCase(),dataHalper.MinByPrice().name);
	}

	@Test
	void totalSellingPrice()
	{
		/*
			Burada save 1 defa yapılmıştır. Akışta
			bir proplem olup olmadığı testi yapılmıştır
		 */
		assertEquals(10,dataHalper.totalSellingPrice().get(0).stock);
	}
	@Test
	void totalByPrice()
	{
			/*
				Burada save 1 defa yapılmıştır. Akışta
			 	bir proplem olup olmadığı testi yapılmıştır
		 */
		assertEquals(10,dataHalper.totalByPrice().get(0).stock);
	}
	@Test
	void totalProfit()
	{
			/*
				Burada save 1 defa yapılmıştır. Akışta
			 	bir proplem olup olmadığı testi yapılmıştır
		 */
		assertEquals("LAPTOP",dataHalper.totalProfit().get(0).name);
	}

}

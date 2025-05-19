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
			product.byPrice =  BigDecimal.valueOf(1200.00);
			product.sellPrice = BigDecimal.valueOf(1100.00);
			product.datetime = LocalDateTime.now();

			dataHalper.save(product);
		}
		else {
			ProductEntity product = new ProductEntity();
			product.name = "Laptop";
			product.addedBy = "Fatih";
			product.stock = 25;
			product.byPrice =  BigDecimal.valueOf(1500.00);
			product.sellPrice = BigDecimal.valueOf(1100.00);
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


		assertEquals("laptop".toUpperCase(),dataHalper.findByByPrice(BigDecimal.valueOf(1800)).get(0).name);
	}

	@Test
	public void findSellPrice() {

		assertEquals("laptop".toUpperCase(),dataHalper.findBySellPrice(BigDecimal.valueOf(1200)).get(0).name);
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

		assertTrue(dataHalper.updateByPrice(BigDecimal.valueOf(12500),"Laptop".toUpperCase()));
	}
	@Test
	public void UpdatePriceFalse(){

		assertFalse(dataHalper.updateByPrice(BigDecimal.valueOf(1100.00),"Laptop".toUpperCase()));
	}
	@Test
	public void UpdateSellPriceTrue(){

		assertTrue(dataHalper.updateSellPrice(BigDecimal.valueOf(1150),"laptop".toUpperCase()));
	}
	@Test
	public void UpdateSellPriceFalse(){

		assertFalse(dataHalper.updateSellPrice(BigDecimal.valueOf(1950),"laptop".toUpperCase()));
	}
	@Test
	public void updateSellPriceAndByPrice(){

		assertTrue(dataHalper.updateSellPriceAndByPrice(BigDecimal.valueOf(12250),BigDecimal.valueOf(12750),"laptop".toUpperCase()));
	}
	@Test
	public void updateToReduceStock()  {
		assertTrue(dataHalper.updateToReduceStock(3, "Laptop"));
	}


	@Test
	void updateADDStock()  {

		assertTrue(dataHalper.updateADDStock(7, "Laptop"));
	}

}

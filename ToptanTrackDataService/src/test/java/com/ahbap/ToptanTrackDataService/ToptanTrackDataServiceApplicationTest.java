package com.ahbap.ToptanTrackDataService;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.TestPropertySource;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootApplication
@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
@EnableJpaRepositories(basePackages = "com.ahbap")
@ComponentScan(basePackages = "com.ahbap")
@EntityScan(basePackages = "com.ahbap")
class ToptanTrackDataServiceApplicationTest {

	@Autowired
	public DataService dataservice;

	@Autowired
	public MapperTest mapper;


	@BeforeEach
	void Save()  {


		var product = new ProductEntityDataService();
		product.name = "Phone";
		product.addedBy = "test dataservices";
		product.byPrice = BigDecimal.valueOf(1100.50);
		product.sellPrice = BigDecimal.valueOf(1000.00);
		product.stock = 80;
		product.datetime = LocalDateTime.now();
		dataservice.save(product);

		assertTrue(dataservice.save(product));
	}
	@Test
	void getProductsWithStockLessThan()  {

		var product = dataservice.getProductsWithStockLessThan(100)
				.stream().filter(a -> a.name.equalsIgnoreCase("Phone")).findFirst().get();
		assertEquals(80,product.stock);
	}

	@Test
	void findAllFalse()  {

        assertFalse(dataservice.findAll().isEmpty());
	}
	@Test
	void findAllTrue()  {

		assertTrue(!dataservice.findAll().isEmpty());
	}

	@Test
	void findByName() {

		var product = dataservice.findByName("Phone").stream()
				.filter(a -> a.name.equalsIgnoreCase("Phone")).findFirst().get().stock;
		assertEquals(80,product);
	}


	@Test
	void findByByPrice()
	{
		assertEquals("PHONE",dataservice.findByByPrice(BigDecimal.valueOf(1100.50)).get(0).name);
	}
	@Test
	void findBySellPrice()
	{
		assertEquals("PHONE",dataservice.findBySellPrice(BigDecimal.valueOf(1000.00)).get(0).name);
	}

	@Test
	void updateByPrice()
	{
		assertTrue(dataservice.updateByPrice(BigDecimal.valueOf(2000),"Phone"));
	}
	@Test
	void updateSellPrice()
	{
		assertTrue(dataservice.updateSellPrice(BigDecimal.valueOf(850.00),"Phone"));
	}
	@Test
	void updateToReduceStock()  {

		assertTrue(dataservice.updateToReduceStock(10, "Phone"));
	}
	@Test
	void updateToAddStock()  {

		assertTrue(dataservice.updateADDStock(10, "Phone"));
	}

	@Test
	void updateSellPriceAndByPriceTrue()
	{
		assertTrue(dataservice.updateSellPriceAndByPrice(BigDecimal.valueOf(1000.00),BigDecimal.valueOf(2000),"Phone"));
	}
	@Test
	void updateSellPriceAndByPriceFalse()
	{
		assertFalse(dataservice.updateSellPriceAndByPrice(BigDecimal.valueOf(3000.00),BigDecimal.valueOf(2000),"Phone"));
	}

	@Test
	void updateStockTrue()
	{
		assertTrue(dataservice.updateStock(10, "Phone"));
	}
	@Test
	void updateStockEquls()
	{
		this.updateStockTrue();

		assertEquals(10,dataservice.findByName("Phone").get(0).stock);
	}
	@Test
	void deleteByName() {

		assertTrue(dataservice.deleteByName("Phone"));
	}

	@Test
	void deleteBy()  {

		assertTrue(dataservice.deleteAll());
	}


}

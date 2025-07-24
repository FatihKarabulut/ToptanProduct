package com.ahbap.ToptanTrackDataService;


import com.ahbap.ToptanTrack.ProductEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
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
@Disabled
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
		product.byPrice = BigDecimal.valueOf(1100.00);
		product.sellPrice = BigDecimal.valueOf(1200.00);
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
		assertEquals("SARJ",dataservice.findByByPrice(BigDecimal.valueOf(1100.50)).get(0).name);
	}
	@Test
	void findBySellPrice()
	{
		assertTrue(!dataservice.findBySellPrice(BigDecimal.valueOf(3000)).isEmpty());
	}

	@Test
	void updateByPrice()
	{
		assertTrue(dataservice.updateByPrice(BigDecimal.valueOf(1050),"Phone"));
	}
	@Test
	void updateSellPrice()
	{
		assertTrue(dataservice.updateSellPrice(BigDecimal.valueOf(2500),"Phone"));
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
		assertTrue(dataservice.updateSellPriceAndByPrice(BigDecimal.valueOf(3000.00),BigDecimal.valueOf(2000),"Phone"));
	}
	@Test
	void updateSellPriceAndByPriceFalse()
	{
		assertFalse(dataservice.updateSellPriceAndByPrice(BigDecimal.valueOf(1000),BigDecimal.valueOf(2000),"Phone"));
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

	@Test
	void totalStockQuantity() {

		assertEquals(2,dataservice.totalStockQuantity());

	}
	@Test
	void totalStockQuantityTrue() {

		assertTrue(dataservice.totalStockQuantity() > 0);

	}
	@Test
	void MaxSellPrice() {

		var pe = new ProductEntityDataService();
		pe.sellPrice = BigDecimal.valueOf(1500.00);
		pe.byPrice = BigDecimal.valueOf(1000.00);
		pe.name = "sarj";
		pe.addedBy = "Hikmet";
		pe.stock = 12;
		dataservice.save(pe);
		assertEquals("SARJ",dataservice.MaxSellPrice().name);
	}

	@Test
	void MinSellPrice() {
		var pe = new ProductEntityDataService();
		pe.sellPrice = BigDecimal.valueOf(1500.00);
		pe.byPrice = BigDecimal.valueOf(1000.00);
		pe.name = "sarj";
		pe.addedBy = "Hikmet";
		pe.stock = 12;
		dataservice.save(pe);
		assertEquals("PHONE",dataservice.MinSellPrice().name);
	}
	@Test
	void MaxByPrice() {

		var pe = new ProductEntityDataService();
		pe.sellPrice = BigDecimal.valueOf(1500.00);
		pe.byPrice = BigDecimal.valueOf(1000.00);
		pe.name = "sarj";
		pe.addedBy = "Hikmet";
		pe.stock = 12;
		dataservice.save(pe);
		assertEquals("PHONE",dataservice.MaxByPrice().name);
	}
	@Test
	void MinByPrice() {

		var pe = new ProductEntityDataService();
		pe.sellPrice = BigDecimal.valueOf(1500.00);
		pe.byPrice = BigDecimal.valueOf(1000.00);
		pe.name = "sarj";
		pe.addedBy = "Hikmet";
		pe.stock = 12;
		dataservice.save(pe);
		assertEquals("SARJ",dataservice.MinByPrice().name);
	}
	@Test
	void totalSellingPrice() {

		assertEquals(92,dataservice.totalSellingPrice().stream().mapToInt(a -> a.stock).sum());

	}
	@Test
	void totalByPrice() {
		assertTrue(!dataservice.totalByPrice().isEmpty());
	}

	@Test
	void totalProfit(){

		System.out.println(dataservice.totalProfit().toString());
		assertTrue(!dataservice.totalProfit().isEmpty());

	}

}

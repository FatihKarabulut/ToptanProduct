# ToptanProduct

**ToptanProduct**, ürünlerin alış-satış fiyat bilgilerini ve stok durumlarını takip etmeyi amaçlayan bir stok kontrol sistemidir. Uygulama 3 katmandan oluşmaktadır:

---

## Katmanlar

### 1. Repository Katmanı
Bu katman veritabanı işlemlerini yönetir. Verilerin eklenmesi, silinmesi, güncellenmesi ve sorgulanması işlemleri burada gerçekleştirilir.

### 2. DataService Katmanı
Bu katman, Controller (Client) ve Repository katmanları arasında bir köprü görevi görür. Controller’dan gelen talepleri alır, Repository'e iletir ve sonuçları tekrar Controller’a döner.

### 3. Controller (Client) Katmanı
Kullanıcılardan gelen HTTP isteklerini karşılayan katmandır. `@GetMapping`, `@PostMapping`, `@DeleteMapping`, `@PutMapping` gibi REST işlemleri burada tanımlanır.

---

## Test ve Dokümantasyon

Projenin test ve API dokümantasyonu için **Swagger** kullanılmıştır.

Swagger arayüzüne erişmek için: http://localhost:7272/swagger-ui/index.html


---

## Kullanılan Teknolojiler

- Spring Boot  
- Spring Security  
- Spring Data JPA  
- PostgreSQL  
- MapStruct  
- Lombok  
- Swagger UI  

---

## Not
Güvenlik için temel düzeyde Basic Auth yapılandırması uygulanmıştır. `InMemoryUserDetailsManager` kullanılarak kullanıcı yetkilendirmesi yapılmıştır.


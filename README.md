### Spring Boot Proje Şablonu Özeti:

Bu Spring Boot proje şablonu java 17, spring 2.5.4 ve maven ile tasarlanmıştır, orta ve büyük springboot monolitik mimari ile tasarlanacak projeler için geliştirilmiştir.
Kapsamlı ve detaylı bir proje mimarisi düşünülerek oluşturulmuştur, başlangıç için ideal bir mimariye sahiptir.
Projenin ana bileşenleri ve hiyerarşi aşağıdaki gibidir:

* #### springboot_template
  * #### docker
  * #### kubernetes
  * #### parent
    * #### core
    * #### domain
    * #### integration
    * #### rest-api

"parent" modülü, "core," "domain," "integration," ve "rest-api" modüllerini içerir. 
Ayrıca, "docker" ve "kubernetes" modülleri, projeyi konteynerleştirme ve dağıtma 
süreçlerini destekler. Şablon, bir dizi yaygın teknolojiyi kullanır, 
bu da projelerin hızlı bir şekilde başlatılmasını ve geliştirilmesini kolaylaştırır. 
Kilit teknolojiler arasında Spring Boot, Hibernate, veritabanları (PostgreSQL veya MySQL), 
Docker ve Docker Compose, logging (Logback, SLF4J), Lombok, Swagger,
JWT tabanlı Spring Security, global hata yönetimi/controller advice, 
Redis cache, RabbitMQ mesaj kuyruğu, i18n (İngilizce ve Türkçe), 
SonarQube entegrasyonu ve birim(unit) testleri (service, controller, repository) bulunur.

### Projenin Teknolojileri:

**_Spring Boot_**: Projeyi hızlı ve kolay bir şekilde geliştirmek için kullanılan Java tabanlı bir framework.

**_Hibernate:_** Veritabanı işlemlerini yönetmek için kullanılan bir ORM (Object-Relational Mapping) framework.

**_PostgreSQL/MySQL:_** Projede kullanılan ilişkisel veritabanlarını temsil eder.

_**H2 Veritabanı (Testler için):**_ Uygulama testleri için hızlı ve geçici bir veritabanı sunar.

_**Docker/Docker Compose:**_ Konteynerleştirme ve uygulamanın hızlı dağıtımı için kullanılır.

_**Logging (Logback, SLF4J):**_ Uygulama loglarını kaydetmek ve izlemek için kullanılır.

_**Lombok:**_ Java sınıflarının yazılmasını basitleştiren ve kod karışıklığını(boiler plate) azaltan bir kütüphanedir.

_**Swagger:**_ RESTful API hizmetleri için dokümantasyon oluşturma konusunda bir standart sağlar ve API kullanıcılarına bir arayüz sunar.

_**Spring Security (JWT tabanlı):**_ Kimlik doğrulama ve yetkilendirme işlemleri için kullanılır.

_**Global Hata Yönetimi/Controller Advice:**_ Uygulama genelinde hata işleme stratejilerini belirlemeye yarayan ve hata yönetimi için kullanılan yapı.

_**Redis Önbellek:**_ Verilerin önbellekte saklanmasını ve hızlı erişim sağlar.

**_RabbitMQ Mesaj Kuyruğu:_** Asenkron iletişim ve mesaj iletim sırası için kullanılır.

**_Dil Desteği - i18n (İngilizce/Türkçe):_** Birden fazla dilde içerik sunma yeteneği sağlar.

**_SonarQube:_** Kod kalitesi ve güvenliği için analiz ve raporlama aracıdır.

**_Birim Testleri (Service, Controller, Repository):_** Kodun işlevselliğini doğrulamak için geliştirilmesi gereken testler.


## Proje Başlangıcı:

Bu Spring Boot Template'i kullanarak yeni bir proje başlatmak için aşağıdaki adımları takip edebilirsiniz:

**1- Proje reposunu klonlayın:** git clone <repo-url>

**2- Projeyi geliştirme için tercih ettiğiniz IDE'yi(örneğin, IntelliJ IDEA veya Eclipse). kullanarak projeyi açın.**

**3- docker klasörü içerisindeki docker-compose dosyasını çalıştırın ve gerekli servislerin ayağa kalkmasını sağlayın.(dev ortamında çalışırken rest-api modülü hariç çalıştırabilirsiniz)**

**4- Projeyi çalıştırıp başarılı bir şekilde veritabanına bağlandıktan sonra rest-api modülü içerisindeki resources kısmında bulunan init.sql scriptini çalıştırın ve örnek role bilgilerini veritabanına kaydedin.**

**5- Şablon üzerine kendi projenizi kurgulayın ve geliştirmeye başlayın.**


### Temel modüller ve detaylar:

**parent:** Tüm alt modülleri içeren ana modül. 

**core:** Temel konfigürasyon sınıflarını ve tüm projede kullanılacak ortak ve generic yapıları içerir.

**domain:** Veritabanı varlıklarını (Entity), servis arayüz ve sınıflarını, repository arayüzlerini, custom exception sınıflarını, util sınıflarını ve bazı constant sınıflarını  tanımlar.

**integration:** Dışarıdan entegre edilecek diğer servislerin entegrasyon işlemleri için gerekli modül ve sınıfları içerir.

**rest-api:** REST API hizmetlerini sunar ve projenin başlangıç noktasıdır. Controller, DTO, Mapper ve bazı util sınıflarını içerir. 

Proje konfigürasyonu, veritabanı bağlantısı, güvenlik ayarları, önbellek yapılandırması ve diğer konular için **_application.yml, application-dev.yml, application-prod.yml_** dosyalarını ve özelleştirme seçeneklerini kullanabilirsiniz.

**Konteynerleştirme:**
Projenizi Docker ile konteynerleştirmek isterseniz, docker klasöründe Dockerfile'ları ve Docker Compose dosyalarını bulacaksınız. İlgili komutları kullanarak uygulamanızı ve projede kullanılacak diğer servisleri bir Docker konteynerinde çalıştırabilir ve test edebilirsiniz.

Projede örnek oluşturması açısından ve Spring Security altyapısının oluşturulması için, User ve Role entity, service, repository, controller, dto ve mapper sınıflarını yazılmıştır. 

Bu template'de kullanılan bazı yapıları detaylı anlattığım yazılarıma aşağıdaki linklerden ulaşabilirsiniz:

**ORM Nedir? : https://medium.com/@aedemirsen/orm-object-relational-mapping-nedir-9c6754e9d705**

**Java Spring Boot RestApi: https://medium.com/@aedemirsen/java-spring-boot-rest-api-ebf676a315b1**

**Springboot ve Docker - 1: https://medium.com/@aedemirsen/java-spring-boot-projesini-docker-container-i̇çerisinde-çalıştırmak-1-212c12663811**

**Springboot ve Docker - 2: https://medium.com/@aedemirsen/java-spring-boot-projesini-docker-container-i̇çerisinde-çalıştırmak-2-317cbf322cbc**

**Kubernetes ve Servis Tipleri: https://medium.com/@aedemirsen/kubernetes-servis-tipleri-cluster-ip-node-port-loadbalancer-f372dd390879**

**Kubernetes ve Podlara erişim: https://medium.com/@aedemirsen/kubernetes-ve-yük-dengeleme-load-balancing-1-429b08ae5150**

**Kubernetes, Load Balancer ve Ingress Controller: https://medium.com/@aedemirsen/kubernetes-loadbalancer-ve-ingress-controller-f805cc98e16**

**Swagger ve OpenAPI: https://medium.com/@aedemirsen/swagger-ve-openapi-nedir-spring-boot-ile-swagger-entegrasyonu-8f0fae0e7eb8**

**Global Exception Handler: https://medium.com/@aedemirsen/spring-boot-global-exception-handler-9a30529ef2c0**

**Request Interceptor: https://medium.com/@aedemirsen/spring-boot-request-interceptor-nedir-ve-nasıl-kullanılır-da809843b71**

**Hibernate PrePersist, PreUpdate: https://medium.com/@aedemirsen/hibernate-prepersist-ve-preupdate-ce412be5b0db**

**Cache: https://medium.com/@aedemirsen/web-projelerinde-önbellek-cache-nedir-e8281c682820**

**Redis: https://medium.com/@aedemirsen/redis-ile-spring-boot-projelerinde-cache-yapısı-b6ba6a5e25fc**

**SonarQube: https://medium.com/@aedemirsen/sonarqube-nedir-ve-spring-boot-projemize-nasıl-entegre-ederiz-9aae3fb9ad4b**


### NOT: Junior developer arkadaşların detaylı bir şekilde tüm yapıyı incelemesini ve kodlarını ince ayrıntılarına kadar okumalarını tavsiye ederim. 

Sorularınız için ve görüşleriniz için aşağıdaki mail adresinden veya linkedin üzerinden bana ulaşabilirsiniz:

www.linkedin.com/in/aedemirsen

**aedemirsen@gmail.com**


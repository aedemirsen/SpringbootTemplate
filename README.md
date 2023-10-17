### Spring Boot Proje Şablonu Özeti:

Bu Spring Boot proje şablonu maven ile tasarlanmıştır, orta ve büyük springboot monolitik mimari ile tasarlanacak projeler için geliştirilmiştir.
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
Docker ve Docker Compose, logging (Logback, SLF4J), Lombok, 
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

Bu template'de kullanılan bazı yapıları detaylı anlattığım yazılarıma aşağıdaki linkten ulaşabilirsiniz:

**https://medium.com/@aedemirsen**

### NOT: Junior developer arkadaşların detaylı bir şekilde tüm yapıyı incelemesini ve kodlarını ince ayrıntılarına kadar okumalarını tavsiye ederim. 

Sorularınız için ve görüşleriniz için aşağıdaki mail adresinden veya linkedin üzerinden bana ulaşabilirsiniz:

www.linkedin.com/in/aedemirsen

**aedemirsen@gmail.com**


Hospital Microservices Project
📋 Description
Ce projet est une architecture de microservices pour la gestion d'un système hospitalier. Il comprend plusieurs services indépendants pour gérer les patients, les paiements, et la configuration, avec une passerelle API (Gateway) pour centraliser les accès et un serveur de découverte Eureka pour l'enregistrement des services.
🏗️ Architecture
Services inclus :

Config Service : Service de configuration centralisée
Eureka Server : Service de découverte et d'enregistrement des microservices
Gateway Service : Passerelle API pour router les requêtes
Patient Service : Gestion des informations des patients
Payment Service : Gestion des paiements et facturation

🚀 Technologies utilisées

Java avec Spring Boot
Spring Cloud pour l'architecture microservices
Spring Cloud Config pour la configuration centralisée
Netflix Eureka pour la découverte de services
Spring Cloud Gateway pour la passerelle API
Maven pour la gestion des dépendances



📁 Structure du projet
hospital-microservices-project/

├── config/                          # Service de configuration

├── eureka/                          # Serveur Eureka

├── gateway/                         # Passerelle API

├── patient/                         # Service Patient

├── payment/                         # Service Payment

├── application.properties           # Configuration principale

├── patient-service.properties       # Config service Patient

├── patient-service-dev.properties   # Config Patient (dev)

├── patient-service-prod.properties  # Config Patient (prod)

├── payment-service.properties       # Config service Payment

├── payment-service-dev.properties   # Config Payment (dev)

├── payment-service-prod.properties  # Config Payment (prod)

└── pom.xml                         # Configuration Maven parent

⚙️ Configuration
Le projet utilise des profils Spring pour différents environnements :

  dev : Environnement de développement
  prod : Environnement de production

Fichiers de configuration :

  Configuration centralisée via le Config Service
  Fichiers de propriétés spécifiques à chaque service
  Profils différenciés par environnement

🛠️ Installation et démarrage
Prérequis

  Java 11 ou plus récent
  Maven 3.6+
  IDE (IntelliJ IDEA, Eclipse, VS Code)

Étapes de déploiement

Cloner le repository
bashgit clone https://github.com/aminessbaa/hopital-microservices-project-v2.git
cd hopital-microservices-project-v2

Compiler le projet
bashmvn clean install

Démarrer les services dans l'ordre suivant :
a. Config Service
  bashcd config
  mvn spring-boot:run
  
b. Eureka Server
  bashcd eureka
  mvn spring-boot:run
  
c. Gateway Service
  bashcd gateway
  mvn spring-boot:run
  
d. Patient Service
  bashcd patient
  mvn spring-boot:run
  
e. Payment Service
bashcd payment
mvn spring-boot:run


🌐 Ports par défaut
Service                     Port

Config Service     :         8888

Eureka Server      :         8761

Gateway service    :         8080

Patient Service    :         8081

Payment Service    :         8082

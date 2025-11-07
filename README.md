# 🎟️ Événementiel — Application Web de Gestion d’Événements, Participants et Tickets

![Spring Boot](https://img.shields.io/badge/SpringBoot-3.2.2-brightgreen)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-HTML5-orange)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue)
![Java](https://img.shields.io/badge/Java-17-red)
![License](https://img.shields.io/badge/License-MIT-lightgrey)

---

## 🧭 Aperçu du projet

**Événementiel** est une application web interactive permettant la **gestion complète des événements, des participants et des tickets**.  
Développée en **Spring Boot (backend)** et **Thymeleaf (frontend)**, elle illustre une architecture **MVC** moderne avec intégration MySQL et interface responsive via **Bootstrap 5**.

> 🎯 Objectif : Simplifier la gestion d’événements et offrir une interface claire et intuitive.

---

## ⚙️ Fonctionnalités principales

- ✅ **CRUD complet** (Créer, Lire, Mettre à jour, Supprimer)
  - Événements
  - Participants
  - Tickets (avec clé composite)
- 📊 **Statistiques dynamiques**
  - Événements par ville et par type
  - Participants par domaine d’email
  - Nombre de tickets par statut
- 🎨 Interface ergonomique avec **Bootstrap 5**
- 🔒 Validation des champs (`@NotNull`, `@Email`, `@Size`)
- 💾 Base de données **MySQL 8.0**
- 🧩 Architecture **Spring Boot / JPA / Thymeleaf**

---

## 🧱 Architecture technique

### 🧩 Stack utilisée
| Composant | Technologie |
|------------|-------------|
| Langage | Java 17 |
| Framework backend | Spring Boot 3.x |
| ORM | Spring Data JPA (Hibernate) |
| Base de données | MySQL 8 |
| Frontend | Thymeleaf, Bootstrap 5 |
| IDE recommandé | IntelliJ IDEA / VS Code |
| Build Tool | Maven |
<img width="631" height="406" alt="image" src="https://github.com/user-attachments/assets/40a0fceb-785b-4c14-8811-74f0f7316fe8" />


---
## 🧬 Structure du projet
<img width="900" height="391" alt="image" src="https://github.com/user-attachments/assets/accd56f3-2888-47e5-9417-b28c507ff80f" />

---

## 🚀 Installation et exécution
### 🔧 Prérequis :
- Java 17+
- Maven 3.8+
- MySQL 8+

### ▶ Étapes :
# ⚙️ Configuration & Lancement
# ------------------------------------------------------

requirements:
  - "Java 17+"
  - "Maven 3.8+"
  - "MySQL 8.0"

configuration:
  database:
    url: "jdbc:mysql://localhost:3306/evenementiel?serverTimezone=UTC"
    username: "root"
    password: ""
  server:
    port: 8081
  jpa:
    ddl-auto: "update"
    show-sql: true

run:
  steps:
    - "git clone https://github.com/ton-nom-utilisateur/evenementiel.git"
    - "cd evenementiel"
    - "mvn clean install"
    - "mvn spring-boot:run"
  access_urls:
    - "http://localhost:8081/evenements"
    - "http://localhost:8081/participants"
    - "http://localhost:8081/tickets"
    - "http://localhost:8081/statistiques"

# ------------------------------------------------------
# 🗃️ Base de données
# ------------------------------------------------------

database_model:
  tables:
    - Evenement:
        columns: [id, titre, ville, date, type]
    - Participant:
        columns: [id, nom, email]
    - Ticket:
        columns: [evenement_id, participant_id, prix, statut, date_achat]
  relations:
    - "Evenement 1..* Ticket"
    - "Participant 1..* Ticket"
    - "Ticket (clé composite) relie Evenement ↔ Participant"

# ------------------------------------------------------
# 📊 Statistiques dynamiques
# ------------------------------------------------------

statistics:
  description: >
    Les statistiques sont calculées dynamiquement via StatistiquesWebController,
    à partir des données MySQL. Elles sont mises à jour en temps réel à chaque ajout,
    modification ou suppression d’un ticket ou événement.
  exemples:
    - "Nombre total de tickets vendus"
    - "Événements par ville et par type"
    - "Revenus totaux par date"
    - "Participants par domaine d’email"

# ------------------------------------------------------
# 🎥 Vidéos de démonstration
# ------------------------------------------------------

videos:


https://github.com/user-attachments/assets/24d85391-db5d-4cef-b285-3c35bd00940a



# ------------------------------------------------------
# 🧑‍💻 Auteur et Encadrement
# ------------------------------------------------------

author:
  name: "Jamila Dabachine"
  
  role: "Étudiante en Master Technologies Émergentes en Éducation"
  
  institution: "École Normale Supérieure de Marrakech"
  
  academic_year: "2025"
  
  supervisor: "Professeur Lachgar"
  
  email: "j.dabachine3378@uca.ac.ma"
 
  # 📜 Licence et droits
# ------------------------------------------------------

license:
  type: "MIT"
  notice: >
    Ce projet est libre d’utilisation et de modification à des fins éducatives.
    La redistribution est autorisée sous réserve de mentionner l’auteur et l’établissement d’origine.
  
  github: "https://github.com/jdabachine3378-svg"





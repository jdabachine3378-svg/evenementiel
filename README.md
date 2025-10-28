Rapport du Projet : Application de Gestion Événementielle
11. Encodement :
•	Nom de l’étudiant : DABACHINE Jamila
•	Encadrant : Professeur  LACHGAR Mohamed
•	Module : Technologies de Programmation Avancées,
•	Année universitaire : 2025
 Introduction
Dans le cadre du module de Technologies de Programmation Avancées, j’ai developer une application web intitulée « Gestion Événementielle ». Ce projet a été conçu dans le but de faciliter la gestion des événements, des participants et des tickets associés à chaque événement. L’application est développée avec Spring Boot, Thymeleaf, Bootstrap et MySQL, et permet de réaliser des opérations CRUD complètes sur toutes les entités.
________________________________________
1. Objectifs du projet
L’objectif principal de ce projet est de mettre en place une application web professionnelle permettant à un utilisateur (organisateur) de: 
- Créer et gérer des événements. 
- Enregistrer et suivre les participants. 
- Générer et gérer les tickets liés aux événements.
Ce projet vise à proposer une solution simple, ergonomique et moderne pour toute structure souhaitant gérer efficacement ses activités événementielles.
________________________________________
2. Technologies utilisées
Composant	Technologie
Langage backend	Java 17 (JDK 17)
Framework	Spring Boot 3.2.2
ORM	Hibernate / JPA
Base de données	MySQL 8
Interface utilisateur	Thymeleaf + HTML + CSS + Bootstrap 5
Gestion de projet	Maven 3.9
IDE de développement	IntelliJ IDEA 2025.2
________________________________________
3. Architecture du projet
Le projet suit une architecture en couches claire et bien organisée:
src/
 ├─ main/java/com/example/evenementiel/
 │   ├─ model/          → Contient les entités JPA (Evenement, Participant, Ticket, TicketKey)
 │   ├─ repository/     → Contient les interfaces JpaRepository
 │   ├─ controller/
 │   │    ├─ api/       → Contrôleurs REST pour les appels API
 │   │    └─ web/       → Contrôleurs Web pour les pages Thymeleaf
 │   └─ EvenementielApplication.java → Classe principale
 ├─ main/resources/
 │   ├─ templates/      → Pages HTML (evenements.html, participants.html, tickets.html)
 │   ├─ static/css/     → Fichiers CSS (style.css)
 │   └─ application.properties
________________________________________
4. Conception du modèle de données
Le modèle repose sur trois entités principales :
◼ Evenement
Champ	Type	Description
id	Long	Identifiant unique de l’événement
titre	String	Nom de l’événement
ville	String	Lieu de l’événement
date	LocalDate	Date de l’événement
type	String	Type d’événement (concert, conférence…)
◼ Participant
Champ	Type	Description
id	Long	Identifiant unique du participant
nom	String	Nom du participant
email	String	Adresse e-mail du participant
◼ Ticket (avec Clé Composite)
Champ	Type	Description
id (TicketKey)	Composite	(evenementId + participantId)
Prix	BigDecimal	Prix du ticket
Statut	String	Statut (Confirmé, En attente, Annulé)
dateAchat	LocalDate	Date d’achat du ticket
Les relations entre les entités sont définies comme suit : - Ticket → Evenement : @ManyToOne - Ticket → Participant : @ManyToOne - Evenement → Ticket : @OneToMany - Participant → Ticket : @OneToMany
4.3 Modèle relationnel (capture d’écran)
Figure 4.1 : Schéma relationnel de la base Événementiel (phpMyAdmin)
<img width="952" height="621" alt="image" src="https://github.com/user-attachments/assets/95a3d258-2833-457f-9c33-82feed88c1ae" />
Le modèle relationnel suivant illustre la structure de la base de données du projet.
Chaque événement peut avoir plusieurs tickets, et chaque participant peut posséder plusieurs tickets.
Le ticket est donc au centre de la relation entre un événement et un participant.
________________________________________
5. Fonctionnalités principales
•	Création, affichage, modification et suppression d’événements.
•	Gestion des participants (inscription et suppression).
•	Génération automatique de tickets lors de l’inscription.
•	Visualisation de la liste des tickets avec leurs statuts.
•	Filtrage des tickets par statut (Confirmé, Annulé, En attente).
•	Statistiques basiques sur le nombre de tickets et d’événements.
________________________________________
6. Configuration de la base de données
spring.datasource.url=jdbc:mysql://localhost:3306/evenementiel?serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
________________________________________
7. Déploiement et exécution
▶ Prérequis :
•	JDK 17 ou plus
•	MySQL 8
•	Maven installé
▶ Lancer le projet :
mvn clean install
mvn spring-boot:run
▶ Accès via navigateur :
•	Page d’accueil: http://localhost:8081/
•	Tickets : http://localhost:8081/tickets
•	Événements : http://localhost:8081/evenements
•	Participants : http://localhost:8081/participants
________________________________________
8. Exemple de données initiales
evenementRepository.save(new Evenement("Tech Conference", "Casablanca", LocalDate.now(), "Conférence"));
participantRepository.save(new Participant("Ali", "ali@gmail.com"));
________________________________________
9. Résultats et observations
L’application répond parfaitement aux besoins de gestion d’événements. Elle permet une navigation fluide, une interface claire et un design professionnel grâce à Bootstrap. Les tests unitaires effectués sur les contrôleurs REST montrent la stabilité et la fiabilité du système.
________________________________________
10. Conclusion
Ce projet m’a permis de mettre en pratique mes compétences en Java Spring Boot, JPA/Hibernate, et Thymeleaf. Il représente une expérience enrichissante en développement full stack et en architecture logicielle. De plus, il constitue une base solide pour d’éventuelles améliorations futures .
________________________________________
Figure – Interface principale de l’application Événementiel
<img width="839" height="456" alt="image" src="https://github.com/user-attachments/assets/3bc05d7c-f248-41cc-8b6a-5a35ca65f172" />

Figure  – Formulaire d’ajout d’un nouveau ticket 
 <img width="1901" height="716" alt="image" src="https://github.com/user-attachments/assets/b027aa72-897e-49a8-b98c-84cf6f3cc0a1" />
 <img width="1805" height="921" alt="image" src="https://github.com/user-attachments/assets/e793c988-e831-4fcc-963e-dc20a8833e76" />
Figure  – Tableau récapitulatif des participants 
<img width="1866" height="915" alt="image" src="https://github.com/user-attachments/assets/197a5a33-b47b-4a0e-bc3b-f4689c60d1c8" />


 

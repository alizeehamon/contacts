# Présentation du projet

La cliente a pour habitude de gérer de nombreux évènements.

Chaque nouvelle année, elle ne parvient pas à remettre la main sur les nombreuses personnes qu'elle a contacté dans le passé, ou bien les personnes qu'elle a pu cotoyer. (échange de numéros via un post-it, rencontre durant un voyage à l'étranger, discussion avec l'amie du frère de la cousine...)

Elle souhaite bénéficier d'une application web lui permettant d'ajouter les contacts qu'elle connait déjà.
Aussi, elle aimerait pouvoir ajouter les contacts qu'elle rencontre durant ses évènements, qu'elle recroise durant ses sorties au restaurant ou encore chez ses amis, ou bien encore, qu'elle retrouve sur une feuille qui traine sur son bureau

Il y a une fonctionnalité dont elle ne cesse de nous parler : l'application pourra proposer d'ajouter des noms associés. Par exemple, John Doe et Rosa Doe sont présents dans les contacts. Il sera possible de préciser sur la fiche du contact de John que Rosa Doe est sa mère. Lorsque l'on visite le contact de John, l'information est visible avec un lien cliquable vers le contact (mère : Rosa Doe). De la même manière, l'information inverse sera visible sur le contact de Rosa Doe, avec un lien cliquable vers le contact associé (fils : John Doe)

Les étiquettes peuvent être : mère, père, parent, frère, soeur, fils, fille, etc.

# Outils utilisés

- JDK 8 (supérieur ou égal)
- Spring Boot 2.7.4 (supérieur ou égal)
- HTML5, CSS3, JS ES6
- JSP, TagForm, JSTL 1.2
- JPA (Hibernate 6.0)
- Mysql ou MariaDB
- Maven et Git
# Lancement du projet

- Executer le script sql pour la base "contacts"
- Remplir le fichier application.properties avec le bon nom de base
  spring.jpa.hibernate.ddl-auto=create
  spring.datasource.url=jdbc:mysql://localhost:3307/contacts
  spring.datasource.username=root
  spring.datasource.password=mdp
  spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
  spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect
  #spring.jpa.show-sql=true
  #spring.jpa.properties.hibernate.format_sql=true
  spring.mvc.view.prefix=/WEB-INF/jsp/
  spring.mvc.view.suffix=.jsp
- Pour se connecter, il est possible d'utiliser le user suivant:
- email: boris.sauvage@gmail.com 
- mdp : boris

# Fonctionnalités
## Utilisateur non connecté:
- S'inscrire (nom, prénom, email, photo, mot de passe)
- Se connecter (email, mot de passe)
## Utilisateur connecté
- Se déconnecter
- Visualiser les contacts
- Rechercher un contact par mots-clés
- Ajouter un contact
- Éditer un contact
- Supprimer un contact
- Editer son profil (nom, prénom, photo, mot de passe)

# Améliorations possibles
- Perfectionnement de l'outil "Relations" : possibilité d'éditer, supprimer et gérer plus finement la relation (notamment lié au sexe des contacts Frère/Soeur etc...)
- Perfectionnement des affichages liés au style CSS/Bootstrap
- Upload de l'image avec un user
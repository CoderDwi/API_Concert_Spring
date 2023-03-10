# API_Concert_Spring
## Membres du groupe : KONATE Ashley, LERHRIBI Douha.

### Base de données de notre API Concert :
La base de données contient 3 tables : 
  - Table Concert : représente un concert, elle a pour attribut : l’identifiant du concert, la date de début et fin du concert, l’identifiant de la soirée et de la salle.
  - Table Soirée : représente la soirée et a pour attributs : l’identifiant de la soirée, son nom, son prix, et sa description.
  - Table Salle : définit la salle de concert et a pour attribut : numéro de la salle, le nom, l’adresse et sa capacité.
  
![image](https://user-images.githubusercontent.com/62214554/224362665-b96293d8-88b3-49cb-b2f7-f25a1953738a.png)

### Un exemple d'API implémentées via spring :

#### API concert : L’ajout d’un concert 

![image](https://user-images.githubusercontent.com/62214554/224359447-415b2a8d-9ebd-4b8d-801c-8ba4bc8d360a.png)

URL : http://localhost:8080/api/concerts.
 La requête API POST: http://localhost:8080/api/concerts/ est une requête HTTP de type POST qui est envoyée à un serveur à l'adresse locale "localhost" sur le port 8080, dans le but de créer une ressource de concert.
 
 
 ### Précision : 
 Les fichiers CONCERTS.postman_collection.json, SALLE.postman_collection.json et SOIREE.postman_collection.json sont des exports des test Postman réalisés.  


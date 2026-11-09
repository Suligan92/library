# Library API
REST API pentru gestionarea unei biblioteci, cu cărți și autori.
Proiect de practică realizat cu Spring Boot.

## Tehnologii
- Java 21
- Spring Boot
- Spring Data JPA (Hibernate)
- Bază de date H2 (în memorie)
- Maven

## Cum pornești aplicația
Din folderul proiectului:
```
./mvnw spring-boot:run
```

Aplicația pornește pe `http://localhost:8080`.
Datele sunt păstrate în memorie și se șterg la oprirea aplicației.

## Endpoint-uri
### Cărți

| Metodă | Adresă | Descriere |
|---|---|---|
| GET | /api/books | toate cărțile |
| GET | /api/books/{id} | o carte după id |
| POST | /api/books | creează o carte |
| PUT | /api/books/{id} | modifică o carte |
| DELETE | /api/books/{id} | șterge o carte |

### Autori

| Metodă | Adresă | Descriere |
|---|---|---|
| GET | /api/authors | toți autorii |
| GET | /api/authors/{id} | un autor după id |
| POST | /api/authors | creează un autor |
| PUT | /api/authors/{id} | modifică un autor |
| DELETE | /api/authors/{id} | șterge un autor |

## Exemplu

Creează un autor, apoi o carte:

```
curl -X POST http://localhost:8080/api/authors -H "Content-Type: application/json" -d '{"name":"Liviu Rebreanu"}'

curl -X POST http://localhost:8080/api/books -H "Content-Type: application/json" -d '{"title":"Ion","isbn":"978-1","publicationYear":1920,"author":{"id":1}}'
```

## Coduri de răspuns

| Cod | Când apare |
|---|---|
| 200 | cerere reușită |
| 201 | resursă creată (POST) |
| 400 | date invalide (câmp lipsă sau greșit) |
| 404 | carte sau autor inexistent |
| 409 | autorul nu poate fi șters, are cărți asociate |
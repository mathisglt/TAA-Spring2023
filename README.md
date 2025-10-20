# TP 3 - Le framework Spring

Ce projet contient les trois parties du TP Spring réalisé dans le cadre du cours TAA.

## Partie 1 - Injection de dépendances

Application de gestion de magasin avec 4 acteurs : client, magasin, banque et fournisseur.

Deux scénarios implémentés :
- Scénario 1 : commande directe d'un article avec vérification stock et transfert bancaire
- Scénario 2 : achat en panier avec paiement à la sortie

L'application utilise l'injection de dépendances Spring pour gérer les relations entre les beans.

## Partie 2 - Spring AOP

Extension du premier projet avec la programmation orientée aspect.

Deux aspects ajoutés :
- Logging automatique de toutes les méthodes publiques des beans
- Gestion de la sécurité avec interception des appels, pour faire simple j'ai fais en sorte qu'on est 1 chance sur 2 d'être bloqué, en réalité il faudrait plutôt un systeme rôle et qu'on soit bloqués en fonction des privilèges de ce rôle.
  Utilise les annotations @Aspect, @Before et @Around pour l'interception.

## Partie 3 - Spring Data JPA

Application web avec persistance de données et API REST.

Fonctionnalités :
- Gestion des utilisateurs avec JPA
- API REST pour créer et consulter les utilisateurs
- Base de données HSQLDB
- Mapping DTO avec MapStruct
- Aspect de logging pour les accès REST

## TP4 - Keycloack

Je ne vois pas comment transmettre et montré mon avancement concernant le Keycloack puisqu'il tourne sur le docker.
J'ai essayé de l'intégrer au mieux dans ce projet, dans spring-boot-sample-data-jpa-standalone, fichier KeycloackConfig dans le dossier aspect.


## Lancement

```bash
# Partie 1 - Simple
Lancer SampleSimpleApplication

# Partie 2 - AOP
Lancer SampleAopApplication
# Partie 3 - JPA (démarrer HSQLDB d'abord)
Lancer le serveur HSQLDB, de mon coté je le lance depuis l'autre projet car je n'ai pas réussi à correctement lancer les scripts depuis celui-ci
Lancer SampleDataJpaApplication

```
L'application JPA sera accessible sur http://localhost:8080 avec les endpoints :
- /create?name=nom
- /utilisateurs
- /utilisateur?idUtilisateur={id valide}


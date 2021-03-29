# BILAN PROJET PC3R - WEB

- [BILAN PROJET PC3R - WEB](#bilan-projet-pc3r---web)
  - [Sujet](#sujet)
  - [API REST](#api-rest)
  - [Features](#features)
    - [Synchronisation depuis l'API](#synchronisation-depuis-lapi)
  - [Use-Case](#use-case)
  - [Database](#database)
  - [Technologies](#technologies)
  - [Client](#client)
    - [description des query](#description-des-query)
  - [Schema global](#schema-global)
    - [fonctionalite requis](#fonctionalite-requis)


## Sujet
**Crypto-Advisor**\
L'application web a pour thème la monnaie virtuelle, elle est nommée
« Crypto-Advisor», elle a pour objectif de mettre en évidences l'évolution des différentes données concernant les cryptos-monnaies en temps réel, les *tradeurs* ont aussi la possibilité de consulter des articles et pronostiques couramment mises à jour de la part d'*experts* certifiés. 



## API REST 
- https://coinmarketcap.com/api/documentation/v1/
- https://www.coinlore.com/cryptocurrency-data-api 

L'API ***Coinmarketcap*** nous fournit plusieurs informations détaillés à propos des cryptos-monnaies, on a opté pour l'abonnement "Basic" qui est limité mais gratuit et permet d'avoir toutes les donées nécessaires tel que le prix, le volume, le rang, la marketcap, etc.
Le nombre de requetes par jour est limite a 333, les données (le prix pour l'exemple) sont mis à jours instantanément.

Le seconde API ***Coinlore*** est totalement gratuite, elle a été choisi pour compléter le role de la dérnière (dans le cas où l'utilisateur dépasse le nombre de requettes autorisées), elle fournit moins informations que *coinmarketcap*.

Notre application collectera les données nécessaires pour simuler les statistiques.

## Features

- En tant que ***visitor*** sans inscription.
- Inscription au choix pour les nouveaux utilisateurs.
- Authentification en tant que ***trader***.
- Authentification en tant que ***advisor*** (conseiller).
- Ecran d’accueil sur lequel on peut trouver le cours des cryptos
monnaies et diverses données en temps réel.
- Recherche par chaine de caractère. 
- Filtrage et classement par rapport a differents critères (e.g prix).
- Page forum de discussions pour chaque crypto-monnaie où les
utilisateurs peuvent communiquer et les tradeurs donner des conseils.
- Ajout, modification et supperssion d'un commentaire sur un poste par le trader ou de l'advisor.
- Ajout, modification et supperssion d'une monnaie virtuelle dans le profile du trader ou de l'advisor.
- Publication des articles ou/et avis d'expèrtise par un ***Advisor***.

  
### Synchronisation depuis l'API
- AJAX

## Use-Case

## Database
- https://dbdiagram.io/home




##  Technologies
- [ ] Ressource ou Service ?
- [ ] Component Diagram + fct de chaque component
- [ ] serveur : Java - Servlet
- [ ] client : Bootstrap + jquery | ReactJS

## Client
- une description du client: plan du site (probablement une application monopage), contenu des
  ´ecrans ; bien identifier `a quels endroits apparaissent les appels aux diff´erents composants du serveur


###  description des query
- HTTP - JSON
- 

## Schema global
- 
  


### fonctionalite requis
- [x] Venus
- [x] (profils, commentaires, notes, messages, publications)
- [x] generer par les utilisateurs


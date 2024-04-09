
# TP2 - SOAP - HOTEL

Ce travail pratique (TP) vise à développer un service web SOAP permettant la gestion des réservations d'hôtels provenant de différentes agences. Le TP se concentre sur la mise en place d'une infrastructure de communication basée sur le protocole SOAP (Simple Object Access Protocol) pour permettre aux agences de réserver des chambres d'hôtel pour leurs clients.


## Installation

### Utilisation

Pour lancer le service de gestion des réservations d'hôtels, suivez les étapes ci-dessous :

#### Étape 1: Configuration du serveur

Ouvrez le fichier "HotelWebServicePublisher" côté serveur.
Dans ce fichier, créez des instances de web services pour chaque hôtel en utilisant leurs WSDL respectifs. Ceci est réalisé en utilisant les fonctionnalités fournies par votre langage de programmation et sa bibliothèque SOAP.
Instanciez les hôtels avec leurs chambres, informations de disponibilité, tarifs, etc...

#### Étape 2: Configuration du client

Ouvrez le fichier côté client où vous souhaitez utiliser le service de réservation d'hôtels.
Instanciez une agence de voyages en utilisant les fonctionnalités fournies par votre langage de programmation.
Ajoutez les différents hôtels créés sur le serveur à l'agence en utilisant leurs WSDL respectifs. Cela permettra à l'agence de communiquer avec les services web de chaque hôtel.

#### Étape 3: Utilisation du service de réservation

Dans le fichier côté client, utilisez les fonctionnalités de l'agence pour rechercher des hôtels disponibles, réserver des chambres, annuler des réservations, etc. Ces fonctionnalités seront exposées par l'agence à travers les services web des hôtels.
Vous pouvez utiliser les méthodes et les paramètres fournis par l'agence pour effectuer les opérations de réservation selon vos besoins.
Lorsque vous lancez le programme principal (main), il exécutera les instructions de réservation de chambre à travers l'agence, qui communiquera avec les services web des hôtels pour effectuer les opérations correspondantes.
Assurez-vous d'avoir démarré le serveur où les services web sont publiés avant de lancer le client. Cela permettra au client de se connecter aux services web des hôtels et d'effectuer les réservations de manière appropriée.
## Technologies utilisées

**Client/Serveur:** Java, SOAP. 


## A faire

+ Donner une pertinence de la classe CarteCredit.
+ Créer une interface graphique (Application web ?).
+ Utiliser une base de donné pour gérer les hotels et les réservations.
## Authors

- [@acswlt](https://www.github.com/acslwt) alias **Ayoub CHENINI**
- [@t0pun](https://www.github.com/t0pun) alias **Thomas LAGUERRE**


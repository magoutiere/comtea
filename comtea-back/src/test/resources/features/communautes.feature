# language: fr
Fonctionnalité: Gestion des communautés

  Scénario: COMMUNAUTE-001 Création d'une communauté
    Soit les communautées existantes :
      | identifiant | nom             |
      | dev         | Communauté dev. |
    Quand je crée la communauté :
      | identifiant | nom                  |
      | animateur   | Communauté animateur |
    Alors j'obtiens communautées existantes :
      | identifiant | nom                  |
      | dev         | Communauté dev.      |
      | animateur   | Communauté animateur |

  Scénario: COMMUNAUTE-002 Suppression d'une communauté
    Soit les communautées existantes :
      | identifiant | nom                  |
      | dev         | Communauté dev.      |
      | animateur   | Communauté animateur |
    Quand je supprime la communauté 'animateur'
    Alors j'obtiens communautées existantes :
      | identifiant | nom             |
      | dev         | Communauté dev. |

  Scénario: COMMUNAUTE-003 Erreur lors de l'ajout d'une communauté éxistante
    Soit les communautées existantes :
      | identifiant | nom             |
      | dev         | Communauté dev. |
    Quand je crée la communauté :
      | identifiant | nom                     |
      | dev         | Deuxième communauté dev |
    Alors j'obtiens une erreur 'La communauté dev éxiste déjà'
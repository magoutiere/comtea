# language: fr
Fonctionnalité: Gestion des collaborateurs

  Scénario: COLLABORATEUR-001 Erreur lors de l'ajout d'un collaborateur déjà existant
    Etant donné les collaborateurs suivants :
      | identifiant |
      | pifou       |
      | caillou     |
    Quand je crée le collaborateur suivant :
      | identifiant |
      | pifou       |
    Alors j'obtiens une erreur 'Le collaborateur pifou éxiste déjà'
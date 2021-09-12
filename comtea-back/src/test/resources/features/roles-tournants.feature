# language: fr
Fonctionnalité: Gestion des rôles tournants

  Scénario: ROLE-TOURNANT-001 Vainqueur lorsque tous les autres sont déjà passés et que le collaborateur n'a jamais été élu
    Etant donné les collaborateurs suivants :
      | identifiant |
      | claude      |
      | fabien      |
      | pifou       |
      | caillou     |
    Et l'historique des élus :
      | role | vainqueur | date       |
      | cafe | claude    | 2021-06-01 |
      | cafe | fabien    | 2021-06-07 |
      | cafe | caillou   | 2021-06-14 |
    Quand je lance l'élection pour le role 'cafe'
    Alors le vainqueur de l'élection est le collaborateur 'pifou'


  Scénario: ROLE-TOURNANT-002 Vainqueur lorsque le plus ancien dans l'historique, si tout le monde a déjà été élu
    Etant donné les collaborateurs suivants :
      | identifiant |
      | claude      |
      | fabien      |
      | pifou       |
      | caillou     |
    Et l'historique des élus :
      | role | vainqueur | date       |
      | cafe | claude    | 2021-06-01 |
      | cafe | fabien    | 2021-06-07 |
      | cafe | caillou   | 2021-06-14 |
      | cafe | pifou     | 2021-06-21 |
    Quand je lance l'élection pour le role 'cafe'
    Alors le vainqueur de l'élection est le collaborateur 'claude'


  Scénario: ROLE-TOURNANT-003 Mise à jour de l'historique après l'élection
    Etant donné la date du jour 2021-06-21
    Et les collaborateurs suivants :
      | identifiant |
      | claude      |
      | fabien      |
      | pifou       |
      | caillou     |
    Et l'historique des élus :
      | role | vainqueur | date       |
      | cafe | pifou     | 2021-05-23 |
      | cafe | claude    | 2021-06-01 |
      | cafe | fabien    | 2021-06-07 |
      | cafe | caillou   | 2021-06-14 |
    Quand je lance l'élection pour le role 'cafe'
    Alors le vainqueur de l'élection est le collaborateur 'pifou'
    Et j'obtiens l'historique des élus pour le role 'cafe' :
      | role | vainqueur | date       |
      | cafe | claude    | 2021-06-01 |
      | cafe | fabien    | 2021-06-07 |
      | cafe | caillou   | 2021-06-14 |
      | cafe | pifou     | 2021-06-21 |


  Scénario: ROLE-TOURNANT-004 Vainqueur au hasard lorsque deux collaborateurs n'ont jamais été élu
    Etant donné la date du jour 2021-06-21
    Et les collaborateurs suivants :
      | identifiant |
      | claude      |
      | fabien      |
      | pifou       |
      | caillou     |
    Et l'historique des élus :
      | role | vainqueur | date       |
      | cafe | claude    | 2021-06-01 |
      | cafe | fabien    | 2021-06-07 |
    Quand je lance l'élection pour le role 'cafe'
    Alors le vainqueur de l'élection est l'un des collaborateur suivant :
      | pifou   |
      | caillou |


  Scénario: ROLE-TOURNANT-005 Vainqueur au hasard lorsque deux collaborateurs ont été élu le même jour
    Etant donné la date du jour 2021-06-21
    Et les collaborateurs suivants :
      | identifiant |
      | claude      |
      | fabien      |
      | pifou       |
      | caillou     |
    Et l'historique des élus :
      | role | vainqueur | date       |
      | cafe | claude    | 2021-06-01 |
      | cafe | fabien    | 2021-06-01 |
      | cafe | pifou     | 2021-06-07 |
      | cafe | caillou   | 2021-06-07 |
    Quand je lance l'élection pour le role 'cafe'
    Alors le vainqueur de l'élection est l'un des collaborateur suivant :
      | claude |
      | fabien |
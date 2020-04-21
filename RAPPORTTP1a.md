**Nom/Prénom Etudiant  :**



# Rapport TP1a

## Exercice 1
*Expliquer le code ajouté, présentez votre solution (diagramme UML ou texte), conclusion(s) ?*

Ma solution pour cette question n'est pas très propre et pas du tout évolutive, mais elle a l'avantage d'être très simple à mettre en place. Le code est dans le `package calculette_tp1a_q1`.

J'ai simplement créé `4 méthodes statiques` dans la classe Calculette, qui prennent en paramètre 2 doubles, font l'opération correspondant au nom de la méthode, et renvoient un double correspondant au résultat.

Dans la classe `Main`, j'ai modifié un peu la méthode `main` pour qu'après avoir vérifié si la chaîne correspondant à l'opérateur souhaitée est bien d'une longueur de 1, on cherche l'opérateur avec un `switch...case`. Si le caractère entré n'est pas un opérateur, on affiche un message d'erreur à l'utilisateur, sinon le résultat de l'opération.

Très simple à mettre en place (il ne m'a fallu que quelques minutes), cette architecture est néanmoins `très difficile à faire évoluer`, puisqu'il va falloir `modifier les 2 classes` à chaque évolution, et n'est pas très propre.

## Exercice 2
*Expliquer le code ajouté, présentez votre solution (diagramme UML ou texte), conclusion(s) ?*

## Exercice 3
*Expliquer le code ajouté: présentez votre solution (diagramme UML ou texte), conclusion(s) ?*

## Votre avis sur le pattern Strategy
*Que retirez vous de son utilisation? Est-ce que c'est utile? ...*


## Votre avis sur le TP et les exercices

### Ce que vous avez aimé

*Donnez votre avis*

### Ce que vous n'avez pas aimé

*Donnez votre avis*

### Propositions d'améliorations

*Donnez votre avis*




**Nom/Prénom Etudiant :**
Ewald JANIN


# Rapport TP1b

## Question 1
*Expliquer le code ajouté*

J'ai complété la classe `Graph`.

Pour la méthode `getAllNodes`, on va créer un ArrayList qui contient toutes les clés de la `Map` des noeuds et des arcs du graphe (`adjacence`).

Pour connaître le nombre de noeuds du graphe, on renvoie tout simplement la taille de cette même `Map`, puisque les clés sont les noeuds du graphe, et qu'il ne peut pas y avoir une clé dupliquée dans un `Map`.

Pour récupérer tous les noeuds adjacents à un noeud donné, on va tout simplement parcourir les arcs de ce noeud, et ajouter les noeuds de destination à une `List` avant de la renvoyer.

Dans la méthode `toString`, on itère à travers les noeuds du graphe, pour afficher le label du noeud et tous les arcs de celui-ci. On utilise au maxium les méthodes déjà définies dans la classe `Graph`.


## Question 2
*Expliquer le code ajouté et insérer un schéma du patron de conception mis en place*

La classe `UndirectedGraph` est très simple, et a seulement deux méthodes. Elle implémente l'interface `IUndirectedGraph` et hérite de la classe `Graph`. 

Les deux méthodes de la classes sont celles définies dans l'interface `IUndirectedGraph`, c'est à dire `addEdge` et `hasEdge`. Elles utilisent les méthodes `addArc` et `hasArc` de la classe `Graph` pour modéliser un graphe non orienté (en ajoutant l'arête comme étant un arc dans les deux sens) et non valué (en choisissant une valuation `null` pour les arêtes).

J'ai mis en place un **pattern Template Method** un peu adapté aux exigences du TP, le diagramme UML résultant est ci-dessous.

![uml_tp1b-q2](img/tp1b-q2.png)

## Question 3
*Expliquer le code ajouté et insérer un schéma du patron de conception mis en place*

Dans cette partie, j'ai également mis en place un **pattern Template Method**, couplé à un **pattern Iterateur**. Le diagramme UML correspondant aux questions 3 et 4 est ci-dessous, après la question 4. J'ai réorganisé un peu les classes en créeant un package search et un package graphe.

Dans l'objectif de sortir au maximum la logique commune aux deux algorithmes de recherche, j'ai créé une **classe abstraite** `ASearchAlgoIterator`, qui implémente l'interface java `Iterator<Node>`. Tout l'intérêt de cette classe, qui est la pierre de voûte de mes deux designs patterns, est de pouvoir y implémenter la logique commune aux deux algorithmes de recherche, et de leur faire chacun une classe dédiée avec leur logique spécifique.

La classe `ASearchAlgoIterator` possède 3 attributs (dont la visibilité est **protected**, pour être accessible par les classes filles) : une liste de noeuds marqués, un graphe, et un index (un curseur dans la liste). Le constructeur, dont la visibilité est également **protected**, prend en paramètre le noeud de départ pour la recherche et le graphe dont il est issu, et initialise la liste de noeuds avec uniquement le noeud de départ, et stock le graphe dans son attribut correspondant. Ce constructeur est appelé par les classes filles.

La méthode `hasNext` surcharge celle de l'interface `Iterator`, et renvoie true si l'**index** n'est pas égal à la longueur de la liste de noeuds, c'est à dire tant que l'on a pas parcouru tous les noeuds de la composante connexe actuelle du graphe.

La méthode `next` surcharge également la méthode de même nom de l'interface `Iterator`, et renvoie le prochain noeud à explorer, en accord avec l'algorithme choisi, notamment grâce à l'utilisation de la méthode abstraite `getNextNode`, renvoyant le noeud à explorer actuellement, et étant surchargée dans les classes filles. C'est également dans la méthode `next` que les prochains noeuds à être explorés sont marqués, en vérifiant si le noeud qui va actuellement être exploré a des voisins à ajouter aux noeuds marqués. 

La méthode `getNextNode` est la seule qui est spécifique à chacun des algorithmes. C'est elle qui fait le parcours dans la liste des noeuds marqués pour nous donner le noeud à explorer à chaque appel de `next`.

Dans le cas de l'algorithme de parcours en largeur, la méthode `getNextNode` de la classe `BFSIterator` (qui hérite de `ASearchAlgoIterator`) se contente de renvoyer le prochain noeud de la liste des noeuds marqués et d'incrémenter l'index de 1, puisque les noeuds sont ajoutés à la liste suivant la technique de marquage de l'algorithme **DFS** dans la méthode `next`de `ASearchAlgoIterator`.

## Question 4
*Expliquer le code ajouté et insérer un schéma du patron de conception mis en place*

En revanche, pour l'algorithme de parcours en profondeur, il a fallu adapter la classe `DFSIterator`(héritant de `ASearchAlgoIterator`), pour bien que le comportement de l'itérateur soit celui d'un algorithme de parcours en profondeur.

J'ai pour cela eu besoin d'une deuxième liste de noeuds, `_explored_nodes`, qui me sert à éviter d'explorer le même noeud plusieurs fois. 

Il me suffit donc dans la méthode `getNextNode`de renvoyer le premier noeud qui n'a pas été exploré en partant de la fin de la liste des noeuds marqués, sans oublier d'ajouter ce dernier à la liste des noeuds explorés avant de le renvoyer. J'incrémente également `_index` pour que la méthode `hasNext` fonctionne toujours.

 > J'aurai pu utiliser une deuxième liste directement dans la classe `ASearchAlgoIterator` pour différencier les noeuds marqués et les noeuds à explorer, mais comme l'**algorithme BFS** ne le nécessitait pas, j'ai préféré ne pas nous en encombrer à ce niveau.

Le diagramme UML ci-dessous présente l'architecture à laquelle j'ai abouti pour les question 3 et 4.

![uml_tp1b-q3&4](img/tp1b-q3&4.png)

L'utilisation du **design pattern Iterateur** m'a permis de créer une couche d'abstraction à la fois sur le type de graphe manipulé (grâce à ce que j'avais déjà réalisé pour la question 2) mais également sur l'algorithme utilisé pour le parcours dans le graphe, ce qui s'inscrit dans le respect du **principde d'inversion des dépendances**. `TestSearch` utilise en effet des objets de plus bas niveau comme`BFSIterator` à travers un calque d'abstraction. 

Cette générisation du comportement est très pratique. Je connaissais déjà l'interface `Iterator` et l'utilisait déjà assez fréquemment, mais c'est la première fois que je crée un itérateur personnalisé, et cela m'a permis de saisir les possibilités que ce modèle offre.

De plus, l'utilisation du **design pattern Template Method** m'a permis de diminuer au maximum les doublons de code, ce qui rend plus facile le débug et la maintenance. 

Par exemple, j'ai eu un problème au début avec mon ajout des noeuds dans la liste de noeuds marqués qui n'était pas tout à fait correct, et j'ai pu facilement localiser le problème en mode debug. Comme je n'ai pas dupliqué cette partie de code, je n'ai à la corriger qu'une seule fois, au lieu de la corriger dans les deux algorithmes que j'implémente. Cela aurait pû être désastreux si j'avais une trentaine d'algorithmes.

L'utilisation du **design pattern Template Method** s'inscrit dans le respect du **principe de responsabilité unique**. J'ai essayé dans ce TP de respecter au maximum les principes **SOLID**. Par exemple, pour ce qui est du **principe de substitution de Liskov**, que l'on manipule un graphe orienté (classe `Graph`) ou un graphe non-orienté (classe `UndirectedGraph`), tout le programme fonctionne correctement. C'est notamment grâce à l'utilisation de nombreuses interfaces spécifiques (`IGraph`, `IDirectedGraph`, `IUnirectedGraph`), en accord avec le **principe de ségrégation des interfaces**, que cette abstraction du type exact de graphe est possible.

Le respect des principes **SOLID** permet de concevoir un code robuste, aisément compréhensible, et le plus facile possible à maintenir et à faire évoluer. Pour respecter au mieux ces concepts, il convient de choisir des design patterns adaptés à notre projet.


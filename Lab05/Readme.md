# SEG3503

|  |  |
| --- | --- |
| Course | SEG 3503 |
| Date | Summer 2021 |
| Professor | Andrew Forward, aforward@uottawa.ca |
| TA | Aymen Mhamdi, amham077@uottawa.ca |
| Team | Hedi Ben Abid 300123192 |

* [Lab05](Lab05)
<br />
<br />
------

# 1) Grades

Lors de l'utilisation d'une méthode stub, j'ai générer un nombre aléatoire entre 1 et 100 pour la note en pourcentage et un élément aléatoire de la liste des résultats possibles pour la note alphabétique et la note numérique.

Voici un exemple sur le site Web :
<br />
<br />
![Capture d’écran 2021-07-04 à 21 12 14](https://user-images.githubusercontent.com/55165009/124398241-8f646700-dd0c-11eb-8de7-f4654b3dbb47.png)

Cependant, lorsque j'ai essayé d'implémenter les solutions qu'on a trouver dans le devoir 2, je me rends compte qu'il y'a une erreur Arithmétique
Comme suit : 
<br />
<br />
![Capture d’écran 2021-07-04 à 21 14 22](https://user-images.githubusercontent.com/55165009/124398335-24fff680-dd0d-11eb-8cdb-8d8c747d4cc6.png)
<br />
<br />
Individuellement, le fichier calculateur.ex a réussi tous les tests et n'a rencontré aucun problème. Cependant, sans avoir utilisé les tests d'intégration, nous ne savions pas que les méthodes de ce fichier ne fonctionneraient pas avec le site Web, car le site Web donnait des arguments sous forme de chaîne plutôt que sous forme d'entier. Par conséquent, pour résoudre ce problème, nous aurions besoin d'ajuster les méthodes afin que les résultats soient convertis de la forme chaîne à la forme entière avant d'effectuer les calculs.

------


# 2) Twitter

Initialement, tous les cas de test n'ont pas fonctionné pour le code qui nous a été fourni. Comme on peut le voir dans la capture d'écran ci-dessous, les méthodes handleNull et dontReturnSubstring ne passaient pas

![Capture d’écran 2021-07-04 à 21 19 38](https://user-images.githubusercontent.com/55165009/124398427-92ac2280-dd0d-11eb-8a73-5e2d148c0eb6.png)

Après avoir examiné le code source, j'ai réalisé que la raison pour laquelle la méthode isMentioned n'a pas de code gérant les valeurs nulles et que le code pour vérifier qui a été tagué dans le tweet vérifie uniquement que le nom est une sous-chaîne et non s'il est égal à l'ensemble chaîne après le "@". 
<br />
J'ai alors fais les changements necessaires pour régler le problème.
<br />
J'ai ensuite obtenu les résultats suivants :
<br />
![Capture d’écran 2021-07-04 à 21 22 27](https://user-images.githubusercontent.com/55165009/124398510-f8001380-dd0d-11eb-8007-1815b8f5cdcf.png)

![Capture d’écran 2021-07-04 à 21 23 06](https://user-images.githubusercontent.com/55165009/124398526-136b1e80-dd0e-11eb-80e8-cdf46d5ea692.png)

Comme on peut le voir sur la capture d'écran, le test actual_call n'a pas fonctionné, mais cela est simplement dû à la façon dont fonctionne le code de load_tweet. La fonction utilise un générateur de nombres aléatoires pour générer une chaîne et a un changement de 45% pour obtenir la chaîne contenant le nom correct pour que le test réussisse et un changement de 55% pour renvoyer une chaîne avec le nom incorrect attendu du test.



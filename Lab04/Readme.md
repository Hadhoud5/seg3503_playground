# SEG3503

|  |  |
| --- | --- |
| Course | SEG 3503 |
| Date | Summer 2021 |
| Professor | Andrew Forward, aforward@uottawa.ca |
| TA | Aymen Mhamdi, amham077@uottawa.ca |
| Team | Hedi Ben Abid 300123192 |

* [Lab04](Lab04)
<br />
<br />

Nous allons travailler sur les test concernant le repertoire Tic.

<br />
<br />

# Commit n°1 : Echec

***On commence tout d'abord par implémenter une mauvaise valeur pour etre sur que le test échoue  :*** 
<br />
<br />
Screenshot JUnit : ![Capture d’écran 2021-06-10 à 21 17 18](https://user-images.githubusercontent.com/55165009/121591359-500a6980-ca31-11eb-9c5a-98f9fdaeb2c4.png)

<br />

# Commit n°2 : Le test ne donne plus d'échec


<br />
<br />
       
# Commit n°3 : Ajout d'autres tests

Ajout de tests pour des grilles " Nx1, 1xN et NxM " quelques cas d'érreurs ont fait face :

![Capture d’écran 2021-06-10 à 21 37 04](https://user-images.githubusercontent.com/55165009/121593582-066f4e00-ca34-11eb-8593-c5224652d249.png)

<br />
<br />

# Commit n°4 : Ajustement de la méthode
<br />
La méthode produit désormais les resultats attendus. 
<br />
<br />


# Commit n°5 : Ajout d'autres tests 

La classe Java "Tic" ne contenait qu'une seule méthode "EmptyBoard" qui prenait les entiers pour les colonnes et les rangées et qui retournait un String.
Apres la finalisation des tests qui marchent, j'ai créer un constructeur pour deux objets: un qui prend des entiers comme paramètres et un sans paramètres qui produit 
un tableau 3X3 vide.
"EmptyBoard" method s'est transformé en toString() et j'ai ajouté deux méthodes (size et showPositions). Les tests ajoutés ensuite sont tous fonctionnels 

<br />
<br />

Voici l'ensemble des commits ainsi qu'un code couleur pour "Pass, Fail, Refractoring"
<br />
<br />

![Image 10-06-2021 à 22 25](https://user-images.githubusercontent.com/55165009/121599975-b85e4880-ca3b-11eb-994a-f395a2625480.JPG)




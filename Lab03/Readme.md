# SEG3503

|  |  |
| --- | --- |
| Course | SEG 3503 |
| Date | Summer 2021 |
| Professor | Andrew Forward, aforward@uottawa.ca |
| TA | Aymen Mhamdi, amham077@uottawa.ca |
| Team | Hedi Ben Abid 300123192 |

* [Lab03](Lab03)


# Run, test and compiling
***On commence tout d'abord par compiler les fichiers fournit grace a la ligne de code suivante dans le repertoire Computation et le repertoire Date :*** 
<br />
<br />



- Computation folder :          ```cd ./Desktop/Lab03/computation/src ```
- Compiling :                    ```javac Computation.java```
       

- Date folder :                 ```cd ./Desktop/Lab03/Date/src```
- compiling :                    ```javac Date.java```

<br />
<br />
       
***Ensuite nous procédons aux premiers test avec l'agent Jacoco grace a la ligne de code suivante dans le repertoire Computation et le repertoire Date :***. 

<br />

- Computation folder :          ```cd ./Desktop/Lab03/computation/bin```
- Genereating test and html :  ```./bin/jacoco```
 
- Date folder :                  ```cd ./Desktop/Lab03/Date/bin```
- Genereating test and html :  ```./bin/jacoco```
 
<br />
<br />
 
***Nous obtenons les resultats suivants pour la classe Date***. 
<br />
<br />

 
 <img width="562" alt="Capture d’écran 2021-06-03 à 16 12 39" src="https://user-images.githubusercontent.com/55165009/120672695-7016b780-c48a-11eb-8de0-375f5c9af3d0.png">
<img width="562" alt="Capture d’écran 2021-06-03 à 16 12 46" src="https://user-images.githubusercontent.com/55165009/120672706-7311a800-c48a-11eb-8c89-fb7a59b58a11.png">

<br />
<br />

***Nous obtenons les resultats suivants pour la classe Computation***. 


<img width="562" alt="Capture d’écran 2021-06-03 à 16 14 53" src="https://user-images.githubusercontent.com/55165009/120696331-52564c00-c4a4-11eb-9dee-a2c7cd96fefd.png">

<br />
<br />

***Rapport généré pour les deux classes***.

<br />
<br />

Date Rapport : 

<br />
<img width="1274" alt="Capture d’écran 2021-06-03 à 19 51 07" src="https://user-images.githubusercontent.com/55165009/120697014-1c659780-c4a5-11eb-8e7c-c8714a2e0769.png">

<br />

Computation Rapport :
<br />
<img width="1274" alt="Capture d’écran 2021-06-03 à 19 51 18" src="https://user-images.githubusercontent.com/55165009/120697056-27b8c300-c4a5-11eb-912a-d34ca8db1f80.png">

<br />

# Objectif 100% de couverture test

<br />

Les cas de test couvrent deja 88% des instructions ainsi que 79% en couverture de la branche pour la classe DateTest comme suit : 

<br />

<img width="1274" alt="Capture d’écran 2021-06-03 à 19 57 09" src="https://user-images.githubusercontent.com/55165009/120697649-e674e300-c4a5-11eb-8890-e7a3878292d8.png">

<br />

J'ai ensuite regardé dans le fichier Date.java pour voir les eventuelles erreurs : 
<br /> 
<img width="989" alt="Capture d’écran 2021-06-03 à 20 05 16" src="https://user-images.githubusercontent.com/55165009/120698923-9d259300-c4a7-11eb-9040-4040d8d0fa3d.png">
<br />

Apres avoir ajouter les tests adéquates, voici ce que j'ai obtenu au moment de lancer les tests :
<br />
<img width="1008" alt="Capture d’écran 2021-06-03 à 20 13 53" src="https://user-images.githubusercontent.com/55165009/120699523-64d28480-c4a8-11eb-90c1-951a5e710a98.png">

<br />

<img width="1008" alt="Capture d’écran 2021-06-03 à 20 14 03" src="https://user-images.githubusercontent.com/55165009/120699536-68660b80-c4a8-11eb-8705-f2b10570e31d.png">

<br />

Nous obtenons donc 99% en couvertures instructions ainsi que 93% en couverture de branche.


# Passons au Refractoring

Nous obtenons les résultats suivants :
<br />

<img width="411" alt="Capture d’écran 2021-06-03 à 20 18 28" src="https://user-images.githubusercontent.com/55165009/120699876-e2969000-c4a8-11eb-9553-442c70d77924.png">

<br />

Nous obtenons alors le rapport suivant apres le refractoring : 
<br />

<img width="1008" alt="Capture d’écran 2021-06-03 à 20 19 09" src="https://user-images.githubusercontent.com/55165009/120700028-0d80e400-c4a9-11eb-9ef9-6563cc699491.png">

<br />

***La couverture des instructions est passée de 93% a 94%, mais la couverture d'état reste inchangée***




                          

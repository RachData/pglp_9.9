# pglp_9.9
# Logiciel de dessin
Objectif du projet

Réalisation d'un logiciel de dessin qui permet de faire une description textuelle et de de manipuler les figures géométriques telles que: des cercles, des rectangles, des carrés et des triangles.
Description des figures

    Un cercle est une figure géométrique ayant un centre et un rayon. Exemple: Cercle(centre=(0,0),rayon=10)

# Manuel Utilisateur

Cette application possède plusieurs fonctionnalités à savoir:

    Créer une figure géométrique
    Déplacer une figure géométrique
    Afficher une ou un ensemble de figure géométrique
    Supprimer une figure géométrique
    Annuler la dernière commande
    Quitter le programme.

Syntaxes des commandes:

    Création d'un cercle: NomCercle =Cercle((X, Y), rayon)
    Création d'un carré: Nomcarre =Carre((Point1_X, Point1_Y), coté)
    Création d'un rectancle: NomRectangle =Rectangle((Point1_X, Point1_Y), longueur, largeur)
    Création d'un triangle: NomTriangle =Triangle((Point1_X, Point1_Y), (Point2_X, Point2_Y), (Point3_X, Point3_Y))
    Pour afficher une figure : affiche(Nomfigure)
    Pour déplacer une figure : move(NomFigure, (Point1, Point2))
    Pour quitter le programme: quit()

Les exemples de commandes valides:

    Pour créer un cercle: c1 =Cercle((0, 0), 50)
    Pour afficher le triangle t1: affiche(
    Pour déplacer le cercle c1 : move(c1, (10, 20))
    Pour déplacer toutes les figures crées: move(all, (10, 20))
    Pour afficher toutes les figures crées crées: view all
    Pour quitter le programme: quit

Compilation et execution du projet

    Pour cloner le projet : (https://github.com/RachData/pglp_9.9.git)
    Pour le compiler et l'exécuter:

`mvn clean`

`mvn package`

`java -jar target/pglp_9.9-1.0-SNAPSHOT.jar `

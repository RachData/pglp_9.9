# pglp_9.9
# Logiciel de dessin
Objectif du projet

Réalisation d'un logiciel de dessin qui permet de faire une description textuelle et de de manipuler les figures géométriques telles que: des cercles, des rectangles, des carrés et des triangles.
Description des figures

    Un cercle est une figure géométrique ayant un centre et un rayon. Exemple: Cercle(centre=(0,0),rayon=10)

# Manuel Utilisateur

Cette application possède plusieurs fonctionnalités à savoir:

    Créer une figure ou un groupe de figure géométrique
    Déplacer une figure ou un groupe de figure géométrique
    Afficher une figure ou un groupe de figure géométrique
    Quitter le programme.

Syntaxes des commandes:

    Création d'un cercle: NomCercle =Cercle((X, Y), rayon)
    Création d'un carré: Nomcarre =Carre((Point1_X, Point1_Y),(Point2_X, Point2_Y))
    Création d'un rectancle: NomRectangle =Rectangle((Point1_X, Point1_Y), (Point2_X, Point2_Y))
    Création d'un triangle: NomTriangle =Triangle((Point1_X, Point1_Y), (Point2_X, Point2_Y), (Point3_X, Point3_Y))
    Creation d'un groupe: Nom_groupe = groupe(nomfig1,nomfig2)
    Pour afficher une figure : affiche(Nomfigure)
    Pour déplacer une figure : move(NomFigure, (Point1, Point2))
    Pour quitter le programme: quit()

Les exemples de commandes:

    Pour créer un cercle: cer1 =Cercle((0, 0), 50)
    Pour afficher le triangle tri1: affiche(t1)
    Pour déplacer le cercle c1 : move(cer1, (10, 20))
    Pour quitter le programme: quit()
    
# Manuel Technique

Une figure (ensemble de figures) est sauvegarder dans un SGBD embarquer automatiquement une fois la figure crée. Le nom de 
chaque figure etant unique on ne peux avoir deux figures ayant le meme nom.

Compilation et execution du projet

    Pour cloner le projet : (https://github.com/RachData/pglp_9.9.git)
    Pour le compiler et l'exécuter:

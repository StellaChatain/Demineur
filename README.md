# Demineur
¯README¯

¦COOKIE-LANTA¦

Ce jeu est une variante du démineur, sous forme de labyrinthe. En effet le joueur se retrouve sur une 
plateforme carré dont il choisit la dimension. Il devra, pour gagner, récupérer  un  «cookie» (visible 
dès le début du jeu) qui se situe sur une case de cette plateforme.  Au début du jeu, le joueur se situe 
sur la case la plus en haut à gauche (case 0/0 du tableau), et ne peut se déplacer que de case en 
case : déplacement en haut avec la touche 8 du pavé numérique, à gauche avec la touche 4, à droite 
avec la touche 6, et en bas avec la touche 5. Sur la plateforme, le joueur peut rencontrer des murs 
(toujours visibles) sur lesquels il ne peut pas se déplacer, et des mines (invisibles) qui lui font perdre 
la partie s’il se déplace dessus. Des indices (chiffres) s’affichent seulement sur les murs et sur les 
cases où le joueur est déjà passé. Ce chiffre indique le nombre de mines se situant sur les cases 
adjacentes à la case concernée (toute, c’est-à-dire les 8 cases autour en comptant celles en 
diagonale). Le joueur peut ainsi se déplacer en sachant plus ou moins où se situent les mines. A la fin 
d’une partie, le jeu propose au joueur si il veut rejouer ou non.

Classe (à compiler) : 
*	Joueur : Créer un objet « joueur » qui se situe sur une case. C’est ce joueur que l’on déplace 
	tout au long de la partie.
*	Case : Créer une case et sa nature (mine, ou mur, ou rien)
*	TableauDeCases : Génère l’organisation du tableau en le remplissant de « cases », fournit 
	chaque case avec son nombre de mines voisines, génère un cookie, gère le déplacement, 
	ainsi que la défaite et la victoire.
*	Main (à exécuter) : Fait tourner le jeu et chaque manche, affiche le tableau de cases et les 
	consignes de jeu. 


A savoir : 
*	Le jeu empêche le joueur de se déplacer en dehors du tableau 
*	Les murs indiquent aussi le nombre de mines adjacentes
*	Le joueur peut retourner sur une case sur laquelle il est déjà passé
*	Il ne peut pas y avoir de mine, ni de mur, ni de cookie sur la première case (en haut à 
	gauche), ni de mine ou mur sur la case en dessous de la première case
*	Malgré les efforts fournit par le joueur, certaines parties ne pourront être gagnées, au vue du 
	caractère aléatoire de la génération des mines / murs / cookie

Affichage :
*	« x » = Case sur laquelle se trouve le joueur
*	« CK » = Cookie
*	« : 0 » ou « : 1 » ou « : 3 »…etc. (donc chiffre sur la droite de la case) = nombre de mines 
	voisines
*	« // » = mur
*	«     » = case cachée
*	« _ : » = Case sur laquelle on est déjà passée

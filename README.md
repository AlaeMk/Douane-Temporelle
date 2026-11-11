 ##  Mini Projet : Douane Temporelle 

*   **Nom & Prénom :** Alae Benelmekki
*   **Groupe :** A06
*   **Matricule / Clé utilisée :** `1784` (Les 4 derniers chiffres de la carte d'étudiant)
*   **Initiales (pour les IDs) :** `ab`

---

##  Description du Projet
L'application simule un poste de douane pour les voyageurs du temps. Elle est composée de trois interfaces (Activités) communicant via des Intents explicites.

1.  **MainActivity (Formulaire) :** Permet la saisie du nom, de l'année de naissance, de l'année de destination et du motif du voyage.
2.  **VerificationActivity (Scanner de Paradoxe) :** Affiche un "Passeport Temporel" avec le résumé des données et l'âge temporel calculé. C'est ici que la règle du paradoxe (nombre premier) s'applique.
3.  **ResultActivity (Verdict) :** Affiche le verdict final avec un fond dynamique (Vert pour approuvé, Rouge pour refusé) et un message personnalisé.

---

##  Contraintes de l'énoncé respectées (Initiales `ab` & Clé `1784`)
Toutes les contraintes techniques demandées dans l'énoncé ont été rigoureusement respectées :

*   **Structure de l'Activité 2 :** Construite avec un `LinearLayout` horizontal racine. L'image à gauche a un poids de `0.3` et le `RelativeLayout` pour les textes a un poids de `0.7`.
*   **Clés Dynamiques (Classe KeyExtra) :** Toutes les clés `putExtra` sont préfixées par `1784` (ex: `1784_NOM_VOYAGEUR`). Elles ne sont pas codées en dur, mais générées via des méthodes statiques (ex: `KeyExtra.getNomKey(...)`).
*   **Règle du Paradoxe :** Dans l'Activité 2, si le motif est *"Modification du passe"* ET que l'âge temporel (Destination - Naissance) est un nombre premier, le bouton "Approuver" est automatiquement désactivé (disabled) dès le chargement.
*   **IDs de l'interface :** Tous les IDs des éléments (TextView, EditText, Button) incluent les initiales du groupe (ex: `et_Nom_ab`, `btn_approuver_ab`).

---

## ✨ Fonctionnalités Optionnelles (Ajoutées par l'étudiant)
Au-delà des exigences de base, plusieurs fonctionnalités ont été ajoutées pour rendre l'application plus professionnelle, sécurisée et unique :

*   **Design Premium & Immersif :** 
    *   *Interface 1 :* Thème sombre futuriste avec des bordures néon (Cyberpunk).
    *   *Interface 2 :* Design d'un vrai Passeport Temporel avec image de fond personnalisée.
    *   *Interface 3 :* Design épuré avec icônes Material Design et transitions de couleurs.
*   **Gestion Avancée des Exceptions (Zéro Crash) :** 
    *   `try-catch` pour gérer les erreurs de format (si l'utilisateur tape des lettres dans l'année).
    *   Vérification des champs vides avec des **Toasts**.
    *   `AlertDialog` pour avertir l'utilisateur d'un paradoxe temporel (Destination <= Naissance).
    *   Vérification du format du nom (Regex) et de la longueur de l'année (exactement 4 chiffres).
    *   Sécurisation des données reçues dans les Activités 2 et 3 (vérification des `null`).
*   **Bouton "Annuler" :** Ajout d'un bouton dans l'Activité 2 permettant de revenir au formulaire (MainActivity) pour corriger les données saisies sans perdre la saisie.
*   **Optimisation & Clean Code :** Utilisation de méthodes séparées (`lancerVerdict()`, `nbPrmier()`) et gestion sécurisée de la navigation avec `finish()` et `FLAG_ACTIVITY_CLEAR_TOP` pour éviter de saturer la mémoire.

---

## 📸 Captures d'écran


| 1. Formulaire (MainActivity) | 2. Scanner (VerificationActivity) | 3. Verdict (ResultActivity) |
| :---: | :---: | :---: |
| <img width="372" height="762" alt="image" src="https://github.com/user-attachments/assets/ae1d48a0-fdec-46cb-8d21-e33d67080b34" />| <img width="367" height="687" alt="image" src="https://github.com/user-attachments/assets/157a124e-f964-441a-a3af-b3b09b251df1" />| <img width="367" height="711" alt="image" src="https://github.com/user-attachments/assets/14cf76f7-4be5-4310-a8d7-db1e31462671" />
| <img width="357" height="697" alt="image" src="https://github.com/user-attachments/assets/15c7f54d-1613-46ff-b131-063d0d556580" />| <img width="352" height="632" alt="image" src="https://github.com/user-attachments/assets/3c5ece07-046e-4e46-b4cd-88761f5a0b45" />




---

## 🚀 Comment exécuter le projet ?
1. Cloner le dépôt : `git clone [Lien de ton repo]`
2. Ouvrir le projet avec **Android Studio**.
3. Lancer l'émulateur (API 29+ recommandé) et cliquer sur **Run**.

***

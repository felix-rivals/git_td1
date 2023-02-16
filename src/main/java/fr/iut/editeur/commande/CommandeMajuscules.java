package fr.iut.editeur.commande;

import fr.iut.editeur.document.Document;
public class CommandeMajuscules extends CommandeDocument {

    public CommandeMajuscules(Document document, String[] parameters) {
        super(document, parameters);
    }

    @Override
    public void executer() {
        if(parameters.length < 3) {
            System.err.println("Format attendu : majuscules;depart;fin");
            return;
        }
        String texte = parameters[3];
        int depart = -1;

        int fin = -1;
        try {
            fin = Integer.parseInt(parameters[2]);
            depart = Integer.parseInt(parameters[1]);
        } catch (NumberFormatException nfe){
            System.err.println("Format attendu : remplacer;depart;fin");
            return;
        }

        this.document.majuscules(depart, fin);
        super.executer();
    }

}

package fr.iut.editeur.commande;

import fr.iut.editeur.document.Document;
public class CommandeRemplacer extends CommandeDocument {


    public CommandeRemplacer(Document document, String[] parameters) {
        super(document, parameters);
    }

    @Override
    public void executer() {
        if(parameters.length < 4) {
            System.err.println("Format attendu : remplacer;depart;fin;chaine");
            return;
        }
        String texte = parameters[3];
        int depart = -1;

        int fin = -1;
        try {
            fin = Integer.parseInt(parameters[2]);
            depart = Integer.parseInt(parameters[1]);
        } catch (NumberFormatException nfe){
            System.err.println("Format attendu : remplacer;depart;fin;chaine");
            return;
        }

        this.document.remplacer(depart, fin, texte);
        super.executer();
    }

}
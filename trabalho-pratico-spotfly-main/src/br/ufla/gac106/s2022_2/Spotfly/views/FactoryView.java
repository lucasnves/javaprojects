package br.ufla.gac106.s2022_2.Spotfly.views;

public class FactoryView {
    
    public View criarView(EnumView tipo){
        View view = null;

        if(tipo == EnumView.VIEWADMINISTRACAO){
            view = new viewAdmnistracao();
        }

        else if(tipo == EnumView.VIEWAVALIACAO){
            view = new viewAvaliacao();
        }

        else if(tipo == EnumView.VIEWRELATORIO){
            view = new viewRelatorio();
        }

        return view;
    }
}

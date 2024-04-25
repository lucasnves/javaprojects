package br.ufla.gac106.s2022_2.Spotfly.modulos;

import java.io.Serializable;
//import para hashmap e arraylist
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import obras de artes
import br.ufla.gac106.s2022_2.Spotfly.obrasdeArte.ObradeArte;
import br.ufla.gac106.s2022_2.Spotfly.Arquivo;
import br.ufla.gac106.s2022_2.Spotfly.ControleAcesso;
import br.ufla.gac106.s2022_2.Spotfly.obrasdeArte.Musica;
import br.ufla.gac106.s2022_2.Spotfly.obrasdeArte.Pintura;


import br.ufla.gac106.s2022_2.Spotfly.usuarios.TipoUser;
import br.ufla.gac106.s2022_2.Spotfly.usuarios.Usuario;
import br.ufla.gac106.s2022_2.Spotfly.usuarios.factoryUser;

public class Administracao  implements Serializable {

    // Atributos 
    private ArrayList<ObradeArte> obras;// indica toda as obras cadastradas no sitema
    private HashMap<String, Usuario> usuarios;// indica todos os usuários cadastrados no sistema
    private static Arquivo arquivo;
    private static Administracao instancia; 
    private factoryUser factory; //fabricas de usuarios

    // Métodos
    private Administracao() {
        /*
         * Padrão de projeto Singleton,
         * garante que apenas uma instancia do objeto
         * Administração seja criada.
         */
        obras = new ArrayList<>();
        usuarios = new HashMap<>();
        factory = new factoryUser();

        usuarios.put("adm", factory.createUsuario(TipoUser.ADMINISTRADOR, "adm", "adm"));
        usuarios.put("mod",factory.createUsuario(TipoUser.MODERADOR, "mod", "mod"));
        usuarios.put("comum", factory.createUsuario(TipoUser.ADMINISTRADOR, "comum", "comum"));
    }

    public static Administracao getInstancia(){
        if(instancia==null){ //verifica se ja foi instanciado
            arquivo = new Arquivo();
            instancia = arquivo.getDados(); //obtem instancia do arquivo
            if(instancia==null){ //verifica se exsite algum arquivo salvo
                instancia = new Administracao();
                return instancia;
            }
        }
        return instancia; //existe instancia, retorna a instancia atual
    }

    public void encerrar(){
        arquivo.salvarDados(instancia); //salva instancia atual
    }

    // Cadastra obras - - - - - - - - - - - - - - - - - - - - - - - - -
    public void cadastrarMusica(String nomeItem, String autor, String descricao, String gravadora, String estilo) {
        ObradeArte novaObra = new Musica(nomeItem, autor, descricao, gravadora, estilo);
        obras.add(novaObra);
    }

    public void cadastrarPintura(String nomeItem, String autor, String descricao, String preco, String categoria) {
        ObradeArte novaObra = new Pintura(nomeItem, autor, descricao, preco, categoria);
        obras.add(novaObra);
    }

    // Visualizar itens do sistema - - - - - - - - - - - - - - - - - - - - - - - - -
    // -
    public String getItens() {
        String todosItens = "";

        for (ObradeArte obraBuscada : obras) {
            todosItens += "\nNome da obra: " + obraBuscada.getNome() + "\nTipo: " + obraBuscada.getTipo() + "\n";
        }
        return todosItens;
    }

    // Busca por um item específico e o exibe - - - - - - - - - - - - - - - - -
    public String getDescricaoItem(String nome) {
        ObradeArte obra = getObra(nome);
        if(obra!=null) {
            return obra.getDescricaoCompleta();
        } else {
            return "\n*Obra nao encontrada!\n";
        }

    }

    public String getNomeItem(String nome){
        ObradeArte obra = getObra(nome);
        if(obra!=null){
          return  obra.getNome();
        }
        return null; 
    }

    public ObradeArte getObra(String nome){
        for (ObradeArte obra : obras) {
            if (obra.getNome().equals(nome)) {
                return obra;
            }
        }
        return null;
    }


    // Exclui o ultimo item cadastrado - - - - - - - - - - - - - - -
    public String ExcluirItem(String nome) {
        if (!obras.isEmpty()) {
            for (ObradeArte obra : obras) {
                if (obra.getNome().equals(nome)) {
                    obras.remove(obra);
                    return "*\nObra removida com sucesso";
                }
            }
            return "\n*Não há obras com o nome [" + nome + "] no sistema";
        }
        return "\n*Não há obras cadastradas";
    }

    // Cadastrar usuarios no sistema - - - - - - - - - - - - - - - - - - - - - -
    public void cadastrarAdministrador(String login, String senha) { //
        Usuario adm = factory.createUsuario(TipoUser.ADMINISTRADOR,login, senha);
        usuarios.put(login, adm);
    }

    public void cadastrarModerador(String login, String senha) {
        Usuario mod =  factory.createUsuario(TipoUser.MODERADOR,login, senha);
        usuarios.put(login, mod);
    }

    public void cadastrarComum(String login, String senha) {
        Usuario comum = factory.createUsuario(TipoUser.COMUM,login, senha);
        usuarios.put(login, comum);
    }

    // buscar por um usuario específico - - - - - - - - - - - - - - - - - - - - - -
    // -
    public boolean buscarUser(String login) {
        if(usuarios.get(login)!=null){
            return true;
        }
        return false;
    }

    //retorna a lista de obras de arte
    public List<ObradeArte> getListObras(){
        return obras;
    }

    //retorna o Map de usuários
    public Map<String,Usuario> getMapUsuarios(){
        return usuarios;
    }

    //obtem usuario logado de controle de acesso
    public Usuario getUserLogado(){
        return ControleAcesso.getInstancia().getUsuarioLogado();
    }
}

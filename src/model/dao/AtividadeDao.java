package model.dao;

import exceptions.AtividadeJaCadastradaException;
import java.io.IOException;
import java.util.ArrayList;
import model.pojo.Atividade;

/**
 *
 * @author Elias Júnior
 */
public interface AtividadeDao {

    /**
     * Obtém uma Atividade à partir do ID
     *
     * @param id ID da atividade que deseja obter
     * @return Objeto de Atividade
     */
    public Atividade getAtividadeById(int id);

    /**
     * Obtém todas as atividades do DAO
     *
     * @return Lista de objetos Atividade
     */
    public ArrayList<Atividade> getAtividades();

    /**
     * Salva os dados
     *
     * @throws IOException Caso haja um problema para salvar
     */
    public void saveFile() throws IOException;

    /**
     * Adiciona uma atividade ao DAO
     *
     * @param atividade Atividade a ser adicionada
     * @throws AtividadeJaCadastradaException Caso a atividade já esteja
     * cadastrada
     * @throws IOException Caso haja problea ao salvar o arquivo
     */
    public void adicionarAtividade(Atividade atividade) throws AtividadeJaCadastradaException, IOException;

}

package view.console;

import exceptions.AtividadeJaCadastradaException;
import exceptions.TurmaNaoEncontradaException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import model.dao.AtividadeDao;
import model.dao.TurmaDao;
import model.pojo.Atividade;

/**
 *
 * @author Elias Júnior
 */
public class AtividadeViewConsole {

    public static void imprimirAtividades() {
        System.out.println("imprimir atividades aqui");
    }

    public static void cadastraAtividade(AtividadeDao dao, TurmaDao turmaDao) {

        Scanner sc = new Scanner(System.in);
        String nome, dataStr, tipo;
        SimpleDateFormat data;
        int turmaId;

        System.out.println("∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎");
        System.out.println("∎∎∎∎∎∎∎∎∎∎∎ CADASTRO ATIVIDADE ∎∎∎∎∎∎∎∎∎∎∎");
        System.out.println("∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎∎");

        System.out.println("");

        System.out.print("Digite o nome da atividade: ");
        nome = sc.nextLine();
        System.out.print("Digite a data da atividade (dd/mm/yy): ");
        dataStr = sc.nextLine();
        data = new SimpleDateFormat("25/01/1994");
        System.out.print("Digite o tipo da atividade: ");
        tipo = sc.nextLine();
        System.out.print("Digite o ID da turma: ");
        turmaId = sc.nextInt();

        Atividade atividade = new Atividade(nome, data.getCalendar(), tipo);

        try {
            turmaDao.adicionarAtividade(turmaId, atividade.hashCode());
            turmaDao.saveFile();
            dao.adicionarAtividade(atividade);
        } catch (AtividadeJaCadastradaException ex) {
            System.out.println("A atividade já está cadastrada nessa turma.");
        } catch (TurmaNaoEncontradaException ex) {
            System.out.println("Turma inválida.");
        } catch (IOException ex) {
            System.out.println("Houve um erro ao adicionar ao banco de dados.");
        }

    }

}

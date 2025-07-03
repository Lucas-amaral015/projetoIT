package controller.jointcell;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import util.FileLoader;

import java.io.IOException;
import java.util.List;

public class TelaJoint {



    @FXML private Label textAreaConteudo;
    @FXML private ImageView imageViewer;
    @FXML private Button btnAnterior;
    @FXML private Button btnProxima;

    private List<String> imagens;
    private int indiceAtual = 0;

    private static final String BASE_TXT = "texto/joint_cell/";
    private static final String BASE_IMG = "imagens/joint_cell/";



    // Botões clicáveis para cada checklist
    @FXML private void handleChecklistAquecedor() {
        carregarChecklist(BASE_TXT  + "Checklist70666.txt",
                BASE_IMG + "checklist_70666");
    }

    @FXML private void handleChecklistPrensa() {
        carregarChecklist(BASE_TXT +  "Checklist70667.txt",
                BASE_IMG + "checklist_70667");

    }

    @FXML private void handleQualityAlert() {
        carregarChecklist(BASE_TXT +  "QualityAlert.txt",
                BASE_IMG + "quality_alert");

    }

    @FXML private void handleIt() {
        carregarChecklist(BASE_TXT +  "Checklist81714.txt",
                BASE_IMG + "checklist_81714");

    }






















    private void carregarChecklist(String nomeTxt, String pastaimagens) {
        try {
            textAreaConteudo.setText(FileLoader.carregarTexto(nomeTxt));
            imagens = FileLoader.listarImagens(pastaimagens);
            indiceAtual = 0;
            atualizarImagem();

            // Tornar botões visíveis após carregar checklist
            btnAnterior.setVisible(true);
            btnProxima.setVisible(true);

        } catch (IOException e) {
            textAreaConteudo.setText("Erro ao carregar checklist: " + e.getMessage());
            imagens = null;
            imageViewer.setImage(null);
            btnAnterior.setVisible(false);
            btnProxima.setVisible(false);
        }
    }

    @FXML
    private void handleImagemAnterior() {
        if (imagens != null && indiceAtual > 0) {
            indiceAtual--;
            atualizarImagem();
        }
    }

    @FXML
    private void handleProximaImagem() {
        if (imagens != null && indiceAtual < imagens.size() - 1) {
            indiceAtual++;
            atualizarImagem();
        }
    }

    private void atualizarImagem() {
        if (imagens != null && !imagens.isEmpty()) {
            imageViewer.setImage(FileLoader.carregarImagem(imagens.get(indiceAtual)));
        }
    }








}
